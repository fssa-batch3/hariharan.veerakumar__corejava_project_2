package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.User;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

 class TestUpdateUser {
@Test
 void testValidUpdate() {
	UserService userService = new UserService();
	User user = new User();
	user.setUserId(1);
	user.setFname("Hari");
	user.setLname("Haran");
	user.setAge(19);
	user.setEmail("hariharan.veerakumar@fssa.freshworks.com");
	user.setPassword("HariPassword@10");
	user.setPhone("9842356365");
	user.setAddress("C.s.nagar, Erode.");
	 
	try {
		assertTrue(userService.userUpdate(user));
	} catch (ServiceException e) {
		e.printStackTrace();
		fail();
	}
}

@Test
void testInvalidUpdate() {
	UserService userService = new UserService();
	User user = new User();
	user.setUserId(100);
	user.setFname("Hari");
	user.setLname("Haran");
	user.setAge(19);
	user.setEmail("hari@gmail.com");
	user.setPassword("Haripassword@10");
	user.setPhone("9842356365");
	user.setAddress("C.s.nagar, Erode.");
	try {
		assertFalse(userService.userUpdate(user));
	} catch (ServiceException e) {
		e.printStackTrace();
	}
}
}
