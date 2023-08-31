package com.fssa.crazyfitness.services;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.crazyfitness.model.User;
import com.fssa.crazyfitness.services.exceptions.ServiceException;

class TestGetAllUsers { 
	@Test
	void testGetAllUsersSuccess() {
		try {
			UserService userService = new UserService();
			List<User> users = userService.getAllUserList();
			for(User user : users) {
				System.out.println(user.getUserId() + " - " + user.getFname() + " - " + user.getLname() + " - "+user.getAge() + " - " + user.getEmail() + " - " + user.getPhone() + " - " + user.getAddress());
			}
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			fail();
		}
		
	}

}
