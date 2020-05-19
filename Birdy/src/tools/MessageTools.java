package tools;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
		d.append("nb_like", 0);
		d.append("commentaires", new ArrayList<>());
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

	public static Document searchMessage(String idM) {
		Document d = new Document();
		d.put("_id", new ObjectId(idM));
		return d;
	}

	public static Document incLike() {
		Document d = new Document();
		d.put("$inc", new Document("nb_like", 1));
		return d;
	}

	public static Document pushComment(String idU, String msg) {
		Document d = new Document();
		Document comment = new Document();
		comment.put("author_id", idU);
		comment.put("text", msg);
		comment.put("date", new Date());
		Document tmp = new Document();
		tmp.put("commentaires", comment);
		d.put("$push", tmp);
		return d;
	}

	public static Bson getMessageBefore(String time) {
		LocalDateTime bfr = LocalDateTime.now().minusMinutes(Integer.parseInt(time));
		return Filters.gte("date", bfr);
	}
}
