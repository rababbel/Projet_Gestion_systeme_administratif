package back.presentation.vue;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * cette classe permet de dessiner une image
 * @author AMINA BOUSSABI,IHSSANE AMZIL ,RABAB BELMABKHOUT
 *
 */
public class ImageCanvas extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * le chemin de l'image a dessiner
	 */
	private String url;
/**
 * constucteur avec parametre
 * @param url le chemin de l'image
 */
	public ImageCanvas(String url) {
		super();
		this.url = url;
	}
	/**
	 * methode permet de dessiner une image
	 */

	public void paint(Graphics g)
	{
		Toolkit t= Toolkit.getDefaultToolkit();
		Image i=t.getImage(url);
		g.drawImage(i, 10, 10, this);
		
	}
	

  }


