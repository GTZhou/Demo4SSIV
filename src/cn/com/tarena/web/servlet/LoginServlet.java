package cn.com.tarena.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.tarena.pojo.Student;



public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Student student = (Student)req.getAttribute("student");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 align=\"center\">Login</h2>");
		out.println("<hr>");
		
		if(req.getSession().getAttribute("message") != null){
			out.println(req.getSession().getAttribute("message"));			
		}
		
		out.println("<form action=\"doLogin.asp\" method=\"post\">");
		out.println("	Username:<input name=\"userName\" type=\"text\"><br>");
		out.println("	Password:<input name=\"password\" type=\"password\"><br>");
		out.println("	<input type=\"submit\" value=\"login\">");
		out.println("</form>");
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
