package tools;

import java.util.Random;

public class AuthentificationTools {
	private static final Random rmd = new Random();
	
	public static String generateKey() {
		StringBuilder res = new StringBuilder();
		int range = 126 - 33 + 1;
		int rndNb;
		for (int i = 0; i < 32; i++) {
			rndNb = rmd.nextInt(range) + 33;
			res.append((char)rndNb);
		}
		return res.toString();
	}

	public static boolean userExists(String login) {
		StringBuilder res = new StringBuilder();
		
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