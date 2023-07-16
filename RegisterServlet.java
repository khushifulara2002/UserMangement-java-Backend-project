package com.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")


public class RegisterServlet extends HttpServlet {
	public final static String query= "INSERT INTO user (name, email, dob, address, phone_no, gender) VALUES ( ?,?, ?, ?, ?, ?)";
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	PrintWriter pw=resp.getWriter();
	resp.setContentType("text/html");
	
	pw.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
	
	//get the values....
	
	  String name=req.getParameter("userName");
      String email=req.getParameter("userEmail");
      String dob=req.getParameter("userDate");
      String address=req.getParameter("userAddress");
      String phone=req.getParameter("userPhone");
      String gender=req.getParameter("userGender");
      
      //load the JDBC server
      
      try {
    	  Class.forName("com.mysql.cj.jdbc.Driver");
      }
      catch(Exception e) {
    	  System.out.println("<h2 class='bg-danger text-light text-center '>"+e);
      }
      
      try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","khushi123")) {

    	  
    	  PreparedStatement ps=con.prepareStatement(query);
          
          ps.setString(1,name);
          ps.setString(2,email);
          ps.setString(3,dob);
          ps.setString(4,address);
          ps.setString(5,phone);
          ps.setString(6,gender);
          
    	  
    	  int count=ps.executeUpdate();
    	  pw.println("<div class='card' style='margin:auto;width:300px;margin-top:50px'>");
    	  if(count==1) {
    		  pw.println("<h2 class= 'bg-primary text-white text-center'>Record Registered Successfully </h2>");
    	  }
    	  else
    	  {
    		  pw.println("<h2  class= 'bg-danger text-white text-center'>Not registered</h2>");
    	  }
    	  
    	  pw.println("<a href='index.jsp'><button type=\"button\" class=\"btn btn-outline-primary\" style='margin-left:100px ; margin-bottom:5px'>Home</button>");
    	  
    	  pw.println("</div>");
    	  
    	  
}
      catch(SQLException se) {
    	System.out.println("<h2 class='bg-danger text-light text-center '>"+se);
      }
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req,resp);
	}
	
}

