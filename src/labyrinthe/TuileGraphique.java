/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 */
public class TuileGraphique extends JButton {

	// éléments qu'on va pouvoir afficher sur la fenêtre de jeu
	BufferedImage image;
	Tuile tuileAssociee;

	public TuileGraphique(Tuile laTuile) {
		tuileAssociee = laTuile;
	}

	@Override
	public void paintComponent(Graphics G) {
		super.paintComponent(G);
		/* Lecture de l'image correspondante (attention aux exeptions) */
		try {
			image = ImageIO.read(new File("src/images/" + tuileAssociee.type + ".png"));
		} catch (IOException ex) {
			Logger.getLogger(TuileGraphique.class.getName()).log(Level.SEVERE, null, ex);
		}
		Graphics2D g = (Graphics2D) G;
		/* Rotation de l'image de l'angle indiqué autour de son centre */
		g.rotate(Math.toRadians(tuileAssociee.orientation), image.getWidth() / 2, image.getHeight() / 2);
		/* Affichage de l'image transformée précedement sur place */
		g.drawImage(image, null, 0, 0);
	}
}
