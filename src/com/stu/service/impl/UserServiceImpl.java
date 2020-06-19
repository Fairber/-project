package com.stu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.User;
import com.stu.bean.UserRole;
import com.stu.dao.UserDao;
import com.stu.dao.impl.UserDaoImpl;
import com.stu.service.UserService;

public class UserServiceImpl implements UserService{

	UserDao userDao = new UserDaoImpl();
	@Override
	public User login(String userNum) throws SQLException {
		return userDao.login(userNum);
	}

	@Override
	public int editPwd(String password, String userNum) throws SQLException {
		return userDao.editPwd(password, userNum);
	}

	@Override
	public int addUser(User user) throws SQLException {
		return userDao.addUser(user);
	}

	@Override
	public List<UserRole> findAll() throws SQLException {
		return userDao.findAll();
	}

	@Override
	public List<User> selectOneUser(int userID) throws SQLException {
		return userDao.selectOneUser(userID);
	}

	@Override
	public int editUser(User user) throws SQLException {
		return userDao.editUser(user);
	}

}
