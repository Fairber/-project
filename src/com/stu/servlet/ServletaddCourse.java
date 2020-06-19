package com.stu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stu.bean.Course;
import com.stu.service.impl.CourseServiceImpl;


public class ServletaddCourse extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Course course;
	private ServletFindAllCos servletFindAllCos=new ServletFindAllCos();
	private CourseServiceImpl courseServiceImpl=new CourseServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseName = request.getParameter("courseName");
		int courseCredit = Integer.parseInt(request.getParameter("courseCredit"));
		int courseHours = Integer.parseInt(request.getParameter("courseHours"));
		String courseTea = request.getParameter("courseTea");
		String coDate = request.getParameter("courseDate");

		
	//	System.out.println(courseDate);
		course=new Course(courseName, courseCredit, courseHours, courseTea,  java.sql.Date.valueOf(coDate));
		//new Course( courseName,  courseCredit,  courseHours,
		//		 courseTea,  courseDate);
		//验证是否存在该教师课程
		Course cos = null;
		try {
			cos = courseServiceImpl.selectOneCos(courseName, courseTea);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cos==null){
			int rs = 0;
			try {
				rs = courseServiceImpl.addCos(course);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rs>0){
				request.setAttribute("msg", "添加成功！！");
				servletFindAllCos.doGet(request, response);
			//	request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "该课程已录入，请重新输入！！");
			request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
