package com.stu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.bean.PageBean;

import com.stu.bean.Teacher;
import com.stu.dao.TeacherDao;
import com.stu.util.DBUtil;

public class TeacherDaoImpl implements TeacherDao {
	Connection conn = DBUtil.getConnection();
	private PageBean pageBean;

	@Override
	public int addTea(Teacher teacher) throws SQLException {
		String sql = "insert into teacher(tea_num,tea_name,tea_sex,tea_age,tea_course,major,department) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, teacher.getTeaNum());
		ps.setString(2, teacher.getTeaName());
		ps.setString(3, teacher.getTeaSex());
		ps.setInt(4, teacher.getTeaAge());
		ps.setString(5, teacher.getTeaCourse());
		ps.setString(6, teacher.getMajor());
		ps.setString(7, teacher.getDepartment());
		int res = ps.executeUpdate();
		return res;

	}

	@Override
	public int deleteTea(String teaNum) throws SQLException {
		String sql = "delete from teacher where tea_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, teaNum);
		int res = ps.executeUpdate();
		return res;
	}

	@Override
	public int editTea(Teacher teacher) throws SQLException {
		String sql = "update teacher set tea_name=?,tea_sex=?,tea_age=?,tea_course=?,major=?,department=? where tea_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, teacher.getTeaName());
		ps.setString(2, teacher.getTeaSex());
		ps.setInt(3, teacher.getTeaAge());
		ps.setString(4, teacher.getTeaCourse());
		ps.setString(5, teacher.getMajor());
		ps.setString(6, teacher.getDepartment());
		ps.setString(7, teacher.getTeaNum());
		int res = ps.executeUpdate();
		return res;
	}

	@Override
	public List<Teacher> findAll() throws SQLException {
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = "select * from teacher";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Teacher teacher = new Teacher(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getString(6), rs.getString(7),rs.getString(8));
			list.add(teacher);
		}
		return list;
	}

	@Override
	public List<Teacher> findOne(String teaNum) throws SQLException {
		List<Teacher> list = new ArrayList<Teacher>();
		String sql="select * from teacher where tea_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, teaNum);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Teacher teacher = new Teacher(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getString(6), rs.getString(7),rs.getString(8));
			list.add(teacher);
		}
		return list;
	}

	@Override
	public PageBean teaListPage(int pageNo, int pageCount) throws SQLException {
		int totalCount=0;
		List<Teacher> list = new ArrayList<Teacher>();
		String sql="select * from teacher limit ?,?";
		String sqlCount="select count(*) from teacher";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNo-1)*pageCount);
		ps.setInt(2, pageCount);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Teacher teacher = new Teacher(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getString(6), rs.getString(7),rs.getString(8));
			list.add(teacher);
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
