package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/getHoTen", initParams = {
		@WebInitParam(name = "ho", value= "Ta"),
		@WebInitParam(name = "ten", value= "Ton")
				
	})
public class getHoTen extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("ho");
		String name1 = req.getParameter("ten");
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<h1>Cac ha ho " + name + " ten "+ name1 + " </h1>");
		writer.close();
		
	}
}
