package com.Spring.Bean;

import java.util.HashMap;
import java.util.HashSet;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hackerProfile")
public class HackerProfile {

	@Id
	private int hackerId;
	@NotNull
	@Length(min = 3, message = "Name Should be Atleas 3 Characters")
	private String hackerName;
	private String solvedChallenges;
	private int expertLevel;
	private String image;
	private int votesCount;

	HashMap<String, Integer> expertIn;
	HashSet<String> voter;

	public HackerProfile() {
	}

	public HackerProfile(int hackerId,
			@NotNull @Length(min = 3, message = "Name Should be Atleas 3 Characters") String hackerName,
			String solvedChallenges, int expertLevel, String image, int votesCount, HashMap<String, Integer> expertIn,
			HashSet<String> voter) {
		super();
		this.hackerId = hackerId;
		this.hackerName = hackerName;
		this.solvedChallenges = solvedChallenges;
		this.expertLevel = expertLevel;
		this.image = image;
		this.votesCount = votesCount;
		this.expertIn = expertIn;
		this.voter = voter;
	}

	public int getHackerId() {
		return hackerId;
	}

	public void setHackerId(int hackerId) {
		this.hackerId = hackerId;
	}

	public String getHackerName() {
		return hackerName;
	}

	public void setHackerName(String hackerName) {
		this.hackerName = hackerName;
	}

	public String getSolvedChallenges() {
		return solvedChallenges;
	}

	public void setSolvedChallenges(String solvedChallenges) {
		this.solvedChallenges = solvedChallenges;
	}

	public int getExpertLevel() {
		return expertLevel;
	}

	public void setExpertLevel(int expertLevel) {
		this.expertLevel = expertLevel;
	}

	public int getVotesCount() {
		return votesCount;
	}

	public void setVotesCount(int votesCount) {
		this.votesCount = votesCount;
	}

	public HashMap<String, Integer> getExpertIn() {
		return expertIn;
	}

	public void setExpertIn(HashMap<String, Integer> expertIn) {
		this.expertIn = expertIn;
	}

	public HashSet<String> getVoter() {
		return voter;
	}

	public void setVoter(HashSet<String> voter) {
		this.voter = voter;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
