package com.codingdojo.BookClub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.Errors;

import com.codingdojo.BookClub.models.LoginUser;
import com.codingdojo.BookClub.models.User;
import com.codingdojo.BookClub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public User getUser(Long id) {
		User user = userRepo.findById(id).orElse(null);
		return user;
	}
	
//	Alternative validation process for greater modularity
//	public void validate(User newUser, Errors errors) {
//		if(!newUser.getPassword().equals(newUser.getConfirm())) {
//			errors.rejectValue("password", "Mismatch", "Passwords do not match!");
//		}
//		
//		if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
//			errors.rejectValue("email", "Unique", "Email is already in use.");
//		}
//	}
	
	
	public User register(User newUser, BindingResult result) {
		// TO-DO - Reject values or register if no errors:
        // Reject if email is taken (present in database)
		if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "This email is already in use!");
		}
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("confirm", "Matches", "The Confirm Password must match Password");
        }
        // Return null if result has errors
		if(result.hasErrors()) {
			return null;
		} else {
		// Hash and set password, save user to database
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRepo.save(newUser);
		}
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		// TO-DO - Reject values:
    	// Find user in the DB by email
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			// Reject if NOT present
			result.rejectValue("email", "Unique", "No matching email found!");
			return null;
		}
		User user = potentialUser.get();
        // Reject if BCrypt password match fails
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
        // Return null if result has errors
		if(result.hasErrors()) {
        	return null;
        } else {
        	// Otherwise, return the user object
        	return user;
        }
	}
	
	public User update(User newUser) {
		return userRepo.save(newUser);
	}
	
	public void delete(Long id) {
		userRepo.deleteById(id);
	}
 }
