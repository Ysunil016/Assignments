package com.Spring.Service.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Bean.Booking;
import com.Spring.Bean.UserRecord;
import com.Spring.CustomException.SlotException;
import com.Spring.Repository.UserRecordRepository;
import com.Spring.Services.Interface.SlotInterface;

/**
 * 
 * @author sunil016 Slot services, that holds all business logics need for Slot
 *         related endpoint at slot resource. It injects all the required
 *         repositories.
 *
 */

@Service
public class SlotService implements SlotInterface {

	@Autowired
	private UserRecordRepository userRecordRepository;
	@Autowired
	private HelperService helperService;

	public Object getAllAvailableSlots(String username) {
		Optional<UserRecord> userRecord = userRecordRepository.findById(username);
		if (!userRecord.isPresent())
			throw new SlotException("Please Login Once Again - Session Broke");

		ArrayList<Integer> allTodaysAvailableSlots = userRecord.get().getAvailableSlots()
				.get((Object) helperService.getDate());

		if (allTodaysAvailableSlots != null)
			return allTodaysAvailableSlots;
		else
			return "No Slot Available, Please Make It Available";
	}

	public Object getAllBookedSlots(String username) {
		Optional<UserRecord> userR = userRecordRepository.findById(username);
		if (!userR.isPresent())
			throw new SlotException("Please Login Once Again - Session Broke");

		ArrayList<Booking> allBooked = userR.get().getBooked().get(helperService.getDate());
		if (allBooked != null)
			return allBooked;
		else
			return "You Have No Booked Slots";
	}

	public boolean setSlotAvailable(String username, int slotNumber) {
		Optional<UserRecord> userRecord = userRecordRepository.findById(username);
		if (!userRecord.isPresent())
			throw new SlotException("Please Login Once Again - Session Broke");

		if (isSlotBooked(userRecord.get(), slotNumber))
			throw new SlotException("Slot Already Booked"); // Already Slot Available as Free

		ArrayList<Integer> allTodaysAvailableSlots = userRecord.get().getAvailableSlots()
				.get((Object) helperService.getDate());

		if (allTodaysAvailableSlots == null) {
			allTodaysAvailableSlots = new ArrayList<Integer>();
		} else if (allTodaysAvailableSlots.contains(slotNumber))
			throw new SlotException("Slot Already Available"); // Already Slot Available as Free

		allTodaysAvailableSlots.add(slotNumber);

		userRecord.get().getAvailableSlots().put(helperService.getDate(), allTodaysAvailableSlots);

		userRecordRepository.save(userRecord.get());

		return true;
	}

	public boolean isSlotBooked(UserRecord userR, int slotNumber) {

		List<Booking> bookedSlots = userR.getBooked().get(helperService.getDate());

		if (bookedSlots == null)
			return false; // Throw

		for (Booking record : bookedSlots) {
			if (record.getSlot() == slotNumber)
				return true;
		}

		return false;
	}

	public boolean isSlotBooked(String username, int slotNumber) {
		Optional<UserRecord> userR = userRecordRepository.findById(username);
		if (!userR.isPresent())
			return false;

		ArrayList<Booking> bookedSlots = userR.get().getBooked().get(helperService.getDate());

		// Since No Slot Booking is There
		if (bookedSlots == null)
			return false;

		for (Booking record : bookedSlots) {
			if (record.getSlot() == slotNumber)
				return true;
		}

		return false;
	}

	public boolean isSlotAvailable(String username, int slotNumber) {
		Optional<UserRecord> userR = userRecordRepository.findById(username);
		if (!userR.isPresent())
			return false;

		ArrayList<Integer> availableSlots = userR.get().getAvailableSlots().get(helperService.getDate());

		if (availableSlots == null)
			return false;

		for (int record : availableSlots) {
			if (record == slotNumber)
				return true;
		}

		return false;
	}

}
