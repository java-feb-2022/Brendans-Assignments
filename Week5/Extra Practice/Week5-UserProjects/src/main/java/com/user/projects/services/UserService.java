package com.user.projects.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.user.projects.models.LoginUser;
import com.user.projects.models.User;
import com.user.projects.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	// Validate User for - Duplicate email and password mismatch
	public void validate() {

	}

	// Hash user's password and add to database
	public User registerUser() {
		return null;
	}

	// find user by email
	public User findByEmail() {
		return null;
	}

	// find user by id
	public User findById() {
		return null;
	}

	// Authenticate user
	public boolean authenticateUser() {
		// first find the user by email
		// if we can't find user by email, return false
			// if user is found check if the passwords match, return true, else, return false
		return false;
	}

}
