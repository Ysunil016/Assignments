package com.Spring.Resources;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Spring.Bean.User;
import com.Spring.Bean.Exception.TimelyBean;
import com.Spring.Services.Interface.UserInterface;

/**
 * 
 * @author sunil016 User class responsible for registering user to the
 *         application and also to check login success/deny. This class doesn't
 *         need any authentication on class, rather it has function based
 *         Authorisation.
 */

@RestController
@RequestMapping("/v1/user")
public class UserResource {

	@Autowired
	private UserInterface userService;

	@Autowired
	RestTemplate restTemplate;

	/**
	 * 
	 * @param user
	 * @return Custom bean, with message whether user is created successfully, or
	 *         some exception is there. Endpoint checks for validation of username,
	 *         password. It also checks if user already exists.
	 */

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public TimelyBean addUser(@Valid @RequestBody User user) {
		if (userService.isUserPresent(user.getUsername()))
			return new TimelyBean("User Already Exists");
		if (userService.registerUser(user))
			return new TimelyBean("User Created Successfully");
		else
			return new TimelyBean("Please Contact to Development Team or Try Again Later");
	}

	/**
	 * 
	 * @param principal
	 * @return Custom response bean, that holds whether you are able to go through
	 *         the function after Authorisation.
	 */

	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public TimelyBean userLogin(Principal principal) {
		// At Successful Login from "isAuth"

		if (principal == null)
			throw new AccessDeniedException("Please Login with Valid Credentials");

		if (userService.isUserPresent(principal.getName())) {
			System.out.println("Login Success");
			return new TimelyBean("Successful Login");
		} else
			throw new AccessDeniedException("Please Login with Valid Credentials");
	}

	@GetMapping(value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
	public TimelyBean userLogout(Principal principal) {
		System.out.println("Logout");
		return new TimelyBean("Successful Logout ");
	}

}
