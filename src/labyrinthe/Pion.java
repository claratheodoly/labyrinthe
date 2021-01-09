/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

/**
 * Le pion indique la position du joueur sur le plateau
 *
 * @author Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 */
public class Pion {

    Joueur propriétaire;
    String coloration;
    /**
     * Crée un pion lié à un joueur
     *
     * @param joueur Le propriétaire du pion
     */
    Pion(Joueur joueur) {
        propriétaire = joueur;
    }
}
