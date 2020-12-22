/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

import java.util.Scanner;

/**
 * Implémente la partie, son initialisation et son déroulement
 *
 * @author Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 */
public class Partie {

	int nombreJoueurs;
	Plateau plateauJeu;
	Joueur[] listeJoueurs;
	Joueur joueurCourant;
	Carte[] listeCartes = new Carte[24];
	Tuile[] listeTuiles = new Tuile[50];

	Partie(int nbjoueurs) {
		nombreJoueurs = nbjoueurs;
		plateauJeu = new Plateau();
		listeJoueurs = new Joueur[nbjoueurs];
	}

	/**
	 * Crée le bon nombre de joueurs Demande le nom à donner et
	 * attribue le bon nombre de cartes
	 *
	 * @return Succès de la création des joueurs
	 */
	public boolean creerJoueurs() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < nombreJoueurs; i++) {
			if (listeJoueurs[i] != null) {
				System.err.println("Le joueur " + (i + 1) + " existe déjà");
				return false;
			}
			System.out.print("Entrez le nom du joueur " + (i + 1) + " : ");
			String nomJoueur = sc.nextLine();
			listeJoueurs[i] = new Joueur(nomJoueur, 24 / nombreJoueurs);
		}
		return true;
	}

	public void initialiserPartie() {
		creerJoueurs();
		attribuerCouleurs();
		distribuerCartes();
	}

	public void debuterPartie() {

	}

	public void joueurSuivant() {

	}

	public void tourDeJeu() {

	}

	public boolean placerTuiles() {
		return false;
	}
	
	public boolean attribuerCouleurs() {
		return false;
	}

	public boolean distribuerCartes() {
		return false;
	}

}
