package com.stu.dao;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.PageBean;
import com.stu.bean.Score;
import com.stu.bean.ScoreCou;

public interface ScoreDao {
	/*
	 * 添加成绩
	 */
	int addScore(Score score)throws SQLException;
	/*
	 * 删除成绩
	 */
	int deleteScore(int scoreID)throws SQLException;
	/*
	 * 修改成绩
	 */
	int editCos(Score score)throws SQLException;
	/*
	 * 查询所有成绩
	 */
	List<Score> findAll()throws SQLException;
	/*
	 * 查询一个学生成绩
	 */
	List<ScoreCou> findOne(String stuNum)throws SQLException;
	/*
	 * 查询一个学生一门课程
	 */
	List<Score> selectScore(int scoreID)throws SQLException;
	/*
	 * 查询该学生的该门课程是否添加
	 */
	Score selectScoreInfo(String stuNum, String courseName)throws SQLException;
	/*
	 * 分页显示一个学生成绩信息
	 */
	PageBean scoreListPage(int pageNo,int pageCount,String stuNum)throws SQLException;
	/*
	 * 分页显示成绩
	 */
	PageBean scoreListPage(int pageNo,int pageCount)throws SQLException;
	/*
	 * 查询一个学生的一门课成绩
	 */
	List<ScoreCou> findStuOne(String stuNum,String courseName)throws SQLException;
	/*
	 * 查询学生总分排名
	 */
	PageBean selectScoreSum(int pageNo,int pageCount)throws SQLException;
	/*
	 * 模糊查询学生成绩
	 */
	PageBean selectStuScore(int pageNo,int pageCount, String stuNum,
			String courseName, String stuName, String stuClass, String major)throws SQLException;
	/*
	 * 查询一个教师所带的课程
	 */
	PageBean selectTeaScore(int pageNo,int pageCount, String teaName, String stuName,String stuClass,String stuNum)throws SQLException;
	
	
}
