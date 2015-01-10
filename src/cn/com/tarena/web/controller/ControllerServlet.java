package cn.com.tarena.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
