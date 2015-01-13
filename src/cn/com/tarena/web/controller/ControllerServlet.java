package cn.com.tarena.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.tarena.pojo.Student;
import cn.com.tarena.service.StudentService;
import cn.com.tarena.service.impl.StudentServiceImpl;



public class ControllerServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String path = req.getServletPath();
		
		path = path.substring(0,path.indexOf("."));
		
		if("/toStudentList".equals(path)){
			try{
				StudentService studentService = new StudentServiceImpl();
				
				List studentList = studentService.getStudentList();
				
				req.setAttribute("studentList", studentList);
				
				getServletContext().getRequestDispatcher("/studentList").forward(req, resp);
				
			} catch (Exception e){
				req.setAttribute("message", e.getMessage());
				
				getServletContext().getRequestDispatcher("/error").forward(req, resp);
			}			
		}else if("/toLogin".equals(path)){
			getServletContext().getRequestDispatcher("/login").forward(req, resp);
			
		} else if("/doLogin".equals(path)){
			String userName = req.getParameter("userName");			
			String password = req.getParameter("password");
			
			Student paramStudent = new Student();
			
			paramStudent.setUserName(userName);
			paramStudent.setPassword(password);
			
			StudentService studentService = new StudentServiceImpl();
			
			Student student = studentService.getStudentByUserNameAndPassword(paramStudent);
			
			if(student != null){
				req.setAttribute("student", student);
				
				getServletContext().getRequestDispatcher("/welcome").forward(req, resp);
			}else{
				req.setAttribute("message", "The user was not found");
				
				getServletContext().getRequestDispatcher("/login").forward(req, resp);
			}
			
		} else {
			resp.sendError(resp.SC_NOT_FOUND);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}
