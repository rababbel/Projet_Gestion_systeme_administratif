package back.presentation.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueGestionEtape {
	private JButton ajouter;
	private JButton supprimer;
	private JButton editer;
	private VueAccuiel a;
	public VueGestionEtape() {
		initialiser();
		dessiner();
		action();
	}
	public void initialiser()
	{
		ajouter=new JButton("ajouter");
		supprimer=new JButton("supprimer");
		editer=new JButton("editer");
		
	}
	public void dessiner()
	{
		a=new VueAccuiel();
		JPanel pan=new JPanel();
		pan.add(ajouter);
		pan.add(supprimer);
		pan.add(editer);
		Dimension d=new Dimension(300,300);
		pan.setPreferredSize(d);
		//pan.setBackground(Color.white);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Gestion des etapes de procedures");
		jpa.add(acc);
		acc.setForeground(Color.red);
		a.add(jpa);
		a.add(pan,BorderLayout.SOUTH);
	}
public void action() {
	
	ajouter.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					new VueAddEtape();
				    a.dispose();
					
				}
		
			}
	);
	supprimer.addActionListener(new ActionListener()
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			new VueSupprimerEtape();
		    a.dispose();
			
		}

	}
);
	editer.addActionListener(new ActionListener()
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			new VueEditerEtape();
		    a.dispose();
			
		}

	}
);
	
	
}


}
