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
	boolean porteNord;
	boolean porteEst;
	boolean porteSud;
	boolean porteOuest;
	ArrayList<Pion> pionsPresents;

	/**
	 * Crée un tuile vide du type donné, dans l'orientation de base
	 *
	 * @param type_donne Le type de la tuile
	 */
	Tuile(String type_donne) {
		type = type_donne;
		orientation = 0;
		pionsPresents = new ArrayList<>();
	}

	/**
	 * Tourne la tuile du nombre de degrés précisés, si ce nombre est un
	 * multiple de 90.
	 *
	 * @param degres L'angle de rotation
	 * @return Succès de l'opération
	 */
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

	/**
	 * Détermine si un objet est présent sur la tuile (c-à-d si la tuile n'est
	 * pas une tuile de départ ou un tuile vide (type 'droit' ou 'coin'))
	 *
	 * @return Si la tuile a un objet
	 */
	public boolean presenceObjet() {
		return !(type.equals("droit") || type.equals("coin") || type.equals("departB") || type.equals("departV") || type.equals("departJ") || type.equals("departR"));
	}

	/**
	 * Détermine si des pions sont présents sur la tuile (ou un seul)
	 *
	 * @return Si la tuile a des pions
	 */
	public boolean presencePion() {
		return !(pionsPresents == null || pionsPresents.isEmpty());
	}

}
