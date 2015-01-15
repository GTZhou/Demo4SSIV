package cn.com.tarena.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.tarena.pojo.Student;

public class WelcomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Student student = (Student) req.getAttribute("student");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("	<title>Welcome</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 align=\"center\">Welcome</h2>");
		out.println("<hr>");
		out.println("Welcome back," + student.getUserName() + "!<br>");
		out.println("<a href=\"toStudentList."
				+ getServletContext().getAttribute("pathSuffix")
				+ "\">to StudentList</a>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
