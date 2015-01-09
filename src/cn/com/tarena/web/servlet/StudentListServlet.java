package cn.com.tarena.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.tarena.pojo.Student;
import cn.com.tarena.service.StudentService;
import cn.com.tarena.service.impl.StudentServiceImpl;



public class StudentListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try{
			StudentService studentService = new StudentServiceImpl();
			
			List studentList = studentService.getStudentList();
			
			showStudentList(resp, studentList);			
		} catch (Exception e){
			showError(resp,e.getMessage());
		}
	}

	private void showStudentList(HttpServletResponse resp, List studentList)
			throws IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>StudentList</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 align=\"center\">StudentList</h2>");
		out.println("<hr>");
		out.println("<table border=\"1\" align=\"center\">");
		out.println("	<tr>");
		out.println("		<th>USER_NAME</th>");
		out.println("		<th>PASSWORD</th>");
		out.println("		<th>PROVINCE</th>");
		out.println("		<th>GENDER</th>");
		out.println("		<th>HOBBIES</th>");
		out.println("	</tr>");

		for(Iterator<Student> it = studentList.iterator();it.hasNext();){
			Student student = it.next();
			
			out.println("	<tr>");
			out.println("		<td>" + student.getUserName() + "</td>");
			out.println("		<td>" + student.getPassword() + "</td>");
			out.println("		<td>" + student.getProvince() + "</td>");
			out.println("		<td>" + student.getGender() + "</td>");
			out.println("		<td>" + student.getProvince() + "</td>");
			out.println("	</tr>");	
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	
	private void showError(HttpServletResponse resp, String message)
			throws IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Error</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 align=\"center\">System Error</h2>");
		out.println("<hr>");
		out.println(message);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
}
