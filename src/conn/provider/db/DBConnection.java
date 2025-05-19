package conn.provider.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String dbUrl = "jdbc:mysql://localhost:3306/";
	private static final String dbDriver = "com.mysql.jdbc.Driver";
	private static final String dbName = "Highradius";
	private static final String dbUserName = "root";
	private static final String dbPassword = "system";
	private static Connection connection = null;
		
		public static Connection openConnection() 
		{
			if (connection != null)
	            return connection;
	        else 
	        {
	            try 
	            {
	            	Class.forName(dbDriver); 
	            	Connection connection = DriverManager.getConnection(dbUrl + dbName,dbUserName, dbPassword);
	            } 
	            catch (ClassNotFoundException e) 
	            {
	                e.printStackTrace();
	            } 
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            } 
	            return connection;
	        }
		}
}
