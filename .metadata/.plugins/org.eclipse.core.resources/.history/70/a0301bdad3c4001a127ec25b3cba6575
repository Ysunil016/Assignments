package com.Spring.Resources;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Bean.Exception.TimelyBean;
import com.Spring.CustomException.SlotException;
import com.Spring.Services.Interface.SlotInterface;

/**
 * 
 * @author Sunil016 Slot resource class, that handles all the request coming
 *         related to Slot management. This class is also annotated with
 *         "isAuthenticated()", that will ensure that whatever request is coming
 *         is Authenticated first.
 */

@RestController
@RequestMapping("/v1/slot")
@PreAuthorize("isAuthenticated()")
public class SlotResource {

	@Autowired
	private SlotInterface slotService;

	/**
	 * 
	 * @param principal, It is a UserIdentity based on request. It detects for
	 *        logged-in user
	 * @return Custom bean with set of all the slots available for your profile, so
	 *         that other can hit booking on those slots.
	 */

	@GetMapping(value = "/getAllSlots", produces = MediaType.APPLICATION_JSON_VALUE)
	public TimelyBean allAvailableSlots(Principal principal) {
		return new TimelyBean(slotService.getAllAvailableSlots(principal.getName()));
	}

	/**
	 * 
	 * @param principal, It is a UserIdentity based on request. It detects for
	 *        logged-in user
	 * @return Custom bean with set of all the slots available for username, so that
	 *         you can hit booking on those slots.
	 */

	@GetMapping(value = "/getAllSlots/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TimelyBean allSlotsAvailableForUser(@PathVariable("username") String username, Principal principal) {
		return new TimelyBean(slotService.getAllAvailableSlots(username));
	}

	/**
	 * 
	 * @param slotNumber
	 * @param            principal, It is a UserIdentity based on request. It
	 *                   detects for logged-in user
	 * @return Success or Failure message inside custom bean.
	 * 
	 *         Endpoint takes PUT request that had url based field injection, this
	 *         endpoint make slots available for the logged-in person if not
	 *         already. It also check, if slot is already alloted to someone.
	 */

	@PutMapping(value = "/setSlotAvailable/{slotNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TimelyBean setSlotAvailable(@PathVariable("slotNumber") Integer slotNumber, Principal principal) {
		if (slotNumber < 0 || slotNumber > 23)
			throw new SlotException("Please Provide Valid Slot Number");

		if (slotService.setSlotAvailable(principal.getName(), slotNumber))
			return new TimelyBean("Slot " + slotNumber + " is Available Now");
		else
			throw new SlotException("Please Report to Development Team");
	}

	/**
	 * 
	 * @param principal, It is a UserIdentity based on request. It detects for
	 *        logged-in user.
	 * @return Custom bean, that holds collections of all the bookings that has been
	 *         done for you by others, for a day i.e today.
	 */

	@GetMapping(value = "/getAllBookedSlots", produces = MediaType.APPLICATION_JSON_VALUE)
	public TimelyBean allBookedSlots(Principal principal) {
		return new TimelyBean(slotService.getAllBookedSlots(principal.getName()));
	}

}
