package com.Spring.Services.Interface;

import java.util.List;

import com.Spring.Bean.HackerProfile;

public interface HackerInterface {
	List<HackerProfile> getAllHackerProfiles();

	HackerProfile getHackerProfiles(int id);

	HackerProfile castVote(int hackerId,String hostName);
	
	boolean hasVoted(String hostName);
}
