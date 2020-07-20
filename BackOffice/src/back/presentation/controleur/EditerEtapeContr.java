package back.presentation.controleur;

import java.util.ArrayList;

import back.backMetier.Etape;
import back.backMetier.GestionnaireEtape;

public class EditerEtapeContr {
	private GestionnaireEtape etape;
	private ArrayList<Object[]> tableau ;
	private ArrayList<Etape> list;
	int idpr,idPer,idEtape;
	public EditerEtapeContr() {
		tableau=new ArrayList<Object[]>();
		etape=new GestionnaireEtape();
		list=etape.listeEtapesProcedure();
	}

	/**
	 * methode pour recuperer les donnees d'une procedure 
	 * @return une liste de tableau d'objet;
	 */
	public  Object[][]donnee()
	{
		for(Etape doc:list)
		{   
			idpr=doc.getIdProcedure();
			idPer=doc.getIdEmploye();
			idEtape=doc.getIdEtape();
			Object[] tab={idEtape,idpr,idPer};
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
