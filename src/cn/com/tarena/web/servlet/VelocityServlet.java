package cn.com.tarena.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public class VelocityServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String templateFile = req.getServletPath();
		
		try {
			/*
			 * setup
			 */

			// 可以通过vm在磁盘上的绝对路径装载vm
			 Velocity.addProperty(Velocity.FILE_RESOURCE_LOADER_PATH,
			 getServletContext().getRealPath("/") + "/WEB-INF/vm");

			// 也可以通过基于classpath的资源装载器，加载classpath下的vm
//			Velocity.addProperty("file.resource.loader.class",
//					"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

			Velocity.init();

			/*
			 * Make a context object and populate with the data. This is where
			 * the Velocity engine gets the data to resolve the references (ex.
			 * $list) in the template
			 */

			VelocityContext context = new VelocityContext();
//			context.put("list", getNames());
			context.put("request", req);
			context.put("session", req.getSession());
			context.put("context", getServletContext());

			/*
			 * get the Template object. This is the parsed version of your
			 * template input file. Note that getTemplate() can throw
			 * ResourceNotFoundException : if it doesn't find the template
			 * ParseErrorException : if there is something wrong with the VTL
			 * Exception : if something else goes wrong (this is generally
			 * indicative of as serious problem...)
			 */

			Template template = null;

			try {
				template = Velocity.getTemplate(templateFile);
			} catch (ResourceNotFoundException rnfe) {
				System.out.println("Example : error : cannot find template "
						+ templateFile);
			} catch (ParseErrorException pee) {
				System.out.println("Example : Syntax error in template "
						+ templateFile + ":" + pee);
			}

			/*
			 * Now have the template engine process your template using the data
			 * placed into the context. Think of it as a 'merge' of the template
			 * and the data to produce the output stream.
			 */

			PrintWriter out = resp.getWriter();

			if (template != null)
				template.merge(context, out);

			/*
			 * flush and cleanup
			 */

			out.flush();
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
