package back.presentation.controleur;

import java.util.ArrayList;

import back.backMetier.Document;
import back.backMetier.GestionnaireDocument;

public class EditerDocumentContr {
	private GestionnaireDocument document;
	private ArrayList<Object[]> tableau ;
	private ArrayList<Document> list;
	int idpr,idDoc;
	String nom;
	public EditerDocumentContr() {
		tableau=new ArrayList<Object[]>();
		document=new GestionnaireDocument();
		list=document.listDocuments();
	}

	/**
	 * methode pour recuperer les donnees d'un document 
	 * @return une liste de tableau d'objet;
	 */
	public  Object[][]donnee()
	{
		for(Document doc:list)
		{   
			idpr=doc.getIdProcedure();
			idDoc=doc.getIdDocument();
			nom=doc.getNomDocument();
			Object[] tab={idDoc,nom,idpr};
			tableau.add(tab);
		}
		Object[] tab=tableau.toArray();
		Object[][] t=new Object[tab.length][3];
		for(int i=0;i<tab.length;i++)
		{
			t[i]=tableau.get(i);	
		}
			
		
		return t;
		
	}
	
}
