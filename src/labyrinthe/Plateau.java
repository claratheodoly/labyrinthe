/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

import java.util.ArrayList;
import java.util.Random;

/**
 * Implémente les plateau et une grande partie de l'intelligence du jeu
 *
 * @author Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 */
public class Plateau {

	Tuile[][] tuiles;
	/*
	La tuile (0,0) se situe en bas à gauche du plateau.
	Le premier niveau de tableau représente la postion verticale, et le deuxième
	la position horizontale.
	 */
	Tuile tuileVolante;

	Plateau() {
		tuiles = new Tuile[7][7];
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
	 * Place la tuile volante
	 *
	 * @param nouvelleTuileVolante La tuile qui devient volante
	 * @return Succès de l'opération
	 */
	public boolean declarerTuileVolante(Tuile nouvelleTuileVolante) {
		if (tuileVolante != null) {
			return false;
		}
		tuileVolante = nouvelleTuileVolante;
		return true;
	}

	/**
	 * Détermine si un passage existe entre deux tuiles adjacentes
	 *
	 * @param x1 Position verticale de la première tuile
	 * @param y1 Position horizontale de la première tuile
	 * @param x2 Position verticale de la deuxième tuile
	 * @param y2 Position horizontale de la deuxième tuile
	 * @return Existance d'un passage entre les tuiles
	 */
	public boolean passageEntreTuilesAdjacentes(int x1, int y1, int x2, int y2) {
		/* Si les coordonnées sont valides */
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
		/* Si les tuiles sont sur la même colonne ou ligne */
		if (x1 == x2) {
			/* On vérifie si les tuiles sont adjacentes */
			if (Math.abs(y1 - y2) > 1) {
				return false;
			} else if (y1 - y2 >= 0) {
				return (tuiles[x1][y1].porteOuest
						&& tuiles[x2][y2].porteEst);
			} else {
				return (tuiles[x1][y1].porteEst
						&& tuiles[x2][y2].porteOuest);
			}
		} else if (y1 == y2) {
			/* On vérifie si les tuiles sont adjacentes */
			if (Math.abs(x1 - x2) > 1) {
				return false;
			} else if (x1 - x2 >= 0) {
				return (tuiles[x1][y1].porteNord
						&& tuiles[x2][y2].porteSud);
			} else {
				return (tuiles[x1][y1].porteSud
						&& tuiles[x2][y2].porteNord);
			}
		} else {
			return false;
		}
	}

	/**
	 * Détermine si il existe un chemin (de plusieurs tuiles si besoin) entre
	 * deux tuiles.
	 *
	 * @param x1            Position verticale de la première tuile
	 * @param y1            Position horizontale de la première tuile
	 * @param x2            Position verticale de la deuxième tuile
	 * @param y2            Position horizontale de la deuxième tuile
	 * @param tuilesConnues Tableau des tuiles connues (null pour un appel
	 *                      manuel)
	 * @return Existance du chemin
	 */
	public boolean cheminPossible(int x1, int y1, int x2, int y2, ArrayList<Tuile> tuilesConnues) {
		ArrayList<Tuile> tuilesCouloir;
		if (tuilesConnues == null) {
			tuilesCouloir = new ArrayList<>();
			tuilesCouloir.add(tuiles[x1][y1]);
		} else {
			tuilesCouloir = tuilesConnues;
		}
		ArrayList<ArrayList<Integer>> tuilesPart = tuilesAccessibles(x1, y1);
		ArrayList<Integer> listeVerif = new ArrayList<>();
		listeVerif.add(x2);
		listeVerif.add(y2);
		if (tuilesPart.contains(listeVerif)) {
			return true;
		} else if (!tuilesPart.isEmpty()) {
			for (ArrayList<Integer> coordsTuileListees : tuilesPart) {
				if (!tuilesCouloir.contains(tuiles[coordsTuileListees.get(0)][coordsTuileListees.get(1)])) {
					tuilesCouloir.add(tuiles[coordsTuileListees.get(0)][coordsTuileListees.get(1)]);
					if (cheminPossible(coordsTuileListees.get(0), coordsTuileListees.get(1), x2, y2, tuilesCouloir)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Donne la liste des tuiles accessibles depuis une tuile de coordonnées
	 * précisées
	 *
	 * @param x Position verticale de la tuile
	 * @param y Position horizontale de la tuile
	 * @return Liste des coordonnées des tuiles accessibles depuis la tuile
	 */
	public ArrayList<ArrayList<Integer>> tuilesAccessibles(int x, int y) {
		ArrayList<ArrayList<Integer>> tuilesAccessibles = new ArrayList<>();
		if (passageEntreTuilesAdjacentes(x, y, x + 1, y)) {
			ArrayList<Integer> listeInter = new ArrayList<>();
			listeInter.add(x + 1);
			listeInter.add(y);
			tuilesAccessibles.add(listeInter);
		}
		if (passageEntreTuilesAdjacentes(x, y, x - 1, y)) {
			ArrayList<Integer> listeInter = new ArrayList<>();
			listeInter.add(x - 1);
			listeInter.add(y);
			tuilesAccessibles.add(listeInter);
		}
		if (passageEntreTuilesAdjacentes(x, y, x, y + 1)) {
			ArrayList<Integer> listeInter = new ArrayList<>();
			listeInter.add(x);
			listeInter.add(y + 1);
			tuilesAccessibles.add(listeInter);
		}
		if (passageEntreTuilesAdjacentes(x, y, x, y - 1)) {
			ArrayList<Integer> listeInter = new ArrayList<>();
			listeInter.add(x);
			listeInter.add(y - 1);
			tuilesAccessibles.add(listeInter);
		}
		return tuilesAccessibles;
	}

	/**
	 * Déplace les tuiles d'une colonne dans la direction indiquée, en comblant
	 * l'espace laissé avec la tuile volante.
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
			temp = tuiles[0][num_col];
		} else {
			decalage = -1;
			temp = tuiles[6][num_col];
		}
		for (int i = 0; i < 7; i++) {
			int j;
			if (!versHaut) {
				j = 6 - i;
			} else {
				j = i;
			}
			if (i == 6) {
				/*
				Échange de la tuile volante et gestion des pions.
				Les pions qui étaient sur le tuile déplacée vont sur la nouvelle.
				La tuile volante n'a pas de pions.
				 */
				tuiles[j][num_col] = tuileVolante;
				tuiles[j][num_col].pionsPresents = new ArrayList<>(temp.pionsPresents);
				temp.pionsPresents.clear();
				tuileVolante = temp;
			} else {
				tuiles[j][num_col] = tuiles[j + decalage][num_col];
			}
		}
		return true;
	}

	/**
	 * Déplace les tuiles d'une ligne dans la direction indiquée, en comblant
	 * l'espace laissé avec la tuile volante.
	 *
	 * @param num_lig    Le numéro de la colonne
	 * @param versDroite Si le déplacement se fait vers la droite ou pas
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
			decalage = -1;
			temp = tuiles[num_lig][6];
		} else {
			decalage = 1;
			temp = tuiles[num_lig][0];
		}
		for (int i = 0; i < 7; i++) {
			int j;
			if (versDroite) {
				j = 6 - i;
			} else {
				j = i;
			}
			if (i == 6) {
				/*
				Échange de la tuile volante et gestion des pions.
				Les pions qui étaient sur le tuile déplacée vont sur la nouvelle.
				La tuile volante n'a pas de pions.
				 */
				tuiles[num_lig][j] = tuileVolante;
				tuiles[num_lig][j].pionsPresents = new ArrayList<>(temp.pionsPresents);
				temp.pionsPresents.clear();
				tuileVolante = temp;
			} else {
				tuiles[num_lig][j] = tuiles[num_lig][j + decalage];
			}
		}
		return true;
	}

