package back.backMetier;

import java.util.ArrayList;

import back.backDAO.DocumentDAO;

public class GestionnaireDocument {
	
	private DocumentDAO documentDAO;

	public GestionnaireDocument() {
		documentDAO = new DocumentDAO();
	}

	public ArrayList<Document> listDocuments() {
		return documentDAO.getAllDocument();
	}
	public ArrayList<Document> getDocumentProcedure(int id) {
		return documentDAO.getDocumentProcedure(id);
	}

	public boolean ajouterDocument(Document doc) {
		return documentDAO.ajouterDocument(doc);
	}

	public boolean modifierDocument(Document doc) {
		return documentDAO.modifierDocument(doc);
	}



}
