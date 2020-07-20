package back.presentation.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueGestionDocument {
	private JButton ajouter;
	private JButton archiver;
	private JButton editer;
	private VueAccuiel a;
	
	public VueGestionDocument() {
		super();
	initialiser();
	dessiner();
	action();
	
	}
	public void initialiser()
	{
		ajouter = new JButton("ajouter");
		archiver=new JButton("archiver");
		editer=new JButton("editer");
		
	}
	public void dessiner()
	{
		a=new VueAccuiel();
		JPanel pan=new JPanel();
		pan.add(ajouter);
		pan.add(archiver);
		pan.add(editer);
		Dimension d=new Dimension(300,300);
		pan.setPreferredSize(d);
		//pan.setBackground(Color.white);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Gestion des procedures et ses documents");
		jpa.add(acc);
		acc.setForeground(Color.red);
		a.add(jpa);
		a.add(pan,BorderLayout.SOUTH);
	
		
	}
	
	public void action() {
		
		ajouter.addActionListener(new ActionListener()
				{
			/** L'évènement déclanché par l'appui sur le bouton "ajoutar".
			@param e L'évènement.
			@throws - Pas d'exceptions levées.
			*/
					@Override
					public void actionPerformed(ActionEvent e) {
						new VueAddDocument();
					    a.dispose();
						
					}
			
				}
		);
		editer.addActionListener(new ActionListener()
		{
			/** L'évènement déclanché par l'appui sur le bouton "editer".
			@param e L'évènement.
			@throws - Pas d'exceptions levées.
			*/
			@Override
			public void actionPerformed(ActionEvent e) {
			
				new VueEditerDocument();
				a.dispose();
			}
	
		}
);
		
	}

}
