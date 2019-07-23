package com.library;
import java.sql.Connection;
import java.sql.DriverManager;
public class Database {
	
	public static Connection getConnection()
	{
		Connection cn=null;
		try {
		
		cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_library", "root", "Bharath@1");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cn;
		
	}

}
