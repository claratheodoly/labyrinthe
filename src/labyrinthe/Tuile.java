/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

/**
 *
 * @author Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 */
public class Tuile {

	// Tuile(String) tournerTuile(int) : boolean placerObjet(String) : boolean recupererObjet(Pion) : boolean
	String type;
	int orientation;
	String objet;
	boolean porteNord;
	boolean porteEst;
	boolean porteSud;
	boolean porteOuest;
	Pion[] pionsPresents;

	Tuile(String type_donne) {
		type = type_donne;
		orientation = 0;
	}
        /*
	public RotatingImage(BufferedImage sourceImage){
		
		
	}
	public boolean tournerTuile(int degres) {
		if (une_orientation = 90){ // rotation de la tuile de pi/2
            		rotatingImage.setAngle(Math.PI*1/2);
      
        }
        	if (une_orientation = 180){
            		rotatingImage.setAngle(Math.PI*2/2);
      
        }
        	if (une_orientation = 270){
            		rotatingImage.setAngle(Math.PI*3/2);
      
        }
        	if (une_orientation = 0){
            		rotatingImage.setAngle(Math.PI*4/2);
      
        }
	}

	public boolean placerObjet(String objet) {
		if (objet == true) { 
            return false;  
        } else {
            objet = true;
            return true;
	}

	public boolean recupererObjet(Pion pion_joueur) {
		Objet ObjetRecuperer = ObjetActuel;
        ObjetActuel = null;
        return ObjetRecuperer; 
		
	}
*/
}
