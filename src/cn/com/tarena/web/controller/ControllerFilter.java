package cn.com.tarena.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.tarena.pojo.Student;
import cn.com.tarena.service.StudentService;
import cn.com.tarena.util.ServiceFactory;

public class ControllerFilter implements Filter {

	private FilterConfig config;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String path = req.getServletPath();

		String pathSuffix = path.split("\\.")[1];

		path = path.split("\\.")[0];
		
		getServletContext().setAttribute("pathSuffix", pathSuffix);
		
		if("/toStudentList".equals(path)){			
			try{
				StudentService studentService = ServiceFactory.getStudentService();
				
				List studentList = studentService.getStudentList();
				
				req.setAttribute("studentList", studentList);
				
				getServletContext().getRequestDispatcher("/studentList.vm").forward(req, resp);
				
			} catch (Exception e){
				req.setAttribute("message", e.getMessage());
				
				getServletContext().getRequestDispatcher("/error.vm").forward(req, resp);
			}			
		}else if("/toLogin".equals(path)){
			getServletContext().getRequestDispatcher("/login.vm").forward(req, resp);
			
			req.getSession().removeAttribute("message");
			
		} else if("/doLogin".equals(path)){
			String userName = req.getParameter("userName");			
			String password = req.getParameter("password");
			
			Student paramStudent = new Student();
			
			paramStudent.setUserName(userName);
			paramStudent.setPassword(password);
			
			req.getSession().setAttribute("paramStudent", paramStudent);
			
			StudentService studentService = ServiceFactory.getStudentService();
			
			Student student = studentService.getStudentByUserNameAndPassword(paramStudent);
			
			if(student != null){
				req.getSession().setAttribute("IS_LOGIN", "1");
				
				req.setAttribute("student", student);
				
				req.getSession().setAttribute("student", student);
				
				getServletContext().getRequestDispatcher("/welcome.vm").forward(req, resp);
			}else{
				req.getSession().setAttribute("message", "The user was not found");
				
				resp.sendRedirect(getServletContext().getContextPath() + "/toLogin." + pathSuffix);
			}
			
		} else {
			chain.doFilter(req, resp);
		}
	}

	private ServletContext getServletContext() {
		return config.getServletContext();
	}

	@Override
	public void destroy() {

	}
	
	
}
