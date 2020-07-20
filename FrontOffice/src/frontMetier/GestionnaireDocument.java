package frontMetier;

import java.util.ArrayList;

import frontDAO.DocumentDAO;

public class GestionnaireDocument {

	public GestionnaireDocument() {
		
	}
	
	public ArrayList<Document> getDocumentProcedure(int id){
		DocumentDAO documentDAO = new DocumentDAO();
		return documentDAO.getDocumentProcedure(id);
	}
	
	
}
