package Depo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Guncelle extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int ogrencino= Integer.parseInt(req.getParameter("ogrencino"));
	String ad= req.getParameter("ad");
	int vize= Integer.parseInt(req.getParameter("vize"));
	int finall= Integer.parseInt(req.getParameter("finall"));
	float ortalama= Float.parseFloat(req.getParameter("ortalama"));
	
	PgConnector pgc=new PgConnector();
	Connection c=pgc.getConnection();
	
	if(c!=null) {
		String sql="UPDATE public.t_ogrenci SET ad_soyad=?, vize=?, final=? , ortalama=?  WHERE ogrenci_no=?;";
		PreparedStatement ps=null;
		try {
			ps=c.prepareStatement(sql);
			ps.setString(1, ad);
			ps.setInt(2, vize);
			ps.setInt(3, finall);
			ps.setFloat(4, ortalama);			
			ps.executeUpdate();
			c.commit();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	resp.sendRedirect("update.jsp");
}
}

