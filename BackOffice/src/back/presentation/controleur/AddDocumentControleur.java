package back.presentation.controleur;

import java.util.ArrayList;

import back.backDAO.DocumentDAO;
import back.backMetier.Document;
import back.backMetier.GestionnaireDocument;
import back.backMetier.GestionnaireProcedure;
import back.backMetier.Procedure;

public class AddDocumentControleur {
	private GestionnaireProcedure procedure;
    private ArrayList<Procedure> table;
    private ArrayList<Integer> tab;
    private GestionnaireDocument doc;
    private DocumentDAO docu;

	public AddDocumentControleur() {
		super();
		procedure=new GestionnaireProcedure();
		this.table = procedure.listProcedure();
	}
	/**
	 * methode pour ajouter un document
	 * @param document le document a ajouter
	 */
	public AddDocumentControleur(Document document) {
		super();
		doc=new GestionnaireDocument();
		docu=new DocumentDAO();
		if(docu.isExist(document))
		{
			new Alert("cet document exist deja");
			
		}else
			doc.ajouterDocument(document);
			
	}
/**
 * methode pour la recuperation des id de procedures existates
 * @return une liste des id de procedures 
 */
	public ArrayList<Integer> getProc()
	{
		tab=new ArrayList<Integer>();
		for(Procedure pr:this.table)
		{
			tab.add(pr.getIdProcedure());
		}
		return tab;
	}

	

}
