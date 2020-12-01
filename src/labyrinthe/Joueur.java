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
	String [] listeObjets;
	Carte [] listeCartes;
	int indexCarteRetournee;
	Pion marqueur;
	
	Joueur(String nom_joueur, int nombre_cartes) {
		nom = nom_joueur;
		listeObjets = new String [nombre_cartes];
		listeCartes = new Carte[nombre_cartes];
		indexCarteRetournee = 0;
		marqueur = new Pion(this);
	}
	
	public boolean rammaserObjet(Tuile tuile) {
		return false;
	}
	
	public boolean ajouterCarte(Carte carte) {
		return false;
	}
	
}
