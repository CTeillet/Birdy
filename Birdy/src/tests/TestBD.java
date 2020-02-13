package tests;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;

public class TestBD {
	public void init() {
		try{
			Context  ctx = new InitialContext();
			if(ctx == null ) throw new Exception("Boom");
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/db");
			if (ds != null) {
				Connection conn = ds.getConnection();
				if(conn != null) {
					Statement stmt = conn.createStatement();
					ResultSet rst = stmt.executeQuery("select * from Utilisateur");
					if(rst.next()) {
						String s = "";
					}
					conn.close();
				}
			}
		} catch(Exception e) { e.printStackTrace(); }
	}
}