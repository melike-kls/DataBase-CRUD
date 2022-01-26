package Depo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Sil extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id= Integer.parseInt(req.getParameter("id"));
	
	PgConnector pgc=new PgConnector();
	Connection c=pgc.getConnection();
			
	if(c!=null) {
		String sql="DELETE FROM public.t_demo WHERE id=?;";
		PreparedStatement ps=null;
		try {
			ps=c.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			c.commit();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	resp.sendRedirect("index.jsp");
	
}
}

