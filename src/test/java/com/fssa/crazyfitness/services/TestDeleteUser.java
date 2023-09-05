package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.services.exceptions.ServiceException;

 class TestDeleteUser {
@Test
  void testValidUserDelete() {
	UserService userService = new UserService();
	try {
		assertTrue(userService.userDelete(2));
	} catch (ServiceException e) {
		e.printStackTrace();
		fail();
	}
}
@Test
 void testInvaliDelete() {
	UserService userService = new UserService();
	try {
		assertFalse(userService.userDelete(1234));
	} catch (ServiceException e) {
		e.printStackTrace();
	}
}
}
