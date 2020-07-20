package back.backMetier;

import java.util.ArrayList;

import back.backDAO.EtapeDAO;

public class GestionnaireEtape {
	private EtapeDAO etapeDAO;

	public GestionnaireEtape() {
		etapeDAO = new EtapeDAO();
	}

	public ArrayList<Etape> listeEtapesProcedure() {
		return etapeDAO.listeEtapesProcedure();
	}
	public ArrayList<Etape> listeEtapesProcedure(int idProcedure) {
		return etapeDAO.listeEtapesProcedure(idProcedure);
	}
	public ArrayList<Etape> listeEtapesPersonne(int idPersonne) {
		return etapeDAO.listeEtapesPersonne(idPersonne);
	}
	public Etape getEtape(int id) {
		return etapeDAO.getEtape(id);
	}

	public boolean ajouterEtape(Etape etape) {
		return etapeDAO.ajouterEtape(etape);
	}

	public boolean affectationEtape(Etape etape) {
		return etapeDAO.affectationEtape(etape);
	}

	public boolean effacerEtape(Etape etape) {
		return etapeDAO.effacerEtape(etape);
	}


}
