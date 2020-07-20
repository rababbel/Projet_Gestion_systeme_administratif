package back.presentation.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import back.backMetier.Personne;
import back.backMetier.Role;
import back.presentation.controleur.AddEmpControleur;
import back.presentation.controleur.Alert;
/**
 * 
 * classe pour ajouter un employe
 *
 */
public class VueAddEmploye {

	private JLabel id;
	private JLabel nom,mail,cin;
	private JLabel prenom,fonc,servi,pwd;
	private JTextField fid,fnom,fprenom,fcin,fmail,fdata;
	private JComboBox<Object> fonction,service;
	private JButton ajouter;
	public VueAccuiel i;
	private Personne personne;
	private Verification V;
		
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	/**
	 * constructeur sans paramétres
	 * @throws HeadlessException
	 */
	public VueAddEmploye() throws HeadlessException {
		initialiser();
		dessiner();
		action();
	}
	/**
	 * methode pour initialiser les composants
	 */
	public void initialiser()
	{
		id=new JLabel("ID :");
		cin=new JLabel("CIN :");
		mail=new JLabel("Email :");
		nom=new JLabel("Nom :");
		prenom=new JLabel("Prenom :");
		fonc=new JLabel("Fonction :");
		servi=new JLabel("Service :");
		pwd=new JLabel("password");
		ajouter=new JButton("ajouter");
		fid=new JTextField();
		fcin=new JTextField();
		fcin.setSize(20, 20);
		fmail=new JTextField();
		fnom=new JTextField();
		fprenom=new JTextField();
		fdata=new JTextField("");
	    Object [] elem=new Object[] {"chef de service","employe"};
	    Object [] el=new Object[] {"RH","comtabilite","administration","informatique"};
	    fonction=new JComboBox<Object>(elem);
		service=new JComboBox<Object>(el);
		V=new Verification();
	}
	
	/**
	 * methode pour dessiner les composants
	 */
	public void dessiner()
	{
	    i=new VueAccuiel();
		JPanel pan= new JPanel();
		JPanel p= new JPanel();
		p.setLayout(new BorderLayout());
		JPanel pi= new JPanel();
		pan.setLayout(new GridLayout(4,4));
		Dimension di=new Dimension(400,400);
		p.setPreferredSize(di);
		pan.add(cin);
		pan.add(fcin);
		pan.add(mail);
		pan.add(fmail);
		pan.add(id);
		pan.add(fid);
		pan.add(pwd);
		pan.add(fdata);
		pan.add(nom);
		pan.add(fnom);
		pan.add(fonc);
		pan.add(fonction);
		pan.add(prenom);
		pan.add(fprenom);
		pan.add(servi);
		pan.add(service);
		p.add(pan,BorderLayout.NORTH);
		pi.add(ajouter);
		p.add(pi,BorderLayout.SOUTH);
		JPanel jpa=new JPanel();
		JLabel acc=new JLabel("Gestion des employe et chef de service              ajouter");
		jpa.add(acc);
		acc.setForeground(Color.red);
		i.add(jpa);
		i.add(p,BorderLayout.SOUTH);
		
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
						if(fonction.getSelectedItem().toString()=="employe")
						{personne=new Personne(Integer.parseInt(fid.getText()), Integer.parseInt(fcin.getText()),fnom.getText(),fprenom.getText(),fmail.getText(),fdata.getText(),service.getSelectedItem().toString(),Role.employe);
						}else
							{
							   personne=new Personne(Integer.parseInt(fid.getText()), Integer.parseInt(fcin.getText()),fnom.getText(),fprenom.getText(),fmail.getText(),fdata.getText(),service.getSelectedItem().toString(),Role.chefDivision);
							
							}
						    if(V.isMail(personne.getEmail()))
					     	new AddEmpControleur(personne);
						    else
						    	new Alert("l'email doit etre ecrit sous la forme xxx@yy.xx\n");
						
						}catch(NumberFormatException ex)
						{
							new Alert("donnees invalide (verifier cin et id)");
						}
					}
			 
			   
				});
	}
	

	
}
