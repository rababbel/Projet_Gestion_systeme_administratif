package back.backMetier;

import java.util.ArrayList;

import back.backDAO.ProcedureDAO;

public class GestionnaireProcedure {
	private ProcedureDAO procedureDAO;

	public GestionnaireProcedure() {
		procedureDAO = new ProcedureDAO();
	}

	public ArrayList<Procedure> listProcedure() {
		return procedureDAO.getAllProcedure();
	}

	public Procedure getProcedure(int id) {
		return procedureDAO.getProcedure(id);
	}

	public boolean ajouterProcedure(Procedure procedure) {
		return procedureDAO.ajouterProcedure(procedure);
	}

	public boolean modifierProcedure(Procedure procedure) {
		return procedureDAO.modifierProcedure(procedure);
	}

	public boolean affectationProcedure(Procedure procedure) {
		return procedureDAO.affectationProcedure(procedure);
	}


}
