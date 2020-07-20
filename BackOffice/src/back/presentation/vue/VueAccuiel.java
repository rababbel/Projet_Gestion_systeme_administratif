package back.presentation.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * c'est la classe de base qui permet de dessiner l'interface 
 *
 */
public class VueAccuiel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// accuiel
	private JLabel acc;
	// gestion employe
	private JLabel  a;
	// gestion procedure
	private JLabel  b;
	// gestion etape
	private JLabel  c;
	// affectaation
	private JLabel  d;
	// Statistique
	private JLabel  f;
	private ImageCanvas image;
	/**
	 * les conteneurs des Jlabel precedents
	 */
	private JPanel ab,abb,abbb,abbbb,pa,r,jp;
	public ImageVue img;

	/**
	 * constructeur sans parametre
	 * @throws HeadlessException
	 */
	public VueAccuiel() throws HeadlessException {
		super();
		initialiser();
		dessiner();
		//action();
	}
	/**
	 * methode permet l'initialisation des composants
	 */
	public void initialiser()
	{
		acc=new JLabel("accuiel |");
		a=new JLabel("gestion des employes et chef de service |");
		b=new JLabel("gestion des procedurees et ses documents|");
		c=new JLabel("gestion des etapes de procedure|");
		d=new JLabel("affectation des procedures et des etapes au employe|");
		f=new JLabel("consulter les statistiques/taux|");
		ab=new JPanel();
		ab.setBackground(Color.white);
		abb=new JPanel();
		abb.setBackground(Color.white);
		abbb=new JPanel();
		abbb.setBackground(Color.white);
		abbbb=new JPanel();
		abbbb.setBackground(Color.white);
		pa=new JPanel();
		pa.setBackground(Color.white);
		r=new JPanel();
		r.setBackground(Color.white);
		jp=new JPanel();
		image= new ImageCanvas("C:\\Users\\AMINA\\eclipse-workspace\\JavaProject\\src\\back\\presentation\\image\\users.png");

	}
	/**
	 * methode permet le dessin des composants
	 */
	public void dessiner()
	{
		this.setLayout(new BorderLayout());
		JPanel pan=new JPanel();
	    acc.addMouseListener(new accueilListener());
		acc.setForeground(Color.BLUE);
		a.setForeground(Color.BLUE);
		a.addMouseListener(new EmployeListener());
		b.setForeground(Color.BLUE);
		b.addMouseListener(new ProcedureListener());
		c.setForeground(Color.BLUE);
		c.addMouseListener(new EtapeListener());
		d.setForeground(Color.BLUE);
		d.addMouseListener(new AffectationListener());
		f.setForeground(Color.BLUE);
		f.addMouseListener(new StatistiqueListener());
		ab.add(acc);
		abb.add(a);
		abbb.add(b);
		abbbb.add(c);
		pa.add(d);
		r.add(f);
		
		JPanel p=new JPanel();
		p.setPreferredSize(new Dimension(100,100));
		p.setLayout(new GridLayout(2,3));
		//pan.setLayout(new GridLayout(6,1));
		jp.setLayout(new BorderLayout());
		jp.setPreferredSize(new Dimension(300,200));
		pan.add(ab);
		pan.add(abb);
		pan.add(abbb);
		pan.add(abbbb);
		pan.add(pa);
		pan.add(r);
		p.add(image);
		p.add(new JLabel("bien venu dans votre espace !!!"));
		JLabel j=new JLabel("Administrateur");
		//j.setForeground(Color.white);
		p.add(j);
		p.setBackground(Color.blue);
		
		jp.add(p,BorderLayout.NORTH);
		jp.add(pan);
		this.add(jp,BorderLayout.NORTH);
		this.setSize(700,700);
		this.setTitle("espace administrateur");
		img=new ImageVue();
		this.add(img);
		this.setBackground(Color.getHSBColor(0, 51, 153));
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	/**
	 * les classe ecouteurs des composants
	 *
	 */
	/*
	 * classe ecoutant le JLabel accuiel
	 */
	class accueilListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			acc.setForeground(Color.black);
			new VueAccuiel();
			dispose();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			acc.setForeground(Color.BLUE);
			
		}

		
	}
	
	class EmployeListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			a.setForeground(Color.black);
			new VueGestionEmploye();
			dispose();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			a.setForeground(Color.BLUE);
			
		}
		
	}
	class ProcedureListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			b.setForeground(Color.black);
			new VueGestionProcDoc();
			dispose();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			b.setForeground(Color.BLUE);
		}
		
	}
	class EtapeListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			c.setForeground(Color.black);
			new VueGestionEtape();
			dispose();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			c.setForeground(Color.BLUE);
			
		}
		
	}
	class AffectationListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {
			d.setForeground(Color.black);
			new VueAffectation();
			dispose();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			d.setForeground(Color.BLUE);
			
		}
		
	}
class StatistiqueListener implements MouseListener
{

	@Override
	public void mouseClicked(MouseEvent e) {
		f.setForeground(Color.black);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		f.setForeground(Color.BLUE);
		
	}
	
}}


	

