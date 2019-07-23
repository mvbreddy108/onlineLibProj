package com.library;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.PrintWriter;
public class SubjectDB extends HttpServlet 
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
		try {
		Connection cn=Database.getConnection();
		PreparedStatement ps=cn.prepareStatement("select subid,subname from subject where deptid=? and sem=?");
		int a=Integer.parseInt(req.getParameter("department"));
		int b=Integer.parseInt(req.getParameter("semester"));
		System.out.println(a+" "+b);
		PrintWriter out=res.getWriter();
		ps.setInt(1,a);
		ps.setInt(2,b);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			out.println("<option value="+String.valueOf(rs.getInt(1))+">"+rs.getString(2)+"</option>");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
}
