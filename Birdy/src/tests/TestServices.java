package tests;

import java.util.logging.Level;
import java.util.logging.Logger;

import services.Authentification;
import services.Friend;
import services.Message;
import services.User;
import tools.AuthentificationTools;

public class TestServices {

	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE); 
//		//Création d'un Utilisateur
//		//createUser("Id", "MDP", "MAIL", nom, prenom, ddateN));
//		System.out.println(User.createUser("Co", "bonjour", "azertyu@sdfgh.fr", null, null, null));
//		//System.out.println(User.getUser("nono"));
//		System.out.println(User.createUser("Nono9196", "hgvj", "azertyuio", null, "allo", null));
//		System.out.println(User.createUser("cghu", "bonjour", "azertyuio", "fdegfg", "xcvbvc", null));
//		System.out.println(User.getUser("Nono9196"));
//		System.out.println(User.getUserList());
//		//System.out.println(User.deleteUser("Nono9196"));	
//		System.out.println(User.getUserList());
//		//System.out.println(AuthentificationTools.generateKey());
//		System.out.println(Friend.addFriend("Nono9196", "Co"));
//		System.out.println(Friend.addFriend("Nono9196", "cghu"));
//		System.out.println(Friend.addFriend("Nono9196", "Corentin"));
//		//System.out.println(Friend.removeFriend("Nono9196", "Co")); 
//		System.out.println(Friend.removeFriend("Nono9196", "Corentin"));
//		System.out.println(Friend.getFriendList("Nono9196"));
		//System.out.println(Friend.removeAllFriend("Nono9196"));
		//System.out.println(Authentification.login("Co", "bonjour"));
		//System.out.println(Authentification.isLogged("Co", "W0dpwAHKFzOgXVC50Yh2PJ7EUJQZgMmu"));
		//System.out.println(Authentification.logout("Co", "W0dpwAHKFzOgXVC50Yh2PJ7EUJQZgMmu"));
		//System.out.println(Message.createMessage("Nono9196", "Yop"));
		//System.out.println(Message.createMessage("Co", "Yop"));
		//System.out.println(Message.createMessage("Nono9196", "Allo"));
		//System.out.println(Message.createMessage("Nono9196", "Comment"));
		//System.out.println(Message.removeAllMessageAuthor("Nono9196"));
		//System.out.println(Message.getMessageFromAuthor("Nono9196"));
		System.out.println(Message.getMessageWithWord("Yop"));
	}

}
