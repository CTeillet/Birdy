package bd;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import tools.JSONTools;

public class InteractionMongo {
	
	public static JSONObject insertQuery(Document query) {
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> collection = db.getCollection(DBStatic.mongo_collection);
		collection.insertOne(query);
		return JSONTools.serviceAccepted();
	}
	
	public static JSONObject executeQuery(Document query) {
		MongoDatabase db = Database.getMongoDBConnection();
		MongoCollection<Document> collection = db.getCollection(DBStatic.mongo_collection);
		collection.insertOne(query);
		return JSONTools.serviceAccepted();
	}
}
