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

	public boolean tournerTuile(int degres) {
		return false;
	}

	public boolean placerObjet(String objet) {
		return false;
	}

	public boolean recupererObjet(Pion pion_joueur) {
		return false;
	}

}
