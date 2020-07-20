package back.presentation.controleur;

import back.backMetier.Etape;
import back.backMetier.GestionnaireEtape;

public class AffecterEtapeControleur {
	private int idEtape,idEmp;
	private GestionnaireEtape etap;
	private Etape et;
	/**
	 * controleur pour affecter une etape
	 * @param idEtape l'etape a affect�
	 * @param idEmp l'employe concern�
	 */
	public AffecterEtapeControleur(int idEtape, int idEmp) {
		super();
		this.idEtape = idEtape;
		this.idEmp = idEmp;
		etap=new GestionnaireEtape();
		et=new Etape(idEtape,etap.getEtape(idEtape).getIdProcedure(),idEmp);
		etap.affectationEtape(et);
		
	}


	

}
