package Depo;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Listele extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		

		
		PgConnector pgc=new PgConnector();
		Connection c=pgc.getConnection();
		String html="<table border=\"1px\">";
		if(c!=null) {
			String sql="SELECT id, ad, adet, fiyat FROM public.t_demo";
			
			Statement ps=null;
			try {
				ps=c.createStatement();
				ResultSet rs= ps.executeQuery(sql);
				while(rs.next()) {
					int id=rs.getInt(1);
					String ad=rs.getString(2);
					int adet=rs.getInt(3);
					float fiyat=rs.getFloat(4);	
				
					
					html+="<tr><td>"+id+"</td><td>"+ad+"</td><td>"+adet+"</td><td>"+fiyat+"</td>  "
							+ "<td>"
							+ "<form action=\"sil.mlk\" method=\"post\">"
							+ "<input type=\"hidden\" name=\"id\" value=\""+id+"\">"
						    + "<input type=\"submit\" value=\"Sil\">"
						    + "</form></td>"
						    + "<td>"
						    + "<form action=\"guncelle.mlk\" method=\"post\">"
						    + "<input type=\"button\" value=\"Guncelle\" onclick=\"(update("+id+",'"+ad+"',"+adet+","+fiyat+");\">"
						    + "</form></td> </tr>";
				}				
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		html+="</table>";
		resp.getWriter().write(html);
	}

}
