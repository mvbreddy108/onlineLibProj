package com.library;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Subject extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
		try {
		Connection cn=Database.getConnection();
		PreparedStatement ps=cn.prepareStatement("select subid,subname from subject where deptid=? and sem=?");
		int a=Integer.parseInt(req.getParameter("dep"));
		int b=Integer.parseInt(req.getParameter("sem"));
		System.out.println(a+" "+b);
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		ps.setInt(1,a);
		ps.setInt(2,b);
		String txt="";
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			txt=txt+"<option value="+String.valueOf(rs.getInt(1))+">"+rs.getString(2)+"</option>";
		}
		out.write(txt);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
