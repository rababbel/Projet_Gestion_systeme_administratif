package back.presentation.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import back.presentation.controleur.EditerProcedureContr;
public class VueEditerProcedure {
	private JTable tableau;
    private Object[][] donne;
    private VueAccuiel a;
	public VueEditerProcedure() {
	initialiser();
	dessiner();
	}
	public void initialiser()
	{
		a=new VueAccuiel();
		donne=new EditerProcedureContr().donnee();
		String title[] = {"id procedure","nom","idchefDivision"};
		this.tableau = new JTable(donne, title); 
	
	}
    public void dessiner()
    {
    	a.getContentPane().add(new JScrollPane(tableau), BorderLayout.SOUTH);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Gestion des Procedures         Editer");
		jpa.add(acc);
		acc.setForeground(Color.red);
		a.add(jpa);
		a.img.setVisible(false);
    }

}
