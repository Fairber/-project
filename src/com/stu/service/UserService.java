package com.stu.service;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.User;
import com.stu.bean.UserRole;

public interface UserService {
	/*
	 * ��¼��֤����ѯ���롢��ѯ��Ϣ
	 */
	User login(String userNum) throws SQLException;

	/*
	 * �޸�����
	 */
	int editPwd(String password, String userNum) throws SQLException;

	/*
	 * ���
	 */
	int addUser(User user) throws SQLException;

	/*
	 * ��ѯ�����˺���Ϣ
	 */
	List<UserRole> findAll() throws SQLException;

	/*
	 * ��ѯһ���˺���Ϣ
	 */
	List<User> selectOneUser(int userID) throws SQLException;

	/*
	 * �޸��˺���Ϣ
	 */
	int editUser(User user) throws SQLException;
}
