package com.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/showdata")

public class ShowUser extends HttpServlet {
	
	private final static String query="select id,name,email,dob,address,phone_no,gender from user";
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		pw.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		pw.println("<marquee><h1 class='text-primary' style='font:Monospace;'>User Data</h1></marquee>");
		
		 try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	      }
	      catch(Exception e) {
	    	  System.out.println("<h2 class='bg-danger text-light text-center '>"+e);
	      }
	      
	      try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","khushi123")) {

	    	  
	    	  PreparedStatement ps=con.prepareStatement(query);
	    	  ResultSet rs=ps.executeQuery();
	    	  pw.println("<div style='margin:auto;width:900px;margin-top:100px;'>");
	    	  pw.println("<table class='table table-hover table-striped'>");
	    	  pw.println("<tr>");
	    	  pw.println("<th>ID</th>");
	    	  pw.println("<th>Name</th>");
	    	  pw.println("<th>Email</th>");
	    	  pw.println("<th>DOB</th>");
	    	  pw.println("<th>Address</th>");
	    	  pw.println("<th>Phone no.</th>");
	    	  pw.println("<th>Gender</th>");
	    	  pw.println("<th>Edit</th>");
	    	  pw.println("<th>Delete</th>");
	    	  
	    	  pw.println("</tr>");
	    	  
	    	  while(rs.next()) {
	    		  pw.println("<tr>");
	    		  pw.println("<td>"+rs.getInt(1)+"</td>");
	    		  pw.println("<td>"+rs.getString(2)+"</td>");
	    		  pw.println("<td>"+rs.getString(3)+"</td>");
	    		  pw.println("<td>"+rs.getString(4)+"</td>");
	    		  pw.println("<td>"+rs.getString(5)+"</td>");
	    		  pw.println("<td>"+rs.getString(6)+"</td>");
	    		  pw.println("<td>"+rs.getString(7)+"</td>");
	    		  pw.println("<td><a href='editurl?id="+rs.getInt(1)+"'>Edit</a></td>");
	    		  pw.println("<td><a href='deleteurl?id="+rs.getInt(1)+"'>Delete</a></td>");
	    		 
	    		 
	    		 
	    		  
	    		  pw.println("</tr>");
	    	  }
	    	  
	    	   pw.println("</table>");
	    	  
	    	  
	          
			
		}
	      catch(SQLException se) {
	      	System.out.println("<h2 class='bg-danger text-light text-center '>"+se);
	        }

	
	      pw.println("<a href='index.jsp'><button type=\"button\" class=\"btn btn-outline-primary\" style='margin-left:10px ; margin-bottom:5px margin-top:10px;'>Home</button>");
    	  
	  	  pw.println("</div>");
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  doGet(req,resp);
}
}
	
	

	


