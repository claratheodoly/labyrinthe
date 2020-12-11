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
	/*
	La tuile (0,0) se situe en bas à gauche du plateau.
	Le premier niveau de tableau représente la postion horizontale
	('x'), et le deuxième la position verticale ('y').
	 */
	Tuile tuileVolante;

	Plateau() {
		tuiles = new Tuile[7][7];
		tuileVolante = new Tuile("");
	}

	/**
	 * Détermine si un passage existe entre deux tuiles adjacentes
	 *
	 * @param x1 Position horizontale de la première tuile
	 * @param y1 Position verticale de la première tuile
	 * @param x2 Position horizontale de la deuxième tuile
	 * @param y2 Position verticale de la deuxième tuile
	 * @return Existance d'un passage entre les tuiles
	 */
	public boolean passageEntreTuilesAdjacentes(int x1, int y1, int x2, int y2) {
		/* Si les tuiles sont sur la même colonne ou ligne */
		if (x1 == x2) {
			/* On vérifie si les tuiles sont adjacentes */
			if (Math.abs(y1 - y2) > 1) {
				return false;
			} else if (y1 - y2 >= 0) {
				return (tuiles[x1][y1].porteSud
						&& tuiles[x2][y2].porteNord);
			} else {
				return (tuiles[x1][y1].porteNord
						&& tuiles[x2][y2].porteSud);
			}
		} else if (y1 == y2) {
			/* On vérifie si les tuiles sont adjacentes */
			if (Math.abs(x1 - x2) > 1) {
				return false;
			} else if (x1 - x2 >= 0) {
				return (tuiles[x1][y1].porteOuest
						&& tuiles[x2][y2].porteEst);
			} else {
				return (tuiles[x1][y1].porteEst
						&& tuiles[x2][y2].porteOuest);
			}
		} else {
			return false;
		}
	}

	public boolean cheminPossible(int x1, int y1, int x2, int y2) {
		return false;
	}

	public boolean deplacerColonne(int num_col, boolean versHaut) {
		return false;
	}

	public boolean deplacerLigne(int num_col, boolean versDroite) {
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

	/**
	 * Intervertit deux tuiles de coordonnées données
	 *
	 * @param x1 Position horizontale de la première tuile
	 * @param y1 Position verticale de la première tuile
	 * @param x2 Position horizontale de la deuxième tuile
	 * @param y2 Position verticale de la deuxième tuile
	 * @return Succès de l'opération
	 */
	public boolean intervertirTuiles(int x1, int y1, int x2, int y2) {
		if (x1 > 6 || x1 < 0) {
			return false;
		}
		if (y1 > 6 || y1 < 0) {
			return false;
		}
		if (x2 > 6 || x2 < 0) {
			return false;
		}
		if (y2 > 6 || y2 < 0) {
			return false;
		}
		Tuile temp = tuiles[x1][y1];
		tuiles[x1][y1] = tuiles[x2][y2];
		tuiles[x2][y2] = temp;
		return true;
	}

}
