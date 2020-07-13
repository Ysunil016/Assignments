package com.Spring.Service.Implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Bean.User;
import com.Spring.Bean.UserRecord;
import com.Spring.Repository.UserRecordRepository;
import com.Spring.Repository.UserRepository;
import com.Spring.Services.Interface.UserInterface;

/**
 * 
 * @author sunil016 User services, that holds all business logics need for User
 *         related endpoint at user resource. It injects all the required
 *         repositories. It is responsible for creating user and checking is
 *         user already exists.
 *
 */

@Service
public class UserService implements UserInterface {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRecordRepository userRecordRepository;

	public boolean registerUser(User user) {
		User savedUser = userRepository.save(user);
		UserRecord userRecord = userRecordRepository.save(new UserRecord(user.getUsername()));
		if (savedUser != null && userRecord != null)
			return true;
		else
			return false;
	}

	public boolean isUserPresent(String username) {
		Optional<User> user = userRepository.findById(username);
		if (user.isPresent())
			return true;
		else
			return false;
	}

}
