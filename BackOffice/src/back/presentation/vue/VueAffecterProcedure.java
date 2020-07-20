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

import back.backMetier.GestionairePersonne;
import back.backMetier.GestionnaireProcedure;
import back.backMetier.Personne;
import back.backMetier.Procedure;
import back.presentation.controleur.AffectationProcedureControleur;

public class VueAffecterProcedure {
	private JLabel proc,empl;
	private JComboBox<Object> idProcedure;
	private JComboBox<Object> idEmploye;
	private JPanel pan,pa,p;
	private VueAccuiel a;
	private GestionnaireProcedure procedure;
	private GestionairePersonne chef;
	private JButton valider;
	public VueAffecterProcedure() {
		initialiser();
		dessiner();
		action();
	}
	/**
	 * initialisation
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
		idProcedure =new JComboBox<Object>(el);
		chef=new GestionairePersonne();
		ArrayList<Personne> per= chef.listChefDivision();
		ArrayList<Integer> pers=new ArrayList<Integer>();
		for(Personne pe:per)
		{
			pers.add(pe.getIdPersonne());
		}
		Object[] person=pers.toArray();
		idEmploye=new JComboBox<Object>(person);
		proc= new JLabel("ID procedure");
		empl= new JLabel("ID Chef de division");
		pan =new JPanel();
		pan.setLayout(new GridLayout(2,2));
		pa =new JPanel();
		p =new JPanel();
		p.setLayout(new BorderLayout());
		valider=new JButton("valider");
		Dimension di=new Dimension(400,400);
		p.setPreferredSize(di);
	}
	/**
	 * dessin des composants
	 */
	public void dessiner()
	{
		a=new VueAccuiel();
		a.img.setVisible(false);
		pan.add(proc);
		pan.add(idProcedure);
		pan.add(empl);
        pan.add(idEmploye);
        pa.add(valider);
        p.add(pan,BorderLayout.NORTH);
        p.add(pa,BorderLayout.SOUTH);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Affecter procedures et etape aux employe           Affecter Procedure");
		jpa.add(acc);
		acc.setForeground(Color.red);
		a.add(jpa);
        a.add(p,BorderLayout.SOUTH);
        
        
		
	}
	
	public void action()
	{
		valider.addActionListener(new ActionListener() {
   
			/** L'évènement déclanché par l'appui sur le bouton "valider".
			@param e L'évènement.
			@throws - Pas d'exceptions levées.
			*/
			@Override
			public void actionPerformed(ActionEvent e) {
			
				new AffectationProcedureControleur(Integer.parseInt(idProcedure.getSelectedItem().toString()),Integer.parseInt(idEmploye.getSelectedItem().toString()));
				
				
			}
			
		});
	
	}

}
