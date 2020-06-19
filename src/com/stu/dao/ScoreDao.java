package com.stu.dao;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.PageBean;
import com.stu.bean.Score;
import com.stu.bean.ScoreCou;

public interface ScoreDao {
	/*
	 * ��ӳɼ�
	 */
	int addScore(Score score)throws SQLException;
	/*
	 * ɾ���ɼ�
	 */
	int deleteScore(int scoreID)throws SQLException;
	/*
	 * �޸ĳɼ�
	 */
	int editCos(Score score)throws SQLException;
	/*
	 * ��ѯ���гɼ�
	 */
	List<Score> findAll()throws SQLException;
	/*
	 * ��ѯһ��ѧ���ɼ�
	 */
	List<ScoreCou> findOne(String stuNum)throws SQLException;
	/*
	 * ��ѯһ��ѧ��һ�ſγ�
	 */
	List<Score> selectScore(int scoreID)throws SQLException;
	/*
	 * ��ѯ��ѧ���ĸ��ſγ��Ƿ����
	 */
	Score selectScoreInfo(String stuNum, String courseName)throws SQLException;
	/*
	 * ��ҳ��ʾһ��ѧ���ɼ���Ϣ
	 */
	PageBean scoreListPage(int pageNo,int pageCount,String stuNum)throws SQLException;
	/*
	 * ��ҳ��ʾ�ɼ�
	 */
	PageBean scoreListPage(int pageNo,int pageCount)throws SQLException;
	/*
	 * ��ѯһ��ѧ����һ�ſγɼ�
	 */
	List<ScoreCou> findStuOne(String stuNum,String courseName)throws SQLException;
	/*
	 * ��ѯѧ���ܷ�����
	 */
	PageBean selectScoreSum(int pageNo,int pageCount)throws SQLException;
	/*
	 * ģ����ѯѧ���ɼ�
	 */
	PageBean selectStuScore(int pageNo,int pageCount, String stuNum,
			String courseName, String stuName, String stuClass, String major)throws SQLException;
	/*
	 * ��ѯһ����ʦ�����Ŀγ�
	 */
	PageBean selectTeaScore(int pageNo,int pageCount, String teaName, String stuName,String stuClass,String stuNum)throws SQLException;
	
	
}
