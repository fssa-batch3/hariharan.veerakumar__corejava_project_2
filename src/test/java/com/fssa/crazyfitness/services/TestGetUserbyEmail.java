package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.User;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestGetUserbyEmail {
	@Test
	void testValidGetUserByEmail() {
		UserService userService = new UserService();
		User user = new User();
		try {
			user = userService.getUserbyEmail("hari@gmail.com");
			System.out.println(user.getUserId() + " - " + user.getEmail() + " - " + user.getPhone());
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
}
