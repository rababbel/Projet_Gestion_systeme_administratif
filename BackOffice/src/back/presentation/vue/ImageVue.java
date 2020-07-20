package back.presentation.vue;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * cette classe permet le dessin de l'image d'accuiel
 * @author AMINA BOUSSABI,IHSSANE AMZIL ,RABAB BELMABKHOUT
 *
 */
public class ImageVue extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * methode permet de dessiner une image
	 */
	public void paintComponent(Graphics g){ 
		try {
			Image img = ImageIO.read(new File("C:\\Users\\AMINA\\eclipse-workspace\\JavaProject\\src\\back\\presentation\\image\\FB_IMG_15397584302756175.jpg"));
		//g.drawImage(img, 0, 0, this);
		int x1 = this.getWidth()/4; 
		int y1 = this.getHeight()/4; 
		g.drawImage(img, x1, y1, this.getWidth()/2, this.getHeight()/2, this); 
		} catch (IOException e) { e.printStackTrace();
		}
		}
		}


