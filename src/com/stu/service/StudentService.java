package com.stu.service;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.PageBean;
import com.stu.bean.Student;

public interface StudentService {
	/*
	 * ���ѧ��
	 */
	int addStu(Student student) throws SQLException;

	/*
	 * ɾ��ѧ��
	 */
	int deleteStu(String stuNum) throws SQLException;

	/*
	 * �޸�ѧ��
	 */
	int editStu(Student student) throws SQLException;

	/*
	 * ��ѯ����ѧ��
	 */
	List<Student> findAll() throws SQLException;

	/*
	 * ��ѯһ��ѧ��
	 */
	List<Student> findOne(String userNum) throws SQLException;

	/*
	 * ��ҳ��ʾѧ��
	 */
	public PageBean stuListPage(int pageNo, int pageCount) throws SQLException;
}
