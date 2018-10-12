package com.kp73.gimnazija.service;

import com.kp73.gimnazija.entities.User;

public interface UserService {
	
	public User findUserByUserName(String userName);
	
	public void saveUser(User user);
	
}
