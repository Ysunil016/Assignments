package com.Spring.Services.Interface;

import com.Spring.Bean.HackerProfile;

public interface AdminInterface {
	HackerProfile addHacker(HackerProfile hacker);

	HackerProfile updateHacker(int hackerId);

	HackerProfile deleteHacker(int hackerId);
}
