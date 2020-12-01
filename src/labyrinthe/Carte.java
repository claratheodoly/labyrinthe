/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

/**
 * Implémente la classe Carte, qui donne un objectif aux joueurs
 *
 * @author Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 */
public class Carte {

	String nomObjet;

	/**
	 * Crée une carte avec un objet à récupérer dessus.
	 *
	 * @param nom Le nom de l'objet sur la carte.
	 */
	Carte(String nom) {
		nomObjet = nom;
	}

}
