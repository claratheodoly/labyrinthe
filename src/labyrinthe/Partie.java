/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
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
    int joueurCourant = 0;
    Tuile[] listeTuiles;

    Partie(int nbjoueurs) {
        nombreJoueurs = nbjoueurs;
        plateauJeu = new Plateau();
        listeJoueurs = new Joueur[nbjoueurs];
        listeTuiles = new Tuile[50];
    }

    /**
     * Crée le bon nombre de joueurs. Demande le nom à donner et attribue le bon
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
     * @param nom le nom du joueur
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
        placerTuiles();
    }

    public void initialiserPartieGraphique() {
        attribuerCouleurs();
        distribuerCartes();
        placerTuiles();
        placerPionsDebut();
    }

    public void placerPionsDebut() {
        for (int i = 0; i < listeJoueurs.length; i++) {
            switch (i) {
                case 0:
                    plateauJeu.tuiles[0][0].pionsPresents.add(listeJoueurs[0].marqueur);
                    break;
                case 1:
                    plateauJeu.tuiles[0][6].pionsPresents.add(listeJoueurs[1].marqueur);
                    break;
                case 2:
                    plateauJeu.tuiles[6][6].pionsPresents.add(listeJoueurs[2].marqueur);
                    break;
                case 3:
                    plateauJeu.tuiles[6][0].pionsPresents.add(listeJoueurs[3].marqueur);
                    break;
            }
        }
    }

    public void debuterPartie() {
        Random rnd = new Random();
        boolean finDePartie = false;

        initialiserPartie();

        joueurCourant = rnd.nextInt(nombreJoueurs);

        System.out.println("Le joueur " + listeJoueurs[joueurCourant] + " commence la partie !");
        do {
            finDePartie = tourDeJeu(joueurCourant);
            joueurSuivant();
        } while (!finDePartie);
    }

    /**
     * Incrémente l'indice correspondant au joueur courant, ce faisant passant
     * au joueur suivant.
     */
    public void joueurSuivant() {
        joueurCourant = ++joueurCourant % nombreJoueurs;
    }

    public boolean tourDeJeu(int joueur) {
        boolean partieGagnee = false;
        // TODO
        return partieGagnee;
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
            return false;
        }
        if (listeTypes.size() != listeTuiles.length) {
            return false;
        }

        /* On remplit le tableau listeTuiles à partir de la liste listeTypes */
        for (int i = 0; i < listeTypes.size(); i++) {
            String[] subString = listeTypes.get(i).split(" ");
            listeTuiles[i] = new Tuile(subString[0]);
            listeTuiles[i].porteNord = Boolean.parseBoolean​(subString[1]);
            listeTuiles[i].porteEst = Boolean.parseBoolean​(subString[2]);
            listeTuiles[i].porteSud = Boolean.parseBoolean​(subString[3]);
            listeTuiles[i].porteOuest = Boolean.parseBoolean​(subString[4]);
        }

        /* Placement des tuiles sur le plateau */
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

    /**
     * Attribue des couleurs aux joueurs, de façon non aléatoire.
     *
     * @return Succès de l'opération
     */
    public boolean attribuerCouleurs() {
        if (nombreJoueurs > 4 || nombreJoueurs < 1) {
            return false;
        }
        switch (nombreJoueurs) {
            case 4:
                listeJoueurs[3].attribuerCouleur("jaune");
            case 3:
                listeJoueurs[2].attribuerCouleur("rouge");
            case 2:
                listeJoueurs[1].attribuerCouleur("vert");
            case 1:
                listeJoueurs[0].attribuerCouleur("bleu");
        }
        return true;
    }

    /**
     * Crée la liste des cartes, les mélange et les distribue.
     *
     * @return Succès de l'opération
     */
    public boolean distribuerCartes() {
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
        try {
            listeTypes = Files.readAllLines​(cheminFichierListe);
        } catch (IOException ex) {
            return false;
        }

        /* On supprime de la liste listeTypes ce qui n'est pas un objet de quête */
        Iterator iter = listeTypes.iterator();
        while (iter.hasNext()) {
            String[] elem = ((String) iter.next()).split(" ");
            String subelem = elem[0];
            /* Comparaison avec les chaînes à ne pas garder */
            if (subelem.equals("droit") || subelem.equals("coin") || subelem.equals("departB") || subelem.equals("departV") || subelem.equals("departJ") || subelem.equals("departR")) {
                iter.remove();
            }
        }
        if (listeTypes.size() != 24) {
            return false;
        }

        /* On mélange la liste avec la méthode de Collections */
        Collections.shuffle(listeTypes);

        /* Distribution des cartes */
        int j = 0;
        int nbCartesPJ = 24 / nombreJoueurs;
        for (int i = 0; i < listeTypes.size(); i++) {
            if (i % nbCartesPJ == 0 && i != 0) {
                j++;
            }
            listeJoueurs[j].listeCartes[i % nbCartesPJ] = new Carte(listeTypes.get(i).split(" ")[0]);
        }

        return true;
    }
}
