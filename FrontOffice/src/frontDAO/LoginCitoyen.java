package frontDAO;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class LoginCitoyen {

	private ConnexionMongo mongo;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	public LoginCitoyen() {
		super();
		this.mongo = new ConnexionMongo();
		this.database = mongo.getDatabase();
		this.collection = database.getCollection("citoyen");
	}
	
	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public boolean CitoyenExist(int CIN) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("CIN", CIN);
		FindIterable<Document> cursor = collection.find(searchQuery).limit(1);
		
		return cursor.first() != null;
	}
	
	public FindIterable<Document> getAllCitoyen() {
		FindIterable<Document> docs = collection.find();
		return docs;
	}
	
	//ca sert pour la consutation du citoyen de ses demandes
		public FindIterable<Document> getDemandeCitoyen(int id) {
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("citoyen.CIN", id);
			searchQuery.put("is_archived", false);
			FindIterable<Document> cursor = collection.find(searchQuery);
			return cursor;
		}
	

}
