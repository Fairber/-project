package com.stu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.Course;
import com.stu.bean.PageBean;
import com.stu.dao.CourseDao;
import com.stu.dao.impl.CourseDaoImpl;
import com.stu.service.CourseService;

public class CourseServiceImpl implements CourseService{

	CourseDao courseDao=new CourseDaoImpl();
	@Override
	public int addCos(Course course) throws SQLException {
		return courseDao.addCos(course);
	}

	@Override
	public int deleteCos(int courseID) throws SQLException {
		return courseDao.deleteCos(courseID);
	}

	@Override
	public int editCos(Course course) throws SQLException {
		return courseDao.editCos(course);
	}

	@Override
	public List<Course> findAll() throws SQLException {
		return courseDao.findAll();
	}

	@Override
	public List<Course> findOne(int courseID) throws SQLException {
		return courseDao.findOne(courseID);
	}

	@Override
	public Course selectOneCos(String courseName, String courseTeacher)
			throws SQLException {
		return courseDao.selectOneCos(courseName, courseTeacher);
	}

	@Override
	public PageBean courseListPage(int pageNo, int pageCount)
			throws SQLException {
		return courseDao.courseListPage(pageNo, pageCount);
	}

}
