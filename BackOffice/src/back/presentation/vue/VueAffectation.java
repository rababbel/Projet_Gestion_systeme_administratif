package back.presentation.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *classe qui affiche l'interface pour affecter une procedure ou une etape
 */
public class VueAffectation {
private JButton etape;
private JPanel pan,pa;
private JButton procedure;
private JLabel acc;
private VueAccuiel a;
/**
 * constructeur sans parametre
 */
public VueAffectation() {
	initialiser();
	dessiner();
	action();
}
/**
 * initialisation des composants
 */
public void initialiser()
{
	a=new VueAccuiel();
	etape=new JButton("affecter etape");
	procedure =new JButton("affecter procedure");
	acc=new JLabel("affectation des etapes et des procedures aux employe");
	acc.setForeground(Color.red);
	pan=new JPanel();
	pa=new JPanel();
	
	
}
/**
 * dessin des composants
 */
public void dessiner()
{
	pan.add(etape);
	pan.add(procedure);
	pa.add(acc);
	pan.setPreferredSize(new Dimension(300,300));
	a.add(pan,BorderLayout.SOUTH);
	a.add(pa);
	
}
public void action()
{
	etape.addActionListener(new ActionListener() {

		/** L'évènement déclanché par l'appui sur le bouton "etape".
		@param e L'évènement.
		@throws - Pas d'exceptions levées.
		*/
		@Override
		public void actionPerformed(ActionEvent e) {
			new VueAffecterEtape();
			a.dispose();
			
		}
		
	});
	
	procedure.addActionListener(new ActionListener() {
		/** L'évènement déclanché par l'appui sur le bouton "procedure".
		@param e L'évènement.
		@throws - Pas d'exceptions levées.
		*/
		@Override
		public void actionPerformed(ActionEvent e) {
			new VueAffecterProcedure();
			a.dispose();
			
		}
		
	});
	
}


}
