package frontMetier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;

import frontDAO.DemandeDAO;
public class GestionnaireDemande {
	
	private DemandeDAO demandeDAO;
	private GestionnaireCitoyen getionnaireCitoyen;
	private GestionnaireProcedure gestionnaireProcedure;

	public GestionnaireDemande() {
		super();
		this.demandeDAO = new DemandeDAO();
		this.getionnaireCitoyen = new GestionnaireCitoyen();
		this.gestionnaireProcedure = new GestionnaireProcedure();
	}
	//ces 3 fonctions c'est pour l'affichage des employes et les chefs de division pour les cas (consulter les demandes, Consulter l'avencement des demandes)
	public ArrayList<Demande> getAllDemande(){
		FindIterable<Document> cursor= demandeDAO.getAllDemande();
		ArrayList<Demande> demandes = new ArrayList<Demande>();
		
		
		for(Document doc : cursor) {
			Demande demande = new Demande();
	
			demande.setId_demande(doc.getInteger("id_demande"));
			demande.setDate_depot(doc.getString("date_depot"));
			demande.setEtat_demande(doc.getString("etat_demande"));
			demande.setIs_archived(doc.getBoolean("is_archived"));
			demande.setCitoyen(getionnaireCitoyen.getCitoyen(doc));
			demande.setProcedure(gestionnaireProcedure.getProcedure(doc));
			
			demandes.add(demande);
		}
		return demandes;
	}
	
	public ArrayList<Demande> getDemandesEmploye(int idetape){
		FindIterable<Document> cursor= demandeDAO.getDemandesEmploye(idetape);
		ArrayList<Demande> demandes = new ArrayList<Demande>();
		
		for(Document doc : cursor) {
			Demande demande = new Demande();
	
			demande.setId_demande(doc.getInteger("id_demande"));
			demande.setDate_depot(doc.getString("date_depot"));
			demande.setEtat_demande(doc.getString("etat_demande"));
			demande.setIs_archived(doc.getBoolean("is_archived"));
			demande.setCitoyen(getionnaireCitoyen.getCitoyen(doc));
			demande.setProcedure(gestionnaireProcedure.getProcedure(doc));
			
			demandes.add(demande);
		}
		return demandes;
	}
	
	public ArrayList<Demande> getDemandesChef(int idProcedure){
		FindIterable<Document> cursor= demandeDAO.getDemandesChef(idProcedure);
		ArrayList<Demande> demandes = new ArrayList<Demande>();
		
		for(Document doc : cursor) {
			Demande demande = new Demande();
	
			demande.setId_demande(doc.getInteger("id_demande"));
			demande.setDate_depot(doc.getString("date_depot"));
			demande.setEtat_demande(doc.getString("etat_demande"));
			demande.setIs_archived(doc.getBoolean("is_archived"));
			demande.setCitoyen(getionnaireCitoyen.getCitoyen(doc));
			demande.setProcedure(gestionnaireProcedure.getProcedure(doc));
			
			demandes.add(demande);
		}
		return demandes;
	}
	
	public ArrayList<Demande> getDemandeCitoyen(String _id){
		ObjectId objectId = new ObjectId(_id);
		FindIterable<Document> cursor= demandeDAO.getDemandeCitoyen(objectId);
		ArrayList<Demande> demandes = new ArrayList<Demande>();
		
		for(Document doc : cursor) {
			Demande demande = new Demande();
	
			demande.setId_demande(doc.getInteger("id_demande"));
			demande.setDate_depot(doc.getString("date_depot"));
			demande.setEtat_demande(doc.getString("etat_demande"));
			demande.setIs_archived(doc.getBoolean("is_archived"));
			demande.setCitoyen(getionnaireCitoyen.getCitoyen(doc));
			demande.setProcedure(gestionnaireProcedure.getProcedure(doc));
			
			demandes.add(demande);
		}
		return demandes;
	}
	
	public void accepterDemande(int idDemande) {
		demandeDAO.accepterDemande(idDemande);
	}
	
	public void archiverDemande(int idDemande) {
		demandeDAO.archiverDemande(idDemande);
	}
	
	public void gestionEtape(int idDemande, int idEtape, etat_etape etatEtape) {
		demandeDAO.gestionEtape(idDemande, idEtape, etatEtape.name());
	}
	
	public ObjectId ajouterDemande(int id_procedure, int CIN) {
		GestionnaireDocument gestionnaireDocument = new GestionnaireDocument();
		ArrayList<frontMetier.Document> documents = new ArrayList<frontMetier.Document>();
		documents = gestionnaireDocument.getDocumentProcedure(id_procedure);
		
		GestionnaireEtape gestionnaireEtape = new GestionnaireEtape(); 
		ArrayList<Etape> etapes = new ArrayList<Etape>();
		etapes = gestionnaireEtape.listeEtapesProcedure(id_procedure);
		
		GestionnaireProcedure gestionnaireProcedure = new GestionnaireProcedure();
		Procedure procedure = new Procedure();
		procedure = gestionnaireProcedure.getProcedure(id_procedure);
		procedure.setDocuments(documents);
		procedure.setEtapes(etapes);
		
		Citoyen citoyen = new Citoyen(CIN);
		
		Random random = new Random();
		int id_demande = random.nextInt(1000);
		System.out.println(demandeDAO.demandeExiste(id_demande));
		while(demandeDAO.demandeExiste(id_demande)){
			id_demande = random.nextInt(1000);
		}
		
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = formatter.format(date); 
	    
		Demande demande = new Demande(id_demande,strDate,citoyen,procedure);
		
		return demandeDAO.deposerDemande(demande);
	}

	
}
