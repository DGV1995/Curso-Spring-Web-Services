package com.example.demo.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaResource {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Optional<User> getUser(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		
		if (user == null) 
			throw new UserNotFoundException("id-" + id);
		
		return user;
	}
	
	@PostMapping("/jpa/post")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		
		User savedUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder
												.fromCurrentRequest()
												.path("/{id}")
												.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/jpa/delete/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping("jpa/posts")
	public List<Post> getPosts() {
		return postRepository.findAll(); 
	}
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getAllPosts(@PathVariable Integer id) {
		
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent())
			throw new UserNotFoundException("id-" + id);
		
		return user.get().getPosts();
		
	}
	
	@PostMapping("/jpa/users/{id}/post")
	public ResponseEntity<Object> createPost(@PathVariable Integer id, @RequestBody Post post) {
		
		Optional<User> foundUser = userRepository.findById(id); 
		
		if (!foundUser.isPresent())
			throw new UserNotFoundException("id-" + id);
		
		User user = foundUser.get();
		
		post.setUser(user);
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(id).toUri();

		return ResponseEntity.created(location).build();
		
	}
	
}
