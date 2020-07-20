package frontDAO;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


public class ConnexionMongo {
	private MongoDatabase database;
    private static MongoClient mongoClient;
    
    //Constructeur 
	public ConnexionMongo() {
		Logger mongoLogger = Logger.getLogger ("org.mongodb.driver");
		mongoLogger.setLevel (Level.SEVERE);
    	try {
    		mongoClient = new MongoClient("localhost",27017);
    		database = mongoClient.getDatabase("projetFront");
    		//System.out.println("connect");
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }

	public MongoDatabase getDatabase() {
		return database;
	}
	
    
}
