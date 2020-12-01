/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

import java.util.Scanner;

/**
 * Classe principale, qui déclenche les autres
 *
 * @author Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 */
public class main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		int nb_joueurs;

		Scanner sc = new Scanner(System.in);
		System.out.println("Combien de joueurs participent ? ");
		nb_joueurs = sc.nextInt();

		Partie partie = new Partie(nb_joueurs);
		partie.initialiserPartie();
		partie.debuterPartie();

	}

}
