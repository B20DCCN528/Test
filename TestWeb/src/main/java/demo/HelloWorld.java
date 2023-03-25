package demo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Hello")
public class HelloWorld extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("Bat dau Servlet!");
	}
	@Override
	public void destroy() {
		System.out.println("Ket thuc Servlet");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req,resp);
		System.out.println("Bat dau 1 service (API)");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Hello World</h1>");
		writer.close();
		
		StringBuffer url = req.getRequestURL();
		System.out.println("URL of the request: " + url.toString());
		
		String method = req.getMethod();
		System.out.println("Method of the request: " + method);
	
		String servletPath = req.getServletPath();
		System.out.println("Servlet path of the request: " + servletPath);
	
		String contextPath = req.getContextPath();
		System.out.println("Context path of the request: " + contextPath);
		
		System.out.println("Headers of the request:");
		Enumeration<String> headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String value = req.getHeader(name);
			System.out.println(name + ": " + value);
		}
		
		resp.setHeader("Content-Type", "text/html; charset=utf-8");
		resp.setHeader("Cache-Control", "no-cache");
		
		Collection<String> headerNames1 = resp.getHeaderNames();
		System.out.println("Response headers:");
		for(String name : headerNames1) {
			String value = resp.getHeader(name);
			System.out.println(name + ": " + value);
		}
		
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		
		int status = resp.getStatus();
		System.out.println("Response status: " + status);
		
		
		resp.getWriter().write("<h1>404 Not Found</h1>");
	
	
	}
	
	
}
