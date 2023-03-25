package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/palindrome", initParams = {
		@WebInitParam(name = "gg", value= "abba")
				
	})
public class Palindrome extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("gg");
		String tmp = "";
		for(int i = name.length() - 1; i >= 0; i--) {
			tmp += name.charAt(i);
		}
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		if(name.compareTo(tmp) == 0) {
			writer.println("<h1>" + name + " la 1 Palindrome" + "</h1>");
			writer.close();
		}
		else {
			writer.println("<h1>" + name + " khong la 1 Palindrome" + "</h1>");
			writer.close();
		}
		
		
		
	}
}
