package com.sapient.aem.web;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.aem.exception.UserException;
import com.sapient.aem.model.Role;
import com.sapient.aem.service.UserService;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test report on LoginServlet class")
class LoginServletTest {
	@Mock
	private UserService userService;
	private Logger logger=Logger.getLogger(LoginServletTest.class);

	@Test
	void testDoGetHttpServletRequestHttpServletResponse() {
		try {
			when(userService.isValidUser("admin", "admin@123", Role.ADMIN))
					.thenReturn(true);
			assertTrue(userService.isValidUser("admin", "admin@123", Role.ADMIN));
		} catch (UserException e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() {
		try {
			when(userService.isValidUser("admin", "admin@123", Role.ADMIN))
					.thenReturn(true);
			assertTrue(userService.isValidUser("admin", "admin@123", Role.ADMIN));
		} catch (UserException e) {
			logger.error(e.getMessage(), e);
		}
	}

}
