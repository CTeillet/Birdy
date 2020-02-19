package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONException;
import org.json.JSONObject;

import tools.JSONTools;

public class InteractionBD {

	
	public static JSONObject executeQuery(String req) {
		Connection conn;
		Statement s;
		ResultSet res;
		try {
			conn = Database.getMySQLConnection();
			s = conn.createStatement();
			res = s.executeQuery(req);
			JSONObject retour = JSONTools.resulSet2JSON(res);
			res.close();
			s.close();
			conn.close();
			return retour;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return null;
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
