package com.Spring.Services.Interface;

import com.Spring.Bean.User;

/**
 * 
 * @author sunil016, Interface holds all the functions related to User Service
 *
 */
public interface UserInterface {

	boolean registerUser(User user);

	boolean isUserPresent(String username);
}
