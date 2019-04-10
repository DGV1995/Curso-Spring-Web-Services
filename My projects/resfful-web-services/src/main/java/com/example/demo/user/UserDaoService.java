package com.example.demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	public static List<User> getUsers() {
		return users;
	}

	static {
		users.add(new User(1, "Diego", new Date()));
		users.add(new User(2, "Alicia", new Date()));
		users.add(new User(3, "Juanito", new Date()));
		users.add(new User(4, "Pepita", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findUser(Integer id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}
	
	public User save(User user) {
		
		if (user.getId() == null)
			user.setId(users.size() + 1);
		if (user.getBirthday() == null)
			user.setBirthday(new Date());
		users.add(user);
		
		return user;
	}
	
	public User deleteById(Integer id) {
		
		Iterator<User> iterator = users.iterator();
		
		while(iterator.hasNext()) {
			
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		
		}
		
		return null;
		
	}

}
