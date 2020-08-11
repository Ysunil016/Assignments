package com.Spring.Service.Implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Bean.HackerProfile;
import com.Spring.CustomException.HackerException;
import com.Spring.Repository.HackerProfileRepository;
import com.Spring.Services.Interface.AdminInterface;

@Service
public class AdminService implements AdminInterface {

	@Autowired
	private HackerProfileRepository hackerProfileRepository;

	@Override
	public HackerProfile addHacker(HackerProfile hacker) {
		return hackerProfileRepository.save(hacker);
	}

	@Override
	public HackerProfile updateHacker(int hackerId) {
		Optional<HackerProfile> hacker = hackerProfileRepository.findById(hackerId);
		if (!hacker.isPresent()) {
			throw new HackerException("No Hacker Found for Update");
		}
		return hackerProfileRepository.save(hacker.get());
	}

	@Override
	public HackerProfile deleteHacker(int hackerId) {
		Optional<HackerProfile> hacker = hackerProfileRepository.findById(hackerId);
		if (!hacker.isPresent()) {
			throw new HackerException("No Hacker Found for Delete");
		}
		hackerProfileRepository.deleteById(hackerId);
		return hacker.get();
	}

}
