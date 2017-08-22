package com.ameym.webapps.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ameym.webapps.Service.UserServiceImpl;
import com.ameym.webapps.model.User;


@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	private static Map<String, User> users = new HashMap<>();

	@RequestMapping("/")
	public String welcome() {//Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<User>> getAllUsers(){
		HttpHeaders headers = new HttpHeaders();
		User user1 = new User("ameya1", "Password1", "Ameya", "Muley", "email1@gmail.com", "9421744726");
		User user2 = new User("ameya2", "Password2", "Ameya", "Muley", "email2@gmail.com", "9421744727");

		List<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);

		if (list == null) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		else {
			headers.add("Number Of Records Found", String.valueOf(list.size()));
			return new ResponseEntity<List<User>>(list, headers, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/users/{userName}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userName) {
		//User user = userService.getUser(userName);
		User user = new User("ameya", "Password", "Ameya", "Muley", "email@gmail.com", "9421744726");
		return user;
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public int createUser(User user) {
		int userId = userService.createUser(user);
		System.out.println("Controller userID: " + userId);
		return userId;
	}
}
