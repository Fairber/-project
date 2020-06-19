package com.stu.dao;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.Course;
import com.stu.bean.PageBean;


public interface CourseDao {
	/*
	 * 添加课程
	 */
	int addCos(Course course)throws SQLException;

	/*
	 * 删除课程
	 */
	int deleteCos(int courseID)throws SQLException;

	/*
	 * 修改课程
	 */
	int editCos(Course course)throws SQLException;

	/*
	 * 查询所有课程
	 */
	List<Course> findAll()throws SQLException;

	/*
	 * 查询一个课程
	 */
	List<Course> findOne(int courseID)throws SQLException;

	/*
	 * 查询该课程是否存在
	 */
	Course selectOneCos(String courseName, String courseTeacher)throws SQLException;

	/*
	 * 分页查询课程
	 */
	PageBean courseListPage(int pageNo, int pageCount)throws SQLException;
}
