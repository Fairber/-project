package com.stu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.bean.User;
import com.stu.bean.UserRole;
import com.stu.dao.UserDao;
import com.stu.util.DBUtil;

public class UserDaoImpl implements UserDao {
	Connection conn = DBUtil.getConnection();

	@Override
	public User login(String userNum) throws SQLException {
		User user = null;
		String sql = "select *from user where user_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userNum);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getInt(6));
		}
		return user;
	}

	@Override
	public int editPwd(String password, String userNum) throws SQLException {
		String sql = "update user set password=? where user_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, password);
		ps.setString(2, userNum);
		int res = ps.executeUpdate();
		return res;
	}

	@Override
	public int addUser(User user) throws SQLException {
		String sql = "insert into user(user_num,user_name,password,phone,role_id) values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUserNum());
		ps.setString(2, user.getUserName());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getPhone());
		ps.setInt(5, user.getRoleID());
		int res = ps.executeUpdate();
		return res;
	}

	@Override
	public List<UserRole> findAll() throws SQLException {
		List<UserRole> list = new ArrayList<UserRole>();
		String sql = "select user_id,user_num,user_name,password,phone,role_name from user,role where user.role_id=role.role_id";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			UserRole userRole = new UserRole(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			list.add(userRole);
		}
		return list;
	}

	@Override
	public List<User> selectOneUser(int userID) throws SQLException {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user where user_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, userID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getInt(6));
			list.add(user);
		}
		return list;
	}

	@Override
	public int editUser(User user) throws SQLException {
		String sql = "update user set user_name=?,password=?,phone=? where user_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getPhone());
		ps.setString(4, user.getUserNum());
		int res = ps.executeUpdate();
		return res;
	}

}
