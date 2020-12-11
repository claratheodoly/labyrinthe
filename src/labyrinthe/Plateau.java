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

	/**
	 *
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public boolean cheminPossible(int x1, int y1, int x2, int y2) {
		// TODO
		return false;
	}

	/**
	 * Déplace les tuiles d'une colonne dans la direction indiquée, en
	 * comblant l'espace laissé avec la tuile volante.
	 *
	 * @param num_col  Le numéro de la colonne
	 * @param versHaut Si le déplacement se fait vers le haut ou pas
	 * @return Succès de l'opération
	 */
	public boolean deplacerColonne(int num_col, boolean versHaut) {
		/* Vérification que la colonne est valide */
		if (num_col < 0 || num_col > 6) {
			return false;
		}
		Tuile temp;
		int decalage;
		if (versHaut) {
			decalage = 1;
			/* On échange la tuile volante avec la tuile qui sort */
			temp = tuiles[num_col][6];
			tuiles[num_col][6] = tuileVolante;
			tuileVolante = temp;
		} else {
			/*
			Décaler de 6 dans un sens revient à décaler de 1 dans
			l'autre si on revient au début. Ceci permet d'éviter le
			bug du modulo en Java si le dividende est négatif.
			 */
			decalage = 6;
			/* On échange la tuile volante avec la tuile qui sort */
			temp = tuiles[num_col][0];
			tuiles[num_col][0] = tuileVolante;
			tuileVolante = temp;
		}
		for (int i = 0; i < 7; i++) {
			/*
			On utilise le modulo pour faire un cycle avec les tuiles
			 */
			int i_pro = (i + decalage) % 7;
			temp = tuiles[num_col][i_pro];
			tuiles[num_col][i_pro] = tuiles[num_col][i];
			tuiles[num_col][i] = temp;
		}
		return true;
	}

	/**
	 * Déplace les tuiles d'une ligne dans la direction indiquée, en
	 * comblant l'espace laissé avec la tuile volante.
	 *
	 * @param num_lig    Le numéro de la colonne
	 * @param versDroite Si le déplacement se fait vers la droite ou
	 *                   pas
	 * @return Succès de l'opération
	 */
	public boolean deplacerLigne(int num_lig, boolean versDroite) {
		/* Vérification que la ligne est valide */
		if (num_lig < 0 || num_lig > 6) {
			return false;
		}
		Tuile temp;
		int decalage;
		if (versDroite) {
			decalage = 1;
			/* On échange la tuile volante avec la tuile qui sort */
			temp = tuiles[6][num_lig];
			tuiles[6][num_lig] = tuileVolante;
			tuileVolante = temp;
		} else {
			/*
			Décaler de 6 dans un sens revient à décaler de 1 dans
			l'autre si on revient au début. Ceci permet d'éviter le
			bug du modulo en Java si le dividende est négatif.
			 */
			decalage = 6;
			/* On échange la tuile volante avec la tuile qui sort */
			temp = tuiles[0][num_lig];
			tuiles[0][num_lig] = tuileVolante;
			tuileVolante = temp;
		}
		for (int i = 0; i < 7; i++) {
			/*
			On utilise le modulo pour faire un cycle avec les tuiles
			 */
			int i_pro = (i + decalage) % 7;
			temp = tuiles[i_pro][num_lig];
			tuiles[i_pro][num_lig] = tuiles[i][num_lig];
			tuiles[i][num_lig] = temp;
		}
		return true;
	}

	/**
	 * Place une tuile aux coordonnées indiquées si la place est vide
	 *
	 * @param x            La position horizontale de la tuile
	 * @param y            La position verticale de la tuile
	 * @param tuileAPlacer La tuile à placer
	 * @return Succès de l'opération
	 */
	public boolean placerTuile(int x, int y, Tuile tuileAPlacer) {
		if (tuiles[x][y] != null) {
			return false;
		} else {
			tuiles[x][y] = tuileAPlacer;
			return true;
		}
	}

	/**
	 *
	 * @param num_col
	 * @param dir
	 * @return
	 */
	public boolean deplacerPion(int num_col, boolean dir) {
		return false;
	}

	/**
	 * Retourne la position du pion du joueur
	 *
	 * @param proprietaire Le propriétaire du pion
	 * @return Les coordonnées du pion
	 */
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
