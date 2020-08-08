package com.Spring.Resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Bean.HackerProfile;
import com.Spring.Service.Implementation.HackerService;

@RestController
@RequestMapping("/v1/coda")
public class HackerResource {

	@Autowired
	private HackerService hackerService;

	@CrossOrigin("*")
	@GetMapping(value = "/hasVoted", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean hasVoted(HttpServletRequest request) {
		return hackerService.hasVoted(request.getRemoteAddr());
	}

	@CrossOrigin("*")
	@GetMapping(value = "/getAllHackers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HackerProfile> getAllHackers() {
		return hackerService.getAllHackerProfiles();
	}

	@CrossOrigin("*")
	@GetMapping(value = "/getHacker/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HackerProfile getHacker(@PathVariable("id") Integer id) {
		return hackerService.getHackerProfiles(id);
	}

	@CrossOrigin("*")
	@GetMapping(value = "/voteToHacker/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public HackerProfile voteHacker(@PathVariable("id") Integer id, HttpServletRequest request) {
		return hackerService.castVote(id, request.getRemoteAddr());
	}

}
