package com.library;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DownloadFile extends javax.servlet.http.HttpServlet {
	private static final long serialVersionUID=1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		try
		{
			Connection cn=Database.getConnection();
			PreparedStatement ps=cn.prepareStatement("select pdf from book where bookid=?");
			int a=Integer.parseInt(req.getParameter("loc"));
			System.out.println(a);
			ps.setInt(1,a);
			ResultSet rs=ps.executeQuery();
			rs.next();
			Object requestObject=rs.getString(1);
			if(requestObject!=null)
			{
				String filePath=(String)requestObject;
				res.setContentType("application/pdf");
				File file=new File(filePath);
				res.addHeader("Content-Disposition", "attachment;filename=yourpdf.pdf");
				res.setContentLength((int) file.length());
				ServletOutputStream sos=res.getOutputStream();
				BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
				int bytesRead=bis.read();
				while(bytesRead!=-1)
				{
					sos.write(bytesRead);
					bytesRead=bis.read();
				}
				//if(sos!=null)
					//sos.close();
				//if(bis!=null)
				//	bis.close();
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
        
}
