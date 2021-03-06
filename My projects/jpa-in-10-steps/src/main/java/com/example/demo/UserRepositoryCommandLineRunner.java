package com.example.demo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRepository;
import com.example.demo.service.UserService;

//This class is who save the elements in the database
@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		User user = new User("Bill", "Medic");
		userRepository.save(user);
		log.info("New user has been created: " + user);
		// New user has been created: User [id=2, name=Bill, role=Medic]
		
		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("User is retrieved: " + userWithIdOne);
				
	}

}
