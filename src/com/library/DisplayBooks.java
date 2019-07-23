package com.library;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.PrintWriter;
public class DisplayBooks extends HttpServlet  {
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			int subid=Integer.parseInt(req.getParameter("subject"));
			Connection cn=Database.getConnection();
			PreparedStatement ps=cn.prepareStatement("Select bookid,title,author,noc,pdf from book where bookid=(select bookid from connection where subid=?)");
			ps.setInt(1, subid);
			ResultSet rs=ps.executeQuery();
			PrintWriter out=res.getWriter();
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"\r\n" + 
					"<title>LoginPage</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"<table style=\"width:100%\">\r\n" + 
					"  <caption>Books Available</caption>\r\n" + 
					"  <tr>\r\n" + 
					"    <th>Book Name</th>\r\n" + 
					"    <th>Author Name</th>\r\n" + 
					"    <th>books available</th>\r\n" + 
					"    <th>PDF</th>\r\n" + 
					"  </tr>");
			
			while(rs.next())
			{
				String s=rs.getString(5);
				out.println("<tr>\r\n"+
						"<th>"+rs.getString(2)+"</th>"+
						"<th>"+rs.getString(3)+"</th>"+
						"<th>"+rs.getInt(4)+"</th>"+
						"<th><a  href=\"downlod?loc="+String.valueOf(rs.getInt(1))+"\">download</a></th>");
			}
			out.println(" <script  src=\"ajax.js\"></script>"+
					"</body>\r\n" + 
					"</html>");
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
