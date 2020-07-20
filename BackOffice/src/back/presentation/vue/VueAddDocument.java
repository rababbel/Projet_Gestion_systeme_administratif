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

import back.backMetier.Document;
import back.presentation.controleur.AddDocumentControleur;
import back.presentation.controleur.Alert;
/**
 * 
 * classe permet l'ajout d'un document
 *
 */
public class VueAddDocument {
	private JLabel id;
	private JLabel nom;
	private JLabel idPr;
	private JTextField fid;
	private JTextField fnom;
	private JPanel pan,p;
	private JButton ajouter; 
	private Document document;
	private JComboBox<Object> procB;
	private ArrayList<Integer> table;
	private VueAccuiel a;
	/**
	 * constructeur sans parametre responsable de l'interface ajouter document
	 */
	public VueAddDocument() {
           initialiser();
           dessiner();
           action();

		
	}
	/**
	 * methode d'initialisation des composant
	 */
	public void initialiser()
	{
		id=new JLabel("ID document:");
		nom=new JLabel("Nom document");
		idPr=new JLabel("ID procedure");
		fid=new JTextField();
		fnom=new JTextField();
		
		pan=new JPanel();
		p=new JPanel();
		ajouter=new JButton("ajouter");
		table=new AddDocumentControleur().getProc();
		Object[] elem=table.toArray();
		procB=new JComboBox<Object>(elem);
		
		
	}
	/**
	 * methode de dessin des composants
	 */
	public void dessiner()
	{
		a=new VueAccuiel();
		a.img.setVisible(false);
		JPanel pa=new JPanel();
		pa.add(ajouter);
		p.setLayout(new BorderLayout());
		Dimension di=new Dimension(400,400);
		p.setPreferredSize(di);
		pan.setLayout(new GridLayout(3,2));
		pan.add(id);
		pan.add(fid);
		pan.add(nom);
		pan.add(fnom);
		pan.add(idPr);
		pan.add(procB);
		p.add(pan,BorderLayout.NORTH);
		p.add(pa,BorderLayout.SOUTH);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Gestion des documents      Ajouter");
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
		ajouter.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
			try {
			
				document=new Document(Integer.parseInt(fid.getText()),fnom.getText(),Integer.parseInt(procB.getSelectedItem().toString()));
				new AddDocumentControleur(document);
			}catch(NumberFormatException ex)
			{
				new Alert("donnees invalide (verifier id)");
			}
			}
		
		
		}
);
	}
	
}
