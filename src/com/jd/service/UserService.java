package com.jd.service;

import java.sql.SQLException;

import com.jd.dao.UserDao;
import com.jd.entity.User;

public class UserService {

	public static User getUser(String username) throws SQLException{
			return UserDao.getUser(username);
	}
	
	public static User login(User user) throws SQLException{
		return UserDao.login(user);
	}
	
	public static void saveUser(User user) throws SQLException{
		UserDao.saveUser(user);
	}
}
