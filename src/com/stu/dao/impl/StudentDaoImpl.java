package com.stu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.bean.PageBean;
import com.stu.bean.Student;
import com.stu.dao.StudentDao;
import com.stu.util.DBUtil;

public class StudentDaoImpl implements StudentDao {
	Connection conn = DBUtil.getConnection();
	private PageBean pageBean;

	@Override
	public int addStu(Student student) throws SQLException {
		String sql = "insert into student(stu_num,stu_name,stu_sex,stu_age,stu_class,major,department) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, student.getStuNum());
		ps.setString(2, student.getStuName());
		ps.setString(3, student.getStuSex());
		ps.setInt(4, student.getStuAge());
		ps.setString(5, student.getStuClass());
		ps.setString(6, student.getMajor());
		ps.setString(7, student.getDepartment());
		int res = ps.executeUpdate();
		return res;

	}

	@Override
	public int deleteStu(String stuNum) throws SQLException {
		String sql = "delete from student where stu_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stuNum);
		int res = ps.executeUpdate();
		return res;
	}

	@Override
	public int editStu(Student student) throws SQLException {
		String sql = "update student set stu_name=?,stu_sex=?,stu_age=?,stu_class=?,major=?,department=? where stu_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, student.getStuName());
		ps.setString(2, student.getStuSex());
		ps.setInt(3, student.getStuAge());
		ps.setString(4, student.getStuClass());
		ps.setString(5, student.getMajor());
		ps.setString(6, student.getDepartment());
		ps.setString(7, student.getStuNum());
		int res = ps.executeUpdate();
		return res;

	}

	@Override
	public List<Student> findAll() throws SQLException {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Student student = new Student(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getString(6), rs.getString(7),rs.getString(8));
			list.add(student);
		}
		return list;
	}

	@Override
	public List<Student> findOne(String userNum) throws SQLException {
		List<Student> list = new ArrayList<Student>();
		String sql="select * from student where stu_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userNum);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Student student = new Student(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getString(6), rs.getString(7),rs.getString(8));
			list.add(student);
		}
		return list;
	}

	
	@Override
	//pageNo当前页码，pageCount每页显示总条数
	public PageBean stuListPage(int pageNo, int pageCount) throws SQLException {
		int totalCount=0;
		List<Student> list = new ArrayList<Student>();
		String sql="select * from student limit ?,?";
		String sqlCount="select count(*) from student";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNo-1)*pageCount);
		ps.setInt(2, pageCount);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Student student = new Student(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getString(6), rs.getString(7),rs.getString(8));
			list.add(student);
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
