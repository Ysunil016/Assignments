package com.Spring.Resources;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Spring.Service.Implementation.SlotService;

/**
 * 
 * @author sunil016 Test class that is responsible to test Slot Resource
 *         Endpoints using JUnit and Mockito
 */
@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
class SlotResourceTest {

	Principal principal = Mockito.mock(Principal.class);

	private MockMvc mockmvc;

	@InjectMocks
	private SlotResource slotResource;

	@Mock
	private SlotService slotService;

	private List<Integer> mockSlots = Arrays.asList(1, 2, 3);

	@BeforeEach
	void setup() {
		mockmvc = MockMvcBuilders.standaloneSetup(slotResource).build();
		Mockito.when(principal.getName()).thenReturn("sunil016@yahoo.com");

		Mockito.when(slotService.getAllAvailableSlots(Mockito.anyString())).thenReturn(mockSlots);
		Mockito.when(slotService.getAllBookedSlots(Mockito.anyString())).thenReturn("All List Object");

	}

	@Test
	void allAvailableSlotsTest() throws Exception {
		ResultActions action = mockmvc.perform(MockMvcRequestBuilders.get("/v1/slot/getAllSlots")
				.accept(MediaType.APPLICATION_JSON).principal(principal));
		action.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is(mockSlots)));
	}

	@Test
	void getAllBookedSlotTest() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/v1/slot/getAllBookedSlots").accept(MediaType.APPLICATION_JSON)
				.principal(principal))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("All List Object")));

	}

}
