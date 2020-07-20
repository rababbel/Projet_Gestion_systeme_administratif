package back.presentation.vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import back.presentation.controleur.EditerEmployContr;
/**
 * classe pour afficher les informations des employes
 *
 */
public class VueEditerEmploye {
	private JTable tableau;
    private Object[][] donne;
    private VueAccuiel a;
	public VueEditerEmploye() {
	initialiser();
	dessiner();
	}
	public void initialiser()
	{
		a=new VueAccuiel();
		donne=new EditerEmployContr().donnee();
		String title[] = {"id ","cin","nom","prenom","email","service","role","password"};
		this.tableau = new JTable(donne, title); 
	
	}
    public void dessiner()
    {
    	a.getContentPane().add(new JScrollPane(tableau), BorderLayout.SOUTH);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Gestion des employe et chef de service         Editer");
		jpa.add(acc);
		acc.setForeground(Color.red);
		a.add(jpa);
		a.img.setVisible(false);
    }

}
