package com.stu.dao;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.PageBean;
import com.stu.bean.Student;



public interface StudentDao {
	/*
	 * 添加学生
	 */
	int addStu(Student student)throws SQLException;

	/*
	 * 删除学生
	 */
	int deleteStu(String stuNum)throws SQLException;

	/*
	 * 修改学生
	 */
	int editStu(Student student)throws SQLException;

	/*
	 * 查询所有学生
	 */
	List<Student> findAll()throws SQLException;

	/*
	 * 查询一个学生
	 */
	List<Student> findOne(String userNum)throws SQLException;

	/*
	 * 分页显示学生
	 */
	public PageBean stuListPage(int pageNo, int pageCount)throws SQLException;
}
