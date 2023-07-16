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
@WebServlet("/deleteurl")
public class Delete extends HttpServlet {
	private  final static String query="delete from user where id=?";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		pw.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		
		int id=Integer.parseInt(req.getParameter("id"));
		 try {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	      }
	      catch(Exception e) {
	    	  System.out.println("<h2 class='bg-danger text-light text-center '>"+e);
	      }
	      
	      try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","khushi123")) {

	    	  
	    	  PreparedStatement ps=con.prepareStatement(query);
	          
	    	  ps.setInt(1, id);
	    	  int count=ps.executeUpdate();
	    	  pw.println("<div class='card' style='margin:auto;width:300px;margin-top:50px'>");
	     	  if(count==1) {
	    		  pw.println("<h2 class= 'bg-danger text-white text-center'>Record Deleted Successfully...</h2>");
	    	  }
	    	  else
	    	  {
	    		  pw.println("<h2  class= 'bg-warning text-white text-center'>Not deleted</h2>");
	    	  }
	    	  
	    	 
	    	  
	}
	      catch(SQLException se) {
	    	System.out.println("<h2 class='bg-danger text-light text-center '>"+se);
	      }
	      pw.println("<a href='index.jsp'><button type=\"button\" class=\"btn btn-outline-danger\" style='margin-left:120px ; margin-bottom:5px'>Home</button>");
    	  
    	  pw.println("<a href='showdata'><button type=\"button\" class=\"btn btn-outline-danger\" style='margin-left:120px ; margin-bottom:5px'>Show</button>");
    	  
    	  pw.println("</div>");
    	  pw.close();
    	  
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  doGet(req,resp);
	}

}
