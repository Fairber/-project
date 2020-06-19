package com.stu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.bean.Course;
import com.stu.bean.PageBean;
import com.stu.dao.CourseDao;
import com.stu.util.DBUtil;

public class CourseDaoImpl implements CourseDao {
	Connection conn = DBUtil.getConnection();
	private PageBean pageBean;

	@Override
	public int addCos(Course course) throws SQLException {
		String sql = "insert into course(course_name,course_credit,course_hours,course_teacher,coursedate) values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, course.getCourseName());
		ps.setInt(2, course.getCourseCredit());
		ps.setInt(3, course.getCourseHours());
		ps.setString(4, course.getCourseTeacher());
		ps.setDate(5, course.getCourseDate());

		int res = ps.executeUpdate();
		return res;

	}

	@Override
	public int deleteCos(int courseID) throws SQLException {
		String sql = "delete from course where course_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, courseID);
		int res = ps.executeUpdate();
		return res;
	}

	@Override
	public int editCos(Course course) throws SQLException {
		String sql = "update course set course_name=?,course_credit=?,course_hours=?,course_teacher=?,coursedate=? where course_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, course.getCourseName());
		ps.setInt(2, course.getCourseCredit());
		ps.setInt(3, course.getCourseHours());
		ps.setString(4, course.getCourseTeacher());
		ps.setDate(5, course.getCourseDate());
		ps.setInt(6, course.getCourseID());
		int res = ps.executeUpdate();
		return res;
	}

	@Override
	public List<Course> findAll() throws SQLException {
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from course";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Course course = new Course(rs.getInt(1), rs.getString(2),
					rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6));
			list.add(course);
		}
		return list;
	}

	@Override
	public List<Course> findOne(int courseID) throws SQLException {
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from course where course_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, courseID);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Course course = new Course(rs.getInt(1), rs.getString(2), rs.getInt(3),
					rs.getInt(4), rs.getString(5), rs.getDate(6));
			list.add(course);
		}
		return list;
	}

	@Override
	public Course selectOneCos(String courseName, String courseTeacher)
			throws SQLException {
		Course course = null;
		String sql = "select * from course where course_name=? and course_teacher=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, courseName);
		ps.setString(2, courseTeacher);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			 course = new Course(rs.getInt(1), rs.getString(2), rs.getInt(3),
					rs.getInt(4), rs.getString(5), rs.getDate(6));
		}
		return course;
		
	}

	@Override
	public PageBean courseListPage(int pageNo, int pageCount)
			throws SQLException {
		int totalCount = 0;
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from course limit ?,?";
		String sqlCount = "select count(*) from course";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNo-1)*pageCount);
		ps.setInt(2, pageCount );

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Course course = new Course(rs.getInt(1), rs.getString(2),
					rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6));
			list.add(course);
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
