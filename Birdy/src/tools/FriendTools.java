package tools;

public class FriendTools {

	public static String getFriendList(String id) {
		StringBuilder res = new StringBuilder();
		res.append("Select * Where Friends.utilisateur1='").append(id).append("';");
		return res.toString();
	}

	public static String addFriend(String id1, String id2) {
		StringBuilder res = new StringBuilder();
		res.append("Insert into Friends(utilisateur1, utilisateur2) values ('").append(id1).append("', '").append(id2).append("');");
		return res.toString();
	}

	public static String removeFriend(String id1, String id2) {
		StringBuilder res = new StringBuilder();
		res.append("Delete from Friend Where Friend.Utilisateur1='").append(id1).append("' and Friend.Utilisateur2='").append(id2).append("';");
		return res.toString();
	}

}
