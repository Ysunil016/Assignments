package com.Spring.Services.GoogleCalender;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Spring.Bean.Booking;
import com.Spring.Service.Implementation.HelperService;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Event.Creator;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;

/**
 * 
 * @author sunil016 Google service, is a class that carries an event addition
 *         functionality and finding the latest records from user's calendar.
 */

public class GoogleService {

	private CalendarConnect calenderInstance = new CalendarConnect();

	@Autowired
	private HelperService helperService;

	public Calendar getGoogleInstance() throws IOException, GeneralSecurityException {
		return new CalendarConnect().getCalanderInstance();
	}

	/**
	 * 
	 * @param booking
	 * @return true if event is successfull added to you google calendar.
	 */

	@SuppressWarnings("deprecation")
	public boolean addAnEventToCalander(Booking booking) {
		Event calEvent = new Event();
		List<EventAttendee> allAttendee = new ArrayList<EventAttendee>() {
			private static final long serialVersionUID = 1L;
			{
				add(new EventAttendee().setEmail(booking.getTo()));
				add(new EventAttendee().setEmail(booking.getFrom()));
			}
		};

		// Creating a Calander Event for Login Person.
		calEvent.setAttendees(allAttendee);
		calEvent.setStart(new EventDateTime().setDate(
				new DateTime(new Date(helperService.getTodayDate().getYear(), helperService.getTodayDate().getMonth(),
						helperService.getTodayDate().getDate(), booking.getSlot(), 0))));
		calEvent.setEnd(new EventDateTime().setDate(
				new DateTime(new Date(helperService.getTodayDate().getYear(), helperService.getTodayDate().getMonth(),
						helperService.getTodayDate().getDate(), booking.getSlot() + 1, 0))));
		calEvent.setCreated(new DateTime(new Date(System.currentTimeMillis())));
		calEvent.setCreator(new Creator().setEmail(booking.getFrom()));
		calEvent.setDescription(booking.getDescription());

		try {
			calenderInstance.getCalanderInstance().events().insert(booking.getBookingId(), calEvent);
		} catch (Exception e) {
			System.out.println("Not Able to Make upto Google Calendar");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param maxDays
	 * @return
	 * @throws IOException
	 * @throws GeneralSecurityException
	 * 
	 *                                  this functional helps to fetch the latest
	 *                                  events added to the calender, based on
	 *                                  maxDays parameter.
	 */

	public List<Event> getEventsFromGoogleCalander(int maxDays) throws IOException, GeneralSecurityException {

		// List the next 10 events from the primary calendar.
		DateTime now = new DateTime(System.currentTimeMillis());
		Events events = calenderInstance.getCalanderInstance().events().list("primary").setMaxResults(maxDays)
				.setTimeMin(now).setOrderBy("startTime").setSingleEvents(true).execute();
		List<Event> items = events.getItems();

		return items;
//		if (items.isEmpty()) {
//			System.out.println("No upcoming events found.");
//		} else {
//			System.out.println("Upcoming events");
//			for (Event event : items) {
//				DateTime start = event.getStart().getDateTime();
//				if (start == null) {
//					start = event.getStart().getDate();
//				}
//				System.out.printf("%s (%s)\n", event.getSummary(), start);
//			}
//		}
	}

}
