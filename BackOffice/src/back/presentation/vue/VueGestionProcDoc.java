package back.presentation.vue;
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JPanel;

	public class VueGestionProcDoc {
	private JButton document;
	private JPanel pan,pa;
	private JButton procedure;
	private JLabel acc;
	private VueAccuiel a;

	public VueGestionProcDoc() {
		initialiser();
		dessiner();
		action();
	}
	public void initialiser()
	{
		a=new VueAccuiel();
		document=new JButton("Document");
		procedure =new JButton("Procedure");
		acc=new JLabel("Gestion des Procedures et ses documents");
		acc.setForeground(Color.red);
		pan=new JPanel();
		pa=new JPanel();
		
		
	}
	public void dessiner()
	{
		pan.add(document);
		pan.add(procedure);
		pa.add(acc);
		pan.setPreferredSize(new Dimension(300,300));
		a.add(pan,BorderLayout.SOUTH);
		a.add(pa);
		
	}
	public void action()
	{
		document.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VueGestionDocument();
				a.dispose();
				
			}
			
		});
		
		procedure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VueGestionProcedure();
				a.dispose();
				
			}
			
		});
		
	}


	}
