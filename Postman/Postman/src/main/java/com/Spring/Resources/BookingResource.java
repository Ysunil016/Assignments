package com.Spring.Resources;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Bean.Booking;
import com.Spring.Bean.Exception.TimelyBean;
import com.Spring.CustomException.BookingException;
import com.Spring.Services.Interface.BookingInterface;

/**
 * 
 * @author Sunil016 Booking resource class, that handles all the request coming
 *         related to Booking management. This class is also annotated with
 *         "isAuthenticated()", that will ensure that whatever request is coming
 *         is Authenticated first.
 */

@RestController
@RequestMapping("/v1/booking")
@PreAuthorize("isAuthenticated()")
public class BookingResource {

	@Autowired
	private BookingInterface bookingService;

	/**
	 * 
	 * @param booking
	 * @param principal
	 * @return Custom created Bean for Response Body, that holds time stamp and
	 *         message field.
	 * 
	 *         This class accepts booking from valid user to the particular valid
	 *         user. Resource endpoint also validate for the bean, i.e for username
	 *         as email and password for min 6 and max 16 characters.
	 * 
	 */

	@PostMapping(value = "/bookSlot", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public TimelyBean bookSlot(@Valid @RequestBody Booking booking, Principal principal) {
		if (booking.getSlot() < 0 || booking.getSlot() > 23)
			throw new BookingException("Please Provide Valid Slot");

		if (principal == null)
			throw new AccessDeniedException("Please Login with Valid Credentials");

		if (booking.getTo().equals(principal.getName()))
			throw new BookingException("Booking Slot to Self is Not Allowed");

		if (bookingService.makeASlotBooking(booking, principal.getName()))
			return new TimelyBean("Slot " + booking.getSlot() + " Booked with " + booking.getTo());

		return new TimelyBean("Report Issue to Developement Team");
	}

	/**
	 * 
	 * @param principal
	 * @return Custom bean, with array of booking records.
	 * 
	 *         Endpoint caters for all the bookings that you have done for the day
	 *         i.e today.
	 */

	@GetMapping(value = "/getAllBookings", produces = MediaType.APPLICATION_JSON_VALUE)
	public TimelyBean getAllBookings(Principal principal) {
		if (principal == null)
			throw new AccessDeniedException("Please Login with Valid Credentials");

		return new TimelyBean(bookingService.getAllBookings(principal.getName()));
	}
}
