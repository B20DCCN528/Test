package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class SqlSever extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    resp.setContentType("text/html");
    PrintWriter printer = resp.getWriter();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/Addbook.jsp");
        dispatcher.forward(req, resp);
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "12345");
      statement = connection.createStatement();
      resultSet = statement.executeQuery("select * from book;");
      while (resultSet.next()) {
        int bookcode = resultSet.getInt("Bookcode");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        int category = resultSet.getInt("category");
        int sold = resultSet.getInt("sold");
        printer.println("<br>"+ bookcode + ", " + title + ", " + author+ ", " + category + ", " + sold);
        
      }
      System.out.println("connect successfully!");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    resp.setContentType("text/html");
    Connection connection = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "12345");
      PreparedStatement st = connection.prepareStatement("INSERT INTO book (title, author, category, sold) VALUES ( ?, ?, ?, ?)");
      

      st.setString(1, req.getParameter("title"));
      st.setString(2, req.getParameter("author"));
      st.setInt(3,Integer.valueOf(req.getParameter("category")));
      st.setInt(4,Integer.valueOf(req.getParameter("sold")));
      
      st.executeUpdate();
      st.close();
      connection.close();
      
      resp.sendRedirect("books");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}