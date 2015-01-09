package cn.com.tarena.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

		Connection conn = null;
		
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from student");
			
			while(rs.next()){
				out.println("	<tr>");
				out.println("		<td>" + rs.getString("USER_NAME") + "</td>");
				out.println("		<td>" + rs.getString("PASSWORD") + "</td>");
				out.println("		<td>" + rs.getString("PROVINCE") + "</td>");
				out.println("		<td>" + rs.getString("GENDER") + "</td>");
				out.println("		<td>" + rs.getString("HOBBIES") + "</td>");
				out.println("	</tr>");				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("error when querying students!",e);
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
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
