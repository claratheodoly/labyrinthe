/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

import java.util.Scanner;

/**
 * Classe principale, qui déclenche les autres, sera remplacée dans le
 * futur.
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
		do {
			System.out.print("Combien de joueurs participent ? ");
			nb_joueurs = sc.nextInt();
			if (nb_joueurs > 4 || nb_joueurs < 1) {
				System.out.println("Le nombre de joueurs doit être "
						+ "compris entre 1 et 4 (inclus).");
			}
		} while (nb_joueurs > 4 || nb_joueurs < 1);

		Partie partie = new Partie(nb_joueurs);
		partie.initialiserPartie();
		partie.debuterPartie();

	}

}
