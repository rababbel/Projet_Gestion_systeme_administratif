package back.presentation.controleur;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Alert {
	private String msg;
	private String imge;

	public Alert(String msg) {
		super();
		this.msg = msg;
		JOptionPane jo=new JOptionPane(); //message d'erreur pour tester si l'employe exist dans la base de donnee ou non
		ImageIcon img = new ImageIcon("C:\\Users\\AMINA\\eclipse-workspace\\JavaProject\\src\\back\\presentation\\image\\alertR.png");
		jo.showMessageDialog(null, msg, "warning", JOptionPane.INFORMATION_MESSAGE,img);
	}

	public Alert(String msg, String imge) {
		super();
		this.msg = msg;
		this.imge = imge;
		JOptionPane jo=new JOptionPane();
		ImageIcon img = new ImageIcon(imge);
		jo.showMessageDialog(null, msg, "warning", JOptionPane.INFORMATION_MESSAGE,img);
	}
	
	

}
