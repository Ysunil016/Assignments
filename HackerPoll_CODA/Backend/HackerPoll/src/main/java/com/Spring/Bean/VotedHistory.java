package com.Spring.Bean;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "votedHost")
public class VotedHistory {

	@Id
	private String hostName;
	@NotNull
	private int votedTo;

	public VotedHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getVotedTo() {
		return votedTo;
	}

	public void setVotedTo(int votedTo) {
		this.votedTo = votedTo;
	}

	public VotedHistory(String hostName, @NotNull int votedTo) {
		super();
		this.hostName = hostName;
		this.votedTo = votedTo;
	}

}
