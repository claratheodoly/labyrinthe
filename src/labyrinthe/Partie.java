/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

/**
 * Implémente la partie, son initialisation et son déroulement
 *
 * @author Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 */
public class Partie {
	
	int nombreJoueurs;
	Plateau plateauJeu;
	Joueur [] listeJoueurs;
	Joueur joueurCourant;
	Carte [] listeCartes = new Carte[24];
	Tuile [] listeTuiles = new Tuile[50];
	
	Partie(int nbjoueurs) {
		nombreJoueurs = nbjoueurs;
		plateauJeu = new Plateau();
		listeJoueurs = new Joueur[nbjoueurs];
	}
	
	public void initialiserPartie() {
		
	}
	
	public void debuterPartie() {
		
	}
	
	public void joueurSuivant() {
		
	}
	
	public void tourDeJeu() {
		
	}
	
	public boolean attribuerCouleurs() {
		return false;
	}
	
	public boolean distribuerCartes() {
		return false;
	}

}
