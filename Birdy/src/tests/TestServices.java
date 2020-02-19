package tests;

import services.Authentification;
import services.User;
import tools.AuthentificationTools;

public class TestServices {

	public static void main(String[] args) {
		//Création d'un Utilisateur
		//createUser("Id", "MDP", "MAIL", Prenom, nom, ddateN));
		System.out.println(User.createUser("Co", "bonjour", "azertyu@sdfgh.fr", null, null, null));
		System.out.println(User.createUser(null, "bonjour", "azertyu@sdfgh.fr", null, null, null));
		System.out.println(User.createUser("Co", null, "azertyu@sdfgh.fr", null, null, null));
		System.out.println(User.createUser("Nono", "bonjour", "azertyuio", "Co", null, null));
		//System.out.println(User.getUser("nono"));
		System.out.println(User.createUser("Nono9196", "bonjour", "azertyuio", "Co", null, null));
		//System.out.println(User.getUser("Nono9196"));
		//System.out.println(User.getUserList());
		System.out.println(User.deleteUser("nono"));	
		System.out.println(User.getUserList());
		System.out.println(AuthentificationTools.generateKey());
	}

}
