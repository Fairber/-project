package com.stu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import com.stu.bean.PageBean;
import com.stu.bean.UserRole;
import com.stu.util.DBUtil;

public class EmpBiz {
	Connection conn = DBUtil.getConnection();
	PageBean pageBean;

	public EmpBiz() {
		super();

	}

	// 具体实现分页的方法，传递两个参数，一个第几页，一个每页的数量
	public PageBean listEmps(int pageNo, int pageCount) throws SQLException {
		int totalCount = 0;
		ArrayList<UserRole> list = new ArrayList<UserRole>();
		String sqlCount = "select count(*) from user";
		String sql = "select user_id,user_num,user_name,password,phone,role_name from user,role where user.role_id=role.role_id limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNo-1)*pageCount);
		ps.setInt(2, pageCount);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			UserRole userRole = new UserRole(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			list.add(userRole);
		}

		PreparedStatement ps1 = conn.prepareStatement(sqlCount);
		ResultSet rs1 = ps1.executeQuery();
		while (rs1.next()) {
			totalCount = rs1.getInt(1);
		}
		pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		return pageBean;
	}

}
