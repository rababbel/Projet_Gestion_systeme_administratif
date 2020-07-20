package back.presentation.vue;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Quitter {
     private JFrame j;
     
	public Quitter(JFrame j) {
		super();
		this.j = j;
		WindowListener ex= new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				quitt();
			}};
			j.addWindowListener(ex);
	}
	public void quitt(){
		int n = JOptionPane.showConfirmDialog(j,"Voulez-vous quitter ?","Quitter l'application...",JOptionPane.YES_NO_OPTION);
		if(n==JOptionPane.OK_OPTION){
			System.exit(0);
		}
	}
	
	

}
