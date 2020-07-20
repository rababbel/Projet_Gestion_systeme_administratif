package frontMetier;

import java.util.ArrayList;

import org.bson.Document;

import frontDAO.ProcedureDAO;

public class GestionnaireProcedure {
		
	public GestionnaireProcedure() {
		
	}

	//pour l'affichage des demande: cela est depuis la collection demande sur mongoDB
	public Procedure getProcedure(Document doc) {
		//System.out.println(doc);
		Procedure procedure = new Procedure();
		procedure.setId_procedure((int) ((Document) doc.get("procedure")).get("id_procedure"));
		procedure.setNom_procedure((String) ((Document) doc.get("procedure")).get("nom_procedure"));

		//System.out.println(procedure.toString());
		return procedure;
	}
	
	public Procedure getProcedure(int id) {
		ProcedureDAO procedureDAO = new ProcedureDAO();
		return procedureDAO.getProcedure(id);
	}
	
	public ArrayList<Procedure> getAllProcedure(int idPersonne){
		ProcedureDAO procedureDAO = new ProcedureDAO();
		return procedureDAO.getAllProcedure(idPersonne);
	}
	public ArrayList<Procedure> getAllProcedure(){
		ProcedureDAO procedureDAO = new ProcedureDAO();
		return procedureDAO.getAllProcedure();
	}

}
