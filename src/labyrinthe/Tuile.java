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

	public void RotatingImage(String sourceImage) {
		// TODO
	}

	public boolean tournerTuile(int degres) {
		if (degres % 90 != 0) {
			return false;
		}
		int angle = degres % 360;
		if (angle < 0) {
			angle = (angle + 360) % 360;
		}
		orientation = (orientation + angle) % 360;
		/*switch (angle) {
			case 0:
		}*/
		return true;
	}

	public boolean placerObjet(String objetAAjouter) {
		if (objet != null) {
			return false;
		} else {
			objet = objetAAjouter;
			return true;
		}
	}

	public boolean recupererObjet(Pion pion_joueur) {
		if (objet == null) {
			return false;
		}
		pion_joueur.propriétaire.rammaserObjet(this);
		objet = null;
		return true;

	}
	
	public boolean presenceObjet() {
		return !(objet == null);
	}
	
	public boolean presencePion() {
		return !(pionsPresents == null);
	}

}
