package back.presentation.controleur;

import back.backMetier.GestionnaireProcedure;
import back.backMetier.Procedure;

public class AffectationProcedureControleur {
	
	private GestionnaireProcedure proc;
	private Procedure procedure;
	/**
	 * controleur pour affecter une procedure
	 * @param idPr la procedure a affecte 
	 * @param idEmp l'employe concerné
	 */
	public AffectationProcedureControleur(int idPr, int idEmp) {
		super();
		proc =new GestionnaireProcedure();
		procedure=new Procedure(idPr,idEmp);
		proc.affectationProcedure(procedure);
	}
	
	
	

}
