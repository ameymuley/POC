package com.ameym.webapps.Service;


import java.util.Map;

import com.ameym.webapps.model.User;

public interface UserService {
	
	public Map<String, User> getUsers();
	 public User getUser(String userName);
	 public int deleteUser(String userName); 
	 public int updateUser(User user);
	 public int createUser(User user);

}
