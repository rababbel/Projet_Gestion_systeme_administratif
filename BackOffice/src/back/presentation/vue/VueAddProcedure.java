package back.presentation.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import back.backMetier.Procedure;
import back.presentation.controleur.AddProcControleur;
/**
 *classe qui affiche l'interfce pour ajouter une procedure 
 */
public class VueAddProcedure {
	private JLabel idPr;
	private JLabel nom;
	private JButton ajouter;
	private JTextField idProcedure,nomProcedure;
	private VueAccuiel a;
	private Procedure procedure;
	/**
	 * constructeur sans parametre
	 */
	public VueAddProcedure() {
	initialiser();
	dessiner();
	action();
	}
	/**
	 * initialisation des composants
	 */
	public void initialiser()
	{
		idPr=new JLabel("ID Procedure:");
		nom=new JLabel("Nom Procedure:");
		idProcedure=new JTextField();
		nomProcedure=new JTextField();
		ajouter=new JButton("ajouter");
		
		
	}
	/**
	 * dessin des composants
	 */
	public void dessiner()
	{
		a=new VueAccuiel();
		JPanel pan=new JPanel();
		JPanel p=new JPanel();
		JPanel pa=new JPanel();
		pa.add(ajouter);
		p.setLayout(new BorderLayout());
		Dimension di=new Dimension(400,400);
		p.setPreferredSize(di);
		pan.setLayout(new GridLayout(2,2));
		pan.add(idPr);
		pan.add(idProcedure);
		pan.add(nom);
		pan.add(nomProcedure);
		p.add(pan,BorderLayout.NORTH);
		p.add(pa,BorderLayout.SOUTH);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Gestion des procedures et ses documents      Ajouter");
		jpa.add(acc);
		acc.setForeground(Color.red);
		a.add(jpa);
		a.add(p,BorderLayout.SOUTH);
		
		
	}
	/** L'évènement déclanché par l'appui sur le bouton "ajouter"
	 * 
	 */
	public void action()
	{
		ajouter.addActionListener( new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						procedure=new Procedure(Integer.parseInt(idProcedure.getText()), nomProcedure.getText());
						new AddProcControleur(procedure);
						
					}
				
				
				}
		);
	}
	}			
	

	

