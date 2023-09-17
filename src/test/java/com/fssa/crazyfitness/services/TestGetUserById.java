package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.User;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestGetUserById {
	@Test
	void testGetUserById() {
		UserService userService = new UserService();
		User user = new User();
		try {
			user = userService.getUserbyId(1);
			System.out.println(user.getUserId() +" - "+ user.getEmail());
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
}
