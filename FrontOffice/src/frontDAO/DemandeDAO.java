package frontDAO;

import java.util.ArrayList;
import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import frontMetier.Demande;

public class DemandeDAO {
	
	private ConnexionMongo mongo;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	

	public DemandeDAO() {
		super();
		this.mongo = new ConnexionMongo();
		this.database = mongo.getDatabase();
		this.collection = database.getCollection("demande");
	}
	
	public boolean demandeExiste(int id_demande) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("id_demande", id_demande);
		FindIterable<Document> cursor = collection.find(searchQuery).limit(1);
		
		return cursor.first() != null;
	}
	
	public FindIterable<Document> getAllDemande() {
		FindIterable<Document> cursor = collection.find();
		return cursor;
	}
	
	//pour la recupertion des demandes de chaque employe c'est avec l'id de l'etape qui lui ete affecter dans le back.
	public FindIterable<Document> getDemandesEmploye(int idetape) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("procedure.etape.id_etape", idetape);
		searchQuery.put("is_archived", false);
		FindIterable<Document> cursor = collection.find(searchQuery);
		return cursor;
	}
	
	//pour la recupertion des demandes de chaque chef de division c'est avec l'id de procedure qui lui ete affecter dans le back.
	public FindIterable<Document> getDemandesChef(int idProcedure) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("procedure.id_procedure", idProcedure);
		searchQuery.put("is_archived", false);
		FindIterable<Document> cursor = collection.find(searchQuery);
		return cursor;
	}
	
	public FindIterable<Document> getDemandeCitoyen(ObjectId _id) {
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", _id);
		searchQuery.put("is_archived", false);
		FindIterable<Document> cursor = collection.find(searchQuery);
		return cursor;
	}
	
	public void accepterDemande(int idDemande) {
		BasicDBObject query = new BasicDBObject();
		query.put("id_demande", idDemande);
		BasicDBObject newDoc = new BasicDBObject();
		newDoc.put("etat_demande", "accept");
		BasicDBObject updateDocument = new BasicDBObject();
		updateDocument.put("$set", newDoc);
		
		collection.updateOne(query, updateDocument);
	}
	
	public void archiverDemande(int idDemande) {
		BasicDBObject query = new BasicDBObject();
		query.put("id_demande", idDemande);
		query.put("is_archived", false);
		BasicDBObject newDoc = new BasicDBObject();
		newDoc.put("is_archived", true);
		BasicDBObject updateDocument = new BasicDBObject();
		updateDocument.put("$set", newDoc);
		
		collection.updateOne(query, updateDocument);
	}
	
	public void gestionEtape(int idDemande, int idEtape, String etatEtape) {
		BasicDBObject query = new BasicDBObject();
		query.put("id_demande", idDemande);
		query.put("procedure.etape.id_etape", idEtape);
		
		BasicDBObject newDoc = new BasicDBObject();
		newDoc.put("procedure.etape.$.etat_etape",etatEtape );
		
		BasicDBObject updateDocument = new BasicDBObject();
		updateDocument.put("$set", newDoc);
		
		collection.updateOne(query, updateDocument);
		
	}
	
	// a verifier apres metier 
	public ObjectId deposerDemande(Demande demande) {
		Document query = new Document();
		
		ArrayList<Document> queryDoc = new ArrayList<Document>();
		ArrayList<Document> queryEtape = new ArrayList<Document>();
		int nbreDocument = demande.getProcedure().getDocuments().size();
		int nbreEtape = demande.getProcedure().getEtapes().size();
		
		for(int i =0 ; i< nbreDocument ; i++) {
			queryDoc.add(new Document("id_document",demande.getProcedure().getDocuments().get(i).getId_document())
							.append("nom_document",demande.getProcedure().getDocuments().get(i).getNom_document())
					);
		}
		for(int i =0 ; i< nbreEtape ; i++) {
			queryEtape.add(new Document("id_etape",demande.getProcedure().getEtapes().get(i).getId_etape())
							.append("etat_etape",demande.getProcedure().getEtapes().get(i).getEtat_etape())
					);
		}
		
		query.append("id_demande", demande.getId_demande())
			.append("date_depot", demande.getDate_depot())
			.append("etat_demande",demande.getEtat_demande())
			.append("is_archived", demande.getIs_archived())
			.append("citoyen", new Document("CIN",demande.getCitoyen().getCIN()))
			.append("procedure", new Document().append("id_procedure", demande.getProcedure().getId_procedure())
					.append("nom_procedure", demande.getProcedure().getNom_procedure())
					.append("document", Arrays.asList(queryDoc))
					.append("etape", Arrays.asList(queryEtape))
					);
		
					
		collection.insertOne(query);
		
		return (ObjectId) query.get("_id");
	}
	
	
	

}
