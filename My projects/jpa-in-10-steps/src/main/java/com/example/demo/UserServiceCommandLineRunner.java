package com.example.demo;

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
public class UserServiceCommandLineRunner implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceCommandLineRunner.class);
	
	@Autowired
	UserService userService;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		User user = new User("Jack", "Engineer");
		long insert = userService.insert(user);
		log.info("New user has been created: " + user);
		// New user has been created: User [id=1, name=Jack, role=Engineer]
		
	}

}
