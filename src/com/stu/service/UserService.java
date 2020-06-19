package com.stu.service;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.User;
import com.stu.bean.UserRole;

public interface UserService {
	/*
	 * 登录验证、查询密码、查询信息
	 */
	User login(String userNum) throws SQLException;

	/*
	 * 修改密码
	 */
	int editPwd(String password, String userNum) throws SQLException;

	/*
	 * 添加
	 */
	int addUser(User user) throws SQLException;

	/*
	 * 查询所有账号信息
	 */
	List<UserRole> findAll() throws SQLException;

	/*
	 * 查询一个账号信息
	 */
	List<User> selectOneUser(int userID) throws SQLException;

	/*
	 * 修改账号信息
	 */
	int editUser(User user) throws SQLException;
}
