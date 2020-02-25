package services;

import org.json.JSONObject;

import bd.InteractionMongo;

public class Message {
	public static JSONObject createMessage(String id, String msg) {
		return InteractionMongo.insertQuery(tools.MessageTools.createMessage(id, msg));
	}
	
	public static JSONObject removeMessage(String idU, String idM) {
		return null;
	}
	
	public static JSONObject getMessageFromId(String id) {
		return null;
	}
	
	
}
