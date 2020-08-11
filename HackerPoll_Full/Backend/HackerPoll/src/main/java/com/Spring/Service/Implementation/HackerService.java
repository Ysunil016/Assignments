package com.Spring.Service.Implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Bean.HackerProfile;
import com.Spring.Bean.VotedHistory;
import com.Spring.CustomException.HackerException;
import com.Spring.Repository.HackerProfileRepository;
import com.Spring.Repository.VotingHistoryRepository;
import com.Spring.Services.Interface.HackerInterface;

@Service
public class HackerService implements HackerInterface {

	@Autowired
	private HackerProfileRepository hackerProfileRepository;
	@Autowired
	private VotingHistoryRepository votedRepository;

	@Override
	public List<HackerProfile> getAllHackerProfiles() {
		return (List<HackerProfile>) hackerProfileRepository.findAll();
	}

	@Override
	public HackerProfile getHackerProfiles(int id) {
		return (HackerProfile) hackerProfileRepository.findById(id).get();
	}

	@Override
	public HackerProfile castVote(int hackerId, String HostIP) {
		Optional<HackerProfile> hacker = hackerProfileRepository.findById(hackerId);
		if (!hacker.isPresent()) {
			throw new HackerException("Profile Not Found");
		}
		Optional<VotedHistory> vH = votedRepository.findById(HostIP);
		System.out.println(vH.isPresent());

		if (vH.isPresent()) {
			return hacker.get();
		}

		HackerProfile nHack = hacker.get();
		nHack.setVotesCount(hacker.get().getVotesCount() + 1);
		HashSet<String> voters = hacker.get().getVoter();
		if (voters == null)
			voters = new HashSet<String>();
		voters.add(HostIP);
		nHack.setVoter(voters);
		VotedHistory vHistory = new VotedHistory(HostIP, hackerId);
		votedRepository.save(vHistory);
		hackerProfileRepository.save(nHack);
		return nHack;
	}

	@Override
	public boolean hasVoted(String hostName) {
		return votedRepository.findById(hostName).isPresent();
	}

}
