package back.backMetier;

import java.util.ArrayList;

import back.backDAO.PersonneDAO;

public class GestionairePersonne {
	private PersonneDAO personneDAO;

	public GestionairePersonne() {
		personneDAO = new PersonneDAO();
	}

	public ArrayList<Personne> listEmploye() {
		return personneDAO.getAllEmploye();
	}
	public ArrayList<Personne> listChefDivision() {
		return personneDAO.getAllChefdivision();
	}

	public Personne getEmploye(int id) {
		return personneDAO.getEmploye(id);
	}
	
	public Personne getChefDivision(int id) {
		return personneDAO.getChefDivision(id);
	}

	public boolean ajouterPersonne(Personne Personne) {
		return personneDAO.ajouterPersonne(Personne);
	}

	public boolean modifierPersonne(Personne Personne) {
		return personneDAO.modifierPersonne(Personne);
	}

}
