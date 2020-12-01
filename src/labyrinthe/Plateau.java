/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

/**
 * Implémente les plateau et une grande partie de l'intelligence du
 * jeu
 *
 * @author Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 */
public class Plateau {

	Tuile[][] tuiles;
	Tuile tuileVolante;

	Plateau() {
		tuiles = new Tuile[7][7];
		tuileVolante = new Tuile("");
	}

	public boolean pontEntreTuiles(int x1, int y1, int x2, int y2) {
		return false;
	}

	public boolean cheminPossible(int x1, int y1, int x2, int y2) {
		return false;
	}

	public boolean deplacerColonne(int num_col, boolean dir) {
		return false;
	}

	public boolean deplacerLigne(int num_col, boolean dir) {
		return false;
	}

	public boolean placerTuile(int x, int y) {
		return false;
	}

	public boolean deplacerPion(int num_col, boolean dir) {
		return false;
	}

	public int[] positionPion(Joueur proprietaire) {
		return new int[0];
	}

	public boolean intervertirTuiles(int x1, int y1, int x2, int y2) {
		return false;
	}

}
