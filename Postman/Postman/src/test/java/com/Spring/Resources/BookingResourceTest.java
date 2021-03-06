package com.Spring.Resources;

import java.security.Principal;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Spring.Bean.Booking;
import com.Spring.Service.Implementation.BookingService;

/**
 * 
 * @author sunil016 Test class that is responsible to test Booking Resource
 *         Endpoints using JUnit and Mockito
 */

@SpringBootTest // Changed in Junit5 from @RunWith
@TestInstance(Lifecycle.PER_CLASS)
class BookingResourceTest {

	private MockMvc mockmvc;

	@Mock
	private BookingService bookingService;

	@InjectMocks
	private BookingResource bookingResource;

	Principal mockPrincipal = Mockito.mock(Principal.class);

	Booking book = new Booking("sunil016@yahoo.com", "sanjay01@yahoo.com", 4);

	@BeforeAll
	void setUp() throws Exception {
		Mockito.when(mockPrincipal.getName()).thenReturn("sanjay01@yahoo.com");

		this.mockmvc = MockMvcBuilders.standaloneSetup(bookingResource).build();
	}

	@Test
	@DisplayName("Get All Bookings Made By You")
	// Making Mock Test for Get Request for Fetching All the Booking Slots
	public void getAllBookingsTest() throws Exception {

		Mockito.when(bookingService.getAllBookings(Mockito.anyString())).thenReturn("All Bookings Object");

		mockmvc.perform(MockMvcRequestBuilders.get("/v1/booking/getAllBookings").accept(MediaType.APPLICATION_JSON)
				.principal(mockPrincipal)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("All Bookings Object")));
	}

	@Test
	@DisplayName("Booking Slot")
	// Making Mock Test for Post Request for Booking Slot
	public void getBookSlotTest() throws Exception {

		Mockito.when(bookingService.makeASlotBooking(Mockito.any(Booking.class), Mockito.anyString())).thenReturn(true);

		mockmvc.perform(MockMvcRequestBuilders.post("/v1/booking/bookSlot").contentType(MediaType.APPLICATION_JSON)
				.content(book.toString()).principal(mockPrincipal)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.message",
						Matchers.is("Slot 4 Booked with sunil016@yahoo.com")));
	}

}
