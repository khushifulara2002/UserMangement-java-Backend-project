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
import javax.servlet.http.HttpServlet;

@WebServlet("/editurl")
public class Edit extends HttpServlet {

	private final static String query="select name,email,dob,address,phone_no,gender from user where id=?";

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		
		//get id 
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		pw.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		
		
		 try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	      }
	      catch(Exception e) {
	    	  System.out.println("<h2 class='bg-danger text-light text-center '>"+e);
	      }
	      
	      try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","khushi123")) {

	    	  
	    	  PreparedStatement ps=con.prepareStatement(query);
	    	  //set value
	    	  ps.setInt(1, id);
	    	  ResultSet rs=ps.executeQuery();
	    	  rs.next();
	    	 pw.println("<div style='margin:auto;width:300px;margin-top:100px;'>");
	    	 pw.println("<form action='edit?id="+id+"' method='post'>");
	    	 pw.println("<table class='table table-hover table-striped'>");
	    	 pw.println("<tr>");
	    	 pw.println("<td>Name</td>");
	    	 pw.println("<td><input type ='text' name='name' value='"+rs.getString(1)+"'</td>");
	    	 pw.println("</tr>");
	    	 pw.println("<tr>");
	    	 pw.println("<td>Email</td>");
	    	 pw.println("<td><input type ='email' name='email' value='"+rs.getString(2)+"'</td>");
	    	 pw.println("</tr>");
	    	 pw.println("<tr>");
	    	 pw.println("<td>DOB</td>");
	    	 pw.println("<td><input type ='date' name='dob' value='"+rs.getString(3)+"'</td>");
	    	 pw.println("</tr>");
	    	 pw.println("<tr>");
	    	 pw.println("<td>Address</td>");
	    	 pw.println("<td><input type ='textarea' name='address' value='"+rs.getString(4)+"'</td>");
	    	 pw.println("</tr>");
	    	 pw.println("<tr>");
	    	 pw.println("<td>Phone number</td>");
	    	 pw.println("<td><input type ='number' name='phone' value='"+rs.getString(5)+"'</td>");
	    	 pw.println("</tr>");
	    	 pw.println("<tr>");
	    	  pw.println("<td>Gender</td>");
	    	 pw.println("<td><input type ='text' name='gender' value='"+rs.getString(6)+"'</td>");
	    	 pw.println("</tr>");
	    	 pw.println("<tr>");
	    	 pw.println("<td><button type='submit' class='btn btn-outline-success'>Edit</button></td>");
	    	 pw.println("<td><a href='index.jsp'><button type=\"button\" class=\"btn btn-outline-primary\">Back to Home</button></td>");
	        pw.println("</tr>");
	    	 
	    	 
	    	 pw.println("</table>");
	    	 
	    	 
	    	 pw.println("</form>");
	    	
	    
	    	   
	    
	    	  
	          
			
		}
	      catch(SQLException se) {
	      	System.out.println("<h2 class='bg-danger text-light text-center '>"+se);
	        }

	     
    	  
	 	 pw.println("</div>");
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  doGet(req,resp);
}
}
	

	
	

