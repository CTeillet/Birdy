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
		JSONObject res =  InteractionBD.executeQuery(req);
		if(res.length()==0) {
			return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
		}else {
			return JSONTools.serviceAccepted("res",res);
		}
		
	}
	
	public static JSONObject getFriend(String id1, String id2) {
		if(id1==null || id2==null) {
			return JSONTools.serviceRefused("Identifiant non defini", -1);
		}
		String req = FriendTools.getFriend(id1, id2);
		JSONObject res = InteractionBD.executeQuery(req);
		if(res.length()!=0) {
			return JSONTools.serviceAccepted();
		}else {
			return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
		}
		
	}
	
	public static JSONObject addFriend(String id1, String id2) {
		if(id1==null || id2==null || id1==id2) {
			return tools.JSONTools.serviceRefused("Identifiant non defini ou identique", -1);
		}else {
			String req = FriendTools.addFriend(id1, id2);
			//System.out.println(req);
			int res  = InteractionBD.executeUpdate(req);
			if (res == 0) {
				return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
			}else {
				return JSONTools.serviceAccepted();
			}
		}
	}
	
	public static JSONObject removeFriend(String id1, String id2) {
		if(id1==null || id2==null || id1==id2) {
			return JSONTools.serviceRefused("Identifiant non defini", -1);
		}else {
			String req = FriendTools.removeFriend(id1, id2);
			int res = InteractionBD.executeUpdate(req);
			if (res == 0) {
				return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
			}else {
				return JSONTools.serviceAccepted();
			}	
		}
	}
	
	public static JSONObject removeAllFriend(String id1) {
		if(id1==null) {
			return JSONTools.serviceRefused("Identifiant non defini", -1);
		}else {
			String req = FriendTools.removeAllFriend(id1);
			int res = InteractionBD.executeUpdate(req);
			if (res == 0) {
				return tools.JSONTools.serviceRefused("Probleme de SQL", 1000);
			}else {
				return JSONTools.serviceAccepted();
			}	
		}
	}
}
