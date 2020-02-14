package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InteractionBD {

	
	public static boolean executeQuery(String req) {
		Connection conn;
		Statement s;
		ResultSet res;
		try {
			conn = Database.getMySQLConnection();
			s = conn.createStatement();
			res = s.executeQuery(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public static int executeUpdate(String req) {
		Connection conn;
		Statement s;
		int res;
		try {
			conn = Database.getMySQLConnection();
			s = conn.createStatement();
			res = s.executeUpdate(req);
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			return 0;
		}
		
	}
}
