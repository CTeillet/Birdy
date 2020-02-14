package tests;

import services.User;

public class TestServices {

	public static void main(String[] args) {
		//Création d'un Utilisateur
		//createUser("Id", "MDP", "MAIL", Prenom, nom, ddateN));
		System.out.println(User.createUser("Co", "bonjour", "azertyu@sdfgh.fr", null, null, null));
		System.out.println(User.createUser(null, "bonjour", "azertyu@sdfgh.fr", null, null, null));
		System.out.println(User.createUser("Co", null, "azertyu@sdfgh.fr", null, null, null));
		System.out.println(User.createUser("Nono", "bonjour", "azertyuio", "Co", null, null));
		System.out.println(User.getUser("Nono"));
		System.out.println(User.createUser("Nono9196", "bonjour", "azertyuio", "Co", null, null));
		System.out.println(User.getUser("Nono9196"));
		
		
	}

}
