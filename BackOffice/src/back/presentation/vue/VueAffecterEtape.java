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

import back.backMetier.Etape;
import back.backMetier.GestionairePersonne;
import back.backMetier.GestionnaireEtape;
import back.backMetier.Personne;
import back.presentation.controleur.AffecterEtapeControleur;
/**
 * classe qui affiche l'interface pour affecter une etape
 *
 */
public class VueAffecterEtape {

	private JLabel empl,etap;
	private JComboBox<Object> idEtape;
	private JComboBox<Object> idEmploye;
	private JPanel pan,pa,p;
	private VueAccuiel a;
	private GestionairePersonne employe;
	private GestionnaireEtape etape;
	private JButton valider;
	
	public VueAffecterEtape() {
		initialiser();
		dessiner();
		action();
	}
	/**
	 * initialisation
	 */
	public void initialiser()
	{
		empl= new JLabel("ID Employe");
		etap= new JLabel("ID etape");
		employe=new GestionairePersonne();
		ArrayList<Personne> per=employe.listEmploye();
		ArrayList<Integer> pers=new ArrayList<Integer>();
		for(Personne pe:per)
		{
			pers.add(pe.getIdPersonne());
		}
		Object[] person=pers.toArray();
		idEmploye=new JComboBox<Object>(person);
		etape=new GestionnaireEtape();
		ArrayList<Etape> et=etape.listeEtapesProcedure();
		ArrayList<Integer> tab=new ArrayList<Integer>();
		for(Etape t:et)
		{
			tab.add(t.getIdEtape());
		}
		Object[] elem=tab.toArray();
		idEtape=new JComboBox<Object> (elem);
		
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
		pan.add(etap);
		pan.add(idEtape);
		pan.add(empl);
        pan.add(idEmploye);
        pa.add(valider);
        p.add(pan,BorderLayout.NORTH);
        p.add(pa,BorderLayout.SOUTH);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Affecter procedures et etape aux employe           Affecter Etape");
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
				
				new AffecterEtapeControleur(Integer.parseInt(idEtape.getSelectedItem().toString()),Integer.parseInt(idEmploye.getSelectedItem().toString()));
				
			}
			
		});
	
	}
}
