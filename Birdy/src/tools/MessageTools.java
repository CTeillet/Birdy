package tools;

import java.util.Date;

import org.bson.Document;

public class MessageTools {
	public static Document createMessage(String id, String msg) {
		Document d = new Document();
		d.append("author_id", id);
		d.append("date", new Date());
		d.append("text", msg);
		return d;
	}
}
