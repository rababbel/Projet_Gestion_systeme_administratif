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

import back.backMetier.Etape;
import back.presentation.controleur.Alert;
import back.presentation.controleur.SupprimerEtapeControleur;

public class VueSupprimerEtape {
	private JLabel id ,acc,supp;
	private JTextField idEtape;
	private JButton supprimer;
	private JPanel pan,p,pa,jp;
	private VueAccuiel a;
	private Etape etape;
	private ImageCanvas img;
	public VueSupprimerEtape() {
    initialiser();
    dessiner();
    action();
	}
	public void initialiser()
	{
		id=new JLabel("l'id d'etape a supprimer");
		acc=new JLabel("gestion des etapes de procedure");
		supp=new JLabel("supprimer");
		idEtape=new JTextField();
		pan=new JPanel();
		p=new JPanel();
		pa=new JPanel();
		jp=new JPanel();
		supprimer=new JButton("supprimer");
		img=new ImageCanvas("C:\\Users\\AMINA\\eclipse-workspace\\JavaProject\\src\\back\\presentation\\image\\clear.png");
		a=new VueAccuiel();
	}
	public void dessiner()
	{
		pan.setLayout(new GridLayout(1,1));
		pan.add(id);
		pan.add(idEtape);
		pa.setLayout(new BorderLayout());
		pa.setPreferredSize(new Dimension(300,300));
		p.setLayout(new GridLayout(1,3));
		p.add(acc);
		p.add(img);
		p.add(supp);
		a.add(p);
		jp.add(supprimer);
		pa.add(pan,BorderLayout.NORTH);
		pa.add(jp,BorderLayout.SOUTH);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Gestion des etapes de procedures          Supprimer");
		jpa.add(acc);
		acc.setForeground(Color.red);
		a.add(jpa);
		a.add(pa,BorderLayout.SOUTH);
		
		
	}
	public void action()
	{
		supprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(idEtape.getText().equals(""))
				{
					new Alert("vous devez saisir l'id de l'etape a supprimer");
				}
				else
				{
				etape=new Etape(Integer.parseInt(idEtape.getText()));
				new SupprimerEtapeControleur(etape);
				}
				
				
			}
			
		});
		
	}
	

}
