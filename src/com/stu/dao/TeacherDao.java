package com.stu.dao;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.PageBean;
import com.stu.bean.Teacher;

public interface TeacherDao {
	/*
	 * ��ӽ�ʦ
	 */
	int addTea(Teacher teacher)throws SQLException;

	/*
	 * ɾ����ʦ
	 */
	int deleteTea(String teaNum)throws SQLException;

	/*
	 * �޸Ľ�ʦ
	 */
	int editTea(Teacher teacher)throws SQLException;

	/*
	 * ��ѯ���н�ʦ
	 */
	List<Teacher> findAll()throws SQLException;

	/*
	 * ��ѯһ����ʦ
	 */
	List <Teacher>findOne(String teaNum)throws SQLException;

	/*
	 * ��ҳ��ʾ���н�ʦ
	 */
	PageBean teaListPage(int pageNo, int pageCount)throws SQLException;
}
