package back.presentation.controleur;

import back.backDAO.PersonneDAO;
import back.backMetier.GestionairePersonne;
import back.backMetier.Personne;

public class ModifierEmpControleur {
	public int n;
	private Personne personne;
	 private GestionairePersonne pers;
	 /**
 * constructeur permet le verification d'existance de personne
 * @param n est l'id de personne a verifier
 */
	public ModifierEmpControleur(int n) {
		super();
		this.n = n;
		personne=new Personne();
		pers=new GestionairePersonne ();
		new PersonneDAO();
		/*
		 * verifiation de l'existance d'employe ou chef de division
		 */
		if(pers.getEmploye(n).getIdPersonne()==0&&pers.getChefDivision(n).getIdPersonne()==0)
			new Alert("cet employe n'exist pas");
		else
		{
			if(pers.getChefDivision(n).getIdPersonne()!=0)
				personne=pers.getChefDivision(n);
			else
				personne=pers.getEmploye(n);
			
	    }
	}
	/**
	 * constructeur permet l'ajout d'une personne
	 * @param personne est la personne a modifier
	 */
	public ModifierEmpControleur(Personne personne) {
		super();
		this.personne = personne;
		pers=new GestionairePersonne();
		pers.modifierPersonne(personne);
	}

	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	

}
