/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author clara
 */
public class TuileGraphique extends JButton {
    
    // éléments qu'on va pouvoir afficher sur la fenêtre de jeu
	Tuile TuileAssociee ;
	// on charge les 5 images
	ImageIcon araignee = new javax.swing.ImageIcon(getClass().getResource("/images/araignee.png"));
	ImageIcon bague = new javax.swing.ImageIcon(getClass().getResource("/images/bague.png"));
	ImageIcon bourse = new javax.swing.ImageIcon(getClass().getResource("/images/bourse.png"));
	ImageIcon carteTresor = new javax.swing.ImageIcon(getClass().getResource("/images/carteTresor.png"));
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
        ImageIcon tuile1 = new javax.swing.ImageIcon(getClass().getResource("/images/tuile1.png"));
        ImageIcon tuile2 = new javax.swing.ImageIcon(getClass().getResource("/images/tuile2.png"));
        
    public TuileGraphique(Tuile laTuile) {
		TuileAssociee = laTuile;
	}
        @Override
	public void paintComponent(Graphics G) {
		super.paintComponent(G);
//mettre les images fixes ici en fonction d'une possible méthode tuilefixe()
		
	}

  
}
