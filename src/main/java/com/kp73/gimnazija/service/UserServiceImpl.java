package com.kp73.gimnazija.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kp73.gimnazija.entities.Role;
import com.kp73.gimnazija.entities.User;
import com.kp73.gimnazija.repository.RoleRepository;
import com.kp73.gimnazija.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        if(userRole == null) {
        	Role userRole1 = new Role();
        	userRole1.setRole("ADMIN");
        	roleRepository.save(userRole1);
        	user.setRoles(new HashSet<Role>(Arrays.asList(userRole1))); 
        }else {
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));        	
        }
        userRepository.save(user);

	}


}
