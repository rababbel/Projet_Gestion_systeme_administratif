package back.presentation.controleur;

import java.util.ArrayList;
import back.backMetier.GestionnaireProcedure;
import back.backMetier.Procedure;

public class EditerProcedureContr {
	private GestionnaireProcedure procedure;
	private ArrayList<Object[]> tableau ;
	private ArrayList<Procedure> list;
	int idpr,idPer;
	String nom;
	public EditerProcedureContr() {
		tableau=new ArrayList<Object[]>();
		procedure=new GestionnaireProcedure();
		list=procedure.listProcedure();
	}

	/**
	 * methode pour recuperer les donnees d'une procedure 
	 * @return une liste de tableau d'objet;
	 */
	public  Object[][]donnee()
	{
		for(Procedure doc:list)
		{   
			idpr=doc.getIdProcedure();
			idPer=doc.getIdChefDivision();
			nom=doc.getNomProcedure();
			Object[] tab={idpr,nom,idPer};
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
