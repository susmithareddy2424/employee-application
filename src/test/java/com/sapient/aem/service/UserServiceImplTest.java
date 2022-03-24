package com.sapient.aem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.aem.dao.UserDAO;
import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;


@ExtendWith(MockitoExtension.class)
@DisplayName("Test report on UserServiceImpl class")
class UserServiceImplTest {
	@Mock
	private UserDAO userDao;
	private Logger logger= Logger.getLogger(UserServiceImplTest.class);
	

	@Test
	void testIsValidUser() {		
		
		try {
			when(userDao.isValidUser("admin", "admin@123", Role.ADMIN)).thenReturn(true);
			assertTrue(userDao.isValidUser("admin", "admin@123", Role.ADMIN));			
		} catch (Exception e) {			
			logger.error(e.getMessage(), e);
		}
	}

	@Test
	void testAddUser() {
		try {
			User user= new User(1,"admin", "admin@123", Role.ADMIN);
			when(userDao.addUser(user)).thenReturn(1);
			assertEquals(1,userDao.addUser(user));
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
