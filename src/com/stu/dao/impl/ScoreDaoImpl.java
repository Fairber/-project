package com.stu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stu.bean.PageBean;
import com.stu.bean.Score;
import com.stu.bean.ScoreCou;
import com.stu.bean.ScoreSum;
import com.stu.dao.ScoreDao;
import com.stu.util.DBUtil;

public class ScoreDaoImpl implements ScoreDao {
	Connection conn = DBUtil.getConnection();
	private PageBean pageBean;

	@Override
	public int addScore(Score score) throws SQLException {
		String sql = "insert into score(stu_num,stu_name,stu_class,course_name,score_grade,major) values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, score.getStuNum());
		ps.setString(2, score.getStuName());
		ps.setString(3, score.getStuClass());
		ps.setString(4, score.getCourseName());
		ps.setDouble(5, score.getScoreGrade());
		ps.setString(6, score.getMajor());
		int res = ps.executeUpdate();
		return res;

	}

	@Override
	public int deleteScore(int scoreID) throws SQLException {
		String sql = "delete from score where score_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, scoreID);
		int res = ps.executeUpdate();
		return res;
	}

	@Override
	public int editCos(Score score) throws SQLException {
		String sql = "update score set stu_num=?,stu_name=?,stu_class=?,course_name=?,score_grade=?,major=? where score_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, score.getStuNum());
		ps.setString(2, score.getStuName());
		ps.setString(3, score.getStuClass());
		ps.setString(4, score.getCourseName());
		ps.setDouble(5, score.getScoreGrade());
		ps.setString(6, score.getMajor());
		ps.setInt(7, score.getScoreID());
		int res = ps.executeUpdate();
		return res;
	}

