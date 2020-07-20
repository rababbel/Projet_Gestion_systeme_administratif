package back.presentation.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueGestionEmploye {
	private JButton ajouter;
	private JButton archiver;
	private JButton modifier;
	private JButton editer;
	private VueAccuiel a;
	public VueGestionEmploye() {
		initialiser();
		dessiner();
		action();
	}
	public void initialiser()
	{
		ajouter=new JButton("ajouter");
		modifier=new JButton("modifier");
		archiver=new JButton("archiver");
		editer=new JButton("editer");
		
	}
	public void dessiner()
	{
		a=new VueAccuiel();
		JPanel pan=new JPanel();
		pan.add(ajouter);
		pan.add(modifier);
		pan.add(archiver);
		pan.add(editer);
		Dimension d=new Dimension(300,300);
		pan.setPreferredSize(d);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Gestion des employe et chef de service");
		jpa.add(acc);
		acc.setForeground(Color.red);
		a.add(jpa);
		a.add(pan,BorderLayout.SOUTH);

	}
public void action() {
	
	ajouter.addActionListener(new ActionListener()
			{
		/** L'évènement déclanché par l'appui sur le bouton "ajouter".
		@param e L'évènement.
		@throws - Pas d'exceptions levées.
		*/
				@Override
				public void actionPerformed(ActionEvent e) {
					new VueAddEmploye();
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
			new VueEditerEmploye();
		    a.dispose();
			
		}

	}
);

	modifier.addActionListener(new ActionListener()
			{
		/** L'évènement déclanché par l'appui sur le bouton "modifier".
		@param e L'évènement.
		@throws - Pas d'exceptions levées.
		*/
				@Override
				public void actionPerformed(ActionEvent e) {
					new VueModifierEmploye();
				    a.dispose();
					
				}
		
			}
	);
	
}

}
