package com.Spring.Resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Bean.HackerProfile;
import com.Spring.CustomException.HackerException;
import com.Spring.Service.Implementation.AdminService;

@RestController
@RequestMapping("/v1/admin")
public class AdminResource {

	@Autowired
	private AdminService adminService;

	@PostMapping(value = "/addHacker", produces = MediaType.APPLICATION_JSON_VALUE)
	public HackerProfile getAllHackers(@Valid @RequestBody HackerProfile hacker) {
		if (hacker == null) {
			throw new HackerException("Not Valid Input Data");
		}
		return adminService.addHacker(hacker);
	}
	
	@DeleteMapping(value = "/deleteHacker/{hackerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HackerProfile deleteHackers(@PathVariable("hackerId") Integer hackerId) {
		if (hackerId == null) {
			throw new HackerException("Not Valid Input Data");
		}
		return adminService.deleteHacker(hackerId);
	}
}
