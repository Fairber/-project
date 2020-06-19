package com.stu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.PageBean;
import com.stu.bean.Teacher;
import com.stu.dao.TeacherDao;
import com.stu.dao.impl.TeacherDaoImpl;
import com.stu.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{

	TeacherDao teacherDao = new TeacherDaoImpl();
	@Override
	public int addTea(Teacher teacher) throws SQLException {
		return teacherDao.addTea(teacher);
	}

	@Override
	public int deleteTea(String teaNum) throws SQLException {
		return teacherDao.deleteTea(teaNum);
	}

	@Override
	public int editTea(Teacher teacher) throws SQLException {
		return teacherDao.editTea(teacher);
	}

	@Override
	public List<Teacher> findAll() throws SQLException {
		return teacherDao.findAll();
	}

	@Override
	public List<Teacher> findOne(String teaNum) throws SQLException {
		return teacherDao.findOne(teaNum);
	}

	@Override
	public PageBean teaListPage(int pageNo, int pageCount) throws SQLException {
		return teacherDao.teaListPage(pageNo, pageCount);
	}

}
