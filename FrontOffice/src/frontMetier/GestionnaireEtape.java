package frontMetier;

import java.util.ArrayList;

import frontDAO.EtapeDAO;

public class GestionnaireEtape {

	public GestionnaireEtape(){
		
	}
	
	public ArrayList<Etape> listeEtapesProcedure(int idProcedure){
		EtapeDAO etapeDAO = new EtapeDAO();
		ArrayList<Etape> etapes = new ArrayList<Etape>();
		etapes = etapeDAO.listeEtapesProcedure(idProcedure);
		for(Etape etape:etapes) {
			etape.setEtat_etape(null);
		}
		return etapes;
	}
	public ArrayList<Etape> listeEtapesPersonne(int idPersonne) {
		EtapeDAO etapeDAO = new EtapeDAO();
		return etapeDAO.listeEtapesPersonne(idPersonne);
	}
	
	public Etape getEtape(int id) {
		EtapeDAO etapeDAO = new EtapeDAO();
		return etapeDAO.getEtape(id);
	}
	
}
