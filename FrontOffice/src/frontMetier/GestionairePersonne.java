package frontMetier;
import frontDAO.PersonneDAO;

public class GestionairePersonne {
	private PersonneDAO personneDAO;

	public GestionairePersonne() {
		personneDAO = new PersonneDAO();
	}

	public Personne getEmploye(int cin) {
		return personneDAO.getEmploye(cin);
	}
	
	public Personne getChefDivision(int cin) {
		return personneDAO.getChefDivision(cin);
	}

}
