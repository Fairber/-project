package com.stu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.PageBean;
import com.stu.bean.Student;
import com.stu.dao.StudentDao;
import com.stu.dao.impl.StudentDaoImpl;
import com.stu.service.StudentService;

public class StudentServiceImpl implements StudentService{

	StudentDao studentDao = new StudentDaoImpl();
	@Override
	public int addStu(Student student) throws SQLException {
		return studentDao.addStu(student);
	}

	@Override
	public int deleteStu(String stuNum) throws SQLException {
		return studentDao.deleteStu(stuNum);
	}

	@Override
	public int editStu(Student student) throws SQLException {
		return studentDao.editStu(student);
	}

	@Override
	public List<Student> findAll() throws SQLException {
		return studentDao.findAll();
	}

	@Override
	public List<Student> findOne(String userNum) throws SQLException {
		return studentDao.findOne(userNum);
	}

	@Override
	public PageBean stuListPage(int pageNo, int pageCount) throws SQLException {
		return studentDao.stuListPage(pageNo, pageCount);
	}

}
