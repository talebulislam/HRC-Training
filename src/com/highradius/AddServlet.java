package com.highradius;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String dbDriver = ("com.mysql.jdbc.Driver");
	String dbUrl = "jdbc:mysql://localhost:3306/";
	String dbName = "Highradius";
	String dbUserName = "root";
	String dbPassword = "system";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();      
		String n=request.getParameter("name_customer");  
		String p=request.getParameter("cust_number");  
		String e=request.getParameter("due_in_date");  
		String c=request.getParameter("doc_id");  
		String t=request.getParameter("total_open_amount");
		String note =request.getParameter("document_type");
        try
        {  
			Class.forName(dbDriver); 
			Connection con = DriverManager.getConnection(dbUrl + dbName,dbUserName, dbPassword);   
        	PreparedStatement ps=con.prepareStatement("insert into Trl values(name_customer,cust_number,due_in_date,doc_id,total_open_amount,document_type)values(?,?,?,?,?,?)");  
        	ps.setString(1,n);  
        	ps.setString(2,p);  
        	ps.setString(3,e);  
        	ps.setString(4,c);  
        	ps.setString(5,t);
        	ps.setString(6,note);
          
        	int i=ps.executeUpdate();  
        	if(i>0)  
        		out.print("You are successfully registered...");  
      
        }
        catch (Exception e2) {System.out.println(e2);}        
        out.close(); 
	}  
  
}  
