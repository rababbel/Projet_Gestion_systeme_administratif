package back.presentation.controleur;

import back.backDAO.EtapeDAO;
import back.backMetier.Etape;
import back.backMetier.GestionnaireEtape;

public class AddEtapeControleur {
private GestionnaireEtape etape;
private EtapeDAO et;
/**
 * controleur pour ajouter une etape
 * @param eta l'etape a ajouter
 */
public AddEtapeControleur(Etape eta) {
	super();
	etape=new GestionnaireEtape();
	et=new EtapeDAO();
	if(et.isExist(eta))
		new Alert("cet etape existe deja");
	else
	etape.ajouterEtape(eta);
}

	
}
