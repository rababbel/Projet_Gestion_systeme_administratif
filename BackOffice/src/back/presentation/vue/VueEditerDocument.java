package back.presentation.vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import back.presentation.controleur.EditerDocumentContr;
/**
 *classe pur afficher les informations des documents
 *
 */
public class VueEditerDocument {
	private JTable tableau;
    private Object[][] donne;
    private VueAccuiel a;
    
	public VueEditerDocument() {
	initialiser();
	dessiner();
	}
	/**
	 * initialisation
	 */
	public void initialiser()
	{
		a=new VueAccuiel();
		donne=new EditerDocumentContr().donnee();
		String title[] = {"id document","nom","idprocedure"};
		this.tableau = new JTable(donne, title); 
	
	}
	/**
	 * dessin des composants
	 */
    public void dessiner()
    {
    	a.getContentPane().add(new JScrollPane(tableau), BorderLayout.SOUTH);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Gestion des documents        Editer");
		jpa.add(acc);
		acc.setForeground(Color.red);
		a.add(jpa);
		a.img.setVisible(false);
    }

	
}
