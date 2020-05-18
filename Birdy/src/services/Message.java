package services;

import org.json.JSONObject;

import bd.InteractionMongo;
import tools.MessageTools;

public class Message {
	public static JSONObject createMessage(String id, String msg) {
		return InteractionMongo.insertQuery(MessageTools.createMessage(id, msg));
	}
	
	public static JSONObject removeOneMessage(String idU, String idM) {
		return InteractionMongo.deleteOne(MessageTools.deleteAMessage(idU, idM));
	}
	
	public static JSONObject removeAllMessageAuthor(String idU) {
		return InteractionMongo.deleteMultiple(MessageTools.deleteAllMessage(idU));
	}
	
	public static JSONObject getMessageFromAuthor(String author) {
		return InteractionMongo.executeQuery(MessageTools.getAllMessageAuthor(author));
	}
	
	public static JSONObject getMessageWithWord(String word) {
		return InteractionMongo.executeFilters(MessageTools.getAllMessageWord(word));
	}
	
	
}
