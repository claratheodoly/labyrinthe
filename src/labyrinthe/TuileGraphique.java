/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
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
	Tuile tuileAssociee;
	int posX;
	int posY;

	public TuileGraphique(Tuile laTuile, int x, int y) {
		tuileAssociee = laTuile;
		posX = x;
		posY = y;
	}

	@Override
	public void paintComponent(Graphics G) {
		super.paintComponent(G);
		BufferedImage image = null;
		/* Lecture de l'image correspondante (attention aux exeptions) */
		try {
			image = ImageIO.read(new File("src/images/" + tuileAssociee.type + ".png"));
		} catch (IOException ex) {
			Logger.getLogger(TuileGraphique.class.getName()).log(Level.SEVERE, null, ex);
		}
		Graphics2D g = (Graphics2D) G;
		/* Cette méthode permet de ne pas tourner toute l'iamge du bouton, et donc
		que les pions restent droits */
 /* Création d'une transformation affine de rotation de l'angle indiqué autour
		du centre de l'image */
		AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians(tuileAssociee.orientation), image.getWidth() / 2, image.getHeight() / 2);
		/* Affichage de l'image tournée */
		g.drawImage(image, tx, null);
		/* Rotation de l'image de l'angle indiqué autour de son centre */
		//g.rotate(Math.toRadians(tuileAssociee.orientation), image.getWidth() / 2, image.getHeight() / 2);
		/* Affichage de l'image transformée précedement sur place */
		//g.drawImage(image, 0, 0, null);
		if (tuileAssociee.presencePion()) {
			for (Pion pion : tuileAssociee.pionsPresents) {
				BufferedImage imagePion = null;
				try {
					imagePion = ImageIO.read(new File("src/images/pion" + pion.coloration + ".png"));
				} catch (IOException ex) {
					Logger.getLogger(TuileGraphique.class.getName()).log(Level.SEVERE, null, ex);
				}
				g.drawImage(imagePion, 0, 0, null);
			}
		}
	}
}
