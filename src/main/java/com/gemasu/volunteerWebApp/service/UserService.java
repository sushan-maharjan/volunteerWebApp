package com.gemasu.volunteerWebApp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gemasu.volunteerWebApp.model.Role;
import com.gemasu.volunteerWebApp.model.User;
import com.gemasu.volunteerWebApp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
//	@Autowired
//	private BCryptPasswordEncoder bCryptPassword;
	
	public User save(User user){
		Role role = new Role(user, "ROLE_MEMBER");
		Set<Role> r = new HashSet<Role>();
		r.add(role);
		//user.setPassword(bCryptPassword.encode(user.getPassword()));
		user.setRoles(r);
		return userRepository.save(user);
	}
	
	public void update(User user){
		userRepository.save(user);
	}
	public List<User> getAll(){
		return userRepository.findAll();
	}

	public User findByUserName(String username){
		return userRepository.findByUsername(username);
	}
	public User findById(String id) {
		return userRepository.findOne(id);
	}

	public void removeuser(User user) {
		userRepository.delete(user);
	}
}
