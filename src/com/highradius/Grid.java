package com.highradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
//import conn.provider.db.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;

@WebServlet("/Grid")
public class Grid extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String dbDriver = ("com.mysql.jdbc.Driver");
	String dbUrl = "jdbc:mysql://localhost:3306/";
	String dbName = "Highradius";
	String dbUserName = "root";
	String dbPassword = "system";

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		List<HashMap<String,Object>> result = new ArrayList<HashMap<String,Object>>();
		
		try
		{
			int start = Integer.parseInt(req.getParameter("start"));
			int limit = Integer.parseInt(req.getParameter("limit"));
			Class.forName(dbDriver); 
			Connection con = DriverManager.getConnection(dbUrl + dbName,dbUserName, dbPassword);
			PreparedStatement ps = con.prepareStatement("select business_code,cust_number,name_customer,clear_date,buisness_year,doc_id from mytable LIMIT ? , ?");
			ps.setInt(1, start);
			ps.setInt(2, limit);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				HashMap<String,Object> row = new HashMap<String,Object>();
				row.put("business_code",rs.getString(1));
				row.put("cust_number",rs.getString(2));
				row.put("name_customer",rs.getString(3));
				row.put("clear_date",rs.getString(4));
				row.put("buisness_year",rs.getString(5));
				row.put("doc_id",rs.getString(6));

				result.add(row);	
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Gson gson = new Gson();
		res.getWriter().print(gson.toJson(result));
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
