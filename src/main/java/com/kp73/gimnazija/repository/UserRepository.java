package com.kp73.gimnazija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kp73.gimnazija.entities.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String userName);
}
