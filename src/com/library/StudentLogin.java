package com.library;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class StudentLogin extends HttpServlet {
	public void service(HttpServletRequest req , HttpServletResponse res)
	{
		try
		{
			String name=req.getParameter("uname");
			System.out.println(name);
			String password=req.getParameter("psw");
			PrintWriter out=res.getWriter();
			String a="nita";
			String b="library";
			if(name.equals(a)&&password.equals(b))
			{
				
				out.printf("<!DOCTYPE html>\r\n" + 
						"<html>\r\n" + 
						"<head>\r\n" + 
						"<meta charset=\"ISO-8859-1\">\r\n" + 
						"<link rel=\"stylesheet\" href=\"style1.css\">\r\n" + 
						"<title>LoginPage</title>\r\n" + 
						"</head>\r\n" +
						"<body>\r\n" + 
						"<h1 style=\"text-align:center\">WELCOME</h1>\r\n" +
						"<form action=\"./display\">"+
						"<div class=\"container\">\r\n" + 
						"Department:\r\n" + 
						"\r\n" + 
						"<select class=\"custom-select\" id=\"dep\"  name=\"department\">\r\n" + 
						"<option value=\"0\">Select Your Department</option>"+
						"<option value=\"1\">BIO TECHNOLOGY</option>\r\n" + 
						"<option value=\"2\">BSMS-MATHEMATICS</option>\r\n" + 
						"<option value=\"3\">BSMS-PHYSICS</option>\r\n" + 
						"<option value=\"4\">CHEMICAL ENGINEERING</option>\r\n" +
						"<option value=\"5\">CIVIL ENGINEERING</option>\r\n" +  
						"<option value=\"6\">COMPUTER SCIENCE AND ENGINEERING</option>\r\n" + 
						"<option value=\"7\">ELECTRONICS AND COMMUNICTION ENGINEERING</option>\r\n" + 
						"<option value=\"8\">ELECTRICAL ENGINEERING</option>\r\n" +
						"<option value=\"9\">ELECTRONICS AND INSTRUMENTATION ENGINEERING</option>\r\n" + 
						"<option value=\"10\">MECHANICAL ENGINEERING</option>\r\n" + 
					    "<option value=\"11\">PRODUCTION ENGINEERING</option>\r\n"+
						"</select><br>\r\n" + 
						"\r\n" );
				
				out.printf(
						"Enter Semester:\r\n" + 
						"<select name=\"semester\" id=\"sem\" class=\"custom-select\" onchange=\"show(this.value)\">\r\n" + 
						"<option value=\"0\">Select Your semester</option>"+
						"<option value=\"1\">1-a</option>\r\n" + 
						"<option value=\"2\">1-b</option>\r\n" + 
						"<option value=\"1\">2-a</option>\r\n" +
						"<option value=\"2\">2-b</option>\r\n" +
						"<option value=\"3\">3</option>\r\n" + 
						"<option value=\"4\">4</option>\r\n" + 
						"<option value=\"5\">5</option>\r\n" + 
						"<option value=\"6\">6</option>\r\n" + 
						"<option value=\"7\">7</option>\r\n" + 
						"<option value=\"8\">8</option>\r\n" + 
						"<option value=\"9\">9</option>\r\n" + 
						"<option value=\"10\">10</option>\r\n" + 
						"</select>\r\n" );
				out.printf("Enter Subject:\r\n"+
							"<select  name=\"subject\" id=\"sub\" class=\"custom-select\">");
						out.println("<option value=\"0\">Enter value</option>");
						out.println("</select>");
						out.println("<input type=\"submit\" value=\"view books\">");
						out.println("</form>");
				out.println(" <script  src=\"ajax.js\"></script>"+
						"</body>\r\n" + 
						"</html>");
			}
			
			else
			{
				out.println("<html><body>wrong userid or password</body></html>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
