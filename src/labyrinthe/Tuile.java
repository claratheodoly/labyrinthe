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
		/*
		if (orientation != 90) { // rotation de la tuile de pi/2
			RotatingImage("a").setAngle(Math.PI * 1 / 2);

		}
		if (une_orientation = 180) {
			rotatingImage.setAngle(Math.PI * 2 / 2);

		}
		if (une_orientation = 270) {
			rotatingImage.setAngle(Math.PI * 3 / 2);

		}
		if (une_orientation = 0) {
			rotatingImage.setAngle(Math.PI * 4 / 2);

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
		return false;
	}
	
	public boolean presencePion() {
		return false;
	}

}
