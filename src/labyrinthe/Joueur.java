/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

/**
 * Implémente les joueurs
 *
 * @author Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 */
public class Joueur {

	String nom;
	String couleur;
	String[] listeObjets;
	Carte[] listeCartes;
	int indexCarteRetournee;
	Pion marqueur;

	Joueur(String nom_joueur, int nombre_cartes) {
		nom = nom_joueur;
		listeObjets = new String[nombre_cartes];
		listeCartes = new Carte[nombre_cartes];
		indexCarteRetournee = 0;
		marqueur = new Pion(this);
	}

	/**
	 * Ajoute l'objet présent sur la tuile à la liste des objets
	 * possédés par le joueur.
	 *
	 * @param tuile La tuile sur laquelle le joueur est
	 * @return Succès de l'opération
	 */
	public boolean rammaserObjet(Tuile tuile) {
		if (sacEstPlein()) {
			return false;
		}
		if (tuile.objet == null) {
			return false;
		}
		int i = 0;
		while (listeObjets[i] != null) {
			i++;
		}
		listeObjets[i] = tuile.objet;
		return true;
	}

	public boolean ajouterCarte(Carte carte) {
		return false;
	}

	/**
	 * Vérifie si le sac du joueur (son attribut 'listeObjets') est
	 * plein.
	 *
	 * @return Le remplissage du sac
	 */
	public boolean sacEstPlein() {
		for (int i = 0; i < listeObjets.length; i++) {
			if (listeObjets[i] == null) {
				return false;
			}
		}
		return true;
	}

}
