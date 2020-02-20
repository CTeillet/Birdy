package services;

import org.json.JSONObject;

import bd.InteractionBD;
import tools.FriendTools;
import tools.JSONTools;

public class Friend {
	public static JSONObject getFriendList(String id) {
		if(id==null) {
			return JSONTools.serviceRefused("Identifiant non defini", -1);
		}
		String req = FriendTools.getFriendList(id);
		return JSONTools.serviceAccepted("res", InteractionBD.executeQuery(req));
	}
	
	public static JSONObject addFriend(String id1, String id2) {
		if(id1==null || id2==null || id1==id2) {
			return tools.JSONTools.serviceRefused("Identifiant non defini ou erreur", -1);
		}else {
			String req = FriendTools.addFriend(id1, id2);
			return JSONTools.serviceAccepted("res", InteractionBD.executeUpdate(req));
		}
	}
	
	public static JSONObject removeFriend(String id1, String id2) {
		if(id1==null || id2==null || id1==id2) {
			return JSONTools.serviceRefused("Identifiant non defini", -1);
		}else {
			String req = FriendTools.removeFriend(id1, id2);
			return JSONTools.serviceAccepted("res", InteractionBD.executeUpdate(req));
		}
		//return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
	}
}