	/**
	 * Cherche le pion du joueur dans la grille et retourne sa position
	 *
	 * @param proprietaireRecherche Le propriétaire du pion
	 * @return Les coordonnées du pion
	 */
	public int[] positionPion(Joueur proprietaireRecherche) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (tuiles[i][j].presencePion()) {
					if (tuiles[i][j].pionsPresents.contains(proprietaireRecherche.marqueur)) {
						return (new int[]{i, j});
					}
				}
			}
		}
		return null;
	}

	/**
	 * Mélange les tuiles du plateau en tirant au hasard des couples de
	 * coordonnées à échanger
	 *
	 * @return Succès de l'opération
	 */
	public boolean melangerTuiles() {
		int x1, y1, x2, y2;
		Random rnd = new Random();
		/* Échange de la tuile volante */
		Tuile tmp = tuileVolante;
		do {
			x1 = rnd.nextInt(6);
			y1 = rnd.nextInt(6);
		} while (tuileDansCoin(x1, y1));
		tuileVolante = tuiles[x1][y1];
		tuiles[x1][y1] = tmp;

		/* On mélange aléatoirement les tuiles du plateau */
		for (int i = 0; i < 30; i++) {
			do {
				x1 = rnd.nextInt(6);
				y1 = rnd.nextInt(6);
			} while (tuileDansCoin(x1, y1));
			do {
				x2 = rnd.nextInt(6);
				y2 = rnd.nextInt(6);
			} while (tuileDansCoin(x2, y2));
			if (!intervertirTuiles(x1, y1, x2, y2)) {
				return false;
			}
		}
		return true;
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

	/**
	 * Détermine si les coordonnées correspondent à un coin du plateau,
	 * c'est-à-dire à une tuile de départ
	 *
	 * @param x Coordonnée verticale
	 * @param y Coordonnée horizontale
	 * @return Si la tuile est dans un coin
	 */
	public boolean tuileDansCoin(int x, int y) {
		if (x > 6 || x < 0) {
			return false;
		}
		if (y > 6 || y < 0) {
			return false;
		}
		return ((x == 0 && y == 0) || (x == 0 && y == 0) || (x == 6 && y == 0) || (x == 6 && y == 6));
	}
}
