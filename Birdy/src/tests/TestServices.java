package tests;

import services.User;

public class TestServices {

	public static void main(String[] args) {
		//Création d'un Utilisateur
		System.out.println(User.createUser("Co", "bonjour", "azertyu@sdfgh.fr"));
		System.out.println(User.createUser(null, "bonjour", "azertyu@sdfgh.fr"));
		System.out.println(User.createUser("Co", null, "azertyu@sdfgh.fr"));
		System.out.println(User.createUser("Co", "bonjour", null));
		
		
	}

}