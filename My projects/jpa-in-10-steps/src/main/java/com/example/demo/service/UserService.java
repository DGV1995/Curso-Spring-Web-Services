package com.example.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

// Interacts with the database ==> REPOSITORY
@Repository
@Transactional // each method would be involucrated in a transaction
public class UserService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user) {
		// Open Transaction
		entityManager.persist(user);
		// Close Transaction
		return user.getId();
	}

}
