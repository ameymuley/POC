package com.ameym.webapps.dao;

import java.util.Map;

import com.ameym.webapps.model.User;

public interface UserDao {
	
	 public Map<String, User> getUsers();
	 public User getUser(String userName);
	 public Integer deleteUser(String userName); 
	 public Integer updateUser(User user);
	 public Integer createUser(User user);

}
