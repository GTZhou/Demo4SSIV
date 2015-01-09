package cn.com.tarena.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
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
		out.println("	<tr>");
		out.println("		<td>ZhouYu</td>");
		out.println("		<td>111</td>");
		out.println("		<td>Shanghai</td>");
		out.println("		<td>male</td>");
		out.println("		<td>Game</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Tom</td>");
		out.println("		<td>123</td>");
		out.println("		<td>&nbsp;</td>");
		out.println("		<td>male</td>");
		out.println("		<td>Mouse</td>");
		out.println("	</tr>");
		out.println("</table>");
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
