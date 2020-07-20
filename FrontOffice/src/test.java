

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.FindIterable;

import frontDAO.DemandeDAO;
import frontMetier.Etape;
import frontMetier.GestionnaireEtape;

public class test {
	public static void main(String[] args) {
		DemandeDAO x = new DemandeDAO();
		FindIterable<Document> d ;
		
		//d = x.getAllDemande();
		
		//d = x.getDemandeCitoyen(5);
		//d = x.getDemandesEmploye(3);
		x.archiverDemande(651);
		//x.accepterDemande(3);
		//x.CitoyenExist(1);
		//d = x.CitoyenExist(1);
		//for(Document a : d) {
			//System.out.println(a);
		//}
		//System.out.println(x.CitoyenExist(1));
		
		//LoginEmployeChef y = new LoginEmployeChef();
		//System.out.println(y.loginChef(2, "5"));
		//System.out.println(y.loginEmploye(1, "1234"));
		
		//GestionnaireDemande g = new GestionnaireDemande();
		//ArrayList<Demande> b = new ArrayList<Demande>();
		//b=g.getDemandesEmploye(1);
		//b=g.getDemandesChef(4);
		//b=g.getDemandeCitoyen("5ec1665c1008f73f568eb25b");
		
			//System.out.println(b.toString());
		
		/*GestionnaireCitoyen c = new GestionnaireCitoyen();
		ArrayList<Citoyen> a = new ArrayList<Citoyen>();
		a=c.getCitoyen();
		for(Demande b:a) {
			System.out.println(b.toString());
		}*/
		
		/*GestionnaireDocument docs = new GestionnaireDocument();
		ArrayList<Document> d = new ArrayList<Document>();
		d = docs.getDocumentProcedure(2);
		for(Document a : d) {
			System.out.println(a);
		}*/
		
		/*GestionnaireDemande gestionnaireDemande = new GestionnaireDemande();
		ObjectId jeton = new ObjectId();
		
		jeton = gestionnaireDemande.ajouterDemande(1, 1);
		System.out.println(jeton);
		*/
		GestionnaireEtape etape=new GestionnaireEtape();
		ArrayList<Etape> a = etape.listeEtapesPersonne(15);
		for(Etape et:a)
		{
			System.out.println(et.getId_etape());
		}
		
	}
}
