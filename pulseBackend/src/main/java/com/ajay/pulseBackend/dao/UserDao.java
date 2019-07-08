package com.ajay.pulseBackend.dao;

import java.util.List;

import com.ajay.pulseBackend.model.User;

public interface UserDao {

	public boolean registerUser(User user);

	public boolean updateUser(User user);

	public List<User> listUser();

	public User getUserByUserName(String username);

	public boolean deleteUser(User user);
	
}
