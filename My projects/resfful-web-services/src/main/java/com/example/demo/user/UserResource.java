package com.example.demo.user;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Integer id) {
		User user = userDaoService.findUser(id);
		
		if (user == null) 
			throw new UserNotFoundException("id-" + id);
		
		return user;
	}
	
	@PostMapping("/post")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		
		User savedUser = userDaoService.save(user);
		
		URI location = ServletUriComponentsBuilder
												.fromCurrentRequest()
												.path("/{id}")
												.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Integer id) {
		
		User user = userDaoService.deleteById(id);
		if (user == null) 
			throw new UserNotFoundException("id-" + id);	
		
	}
	
}
