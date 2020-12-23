/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	Carte[] listeCartes;
	Tuile[] listeTuiles;

	Partie(int nbjoueurs) {
		nombreJoueurs = nbjoueurs;
		plateauJeu = new Plateau();
		listeJoueurs = new Joueur[nbjoueurs];
		listeCartes = new Carte[24];
		listeTuiles = new Tuile[50];
	}

	/**
	 * Crée le bon nombre de joueurs Demande le nom à donner et attribue le bon
	 * nombre de cartes
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
			creerJoueur(i, nomJoueur);
		}
		return true;
	}

	/**
	 * Crée un joueur de la liste à parir de son numéro et de son nom.
	 *
	 * @param indice la position du joueur
	 * @param nom    le nom du joueur
	 * @return Succès de l'opération
	 */
	public boolean creerJoueur(int indice, String nom) {
		if (indice >= nombreJoueurs) {
			return false;
		}
		if (listeJoueurs[indice] != null) {
			return false;
		}
		listeJoueurs[indice] = new Joueur(nom, 24 / nombreJoueurs);
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

	/**
	 * Crée la liste des tuiles à partir du fichier 'listeTuilesOrdonnees.txt',
	 * et place les tuiles de la liste sur le plateau.
	 *
	 * @return Succès de l'opération
	 */
	public boolean placerTuiles() {
		/* Création de la liste des tuiles */
		Path cheminFichierListe = Path.of("src/labyrinthe/listeTuilesOrdonee.txt");
		List<String> listeTypes;
		if (Files.notExists(cheminFichierListe)) {
			System.err.println("Le fichier listeTuilesOrdonee.txt n'existe pas");
			return false;
		}
		if (!Files.isReadable(cheminFichierListe)) {
			System.err.println("Impossible de lire le fichier listeTuilesOrdonee.txt");
			return false;
		}
		/* Ajout d'un try-catch pour gérer une exception */
		try {
			listeTypes = Files.readAllLines​(cheminFichierListe);
		} catch (IOException ex) {
			Logger.getLogger(Partie.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
		if (listeTypes.size() != listeTuiles.length) {
			return false;
		}
		for (int i = 0; i < listeTypes.size(); i++) {
			listeTuiles[i] = new Tuile(listeTypes.get(i));
		}

		/* Placemnt des tuiles sur le plateau */
		int indiceListe;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				indiceListe = 7 * i + j;
				if (!plateauJeu.placerTuile(i, j, listeTuiles[indiceListe])) {
					return false;
				}
			}
		}
		return plateauJeu.declarerTuileVolante(listeTuiles[49]);
	}

	public boolean attribuerCouleurs() {
		return false;
	}

	public boolean distribuerCartes() {
		return false;
	}

}
