package com.stu.dao;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.PageBean;
import com.stu.bean.Teacher;

public interface TeacherDao {
	/*
	 * 添加教师
	 */
	int addTea(Teacher teacher)throws SQLException;

	/*
	 * 删除教师
	 */
	int deleteTea(String teaNum)throws SQLException;

	/*
	 * 修改教师
	 */
	int editTea(Teacher teacher)throws SQLException;

	/*
	 * 查询所有教师
	 */
	List<Teacher> findAll()throws SQLException;

	/*
	 * 查询一个教师
	 */
	List <Teacher>findOne(String teaNum)throws SQLException;

	/*
	 * 分页显示所有教师
	 */
	PageBean teaListPage(int pageNo, int pageCount)throws SQLException;
}
