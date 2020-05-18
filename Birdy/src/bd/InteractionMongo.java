package bd;

import java.util.Iterator;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONException;
import org.json.JSONObject;


import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;

import tools.JSONTools;

public class InteractionMongo {
	
	public static JSONObject insertQuery(Document query) {
		MongoDatabase db = Database.getMongoDBConnection();
		if (db ==null) {
			return JSONTools.serviceRefused("Probleme de connexion mongo", 1000);
		}else {
			MongoCollection<Document> collection = db.getCollection(DBStatic.mongo_collection);
			collection.insertOne(query);
			return JSONTools.serviceAccepted();
		}
	}
	
	public static JSONObject deleteOne(Document query) {
		MongoDatabase db = Database.getMongoDBConnection();
		if (db ==null) {
			return JSONTools.serviceRefused("Probleme de connexion mongo", 1000);
		}else {
			MongoCollection<Document> collection = db.getCollection(DBStatic.mongo_collection);
			collection.deleteOne(query);
			return JSONTools.serviceAccepted();
		}
	}
	
	public static JSONObject deleteMultiple(Document query) {
		MongoDatabase db = Database.getMongoDBConnection();
		if (db ==null) {
			return JSONTools.serviceRefused("Probleme de connexion mongo", 1000);
		}else {
			MongoCollection<Document> collection = db.getCollection(DBStatic.mongo_collection);
			collection.deleteMany(query);
			return JSONTools.serviceAccepted();
		}
	}
	
	
	
	public static JSONObject executeQuery(Document query) {
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> collection = db.getCollection(DBStatic.mongo_collection);
		FindIterable<Document> cursor = collection.find(query);

		return JSONTools.serviceAccepted("res", findIterable2JsonObject(cursor));
	}
	
	public static JSONObject executeFilters(Bson filter) {
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> collection = db.getCollection(DBStatic.mongo_collection);
		collection.createIndex(Indexes.text("text"));
		FindIterable<Document> cursor = collection.find(filter);
		
		return JSONTools.serviceAccepted("res", findIterable2JsonObject(cursor));
	}
	
	private static JSONObject findIterable2JsonObject(FindIterable<Document> cursor) {
		Iterator<Document> it = cursor.iterator();
		JSONObject res = new JSONObject();
		int i=0;
		while(it.hasNext()) {
			//System.out.println(document);
			try {
				res.put(""+i, it.next());
			} catch (JSONException e) {
				JSONTools.serviceRefused("probleme JSON", 100);
			}
		i++;
		}
		return res;
	}
	
}
