package com.ameym.webapps.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ameym.webapps.dao.UserDaoImpl;
import com.ameym.webapps.model.User;


@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDaoImpl userDao;
	
	private static Map<String, User> users;

	public Map<String, User> getUsers() {
		users = userDao.getUsers();
		return users;
	}

	public User getUser(String userName) {
		User user = userDao.getUser(userName);
		return user;
	}

	public int deleteUser(String userName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createUser(User user) {
		int userId = userDao.createUser(user);
		System.out.println("Controller userID: " + userId);
		return userId;
	}

	
	
	

}
