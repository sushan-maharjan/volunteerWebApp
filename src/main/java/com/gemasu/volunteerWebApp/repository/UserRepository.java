package com.gemasu.volunteerWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gemasu.volunteerWebApp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	public User findByUsername(String username);
//	public User findByEmail(String email);

}
