package tests;

import bd.Database;
import java.sql.*;

import org.json.JSONException;
import org.json.JSONObject;

public class TestBD {
	

	public static void main(String[] args) {
		try {
			Connection conn = Database.getMySQLConnection();
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery("Select * from test");
			res.next();
			s.close();
			conn.close();
			//(new JSONObject()).put("val", res.getInt("ty"));
			System.out.println((new JSONObject()).put("val", res.getInt("ty")).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return null;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return null;
		}
		
	}
}