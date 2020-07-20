package back.presentation.controleur;

import back.backDAO.ProcedureDAO;
import back.backMetier.GestionnaireProcedure;
import back.backMetier.Procedure;

public class AddProcControleur {
	private GestionnaireProcedure procedure;
	private ProcedureDAO pr;
	/**
	 * controleur pour ajouter une procedure
	 * @param proc la procedure a ajouter
	 */
	public AddProcControleur(Procedure proc) {
		super();
		procedure=new GestionnaireProcedure();
		pr=new ProcedureDAO();
		if(pr.isExist(proc))
			new Alert("cette procedure existe deja ");
		else
		procedure.ajouterProcedure(proc);
	}
	
	

}
