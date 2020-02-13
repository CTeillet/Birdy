package tools;

import java.sql.SQLException;
import java.sql.Statement;

import bd.Database;

public class AuthentificationTools {


	public static boolean userExists(String login) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = Database.getMySQLConnection().createStatement();
		
		return false;
	}

	public static boolean checkPassword(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public static int getIdUser(String login) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static String insertSession(int id_user, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

}
