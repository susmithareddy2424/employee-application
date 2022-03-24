package com.sapient.aem.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
	private User user=null;
	
	@BeforeEach
	void setUp() throws Exception {
		user= new User(101,"smith","smith@123",Role.ADMIN);
	}

	@AfterEach
	void tearDown() throws Exception {
		user=null;
	}

	@Test
	void testGetUserId() {
		assertEquals(101,user.getUserId(),"testing userid");
	}
	
	@Test
	void testInvalidGetUserId() {
		assertNotEquals(110,user.getUserId(),"testing userid");
	}

	@Test
	void testGetUserName() {
		assertEquals("smith",user.getUserName(),()->"testing username");
	}
	
	@Test
	void testInvalidGetUserName() {
		assertNotEquals("Smith",user.getUserName(),()->"testing username");
	}

	@Test
	void testGetPassword() {
		assertEquals("smith@123",user.getPassword());
	}

	@Test
	void testInvalidGetPassword() {
		assertNotEquals("smith123",user.getPassword());
	}
	
	
	@Test
	void testGetRole() {
		assertEquals("ADMIN",user.getRole().toString());
	}
	
	@Test
	void testInvalidGetRole() {
		assertNotEquals("MANAGER",user.getRole().toString());
	}

	@Test
	void testSetUserId() {
		user.setUserId(102);
		assertEquals(102,user.getUserId());
	}
	
	@Test
	void testInvalidSetUserId() {
		user.setUserId(102);
		assertNotEquals(101,user.getUserId());
	}

	@Test
	void testSetUserName() {
		user.setUserName("clarke");
		assertEquals("clarke",user.getUserName());
	}
	
	@Test
	void testInvalidSetUserName() {
		user.setUserName("clarke");
		assertNotEquals("smith",user.getUserName());
	}
	

	@Test
	void testSetPassword() {
		user.setPassword("clarke@123");
		assertEquals("clarke@123",user.getPassword());
	}
	
	@Test
	void testInvalidSetPassword() {
		user.setPassword("clarke@123");
		assertNotEquals("smith@123",user.getPassword());
	}
	

	@Test
	void testSetRole() {
		user.setRole(Role.MANAGER);
		assertEquals(Role.MANAGER,user.getRole());
	}
	
	
	@Test
	void testInvalidSetRole() {
		user.setRole(Role.MANAGER);
		assertNotEquals(Role.ADMIN,user.getRole());
	}

}
