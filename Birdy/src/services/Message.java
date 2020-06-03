package services;

import org.json.JSONObject;

import bd.InteractionMongo;
import tools.JSONTools;
import tools.MessageTools;

public class Message {
	
	public static JSONObject createMessage(String id, String msg) {
		if (id == null || msg == null ) {
			return JSONTools.serviceRefused("Pas d'argument", -1);
		}
		return InteractionMongo.insertQuery(MessageTools.createMessage(id, msg));
	}
	
	public static JSONObject removeOneMessage(String idU, String idM) {
		if (idU == null || idM == null) {
			return JSONTools.serviceRefused("Pas d'argument", -1);
		}
		return InteractionMongo.deleteOne(MessageTools.deleteAMessage(idU, idM));
	}
	
	public static JSONObject removeAllMessageAuthor(String idU) {
		if (idU == null) {
			return JSONTools.serviceRefused("Pas d'argument", -1);
		}
		return InteractionMongo.deleteMultiple(MessageTools.deleteAllMessage(idU));
	}
	
	public static JSONObject getMessageFromAuthor(String author) {
		if (author == null) {
			return JSONTools.serviceRefused("Pas d'argument", -1);
		}
		return InteractionMongo.executeQuery(MessageTools.getAllMessageAuthor(author));
	}
	
	public static JSONObject getMessageWithWord(String word) {
		if (word == null) {
			return JSONTools.serviceRefused("Pas d'argument", -1);
		}
		return InteractionMongo.executeFilters(MessageTools.getAllMessageWord(word));
	}
	
	public static JSONObject addLikeMessage(String idM) {
		if(idM == null) {
			return JSONTools.serviceRefused("Pas d'argument", -1);
		}
		return InteractionMongo.executeUpdate(MessageTools.searchMessage(idM), MessageTools.incLike());
	}
	
	public static JSONObject addCommentMessage(String idM, String idU, String msg) {
		if(idM==null || idU==null || msg==null || msg == "") {
			return JSONTools.serviceRefused("Pas d'argument", -1);
		}
		return InteractionMongo.executeUpdate(MessageTools.searchMessage(idM), MessageTools.pushComment(idU, msg));
	}

	public static JSONObject getMessageByTime(String time) {
		if(time==null || time.equals("")) {
			return JSONTools.serviceRefused("Pas d'argument", -1);
		}
		return InteractionMongo.executeFilters(MessageTools.getMessageBefore(time));
	}
	
	
}
