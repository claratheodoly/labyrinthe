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
public class Pion {
	
	Joueur propriétaire;
	
	/**
	 * Crée un pio lié à un joueur
	 * 
	 * @param joueur Le propriétaire du pion
	 */
	Pion(Joueur joueur) {
		propriétaire = joueur;
	}

}
