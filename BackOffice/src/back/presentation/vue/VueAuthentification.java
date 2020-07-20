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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import back.presentation.controleur.Alert;
import back.presentation.controleur.LoginControleur;

public class VueAuthentification extends JFrame{
	/**
	 * classe pour l'authentification 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel login,passwd,acc,role,remarque;
	private JTextField flogin;
	private JComboBox<Object> frole;
	private JPasswordField fpasswd;
	private JPanel pan,p,jp,pa;
	private JButton valider;
	private ImageCanvas img;
	/**
	 * 
	 * @throws HeadlessException
	 */
	public VueAuthentification() throws HeadlessException {
		super();
		initialiser();
		dessiner();
		action();
	}
	/**
	 * initialisation
	 */
	public void initialiser()
	{
		new Quitter(this);
		login=new JLabel("Nom d'utilisateur");
		passwd=new JLabel("mot de passe");
		role=new JLabel("votre role");
		acc=new JLabel("SE CONNECTER :");
		acc.setSize(100, 100);
		flogin=new JTextField();
		Object[] elem= {"admin"};
		frole=new JComboBox<Object>(elem);
		fpasswd=new JPasswordField();
		pan=new JPanel();
		p=new JPanel();
		pa=new JPanel();
		valider =new JButton("se connecter");
		img=new ImageCanvas("C:\\Users\\AMINA\\eclipse-workspace\\JavaProject\\src\\back\\presentation\\image\\users.png");
	    jp=new JPanel();
	    remarque=new JLabel("pour le nom d'utilisateur veuiller entrer votre CIN");
	    remarque.setForeground(Color.red);
		
	}
	/**
	 * dessiner les composants
	 */
	public void dessiner()
	{
		this.setLayout(new BorderLayout());
		pan.setLayout(new GridLayout(3,2));
		p.setLayout(new BorderLayout());
		jp.setPreferredSize(new Dimension(100,100));
		jp.setLayout(new GridLayout(2,2));
		acc.setForeground(Color.blue);
		pan.add(login);
		pan.add(flogin);
		pan.add(role);
		pan.add(frole);
		pan.add(passwd);
		pan.add(fpasswd);
		jp.add(img);
	    jp.add(acc);
		p.add(pan,BorderLayout.NORTH);
		this.add(jp,BorderLayout.NORTH);
		pa.add(valider);
		p.add(pa,BorderLayout.SOUTH);
		this.add(p,BorderLayout.CENTER);
		this.add(remarque,BorderLayout.SOUTH);	
		this.setSize(500, 500);
		this.setVisible(true);
		
	}
	public void action()
	{
		valider.addActionListener(new ActionListener()
				{
			
			
			
			/** L'évènement déclanché par l'appui sur le bouton "valider".
			@param e L'évènement.
			@throws - Pas d'exceptions levées.
			*/
					@SuppressWarnings("deprecation")
					@Override
					public void actionPerformed(ActionEvent e) {
						if(flogin.getText().equals("")||fpasswd.getText().equals(""))
							new Alert("assurez vous que vous avez rempli tous les champs");
						else if(frole.getSelectedItem().toString().equals("admin"))
                    	 new LoginControleur(Integer.parseInt(flogin.getText()),fpasswd.getText());
                        flogin.setText("");
                        fpasswd.setText("");
                    	 
						
					}
			
				});
		
	}

	
	

}
