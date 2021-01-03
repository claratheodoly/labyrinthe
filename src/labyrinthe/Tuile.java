/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

import java.util.ArrayList;

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
	ArrayList<Pion> pionsPresents;

	Tuile(String type_donne) {
		type = type_donne;
		orientation = 0;
		pionsPresents = new ArrayList<>();
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
		boolean tmp;
		switch (angle) {
			case 0:
				break;
			case 90:
				tmp = porteNord;
				porteNord = porteOuest;
				porteOuest = porteSud;
				porteSud = porteEst;
				porteEst = tmp;
				break;
			case 180:
				tmp = porteNord;
				porteNord = porteSud;
				porteSud = tmp;
				tmp = porteEst;
				porteEst = porteOuest;
				porteOuest = tmp;
				break;
			case 270:
				tmp = porteNord;
				porteNord = porteEst;
				porteEst = porteSud;
				porteSud = porteOuest;
				porteOuest = tmp;
				break;
		}
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
		pion_joueur.propriétaire.rammasserObjet(this);
		objet = null;
		return true;

	}

	public boolean presenceObjet() {
		return !(objet == null);
	}

	public boolean presencePion() {
		return !(pionsPresents == null || pionsPresents.isEmpty());
	}

}
