package back.presentation.controleur;

import javax.swing.JOptionPane;

import back.backDAO.EtapeDAO;
import back.backMetier.Etape;
import back.backMetier.GestionnaireEtape;

public class SupprimerEtapeControleur {
	private Etape etape;
	private GestionnaireEtape eta;
	private EtapeDAO et;
	private JOptionPane jop;
	public SupprimerEtapeControleur(Etape etape) {
		super();
		this.etape = etape;
		eta=new GestionnaireEtape();
		jop=new JOptionPane();
		et=new  EtapeDAO();
		if(et.isExist(etape))
			{
			int option = jop.showConfirmDialog(null, "Voulez-vous supprimer cet etape ?", "Suppression de l'etape", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION)
			{eta.effacerEtape(etape);
			new Alert("l'etape est supprimer avec succé","C:\\Users\\AMINA\\eclipse-workspace\\JavaProject\\src\\back\\presentation\\image\\aff.png");
			}
			}
		else
			new Alert("cet etape n'existe pas");
			
		
	}
	

}
