package tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AuthentificationTools {
	private static final Random rmd = new Random();
	private static List<Character> listeChar = generateCharListe();
	
	private static List<Character> generateCharListe() {
		ArrayList<Character> liste = new ArrayList<Character>();
		for(int i = (int)'A'; i<=(int)'Z'; i++ ) {
			liste.add(((char)i));
		}
		for(int i = (int)'a'; i<=(int)'z'; i++ ) {
			liste.add(((char)i));
		}
		for(int i = (int)'0'; i<=(int)'9'; i++ ) {
			liste.add(((char)i));
		}
		return liste;
	}
	
	public static String generateKey() {
		StringBuilder res = new StringBuilder();
		int range = listeChar.size();
		char rndNb;
		for (int i = 0; i < 32; i++) {
			rndNb = listeChar.get(rmd.nextInt(range));
			res.append(rndNb);
		}
		return res.toString();
	}

	public static String userExists(String id) {
		StringBuilder res = new StringBuilder();
		res.append("Select * From Utilisateur Where Utilisateur.identifiant='").append(id).append("';");
		return res.toString();
	}

	public static String passwordOfUser(String id, String password) {
		StringBuilder res = new StringBuilder();
		res.append("Select * From Utilisateur Where Utilisateur.identifiant='").append(id).append("' and Utilisateur.password='").append(password).append("';");
		return res.toString();
	}

	public static String insertSession(String key_user, String id) {
		StringBuilder res = new StringBuilder();
		res.append("Insert into Enligne(Identifiant, cle) values ('").append(id).append("', \"").append(key_user).append("\");");
		return res.toString();
	}

	public static String removeSession(String id, String key) {
		StringBuilder res = new StringBuilder();
		res.append("Delete from Enligne Where Enligne.identifiant='").append(id).append("' and Enligne.cle=\"").append(key).append("\";");
		return res.toString();
	}

	public static String userLogged(String id, String key) {
		StringBuilder res = new StringBuilder();
		res.append("Select * From Enligne Where Enligne.identifiant='").append(id).append("' and Enligne.cle=\"").append(key).append("\";");
		return res.toString();
	}

	public static String updateTime(String id, String key, String heure) {
		StringBuilder res = new StringBuilder();
		res.append("Update Enligne Set Heure='").append(heure).append("' Where Enligne.identifiant='").append(id).append("' and Enligne.cle=\"").append(key).append("\";");
		return res.toString();
	}


}