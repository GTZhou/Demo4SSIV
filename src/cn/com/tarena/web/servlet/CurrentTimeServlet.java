package cn.com.tarena.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrentTimeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		out.println("<head>");
		out.println("	<title>Current Time</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 align=\"center\">Current Time</h2>");
		out.println("<hr>");
		out.println(new Date());
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
