/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 *
 * @author Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 */
public class TuileGraphique extends JButton {

	// éléments qu'on va pouvoir afficher sur la fenêtre de jeu
	Tuile tuileAssociee;
	
	/* On charge les images */
	ImageIcon araignee = new javax.swing.ImageIcon(getClass().getResource("/images/araignee.png"));
	ImageIcon bague = new javax.swing.ImageIcon(getClass().getResource("/images/bague.png"));
	ImageIcon bourse = new javax.swing.ImageIcon(getClass().getResource("/images/bourse.png"));
	ImageIcon carteTresor = new javax.swing.ImageIcon(getClass().getResource("/images/carte.png"));
	ImageIcon chandelier = new javax.swing.ImageIcon(getClass().getResource("/images/chandelier.png"));
	ImageIcon chauvesouris = new javax.swing.ImageIcon(getClass().getResource("/images/chauvesouris.png"));
	ImageIcon chouette = new javax.swing.ImageIcon(getClass().getResource("/images/chouette.png"));
	ImageIcon cle = new javax.swing.ImageIcon(getClass().getResource("/images/cle.png"));
	ImageIcon couronne = new javax.swing.ImageIcon(getClass().getResource("/images/couronne.png"));
	ImageIcon crane = new javax.swing.ImageIcon(getClass().getResource("/images/crane.png"));
	ImageIcon departB = new javax.swing.ImageIcon(getClass().getResource("/images/departB.png"));
	ImageIcon departJ = new javax.swing.ImageIcon(getClass().getResource("/images/departJ.png"));
	ImageIcon departR = new javax.swing.ImageIcon(getClass().getResource("/images/departR.png"));
	ImageIcon departV = new javax.swing.ImageIcon(getClass().getResource("/images/departV.png"));
	ImageIcon dragon = new javax.swing.ImageIcon(getClass().getResource("/images/dragon.png"));
	ImageIcon epee = new javax.swing.ImageIcon(getClass().getResource("/images/epee.png"));
	ImageIcon fantome = new javax.swing.ImageIcon(getClass().getResource("/images/fantome.png"));
	ImageIcon fee = new javax.swing.ImageIcon(getClass().getResource("/images/fee.png"));
	ImageIcon genie = new javax.swing.ImageIcon(getClass().getResource("/images/genie.png"));
	ImageIcon gobelin = new javax.swing.ImageIcon(getClass().getResource("/images/gobelin.png"));
	ImageIcon heaume = new javax.swing.ImageIcon(getClass().getResource("/images/heaume.png"));
	ImageIcon lezard = new javax.swing.ImageIcon(getClass().getResource("/images/lezard.png"));
	ImageIcon livre = new javax.swing.ImageIcon(getClass().getResource("/images/livre.png"));
	ImageIcon papillon = new javax.swing.ImageIcon(getClass().getResource("/images/papillon.png"));
	ImageIcon rat = new javax.swing.ImageIcon(getClass().getResource("/images/rat.png"));
	ImageIcon saphir = new javax.swing.ImageIcon(getClass().getResource("/images/saphir.png"));
	ImageIcon scarabee = new javax.swing.ImageIcon(getClass().getResource("/images/scarabee.png"));
	ImageIcon tresor = new javax.swing.ImageIcon(getClass().getResource("/images/tresor.png"));
	ImageIcon droit = new javax.swing.ImageIcon(getClass().getResource("/images/droit.png"));
	ImageIcon coin = new javax.swing.ImageIcon(getClass().getResource("/images/coin.png"));

	public TuileGraphique(Tuile laTuile) {
		tuileAssociee = laTuile;
	}

	@Override
	public void paintComponent(Graphics G) {
		super.paintComponent(G);
	//mettre les images fixes ici en fonction d'une possible méthode tuilefixe()
	
	setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + tuileAssociee.type + ".png")));

	}

}
