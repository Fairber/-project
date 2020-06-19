package com.stu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.stu.bean.PageBean;
import com.stu.bean.Score;
import com.stu.bean.ScoreCou;
import com.stu.dao.ScoreDao;
import com.stu.dao.impl.ScoreDaoImpl;
import com.stu.service.ScoreService;

public class ScoreServiceImpl implements ScoreService{
	ScoreDao scoreDao = new ScoreDaoImpl();
	@Override
	public int addScore(Score score) throws SQLException {
		return scoreDao.addScore(score);
	}

	@Override
	public int deleteScore(int scoreID) throws SQLException {
		return scoreDao.deleteScore(scoreID);
	}

	@Override
	public int editCos(Score score) throws SQLException {
		return scoreDao.editCos(score);
	}

	@Override
	public List<Score> findAll() throws SQLException  {
		return scoreDao.findAll();
	}

	@Override
	public List<ScoreCou> findOne(String stuNum) throws SQLException {
		return scoreDao.findOne(stuNum);
	}

	@Override
	public List<Score> selectScore(int scoreID) throws SQLException {
		return scoreDao.selectScore(scoreID);
	}

	@Override
	public Score selectScoreInfo(String stuNum, String courseName)
			throws SQLException {
		return scoreDao.selectScoreInfo(stuNum, courseName);
	}

	@Override
	public PageBean scoreListPage(int pageNo, int pageCount, String stuNum)
			throws SQLException {
		return scoreDao.scoreListPage(pageNo, pageCount, stuNum);
	}

	@Override
	public PageBean scoreListPage(int pageNo, int pageCount)
			throws SQLException {
		return scoreDao.scoreListPage(pageNo, pageCount);
	}

	@Override
	public List<ScoreCou> findStuOne(String stuNum, String courseName)
			throws SQLException {
		return scoreDao.findStuOne(stuNum, courseName);
	}

	@Override
	public PageBean selectScoreSum(int pageNo, int pageCount)
			throws SQLException {
		return scoreDao.selectScoreSum(pageNo, pageCount);
	}

	@Override
	public PageBean selectStuScore(int pageNo, int pageCount, String stuNum,
			String courseName, String stuName, String stuClass, String major)
			throws SQLException {
		return scoreDao.selectStuScore(pageNo, pageCount, stuNum, courseName, stuName, stuClass, major);
	}

	@Override
	public PageBean selectTeaScore(int pageNo, int pageCount, String teaName,
			String stuName, String stuClass, String stuNum) throws SQLException {
		return scoreDao.selectTeaScore(pageNo, pageCount, teaName, stuName, stuClass, stuNum);
	}

	@Override
	public double findStuSc(String stuNum) throws SQLException {
		double sum=0;
		List<ScoreCou> rs=scoreDao.findOne(stuNum);
		for(int i=0;i<rs.size();i++){
			ScoreCou scu=(ScoreCou) rs.get(i);
			sum+=scu.getScoreGrade();
		}
		return sum;
	}

}
