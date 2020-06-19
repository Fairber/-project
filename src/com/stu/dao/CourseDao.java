package com.stu.dao;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.Course;
import com.stu.bean.PageBean;


public interface CourseDao {
	/*
	 * ��ӿγ�
	 */
	int addCos(Course course)throws SQLException;

	/*
	 * ɾ���γ�
	 */
	int deleteCos(int courseID)throws SQLException;

	/*
	 * �޸Ŀγ�
	 */
	int editCos(Course course)throws SQLException;

	/*
	 * ��ѯ���пγ�
	 */
	List<Course> findAll()throws SQLException;

	/*
	 * ��ѯһ���γ�
	 */
	List<Course> findOne(int courseID)throws SQLException;

	/*
	 * ��ѯ�ÿγ��Ƿ����
	 */
	Course selectOneCos(String courseName, String courseTeacher)throws SQLException;

	/*
	 * ��ҳ��ѯ�γ�
	 */
	PageBean courseListPage(int pageNo, int pageCount)throws SQLException;
}
