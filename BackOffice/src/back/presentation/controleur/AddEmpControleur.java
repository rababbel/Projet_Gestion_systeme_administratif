package back.presentation.controleur;

import back.backDAO.PersonneDAO;
import back.backMetier.GestionairePersonne;
import back.backMetier.Personne;

public class AddEmpControleur {
     private GestionairePersonne personne;
     private 	PersonneDAO p;
     /**
      * controleur pour ajouter un employe
      * @param employe l'employe a ajouter
      */
	public AddEmpControleur(Personne employe) {
		super();
		personne=new GestionairePersonne();
		p=new PersonneDAO();
		if(p.isExist(employe)==true)
		{
			new Alert("cet employe exist deja");
		}else
			personne.ajouterPersonne(employe);
			
		
		
	}

	

}
