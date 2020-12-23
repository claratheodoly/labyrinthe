/*
 * Mini projet de CPO (2A), 2020
 * Par  Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 * Implémentation de jeu « Labyrinthe »
 */
package labyrinthe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Lucas DELMOTTE, Clara THEODOLY et Émile ROYER
 */
public class FenetreDeJeu extends javax.swing.JFrame {

	// variables utilisées pour le chrono
	int nbSecondes = 0;
	Timer monChrono;
	Partie partieJeu;

	// insertion de l'image pour notre chrono
	ImageIcon img_iconetimer = new javax.swing.ImageIcon(getClass().getResource("/images/timer.png"));
	// insertion de l'image pour les boutons de chaques cotés du plateau
	ImageIcon img_fleched = new javax.swing.ImageIcon(getClass().getResource("/images/fleched.png"));
	ImageIcon img_flecheg = new javax.swing.ImageIcon(getClass().getResource("/images/flecheg.png"));
	ImageIcon img_flecheh = new javax.swing.ImageIcon(getClass().getResource("/images/flecheh.png"));
	ImageIcon img_flecheb = new javax.swing.ImageIcon(getClass().getResource("/images/flecheb.png"));

	public FenetreDeJeu() {
		initComponents();

		// création du chrono
		ActionListener tache_recurrente = new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				nbSecondes++; // incrémentation du nombres de seconde
				texte_temps.setText(nbSecondes + "");
			}
		;
		};

        /* Instanciation du timer */
		monChrono = new Timer(1000, tache_recurrente);
		iconeTimer.setIcon(img_iconetimer); // création de la petite image avec le chrono

		/* ajout des images aux divers boutons */
		jouer_versdroite_ligne2.setIcon(img_fleched);
		jouer_versdroite_ligne4.setIcon(img_fleched);
		jouer_versdroite_ligne6.setIcon(img_fleched);

		jouer_versgauche_ligne2.setIcon(img_flecheg);
		jouer_versgauche_ligne4.setIcon(img_flecheg);
		jouer_versgauche_ligne6.setIcon(img_flecheg);

		jouer_versbas_col2.setIcon(img_flecheb);
		jouer_versbas_col4.setIcon(img_flecheb);
		jouer_versbas_col6.setIcon(img_flecheb);

		jouer_vershaut_col2.setIcon(img_flecheh);
		jouer_vershaut_col4.setIcon(img_flecheh);
		jouer_vershaut_col6.setIcon(img_flecheh);

		Infojeu.setVisible(false);
		panneauGrille.setVisible(true);
		panel_tuilevolante.setVisible(false);
		panel_joueur.setVisible(false);
		panel_chrono.setVisible(false);

		/* Dialogue modal du nombre de joueurs */
		jLabel22.setVisible(false);
		nom_joueur2_dia.setVisible(false);
		jLabel23.setVisible(false);
		nom_joueur3_dia.setVisible(false);
		jLabel20.setVisible(false);
		nom_joueur4_dia.setVisible(false);

		/* On  affiche le panneau de création des joueurs */
		afficherDialogueCreationJoueurs();

		/*// TODO à enlever quand fonctionnel
		// Exemple le temps d'ajouter le reste de la fonctionnalité
		panneauGrille.add(new TuileGraphique(new Tuile("departB")));
		panneauGrille.add(new TuileGraphique(new Tuile("lezard")));
		panneauGrille.add(new TuileGraphique(new Tuile("heaume")));
		panneauGrille.add(new TuileGraphique(new Tuile("gobelin")));
		panneauGrille.add(new TuileGraphique(new Tuile("chandelier")));
		panneauGrille.add(new TuileGraphique(new Tuile("coin")));
		panneauGrille.add(new TuileGraphique(new Tuile("departV")));
		panneauGrille.add(new TuileGraphique(new Tuile("coin")));
		panneauGrille.add(new TuileGraphique(new Tuile("fantome")));
		panneauGrille.add(new TuileGraphique(new Tuile("droit")));
		panneauGrille.add(new TuileGraphique(new Tuile("droit")));
		panneauGrille.add(new TuileGraphique(new Tuile("araignee")));
		panneauGrille.add(new TuileGraphique(new Tuile("chouette")));
		panneauGrille.add(new TuileGraphique(new Tuile("droit")));
		panneauGrille.add(new TuileGraphique(new Tuile("epee")));
		panneauGrille.add(new TuileGraphique(new Tuile("droit")));
		panneauGrille.add(new TuileGraphique(new Tuile("saphir")));
		panneauGrille.add(new TuileGraphique(new Tuile("droit")));
		panneauGrille.add(new TuileGraphique(new Tuile("tresor")));
		panneauGrille.add(new TuileGraphique(new Tuile("coin")));
		panneauGrille.add(new TuileGraphique(new Tuile("bague")));
		panneauGrille.add(new TuileGraphique(new Tuile("coin")));
		panneauGrille.add(new TuileGraphique(new Tuile("scarabee")));
		panneauGrille.add(new TuileGraphique(new Tuile("droit")));
		panneauGrille.add(new TuileGraphique(new Tuile("rat")));
		panneauGrille.add(new TuileGraphique(new Tuile("papillon")));
		panneauGrille.add(new TuileGraphique(new Tuile("droit")));
		panneauGrille.add(new TuileGraphique(new Tuile("fee")));
		panneauGrille.add(new TuileGraphique(new Tuile("crane")));
		panneauGrille.add(new TuileGraphique(new Tuile("dragon")));
		panneauGrille.add(new TuileGraphique(new Tuile("cle")));
		panneauGrille.add(new TuileGraphique(new Tuile("coin")));
		panneauGrille.add(new TuileGraphique(new Tuile("couronne")));
		panneauGrille.add(new TuileGraphique(new Tuile("coin")));
		panneauGrille.add(new TuileGraphique(new Tuile("carte")));
		panneauGrille.add(new TuileGraphique(new Tuile("coin")));
		panneauGrille.add(new TuileGraphique(new Tuile("chauvesouris")));
		panneauGrille.add(new TuileGraphique(new Tuile("droit")));
		panneauGrille.add(new TuileGraphique(new Tuile("coin")));
		panneauGrille.add(new TuileGraphique(new Tuile("coin")));
		panneauGrille.add(new TuileGraphique(new Tuile("droit")));
		panneauGrille.add(new TuileGraphique(new Tuile("fantome")));
		panneauGrille.add(new TuileGraphique(new Tuile("departJ")));
		panneauGrille.add(new TuileGraphique(new Tuile("droit")));
		panneauGrille.add(new TuileGraphique(new Tuile("bourse")));
		panneauGrille.add(new TuileGraphique(new Tuile("coin")));
		panneauGrille.add(new TuileGraphique(new Tuile("livre")));
		panneauGrille.add(new TuileGraphique(new Tuile("droit")));
		panneauGrille.add(new TuileGraphique(new Tuile("departR")));*/
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        dialogueJoueurs = new javax.swing.JDialog();
        nbJoueurs_dia = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        nom_joueur4_dia = new javax.swing.JTextField();
        nom_joueur1_dia = new javax.swing.JTextField();
        nom_joueur2_dia = new javax.swing.JTextField();
        nom_joueur3_dia = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        lbl_texteNbJoueurs = new javax.swing.JLabel();
        panneauGrille = new javax.swing.JPanel();
        Infojeu = new javax.swing.JPanel();
        panel_tuilevolante = new javax.swing.JPanel();
        btn_tournerTuileVolante = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panel_joueur = new javax.swing.JPanel();
        lbl_nomJCourant = new javax.swing.JLabel();
        lbl_objectifCourantJCourant = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_objectifRestantsJCourant = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panel_chrono = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        texte_temps = new javax.swing.JLabel();
        iconeTimer = new javax.swing.JLabel();
        jouer_versbas_col6 = new javax.swing.JButton();
        jouer_vershaut_col2 = new javax.swing.JButton();
        jouer_vershaut_col4 = new javax.swing.JButton();
        jouer_vershaut_col6 = new javax.swing.JButton();
        jouer_versbas_col2 = new javax.swing.JButton();
        jouer_versbas_col4 = new javax.swing.JButton();
        jouer_versgauche_ligne6 = new javax.swing.JButton();
        jouer_versdroite_ligne6 = new javax.swing.JButton();
        jouer_versdroite_ligne4 = new javax.swing.JButton();
        jouer_versdroite_ligne2 = new javax.swing.JButton();
        jouer_versgauche_ligne2 = new javax.swing.JButton();
        jouer_versgauche_ligne4 = new javax.swing.JButton();

        jTextField2.setText("jTextField1");

        dialogueJoueurs.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogueJoueurs.setTitle("Création des joueurs");
        dialogueJoueurs.setMinimumSize(new java.awt.Dimension(500, 500));
        dialogueJoueurs.setModal(true);
        dialogueJoueurs.setSize(new java.awt.Dimension(500, 500));
        dialogueJoueurs.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nbJoueurs_dia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));
        nbJoueurs_dia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nbJoueurs_diaStateChanged(evt);
            }
        });
        dialogueJoueurs.getContentPane().add(nbJoueurs_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 60, -1));

        jLabel19.setText("Combien de personnes jouent ?");
        dialogueJoueurs.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel20.setText("Nom du joueur 4 :");
        dialogueJoueurs.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 130, -1));

        jLabel21.setText("Nom du joueur 1 :");
        dialogueJoueurs.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 130, -1));

        jLabel22.setText("Nom du joueur 2 :");
        dialogueJoueurs.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 130, -1));

        jLabel23.setText("Nom du joueur 3 :");
        dialogueJoueurs.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 130, -1));
        dialogueJoueurs.getContentPane().add(nom_joueur4_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 120, -1));
        dialogueJoueurs.getContentPane().add(nom_joueur1_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 120, -1));
        dialogueJoueurs.getContentPane().add(nom_joueur2_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 120, -1));
        dialogueJoueurs.getContentPane().add(nom_joueur3_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 120, -1));

        btn_start.setText("Démarrer la partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        dialogueJoueurs.getContentPane().add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, -1));

        lbl_texteNbJoueurs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_texteNbJoueurs.setText("1 joueur jouera");
        dialogueJoueurs.getContentPane().add(lbl_texteNbJoueurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Labyrinthe");
        setMinimumSize(new java.awt.Dimension(1170, 715));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneauGrille.setBackground(new java.awt.Color(231, 193, 127));
        panneauGrille.setLayout(new java.awt.GridLayout(7, 7));
        getContentPane().add(panneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 567, 567));

        Infojeu.setBackground(new java.awt.Color(204, 204, 204));
        Infojeu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Infojeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 210, 330));

        panel_tuilevolante.setBackground(new java.awt.Color(204, 204, 204));
        panel_tuilevolante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_tournerTuileVolante.setText("Tourner la tuile");
        btn_tournerTuileVolante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tournerTuileVolanteActionPerformed(evt);
            }
        });
        panel_tuilevolante.add(btn_tournerTuileVolante, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 140, 30));

        jLabel16.setText("Cliquez sur le bouton de rotation");
        panel_tuilevolante.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 30));

        jLabel17.setText("pour faire pivoter la tuile de 90°");
        panel_tuilevolante.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        getContentPane().add(panel_tuilevolante, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 210, 210));

        panel_joueur.setBackground(new java.awt.Color(255, 255, 255));
        panel_joueur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nomJCourant.setText("Jcourant");
        panel_joueur.add(lbl_nomJCourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        lbl_objectifCourantJCourant.setBackground(new java.awt.Color(102, 102, 255));
        lbl_objectifCourantJCourant.setText("jLabel1");
        lbl_objectifCourantJCourant.setMaximumSize(new java.awt.Dimension(30, 30));
        lbl_objectifCourantJCourant.setMinimumSize(new java.awt.Dimension(30, 30));
        lbl_objectifCourantJCourant.setPreferredSize(new java.awt.Dimension(30, 30));
        panel_joueur.add(lbl_objectifCourantJCourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 81, 81));

        jLabel2.setText("Il vous reste encore");
        panel_joueur.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 120, -1));

        lbl_objectifRestantsJCourant.setText("objectif_restants");
        panel_joueur.add(lbl_objectifRestantsJCourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 120, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        panel_joueur.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 140, 10));

        jLabel3.setText("C'est le tour de  ");
        panel_joueur.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jButton1.setText("Commencer le tour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_joueur.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 170, -1));

        jButton2.setText("Terminer le tour");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel_joueur.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 170, -1));

        jLabel1.setText("Votre objectif :");
        panel_joueur.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        getContentPane().add(panel_joueur, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 250, 330));

        panel_chrono.setBackground(new java.awt.Color(204, 204, 204));
        panel_chrono.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setText("temps écoulé");
        panel_chrono.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 20));

        texte_temps.setText("0");
        panel_chrono.add(texte_temps, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 30, -1));
        panel_chrono.add(iconeTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 36, 40));

        getContentPane().add(panel_chrono, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 410, 250, 210));

        jouer_versbas_col6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouer_versbas_col6ActionPerformed(evt);
            }
        });
        getContentPane().add(jouer_versbas_col6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 30, 30));

        jouer_vershaut_col2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouer_vershaut_col2ActionPerformed(evt);
            }
        });
        getContentPane().add(jouer_vershaut_col2, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 630, 30, 30));

        jouer_vershaut_col4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouer_vershaut_col4ActionPerformed(evt);
            }
        });
        getContentPane().add(jouer_vershaut_col4, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 630, 30, 30));

        jouer_vershaut_col6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouer_vershaut_col6ActionPerformed(evt);
            }
        });
        getContentPane().add(jouer_vershaut_col6, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 630, 30, 30));

        jouer_versbas_col2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouer_versbas_col2ActionPerformed(evt);
            }
        });
        getContentPane().add(jouer_versbas_col2, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 10, 30, 30));

        jouer_versbas_col4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouer_versbas_col4ActionPerformed(evt);
            }
        });
        getContentPane().add(jouer_versbas_col4, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 10, 30, 30));

        jouer_versgauche_ligne6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouer_versgauche_ligne6ActionPerformed(evt);
            }
        });
        getContentPane().add(jouer_versgauche_ligne6, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 480, 30, 30));

        jouer_versdroite_ligne6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouer_versdroite_ligne6ActionPerformed(evt);
            }
        });
        getContentPane().add(jouer_versdroite_ligne6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 30, 30));

        jouer_versdroite_ligne4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouer_versdroite_ligne4ActionPerformed(evt);
            }
        });
        getContentPane().add(jouer_versdroite_ligne4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 318, 30, 30));

        jouer_versdroite_ligne2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouer_versdroite_ligne2ActionPerformed(evt);
            }
        });
        getContentPane().add(jouer_versdroite_ligne2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 156, 30, 30));

        jouer_versgauche_ligne2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouer_versgauche_ligne2ActionPerformed(evt);
            }
        });
        getContentPane().add(jouer_versgauche_ligne2, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 156, 30, 30));

        jouer_versgauche_ligne4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jouer_versgauche_ligne4ActionPerformed(evt);
            }
        });
        getContentPane().add(jouer_versgauche_ligne4, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 318, 30, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_tournerTuileVolanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tournerTuileVolanteActionPerformed
		partieJeu.plateauJeu.tuileVolante.tournerTuile(90);
		actualiserAffichage();
    }//GEN-LAST:event_btn_tournerTuileVolanteActionPerformed

    private void jouer_versbas_col6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versbas_col6ActionPerformed
		partieJeu.plateauJeu.deplacerColonne(6, false);
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versbas_col6ActionPerformed

    private void jouer_vershaut_col2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_vershaut_col2ActionPerformed
		partieJeu.plateauJeu.deplacerColonne(2, true);
		actualiserAffichage();
    }//GEN-LAST:event_jouer_vershaut_col2ActionPerformed

    private void jouer_vershaut_col4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_vershaut_col4ActionPerformed
		partieJeu.plateauJeu.deplacerColonne(4, true);
		actualiserAffichage();
    }//GEN-LAST:event_jouer_vershaut_col4ActionPerformed

    private void jouer_vershaut_col6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_vershaut_col6ActionPerformed
		partieJeu.plateauJeu.deplacerColonne(6, true);
		actualiserAffichage();
    }//GEN-LAST:event_jouer_vershaut_col6ActionPerformed

    private void jouer_versbas_col2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versbas_col2ActionPerformed
		partieJeu.plateauJeu.deplacerColonne(2, false);
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versbas_col2ActionPerformed

    private void jouer_versbas_col4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versbas_col4ActionPerformed
		partieJeu.plateauJeu.deplacerColonne(4, false);
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versbas_col4ActionPerformed

    private void jouer_versgauche_ligne6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versgauche_ligne6ActionPerformed
		partieJeu.plateauJeu.deplacerLigne(6, false);
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versgauche_ligne6ActionPerformed

    private void jouer_versdroite_ligne6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versdroite_ligne6ActionPerformed
		partieJeu.plateauJeu.deplacerLigne(6, true);
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versdroite_ligne6ActionPerformed

    private void jouer_versdroite_ligne4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versdroite_ligne4ActionPerformed
		partieJeu.plateauJeu.deplacerLigne(4, true);
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versdroite_ligne4ActionPerformed

    private void jouer_versdroite_ligne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versdroite_ligne2ActionPerformed
		partieJeu.plateauJeu.deplacerLigne(2, true);
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versdroite_ligne2ActionPerformed

    private void jouer_versgauche_ligne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versgauche_ligne2ActionPerformed
		partieJeu.plateauJeu.deplacerLigne(2, false);
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versgauche_ligne2ActionPerformed

    private void jouer_versgauche_ligne4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versgauche_ligne4ActionPerformed
		partieJeu.plateauJeu.deplacerLigne(4, false);
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versgauche_ligne4ActionPerformed

	private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {
		monChrono.start(); // lorsqu'on appuie sur le bouton "démarrer partie" le chrono se lance
		int nb_joueurs = (int) nbJoueurs_dia.getValue();
		partieJeu = new Partie(nb_joueurs);
		/*
		 * Petit bidouillage : le programme commence la pile au cas le plus haut
		 * qui lui correspond, c-à-d le nombre de joueurs.
		 * Comme il n'y a pas de 'break', il exécute ensuite tous ceux qui sont
		 * en-dessous.
		 */
		switch (nb_joueurs) {
			case 4:
				partieJeu.creerJoueur(3, nom_joueur4_dia.getText());
			case 3:
				partieJeu.creerJoueur(2, nom_joueur3_dia.getText());
			case 2:
				partieJeu.creerJoueur(1, nom_joueur2_dia.getText());
			case 1:
				partieJeu.creerJoueur(0, nom_joueur1_dia.getText());
				break;
		}
		partieJeu.initialiserPartieGraphique();
		dialogueJoueurs.dispose();
		ajouterTuilesGraphiques();
		Infojeu.setVisible(true);
		panneauGrille.setVisible(true);
		panel_tuilevolante.setVisible(true);
		panel_joueur.setVisible(true);
		panel_chrono.setVisible(true);
		actualiserAffichage();
	}

    private void nbJoueurs_diaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nbJoueurs_diaStateChanged
		int nbJoueurs = (int) nbJoueurs_dia.getValue();
		switch (nbJoueurs) {
			case 1:
				lbl_texteNbJoueurs.setText("1 joueur jouera");
				jLabel21.setVisible(true);
				nom_joueur1_dia.setVisible(true);
				jLabel22.setVisible(false);
				nom_joueur2_dia.setVisible(false);
				jLabel23.setVisible(false);
				nom_joueur3_dia.setVisible(false);
				jLabel20.setVisible(false);
				nom_joueur4_dia.setVisible(false);
				break;
			case 2:
				lbl_texteNbJoueurs.setText("2 joueurs joueront");
				jLabel21.setVisible(true);
				nom_joueur1_dia.setVisible(true);
				jLabel22.setVisible(true);
				nom_joueur2_dia.setVisible(true);
				jLabel23.setVisible(false);
				nom_joueur3_dia.setVisible(false);
				jLabel20.setVisible(false);
				nom_joueur4_dia.setVisible(false);
				break;
			case 3:
				lbl_texteNbJoueurs.setText("3 joueurs joueront");
				jLabel21.setVisible(true);
				nom_joueur1_dia.setVisible(true);
				jLabel22.setVisible(true);
				nom_joueur2_dia.setVisible(true);
				jLabel23.setVisible(true);
				nom_joueur3_dia.setVisible(true);
				jLabel20.setVisible(false);
				nom_joueur4_dia.setVisible(false);
				break;
			case 4:
				lbl_texteNbJoueurs.setText("4 joueurs joueront");
				jLabel21.setVisible(true);
				nom_joueur1_dia.setVisible(true);
				jLabel22.setVisible(true);
				nom_joueur2_dia.setVisible(true);
				jLabel23.setVisible(true);
				nom_joueur3_dia.setVisible(true);
				jLabel20.setVisible(true);
				nom_joueur4_dia.setVisible(true);
				break;
		}
    }//GEN-LAST:event_nbJoueurs_diaStateChanged

	/**
	 * Tout est dans le nom : la méthode affiche le dialogue modal de création
	 * des joueurs (et de la partie).
	 */
	public final void afficherDialogueCreationJoueurs() {
		dialogueJoueurs.setVisible(true);
	}

	/**
	 *
	 */
	public void actualiserAffichage() {
		/* Pour faciliter l'écriture */
		Joueur joueurCourant = partieJeu.listeJoueurs[partieJeu.joueurCourant];
		/* Actualisation des affichages */
		panneauGrille.repaint();
		panel_tuilevolante.repaint();

		/* On met à jour les labels d'information à partir des données de la partie */
		lbl_nomJCourant.setText(joueurCourant.nom);
		lbl_objectifCourantJCourant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/" + joueurCourant.listeCartes[joueurCourant.indexCarteRetournee].nomObjet + ".png")));
		int objReste = joueurCourant.listeCartes.length - 1 - joueurCourant.indexCarteRetournee;
		/* Pour que le texte s'adapte au nombre restant */
		switch (objReste) {
			case 0:
				lbl_objectifRestantsJCourant.setText("C'est le dernier !");
				break;
			case 1:
				lbl_objectifRestantsJCourant.setText("Puis 1 autre");
				break;
			default:
				lbl_objectifRestantsJCourant.setText("Puis " + objReste + " autres");
				break;
		}
	}

	/**
	 * Crée une tuile pour chaque tuile de la grille
	 */
	public final void ajouterTuilesGraphiques() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (partieJeu.plateauJeu.tuiles[i][j] == null) {
					break;
				}
				TuileGraphique tuileGraph = new TuileGraphique(partieJeu.plateauJeu.tuiles[i][j]);

				/* On ajoute l'action à effectuer qua d on clique sur la case */
				tuileGraph.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						Tuile t = tuileGraph.tuileAssociee;
					}
				});
				panneauGrille.add(tuileGraph);
			}
		}
		javax.swing.JButton btn_tuileVolante = new javax.swing.JButton();
		panel_tuilevolante.add(new TuileGraphique(partieJeu.plateauJeu.tuileVolante), new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 80, 80));
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FenetreDeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FenetreDeJeu().setVisible(true);
			}
		});
	}

	/* public final void ajouterTuilesGraphiques() {
        for (int i = 0; i < PlateauJeu.nb_lignes; i++) {
            for (int j = 0; j < PlateauJeu.nb_colonnes; j++) {
                ... A ADAPTER POUR LA CRATION DES TUILE GRAPHIQUE DU LAYOUT
                CelluleGraphique cellGraph = new CelluleGraphique(grilleJeu.Cellules[i][j]); // création d'une nouvelle cellule graphique appelé cellGraph

                cellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        Cellule c = cellGraph.celluleAssociee;
                        if (c.jetonCourant == null) {
                            texte_message.setText("");
                            return;
                        }
                        if (c.jetonCourant.Couleur.equals(joueurCourant.Couleur)) {
                            texte_message.setText(joueurCourant.Nom + " récupère un de ses jetons");
                            Jeton j_recup = c.recupererJeton();
                            c.supprimerJeton();
                            joueurCourant.ajouterJeton(j_recup);
                            joueurSuivant();
                        } else {
                            if (joueurCourant.nombreDesintegrateurs > 0) {
                                texte_message.setText(joueurCourant.Nom + " désintègre un jeton adverse");
                                c.supprimerJeton();
                                joueurCourant.utiliserDesintegrateur();
                                joueurSuivant();
                            }
                        }
                        grilleJeu.tasserGrille();
                        actualiserAffichage();
                    }
                });
                panneau_grille.add(cellGraph); // on ajoute les éléments cellGraph à notre panneau de jeu
            }
        }
    }
	 */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Infojeu;
    private javax.swing.JButton btn_start;
    private javax.swing.JButton btn_tournerTuileVolante;
    private javax.swing.JDialog dialogueJoueurs;
    private javax.swing.JLabel iconeTimer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton jouer_versbas_col2;
    private javax.swing.JButton jouer_versbas_col4;
    private javax.swing.JButton jouer_versbas_col6;
    private javax.swing.JButton jouer_versdroite_ligne2;
    private javax.swing.JButton jouer_versdroite_ligne4;
    private javax.swing.JButton jouer_versdroite_ligne6;
    private javax.swing.JButton jouer_versgauche_ligne2;
    private javax.swing.JButton jouer_versgauche_ligne4;
    private javax.swing.JButton jouer_versgauche_ligne6;
    private javax.swing.JButton jouer_vershaut_col2;
    private javax.swing.JButton jouer_vershaut_col4;
    private javax.swing.JButton jouer_vershaut_col6;
    private javax.swing.JLabel lbl_nomJCourant;
    private javax.swing.JLabel lbl_objectifCourantJCourant;
    private javax.swing.JLabel lbl_objectifRestantsJCourant;
    private javax.swing.JLabel lbl_texteNbJoueurs;
    private javax.swing.JSpinner nbJoueurs_dia;
    private javax.swing.JTextField nom_joueur1_dia;
    private javax.swing.JTextField nom_joueur2_dia;
    private javax.swing.JTextField nom_joueur3_dia;
    private javax.swing.JTextField nom_joueur4_dia;
    private javax.swing.JPanel panel_chrono;
    private javax.swing.JPanel panel_joueur;
    private javax.swing.JPanel panel_tuilevolante;
    private javax.swing.JPanel panneauGrille;
    private javax.swing.JLabel texte_temps;
    // End of variables declaration//GEN-END:variables
}
