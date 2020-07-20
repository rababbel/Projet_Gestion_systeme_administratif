package back.presentation.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import back.backMetier.Etape;
import back.backMetier.GestionnaireProcedure;
import back.backMetier.Procedure;
import back.presentation.controleur.AddEtapeControleur;
/**
 * 
 *classe qui affiche l'interface pour ajouter une etape
 */
public class VueAddEtape {

	private JComboBox  idProcedure;
	private JLabel pr;
	private JLabel id;
	private JTextField idEtape;
	private VueAccuiel a;
	private JPanel pan,p,pa;
	private JButton ajouter;
	private GestionnaireProcedure procedure;
	private Etape etape;
	/**
	 * constructeur sans paramettres
	 */
	public VueAddEtape() {
		initialiser();
		dessiner();
		action();
	}
	/**
	 * methode pour initialiser les composants
	 */
	public void initialiser()

	{
		procedure=new GestionnaireProcedure();
		ArrayList<Procedure> elem=procedure.listProcedure();
		ArrayList<Integer> tab=new ArrayList<Integer>();
		for(Procedure a:elem)
		{
			tab.add(a.getIdProcedure());
		}
		Object[] el=tab.toArray();
		idProcedure =new JComboBox(el);
		pr=new JLabel("choisir une procedure");
		id=new JLabel("ID Etape");
		idEtape=new JTextField();
		pan=new JPanel();
		p=new JPanel();
		pa=new JPanel();
		ajouter=new JButton("ajouter");
		p.setLayout(new BorderLayout());
		pan.setLayout(new GridLayout(2,2));
		Dimension di=new Dimension(400,400);
		p.setPreferredSize(di);
		
		
		
	}
	/**
	 * methode pour le dessin des composants 
	 */
	public void dessiner()
	{
		a=new VueAccuiel();
		a.img.setVisible(false);
		pan.add(pr);
		pan.add(idProcedure);
		pan.add(id);
		pan.add(idEtape);
		p.add(pan,BorderLayout.NORTH);
		pa.add(ajouter);
		p.add(pa,BorderLayout.SOUTH);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Gestion des etapes de procedures           Ajouter");
		jpa.add(acc);
		acc.setForeground(Color.red);
		a.add(jpa);
		a.add(p,BorderLayout.SOUTH);
		
		
	}
	/** 
	 * L'évènement déclanché par l'appui sur le bouton "ajouter".
	*/
	public void action()
	{
		ajouter.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
			
						etape=new Etape(Integer.parseInt(idEtape.getText()),(Integer.parseInt(idProcedure.getSelectedItem().toString())));
						new AddEtapeControleur(etape);
						
					}
			
				});
	}
	
}
