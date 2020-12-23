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
	 * Ajoute l'objet présent sur la tuile à la liste des objets possédés par le
	 * joueur.
	 *
	 * @param tuile La tuile sur laquelle le joueur est
	 * @return Succès de l'opération
	 */
	public boolean rammaserObjet(Tuile tuile) {
		/* Si l'invetaire est plein, on ne peut pas ajouter d'objet
		dedans. */
		if (sacEstPlein()) {
			return false;
		}
		/* On ne peut pas ajouter d'objet qui n'existe pas */
		if (!tuile.presenceObjet()) {
			return false;
		}
		int i = 0;
		while (listeObjets[i] != null) {
			i++;
		}
		listeObjets[i] = tuile.objet;
		return true;
	}

	/**
	 * Ajoute la carte en paramètre à la main du joueur
	 *
	 * @param carte La carte à ajouter
	 * @return Succès de l'opération
	 */
	public boolean ajouterCarte(Carte carte) {
		/* Si la main est pleine, on ne peut pas ajouter d'objet
		dedans. */
		if (mainEstPleine()) {
			return false;
		}
		int i = 0;
		while (listeCartes[i] != null) {
			i++;
		}
		listeCartes[i] = carte;
		return true;
	}

	/**
	 * Vérifie si le sac du joueur (son attribut 'listeObjets') est plein.
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

	/**
	 * Vérifie si la main du joueur (son attribut 'listeCartes') est pleine.
	 *
	 * @return Le remplissage de la main
	 */
	public boolean mainEstPleine() {
		for (int i = 0; i < listeCartes.length; i++) {
			if (listeCartes[i] == null) {
				return false;
			}
		}
		return true;
	}

	public boolean tousObjetsRamasses() {
		return false;
	}

}
