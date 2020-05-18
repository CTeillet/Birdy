package tools;

import java.util.Date;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.model.Filters;

public class MessageTools {
	public static Document createMessage(String id, String msg) {
		Document d = new Document();
		d.append("author_id", id);
		d.append("date", new Date());
		d.append("text", msg);
		return d;
	}
	
	public static Document deleteAMessage(String autId, String msgId) {
		Document d = new Document();
		d.append("author_id", autId);
		ObjectId oi = new ObjectId(msgId);
		d.append("_id", oi);
		return d;
	}

	public static Document deleteAllMessage(String idU) {
		Document d = new Document();
		d.append("author_id", idU);
		return d;
	}
	
	public static Document getAllMessageAuthor(String id) {
		Document d = new Document();
		d.append("author_id", id);
		return d;
	}

	public static Bson getAllMessageWord(String word) {
		return Filters.text(word);
	}
}
