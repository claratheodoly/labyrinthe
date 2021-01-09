/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

import java.util.Arrays;

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

	public void attribuerCouleur(String couleurAttribuee) {
		couleur = couleurAttribuee;
		marqueur.coloration = couleurAttribuee;
	}

	/**
	 * Détermine quoi faire quand le pion du joueur arrive sur une nouvelle
	 * tuile
	 *
	 * @param nouvelleTuile La nouvelle tuile sur laquelle le pion du joueur est
	 */
	public void nouvellePosition(Tuile nouvelleTuile) {
		if (nouvelleTuile.presenceObjet()) {
			if (listeCartes[indexCarteRetournee].nomObjet.equals(nouvelleTuile.type)) {
				ramasserObjet(nouvelleTuile);
				indexCarteRetournee++;
			}
		}
	}

	/**
	 * Ajoute l'objet présent sur la tuile à la liste des objets possédés par le
	 * joueur.
	 *
	 * @param tuile La tuile sur laquelle le joueur est
	 * @return Succès de l'opération
	 */
	public boolean ramasserObjet(Tuile tuile) {
		/* Si l'inventaire est plein, on ne peut pas ajouter d'objet
		dedans. */
		if (sacEstPlein()) {
			return false;
		}
		/* On ne peut pas ajouter d'objet qui n'existe pas */
		if (!tuile.presenceObjet()) {
			return false;
		}
		listeObjets[indexCarteRetournee] = tuile.type;
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
	 * Détermine si le joueur a collecté tous ses objets de quête
	 *
	 * @return Si tous les objets ont été ramassés
	 */
	public boolean tousObjetsRamasses() {
		if (!sacEstPlein()) {
			return false;
		}
		if (listeObjets.length < listeCartes.length) {
			return false;
		}
		for (Carte carte : listeCartes) {
			/*
			On retourne faux si l'objet d'une des cartes recherchées n'est pas
		contenu dans listeObjets
			 */
			if (!Arrays.asList(listeObjets).contains(carte.nomObjet)) {
				return false;
			}
		}
		return true;
	}

}
