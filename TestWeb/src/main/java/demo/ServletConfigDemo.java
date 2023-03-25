package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/test-config", initParams = {
	@WebInitParam(name = "number", value= "5")
			
})
public class ServletConfigDemo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int number = Integer.parseInt(req.getParameter("number"));
		String id = req.getParameter("id");
		String user = req.getParameter("user");
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Binh Phuong Cua "+ Integer.toString(number) + " la " + Integer.toString(number * number)+ "</h1>");
		writer.close();
		
		
	}
	
}

