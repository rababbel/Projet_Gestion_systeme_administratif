package back.presentation.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import back.backMetier.Personne;
import back.backMetier.Role;
import back.presentation.controleur.Alert;
import back.presentation.controleur.ModifierEmpControleur;

public class VueModifierEmploye {

	private JButton valider;
	private JLabel id;
	private JTextField fid;
	private VueAccuiel a;
	private JLabel nom,mail;
	private JLabel prenom,fonc,servi,dataj;
	private JTextField fnom,fprenom,fmail,fdata;
	private JComboBox fonction,service;
	private JButton b;
	private int n;
	private JPanel jp,jpa,p;
	private Personne per,personne;
	private ModifierEmpControleur contr;
	private Verification V;
	/**
	 * constructeur sans argument
	 */
	public VueModifierEmploye() {
	initialiser();
	dessiner();
	action();
	}
	public void initialiser()
	{
		jp=new JPanel();
		jpa=new JPanel();
		jpa.setLayout(new GridLayout(2,2));
		id=new JLabel("ID :");
		fid=new JTextField();
		valider=new JButton("valider");
		Dimension di=new Dimension(400,400);
		jp.setPreferredSize(di);
		id=new JLabel("ID :");
		//cin=new JLabel("CIN :");
		mail=new JLabel("Email :");
		nom=new JLabel("Nom :");
		prenom=new JLabel("Prenom :");
		fonc=new JLabel("Fonction :");
		servi=new JLabel("Service :");
		dataj=new JLabel("password");
		b=new JButton("modifier");
		fid=new JTextField();
	   //fcin=new JTextField();
		//fcin.setSize(20, 20);
		fmail=new JTextField();
		fnom=new JTextField();
		fprenom=new JTextField();
		fdata=new JTextField("");
	    Object [] elem=new Object[] {"chef de service","employe"};
	    Object [] el=new Object[] {"RH","comtabilite","administration","informatique"};
	    fonction=new JComboBox(elem);
		service=new JComboBox(el);
		V=new Verification();
		
	}
	public void dessiner()
	{
		a=new VueAccuiel();
		JPanel pan= new JPanel();
		p= new JPanel();
		p.setLayout(new BorderLayout());
		JPanel pi= new JPanel();
		pan.setLayout(new GridLayout(3,3));
		Dimension di=new Dimension(400,400);
		p.setPreferredSize(di);
		//i.add(new JLabel("gestion des employes et chef de service                     ajouter"));
		//pan.add(cin);
		//pan.add(fcin);
		pan.add(mail);
		pan.add(fmail);
		pan.add(id);
		pan.add(fid);
		pan.add(dataj);
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
		pi.add(b);
		p.add(pi,BorderLayout.SOUTH);
		JPanel j=new JPanel();
		jp.setLayout(new BorderLayout());
		jpa.add(id);
		jpa.add(fid);
		j.add(valider);
		jpa.add(j);
		jp.add(jpa,BorderLayout.NORTH);
		jp.add(p,BorderLayout.CENTER);
		JPanel jpan=new JPanel();
		JLabel acc=new JLabel("Gestion des employe et chef de service           Modifier");
		jpan.add(acc);
		acc.setForeground(Color.red);
		a.add(jpan);
		a.add(jp,BorderLayout.SOUTH);
		
	}
	public void action()
	{
		valider.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						n=Integer.parseInt(fid.getText());
						contr=new ModifierEmpControleur(n);
						per=contr.getPersonne();
						if(per.getIdPersonne()!=0)
						{
							fid.setText(String.valueOf(per.getIdPersonne()));
							fnom.setText(per.getNom());
							fprenom.setText(per.getPrenom());
							fmail.setText(per.getEmail());
							fdata.setText(per.getPassword());
							
						}
		
					}
			
				});
		b.addActionListener( new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(fonction.getSelectedItem().toString()=="employe")
				{personne=new Personne(Integer.parseInt(fid.getText()), per.getCIN(),fnom.getText(),fprenom.getText(),fmail.getText(),fdata.getText(),service.getSelectedItem().toString(),Role.employe);
				}else
					{
					   personne=new Personne(Integer.parseInt(fid.getText()), per.getCIN(),fnom.getText(),fprenom.getText(),fmail.getText(),fdata.getText(),service.getSelectedItem().toString(),Role.chefDivision);
					
					}
				
			    if(V.isMail(personne.getEmail()))
			    	new ModifierEmpControleur(personne);
			    else
			    	new Alert("l'email doit etre ecrit sous la forme xxx@yy.xx\n");
				
				
				
			}
	 
	   
		});
		
	}

}