	@Override
	public List<Score> findAll() throws SQLException {
		List<Score> list = new ArrayList<Score>();
		String sql = "select * from score";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Score score = new Score(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDouble(6), rs.getString(7));
			list.add(score);
		}
		return list;
	}

	@Override
	public List<ScoreCou> findOne(String stuNum) throws SQLException {
		List<ScoreCou> list = new ArrayList<ScoreCou>();
		String sql = "select score.course_name,course_credit,course_hours,course_teacher,major,coursedate,score_grade "
				+ "from score,course where score.course_name=course.course_name and stu_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stuNum);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ScoreCou scoreCou = new ScoreCou(rs.getString(1), rs.getInt(2),
					rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getDate(6), rs.getDouble(7));
			list.add(scoreCou);
		}
		return list;
	}

	@Override
	public List<Score> selectScore(int scoreID) throws SQLException {
		List<Score> list = new ArrayList<Score>();
		String sql = "select * from score where score_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, scoreID);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Score score = new Score(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDouble(6), rs.getString(7));
			list.add(score);
		}
		return list;

	}

	@Override
	public Score selectScoreInfo(String stuNum, String courseName)
			throws SQLException {
		Score score = null;
		String sql = "select * from score where stu_num=? and course_name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stuNum);
		ps.setString(2, courseName);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			score = new Score(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getDouble(6),
					rs.getString(7));

		}
		return score;
	}

	@Override
	public PageBean scoreListPage(int pageNo, int pageCount, String stuNum)
			throws SQLException {
		int totalCount = 0;
		List<ScoreCou> list = new ArrayList<ScoreCou>();
		String sql = "select score.course_name,course_credit,course_hours,course_teacher,major,coursedate,score_grade "
				+ "from score,course where score.course_name=course.course_name and stu_num=? limit ?,?";
		String sqlCount = "select count(*) from score,course where score.course_name=course.course_name and stu_num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stuNum);
		ps.setInt(2, (pageNo - 1) * pageCount);
		ps.setInt(3, pageCount);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ScoreCou scoreCou = new ScoreCou(rs.getString(1), rs.getInt(2),
					rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getDate(6), rs.getDouble(7));
			list.add(scoreCou);
		}
		PreparedStatement ps1 = conn.prepareStatement(sqlCount);
		ps1.setString(1, stuNum);
		ResultSet rs1 = ps1.executeQuery();
		while (rs1.next()) {
			totalCount = rs1.getInt(1);
		}
		pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		return pageBean;

	}

	@Override
	public PageBean scoreListPage(int pageNo, int pageCount)
			throws SQLException {
		int totalCount = 0;
		List<Score> list = new ArrayList<Score>();
		String sql = "select * from score limit ?,?";
		String sqlCount = "select count(*) from score";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNo - 1) * pageCount);
		ps.setInt(2, pageCount);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Score score = new Score(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDouble(6), rs.getString(7));
			list.add(score);
		}
		PreparedStatement ps1 = conn.prepareStatement(sqlCount);
		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {
			totalCount = rs1.getInt(1);
		}
		pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		return pageBean;
	}

	@Override
	public List<ScoreCou> findStuOne(String stuNum, String courseName)
			throws SQLException {
		List<ScoreCou> list = new ArrayList<ScoreCou>();
		String sql = "select score.course_name,course_credit,course_hours,course_teacher,major,coursedate,score_grade "
				+ "from score,course where score.course_name=course.course_name and stu_num=? and course.course_name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, stuNum);
		ps.setString(2, courseName);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ScoreCou scoreCou = new ScoreCou(rs.getString(1), rs.getInt(2),
					rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getDate(6), rs.getDouble(7));
			list.add(scoreCou);
		}
		return list;

	}

	@Override
	public PageBean selectScoreSum(int pageNo, int pageCount)
			throws SQLException {
		int totalCount = 0;
		int i = 1;
		List<ScoreSum> list = new ArrayList<ScoreSum>();
		String sql = "select score.stu_num,score.stu_name,score.stu_class,score.major, sum(score.score_grade) as total,avg(score.score_grade) as avg "
				+ "from score group by score.stu_num order by total DESC limit ?,?";
		String sqlCount = "select count(*) from (select stu_num from score group by stu_num ) as a";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNo - 1) * pageCount);
		ps.setInt(2, pageCount);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int number = i;

			ScoreSum scoreSum = new ScoreSum(number, rs.getString(1),
					rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getDouble(5), rs.getDouble(6));
			list.add(scoreSum);
			i++;
		}
		PreparedStatement ps1 = conn.prepareStatement(sqlCount);
		ResultSet rs1 = ps1.executeQuery();
		while (rs1.next()) {
			totalCount = rs1.getInt(1);
		}
		pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		return pageBean;
	}

	@Override
	public PageBean selectStuScore(int pageNo, int pageCount, String stuNum,
			String courseName, String stuName, String stuClass, String major)
			throws SQLException {
		int totalCount = 0;
		List<Score> list = new ArrayList<Score>();
		String sql = "select * from score where stu_num like ? and course_name like ? and stu_name like ? and stu_class like ? and major like ?limit ?,?";
		String sqlCount = "select count(*) from score where stu_num like ? and course_name like ? and stu_name like ?and stu_class like ? and major like ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + stuNum + "%");
		ps.setString(2, "%" + courseName + "%");
		ps.setString(3, "%" + stuName + "%");
		ps.setString(4, "%" + stuClass + "%");
		ps.setString(5, "%" + major + "%");
		ps.setInt(6, (pageNo - 1) * pageCount);
		ps.setInt(7, pageCount);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Score score = new Score(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getDouble(6), rs.getString(7));
			list.add(score);
		}
		PreparedStatement ps1 = conn.prepareStatement(sqlCount);
		ps1.setString(1, "%" + stuNum + "%");
		ps1.setString(2, "%" + courseName + "%");
		ps1.setString(3, "%" + stuName + "%");
		ps1.setString(4, "%" + stuClass + "%");
		ps1.setString(5, "%" + major + "%");
		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {
			totalCount = rs1.getInt(1);
		}
		pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		return pageBean;
	}

	@Override
	public PageBean selectTeaScore(int pageNo, int pageCount, String teaName,
			String stuName, String stuClass, String stuNum) throws SQLException {
		int totalCount = 0;
		List<Score> list = new ArrayList<Score>();
		String sql = "select score.score_id,score.stu_num,score.stu_name,score.stu_class,score.course_name,score.score_grade,score.major from score,course where score.course_name=course.course_name and course.course_teacher=?"
				+ " and score.stu_name like ?"
				+ " and score.stu_class like ?"
				+ " and score.stu_num like ? limit ?,?";

		String sqlCount = "select count(*) from score,course where score.course_name=course.course_name and course_teacher=? and stu_name like ? and stu_class like ? and stu_num like ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, teaName);
		ps.setString(2, "%" + stuName + "%");
		ps.setString(3, "%" + stuClass + "%");
		ps.setString(4, "%" + stuNum + "%");
		ps.setInt(5, (pageNo - 1) * pageCount);
		ps.setInt(6, pageCount);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Score score = new Score(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7));
			list.add(score);
		}
		PreparedStatement ps1 = conn.prepareStatement(sqlCount);
		ps1.setString(1, teaName);
		ps1.setString(2, "%" + stuName + "%");
		ps1.setString(3, "%" + stuClass + "%");
		ps1.setString(4, "%" + stuNum + "%");
		ResultSet rs1 = ps1.executeQuery();

		while (rs1.next()) {
			totalCount = rs1.getInt(1);
		}
		pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		return pageBean;
		
	}

}
