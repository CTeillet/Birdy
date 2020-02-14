package services;

import org.json.JSONObject;

public class Friend {
	public static JSONObject getFriendList(String id) {
		if(id==null) {
			return tools.ErrorJSON.serviceRefused("Identifiant non defini", -1);
		}
		String req = tools.FriendTools.getFriendList(id);
		return null;
	}
	
	public static JSONObject addFriend(String id1, String id2) {
		
		return null;
	}
	
	public static JSONObject removeFriend(String id1, String id2) {
		
		return null;
	}
}
