package com.Spring.Service.Implementation;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Bean.Booking;
import com.Spring.Bean.UserRecord;
import com.Spring.CustomException.BookingException;
import com.Spring.CustomException.SlotException;
import com.Spring.Repository.BookingRepository;
import com.Spring.Repository.UserRecordRepository;
import com.Spring.Services.Interface.BookingInterface;

/**
 * 
 * @author sunil016 Booking services, that holds all business logics need for
 *         Booking related endpoint at booking resource. It injects all the
 *         required repositories.
 */

@Service
public class BookingService implements BookingInterface {

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private UserRecordRepository userRecordRepository;
	@Autowired
	private SlotService slotService;
	@Autowired
	private HelperService helperService;

	public boolean makeASlotBooking(Booking book, String from) {
		// Check if To | User is Available
		if (!isUserValid(book.getTo())) {
			throw new BookingException("Please User Valid Username for Booking");
		}

		book.initiateBooking(from);

		// Check is if Slot is Available
		if (slotService.isSlotBooked(book.getTo(), book.getSlot()))
			throw new SlotException("Slot " + book.getSlot() + " for " + book.getTo() + " Already Booked");

		if (!slotService.isSlotAvailable(book.getTo(), book.getSlot()))
			throw new SlotException("Slot " + book.getSlot() + " is Not Available for " + book.getTo());

		try {
			Optional<UserRecord> userR_From = userRecordRepository.findById(book.getFrom());
			Optional<UserRecord> userR_To = userRecordRepository.findById(book.getTo());
			if (userR_From.isPresent() && userR_To.isPresent()) {
				ArrayList<Booking> from_Bookings = userR_From.get().getBookings().get(helperService.getDate());
				ArrayList<Booking> to_Booked = userR_To.get().getBooked().get(helperService.getDate());
				if (from_Bookings == null) {
					from_Bookings = new ArrayList<Booking>();
				}
				if (to_Booked == null) {
					to_Booked = new ArrayList<Booking>();
				}
				from_Bookings.add(book);
				to_Booked.add(book);

				userR_From.get().getBookings().put(helperService.getDate(), from_Bookings);
				userR_To.get().getBooked().put(helperService.getDate(), to_Booked);

				if (saveUserRecord(userR_From.get()) && saveUserRecord(userR_To.get())
						&& removeSlotFromUserRecord(userR_To.get(), book.getSlot())) {
					saveBooking(book);
				}
			}

		} catch (Exception e) {
			throw new BookingException("Some Technical Issue Please Contact to Development Team");
		}

		return true;

	}

	public Object getAllBookings(String username) {
		Optional<UserRecord> userR = userRecordRepository.findById(username);
		if (!userR.isPresent())
			throw new BookingException("No Such User Exists, Please Login Again");

		ArrayList<Booking> allBookings = userR.get().getBookings().get(helperService.getDate());
		if (allBookings != null)
			return allBookings;
		else
			return "No Bookings for Today";
	}

	public boolean isUserValid(String username) {
		Optional<UserRecord> userR = userRecordRepository.findById(username);
		if (userR.isPresent())
			return true;
		else
			return false;
	}

	public boolean removeSlotFromUserRecord(UserRecord userRecord, Integer slot) {
		ArrayList<Integer> availableSlots = userRecord.getAvailableSlots().get(helperService.getDate());
		System.out.println(availableSlots);
		if (availableSlots == null)
			return true;
		availableSlots.remove(slot);
		userRecord.getAvailableSlots().put(helperService.getDate(), availableSlots);
		saveUserRecord(userRecord);
		return true;
	}

	public boolean saveUserRecord(UserRecord userRecord) {
		if (userRecordRepository.save(userRecord) != null)
			return true;
		return false;
	}

	public boolean saveBooking(Booking bookRecord) {
		if (bookingRepository.save(bookRecord) != null)
			return true;
		return false;
	}

}
