package back.presentation.controleur;

import java.util.ArrayList;

import back.backMetier.GestionairePersonne;
import back.backMetier.Personne;
import back.backMetier.Role;

public class EditerEmployContr {
	
	private GestionairePersonne personne;
	private ArrayList<Object[]> tableau ;
	private ArrayList<Personne> list;
	int idper,cin;
	String nom,prenom,email,service,pwd;
	Role role;
	public EditerEmployContr() {
		tableau=new ArrayList<Object[]>();
		personne=new GestionairePersonne();
		list=personne.listChefDivision();
	    for(Personne p:personne.listEmploye())
	    	list.add(p);
	}

	/**
	 * methode pour recuperer les donnees d'une procedure 
	 * @return une liste de tableau d'objet;
	 */
	public  Object[][]donnee()
	{
		for(Personne doc:list)
		{   
			idper=doc.getIdPersonne();
			cin=doc.getCIN();
			nom=doc.getNom();
			prenom=doc.getPrenom();
			email=doc.getEmail();
			service=doc.getService();
			role=doc.getRole();
			pwd=doc.getPassword();
			Object[] tab={idper,cin,nom,prenom,email,service,role,pwd};
			tableau.add(tab);
		}
		
		Object[] tab=tableau.toArray();
		Object[][] t=new Object[tab.length][3];
		for(int i=0;i<tab.length;i++)
		{
			t[i]=tableau.get(i);	
		}
			
		
		return t;
		
	}

}
