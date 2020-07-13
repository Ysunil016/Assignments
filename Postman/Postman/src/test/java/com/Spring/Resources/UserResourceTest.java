package com.Spring.Resources;

import java.security.Principal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Spring.Service.Implementation.UserService;

/**
 * 
 * @author sunil016 Test class that is responsible to test User Resource
 *         Endpoints using JUnit and Mockito
 */

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
class UserResourceTest {

	private MockMvc mockmvc;

	@Mock
	private UserService userService;

	@InjectMocks
	private UserResource bookingResource;

	Principal mockPrincipal = Mockito.mock(Principal.class);

	@BeforeAll
	void setUp() throws Exception {
		Mockito.when(mockPrincipal.getName()).thenReturn("sanjay01@yahoo.com");
		Mockito.when(userService.isUserPresent(Mockito.anyString())).thenReturn(true);
		this.mockmvc = MockMvcBuilders.standaloneSetup(bookingResource).build();
	}

	@Test
	@DisplayName("Test for Login Attempt")
	void getAllBookingsTest() throws Exception {
		// Adding Header for sunil016@yahoo.com and 12345
		ResultActions action = mockmvc.perform(MockMvcRequestBuilders.get("/v1/user/login").principal(mockPrincipal));
		System.out.println(action.toString());
		action.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
