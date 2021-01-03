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
	// sera utilisé lorqu'on clic sur n'importe quel bouton permettant de placer une tuile
	int compteur = 0;
	// sera utilisé pour qu'on ne puisser terminer le tour qu'une seule fois
	int compteur2 = 0;
	// sera utilisé pour qu'on ne puisser commencer le tour qu'une seule fois
	int compteur3 = 0;
	Partie partieJeu;

	TuileGraphique[][] tabStockTuilesGraphiques = new TuileGraphique[7][7];
	TuileGraphique tuileGraphVol;

	// insertion de l'image pour notre chrono
	ImageIcon img_iconetimer = new javax.swing.ImageIcon(getClass().getResource("/images/timer.png"));
	// insertion de l'image pour les boutons de chaques cotés du plateau
	ImageIcon img_fleched = new javax.swing.ImageIcon(getClass().getResource("/images/fleched.png"));
	ImageIcon img_flecheg = new javax.swing.ImageIcon(getClass().getResource("/images/flecheg.png"));
	ImageIcon img_flecheh = new javax.swing.ImageIcon(getClass().getResource("/images/flecheh.png"));
	ImageIcon img_flecheb = new javax.swing.ImageIcon(getClass().getResource("/images/flecheb.png"));
	// insertion des images des pions
	ImageIcon img_pionjaune = new javax.swing.ImageIcon(getClass().getResource("/images/pionjaune.png"));
	ImageIcon img_pionrouge = new javax.swing.ImageIcon(getClass().getResource("/images/pionrouge.png"));
	ImageIcon img_pionvert = new javax.swing.ImageIcon(getClass().getResource("/images/pionvert.png"));
	ImageIcon img_pionbleu = new javax.swing.ImageIcon(getClass().getResource("/images/pionbleu.png"));

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

		/* Pas besoin de ces instruction il semble, le paneau n'est pas encore affiché */
 /*Infojeu.setVisible(false);
		panneauGrille.setVisible(true);
		panel_tuilevolante.setVisible(false);
		panel_joueur.setVisible(false);
		panel_chrono.setVisible(false);*/

 /* Dialogue modal du nombre de joueurs */
		jLabel22.setVisible(false);
		nom_joueur2_dia.setVisible(false);
		jLabel23.setVisible(false);
		nom_joueur3_dia.setVisible(false);
		jLabel20.setVisible(false);
		nom_joueur4_dia.setVisible(false);
                jLabel1.setVisible(false);
                phrase2.setVisible(false);
                phrase3.setVisible(false);
                phrase4.setVisible(false);
                // ajustement des couleurs de fond des jLabels et leur visibilité
                bleu.setOpaque(true);
                bleu.setBackground(new java.awt.Color(77, 132, 187));
                vert.setVisible(false);
                vert.setOpaque(true);
                vert.setBackground(new java.awt.Color(58, 171, 83));
                jaune.setVisible(false);
                jaune.setOpaque(true);
                jaune.setBackground(new java.awt.Color(252, 210, 29));
                rouge.setVisible(false);
                rouge.setOpaque(true);
                rouge.setBackground(new java.awt.Color(214, 90, 57));
                
               lbl_objectifCourantJCourant.setVisible(false);
               lbl_objectifRestantsJCourant.setVisible(false);
               btn_tournerTuileVolante.setEnabled(false);
               jouer_versbas_col6.setEnabled(false);
               jouer_versbas_col2.setEnabled(false);
               jouer_versbas_col4.setEnabled(false);
               jouer_vershaut_col2.setEnabled(false);
               jouer_vershaut_col4.setEnabled(false);
               jouer_vershaut_col6.setEnabled(false);
               jouer_versgauche_ligne6.setEnabled(false);
               jouer_versgauche_ligne4.setEnabled(false);
               jouer_versgauche_ligne2.setEnabled(false);
               jouer_versdroite_ligne4.setEnabled(false);
               jouer_versdroite_ligne2.setEnabled(false);
               jouer_versdroite_ligne6.setEnabled(false);
               

		/* On  affiche le panneau de création des joueurs */
		afficherDialogueCreationJoueurs();
                
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
        phrase4 = new javax.swing.JLabel();
        phrase1 = new javax.swing.JLabel();
        phrase2 = new javax.swing.JLabel();
        phrase3 = new javax.swing.JLabel();
        rouge = new javax.swing.JLabel();
        bleu = new javax.swing.JLabel();
        vert = new javax.swing.JLabel();
        jaune = new javax.swing.JLabel();
        fenetre_info_jeu = new javax.swing.JFrame();
        btn_fermer_les_infos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panneauGrille = new javax.swing.JPanel();
        Infojeu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panel_tuilevolante = new javax.swing.JPanel();
        btn_tournerTuileVolante = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panel_joueur = new javax.swing.JPanel();
        lbl_nomJCourant = new javax.swing.JLabel();
        lbl_objectifCourantJCourant = new javax.swing.JLabel();
        lbl_objectifRestantsJCourant = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btn_commencerTour = new javax.swing.JButton();
        btn_terminerTour = new javax.swing.JButton();
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
        btn_ouvrir_les_infos = new javax.swing.JButton();

        jTextField2.setText("jTextField1");

        dialogueJoueurs.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogueJoueurs.setTitle("Création des joueurs");
        dialogueJoueurs.setMinimumSize(new java.awt.Dimension(500, 500));
        dialogueJoueurs.setModal(true);
        dialogueJoueurs.setSize(new java.awt.Dimension(675, 412));
        dialogueJoueurs.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nbJoueurs_dia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));
        nbJoueurs_dia.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nbJoueurs_diaStateChanged(evt);
            }
        });
        dialogueJoueurs.getContentPane().add(nbJoueurs_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 60, -1));

        jLabel19.setText("Combien de personnes jouent ?");
        dialogueJoueurs.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        jLabel20.setText("Nom du joueur 4 :");
        dialogueJoueurs.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 130, -1));

        jLabel21.setText("Nom du joueur 1 :");
        dialogueJoueurs.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 130, -1));

        jLabel22.setText("Nom du joueur 2 :");
        dialogueJoueurs.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 130, -1));

        jLabel23.setText("Nom du joueur 3 :");
        dialogueJoueurs.getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 130, -1));

        nom_joueur4_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_joueur4_diaActionPerformed(evt);
            }
        });
        dialogueJoueurs.getContentPane().add(nom_joueur4_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 120, -1));

        nom_joueur1_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_joueur1_diaActionPerformed(evt);
            }
        });
        dialogueJoueurs.getContentPane().add(nom_joueur1_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 120, -1));
        dialogueJoueurs.getContentPane().add(nom_joueur2_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 120, -1));
        dialogueJoueurs.getContentPane().add(nom_joueur3_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 120, -1));

        btn_start.setText("Démarrer la partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        dialogueJoueurs.getContentPane().add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        lbl_texteNbJoueurs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_texteNbJoueurs.setText("1 joueur jouera");
        dialogueJoueurs.getContentPane().add(lbl_texteNbJoueurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        phrase4.setText("dont le pion sera de la couleur suivante");
        dialogueJoueurs.getContentPane().add(phrase4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 220, 20));

        phrase1.setText("dont le pion sera de la couleur suivante");
        dialogueJoueurs.getContentPane().add(phrase1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 220, 20));

        phrase2.setText("dont le pion sera de la couleur suivante");
        dialogueJoueurs.getContentPane().add(phrase2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 220, 20));

        phrase3.setText("dont le pion sera de la couleur suivante");
        dialogueJoueurs.getContentPane().add(phrase3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 220, 20));

        rouge.setBackground(new java.awt.Color(214, 90, 57));
        dialogueJoueurs.getContentPane().add(rouge, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 40, 30));

        bleu.setBackground(new java.awt.Color(77, 132, 187));
        bleu.setForeground(new java.awt.Color(77, 132, 187));
        dialogueJoueurs.getContentPane().add(bleu, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 40, 30));

        vert.setBackground(new java.awt.Color(58, 171, 83));
        dialogueJoueurs.getContentPane().add(vert, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 40, 30));

        jaune.setBackground(new java.awt.Color(252, 210, 29));
        dialogueJoueurs.getContentPane().add(jaune, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 40, 30));

        fenetre_info_jeu.setTitle("Légende");
        fenetre_info_jeu.setAlwaysOnTop(true);
        fenetre_info_jeu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fenetre_info_jeu.setLocation(new java.awt.Point(450, 80));
        fenetre_info_jeu.setMinimumSize(new java.awt.Dimension(400, 620));
        fenetre_info_jeu.setUndecorated(true);
        fenetre_info_jeu.setResizable(false);
        fenetre_info_jeu.setSize(new java.awt.Dimension(395, 566));
        fenetre_info_jeu.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_fermer_les_infos.setText("Fermer la fenêtre d'information");
        btn_fermer_les_infos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fermer_les_infosActionPerformed(evt);
            }
        });
        fenetre_info_jeu.getContentPane().add(btn_fermer_les_infos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 210, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Auteurs :");
        fenetre_info_jeu.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 150, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Règles du jeu :");
        fenetre_info_jeu.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setText("<html>Ce projet scolaire de Conception Programmation Objet a été créé par Émile ROYER, Lucas DELMOTTE, et Clara THEODOLY. \n\n\n\n\nLe dépôt (git) du projet est disponible à l'adresse suivante : https://github.com/claratheodoly/labyrinthe.");
        jLabel7.setToolTipText("");
        fenetre_info_jeu.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 380, 130));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("<html>Ce jeu se joue de 1 à 4 joueurs. Sur un plateau représentant un labyrinthe, les joueurs doivent atteindre des objets dessinés sur les tuiles. La disposition des tuiles évolue à chaque tour de jeu. Le plateau de jeu comprend des tuiles fixes, et des rangées de tuiles mobiles. Il y a toujours une tuile hors du plateau. À son tour, le joueur utilise la tuile libre pour pousser une rangée de tuile du plateau, faisant ainsi évoluer le labyrinthe. Il dégage ainsi une tuile pour le joueur suivant, et peut éventuellement faire progresser son pion dans le labyrinthe. Chaque joueur possède des cartes représentant des objets. Ces objets sont également représentés sur les tuiles (fixes ou mobiles) du labyrinthe. Chaque joueur doit atteindre ses objets avec son pion. Le jeu se termine quand un joueur a atteint tous les objets de sa liste et est revenu à son point de départ.");
        jLabel8.setToolTipText("");
        fenetre_info_jeu.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 380, 320));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Labyrinthe");
        setMinimumSize(new java.awt.Dimension(1170, 715));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneauGrille.setBackground(new java.awt.Color(231, 193, 127));
        panneauGrille.setLayout(new java.awt.GridLayout(7, 7));
        getContentPane().add(panneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 567, 567));

        Infojeu.setBackground(new java.awt.Color(204, 204, 204));
        Infojeu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gif-bravo.gif"))); // NOI18N
        Infojeu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, 90));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("La partie est remportée ! BRAVO !");
        Infojeu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 190, -1));

        getContentPane().add(Infojeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 210, 160));

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
        panel_joueur.add(lbl_objectifCourantJCourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 81, 81));

        lbl_objectifRestantsJCourant.setText("objectif_restants");
        panel_joueur.add(lbl_objectifRestantsJCourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 120, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        panel_joueur.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 140, 10));

        jLabel3.setText("C'est le tour de  ");
        panel_joueur.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        btn_commencerTour.setText("Commencer le tour");
        btn_commencerTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_commencerTourActionPerformed(evt);
            }
        });
        panel_joueur.add(btn_commencerTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 170, -1));

        btn_terminerTour.setText("Terminer le tour");
        btn_terminerTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_terminerTourActionPerformed(evt);
            }
        });
        panel_joueur.add(btn_terminerTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 170, -1));

        jLabel1.setText("Votre objectif :");
        panel_joueur.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        getContentPane().add(panel_joueur, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 250, 330));

        panel_chrono.setBackground(new java.awt.Color(204, 204, 204));
        panel_chrono.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setText("temps écoulé");
        panel_chrono.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        texte_temps.setText("0");
        panel_chrono.add(texte_temps, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        iconeTimer.setText("Label");
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

        btn_ouvrir_les_infos.setText("Informations du jeu");
        btn_ouvrir_les_infos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ouvrir_les_infosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ouvrir_les_infos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 210, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_commencerTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_commencerTourActionPerformed
		jLabel1.setVisible(true);
		lbl_objectifCourantJCourant.setVisible(true);
		lbl_objectifRestantsJCourant.setVisible(true);
		// si on clique une fois sur ce btn alors il se désactive
		compteur3++;
		if (compteur3 == 1) {
			btn_commencerTour.setEnabled(false);
		}
		// réactivation des divers boutons pour jouer dans les lignes et les colonnes
		compteur = 0;
		btn_tournerTuileVolante.setEnabled(true);
		jouer_versbas_col6.setEnabled(true);
		jouer_versbas_col2.setEnabled(true);
		jouer_versbas_col4.setEnabled(true);
		jouer_vershaut_col2.setEnabled(true);
		jouer_vershaut_col4.setEnabled(true);
		jouer_vershaut_col6.setEnabled(true);
		jouer_versgauche_ligne6.setEnabled(true);
		jouer_versgauche_ligne4.setEnabled(true);
		jouer_versgauche_ligne2.setEnabled(true);
		jouer_versdroite_ligne4.setEnabled(true);
		jouer_versdroite_ligne2.setEnabled(true);
		jouer_versdroite_ligne6.setEnabled(true);
		// reactivation du btn terminer le tour
		compteur2 = 0;
		btn_terminerTour.setEnabled(true);

		actualiserAffichage();

    }//GEN-LAST:event_btn_commencerTourActionPerformed

    private void btn_terminerTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_terminerTourActionPerformed
		partieJeu.joueurSuivant();
		jLabel1.setVisible(false);
		lbl_objectifCourantJCourant.setVisible(false);
		lbl_objectifRestantsJCourant.setVisible(false);
		// reactivation du btn commenecer le tour
		compteur3 = 0;
		btn_commencerTour.setEnabled(true);
		// si on clique une fois sur ce btn alors il se désactive
		compteur2++;
		if (compteur2 == 1) {
			btn_terminerTour.setEnabled(false);
		}
		actualiserAffichage();
    }//GEN-LAST:event_btn_terminerTourActionPerformed

    private void btn_tournerTuileVolanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tournerTuileVolanteActionPerformed
		partieJeu.plateauJeu.tuileVolante.tournerTuile(90);
		actualiserAffichage();
    }//GEN-LAST:event_btn_tournerTuileVolanteActionPerformed

    private void jouer_versbas_col6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versbas_col6ActionPerformed
		partieJeu.plateauJeu.deplacerColonne(5, false);
		compteur++;
		désactiverbouton();
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versbas_col6ActionPerformed

    private void jouer_vershaut_col2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_vershaut_col2ActionPerformed
		partieJeu.plateauJeu.deplacerColonne(1, true);
		compteur++;
		désactiverbouton();
		actualiserAffichage();
    }//GEN-LAST:event_jouer_vershaut_col2ActionPerformed

    private void jouer_vershaut_col4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_vershaut_col4ActionPerformed
		partieJeu.plateauJeu.deplacerColonne(3, true);
		compteur++;
		désactiverbouton();
		actualiserAffichage();
    }//GEN-LAST:event_jouer_vershaut_col4ActionPerformed

    private void jouer_vershaut_col6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_vershaut_col6ActionPerformed
		partieJeu.plateauJeu.deplacerColonne(5, true);
		compteur++;
		désactiverbouton();
		actualiserAffichage();
    }//GEN-LAST:event_jouer_vershaut_col6ActionPerformed

    private void jouer_versbas_col2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versbas_col2ActionPerformed
		partieJeu.plateauJeu.deplacerColonne(1, false);
		compteur++;
		désactiverbouton();
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versbas_col2ActionPerformed

    private void jouer_versbas_col4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versbas_col4ActionPerformed
		partieJeu.plateauJeu.deplacerColonne(3, false);
		compteur++;
		désactiverbouton();
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versbas_col4ActionPerformed

    private void jouer_versgauche_ligne6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versgauche_ligne6ActionPerformed
		partieJeu.plateauJeu.deplacerLigne(5, false);
		compteur++;
		désactiverbouton();
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versgauche_ligne6ActionPerformed

    private void jouer_versdroite_ligne6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versdroite_ligne6ActionPerformed
		partieJeu.plateauJeu.deplacerLigne(5, true);
		compteur++;
		désactiverbouton();
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versdroite_ligne6ActionPerformed

    private void jouer_versdroite_ligne4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versdroite_ligne4ActionPerformed
		partieJeu.plateauJeu.deplacerLigne(3, true);
		compteur++;
		désactiverbouton();
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versdroite_ligne4ActionPerformed

    private void jouer_versdroite_ligne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versdroite_ligne2ActionPerformed
		partieJeu.plateauJeu.deplacerLigne(1, true);
		compteur++;
		désactiverbouton();
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versdroite_ligne2ActionPerformed

    private void jouer_versgauche_ligne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versgauche_ligne2ActionPerformed
		partieJeu.plateauJeu.deplacerLigne(1, false);
		compteur++;
		désactiverbouton();
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versgauche_ligne2ActionPerformed

    private void jouer_versgauche_ligne4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jouer_versgauche_ligne4ActionPerformed
		partieJeu.plateauJeu.deplacerLigne(3, false);
		compteur++;
		désactiverbouton();
		actualiserAffichage();
    }//GEN-LAST:event_jouer_versgauche_ligne4ActionPerformed
	private void désactiverbouton() {
		if (compteur == 1) {
			jouer_vershaut_col2.setEnabled(false);
			jouer_versbas_col6.setEnabled(false);
			jouer_versbas_col2.setEnabled(false);
			jouer_versbas_col4.setEnabled(false);
			jouer_vershaut_col4.setEnabled(false);
			jouer_vershaut_col6.setEnabled(false);
			jouer_versgauche_ligne6.setEnabled(false);
			jouer_versgauche_ligne4.setEnabled(false);
			jouer_versgauche_ligne2.setEnabled(false);
			jouer_versdroite_ligne4.setEnabled(false);
			jouer_versdroite_ligne2.setEnabled(false);
			jouer_versdroite_ligne6.setEnabled(false);
			btn_tournerTuileVolante.setEnabled(false);
		}
	}

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
                                phrase1.setVisible(true);
                                phrase2.setVisible(false);
                                phrase3.setVisible(false);
                                phrase4.setVisible(false);
                                vert.setVisible(false);
                                jaune.setVisible(false);
                                rouge.setVisible(false);
                                bleu.setVisible(true);
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
				phrase1.setVisible(true);
				phrase2.setVisible(true);
				phrase3.setVisible(false);
				phrase4.setVisible(false);
				vert.setVisible(true);
				jaune.setVisible(false);
				rouge.setVisible(false);
				bleu.setVisible(true);

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
				phrase1.setVisible(true);
				phrase2.setVisible(true);
				phrase3.setVisible(true);
				phrase4.setVisible(false);
				vert.setVisible(true);
				jaune.setVisible(true);
				rouge.setVisible(false);
				bleu.setVisible(true);

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
				phrase1.setVisible(true);
				phrase2.setVisible(true);
				phrase3.setVisible(true);
				phrase4.setVisible(true);
				vert.setVisible(true);
				jaune.setVisible(true);
				rouge.setVisible(true);
				bleu.setVisible(true);

				break;
		}
    }//GEN-LAST:event_nbJoueurs_diaStateChanged

    private void nom_joueur1_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_joueur1_diaActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_nom_joueur1_diaActionPerformed

    private void nom_joueur4_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_joueur4_diaActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_nom_joueur4_diaActionPerformed

    private void btn_ouvrir_les_infosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ouvrir_les_infosActionPerformed
        // action lorqu'on clique sur le bouton légende
        btn_ouvrir_les_infos.setEnabled(false); // on ne peut pas appuyer sur le bouton légende tant qu'on a pas fermer la fentere de légende
        fenetre_info_jeu.setVisible(true); // la fenetre de légende apparaît et s'affiche
    }//GEN-LAST:event_btn_ouvrir_les_infosActionPerformed

    private void btn_fermer_les_infosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fermer_les_infosActionPerformed
          // action lorqu'on clique sur le bouton fermer
        fenetre_info_jeu.setVisible(false); // fermeture de la fenêtre de légende
        btn_ouvrir_les_infos.setEnabled(true); // on peut si on le souhaite re-ouvrir le tout en cliquant à nouveau sur le bouton légende
    }//GEN-LAST:event_btn_fermer_les_infosActionPerformed

	/**
	 * Tout est dans le nom : la méthode affiche le dialogue modal de création
	 * des joueurs (et de la partie).
	 */
	public final void afficherDialogueCreationJoueurs() {
		dialogueJoueurs.setVisible(true);
	}

	/**
	 * Actualise les textes et les tuiles graphiques
	 */
	public void actualiserAffichage() {
		/* Pour faciliter l'écriture */
		Joueur joueurCourant = partieJeu.listeJoueurs[partieJeu.joueurCourant];
		/* Actualisation des affichages */
		actualiserTuilesGraphiques();
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
				TuileGraphique tuileGraph = new TuileGraphique(partieJeu.plateauJeu.tuiles[i][j], i, j);

				/* On ajoute l'action à effectuer quand on clique sur la case */
				tuileGraph.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						int[] posPionJCourant = partieJeu.plateauJeu.positionPion(partieJeu.listeJoueurs[partieJeu.joueurCourant]);
						if (posPionJCourant != null) {
							if (partieJeu.plateauJeu.cheminPossible(posPionJCourant[0], posPionJCourant[1], tuileGraph.posX, tuileGraph.posY, null)) {
								Pion pionActuel = partieJeu.listeJoueurs[partieJeu.joueurCourant].marqueur;
								partieJeu.plateauJeu.tuiles[posPionJCourant[0]][posPionJCourant[1]].pionsPresents.remove(pionActuel);
								partieJeu.plateauJeu.tuiles[tuileGraph.posX][tuileGraph.posY].pionsPresents.add(pionActuel);
							} else {
								System.err.println("Chemin impossible");
							}
							actualiserAffichage();
						}
					}
				});
				panneauGrille.add(tuileGraph);
				tabStockTuilesGraphiques[i][j] = tuileGraph;
			}
		}
		//javax.swing.JButton btn_tuileVolante = new javax.swing.JButton();
		tuileGraphVol = new TuileGraphique(partieJeu.plateauJeu.tuileVolante, 0, 0);
		panel_tuilevolante.add(tuileGraphVol, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 80, 80));
	}

	/**
	 * Actualise la tuile associée à chaque tuile graphique pour correspondre au
	 * plateau (c'est moche, mais c'est le mieux de ce à quoi j'ai pensé).
	 */
	public void actualiserTuilesGraphiques() {
		tuileGraphVol.tuileAssociee = partieJeu.plateauJeu.tuileVolante;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				tabStockTuilesGraphiques[i][j].tuileAssociee = partieJeu.plateauJeu.tuiles[i][j];
			}
		}
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Infojeu;
    private javax.swing.JLabel bleu;
    private javax.swing.JButton btn_commencerTour;
    private javax.swing.JButton btn_fermer_les_infos;
    private javax.swing.JButton btn_ouvrir_les_infos;
    private javax.swing.JButton btn_start;
    private javax.swing.JButton btn_terminerTour;
    private javax.swing.JButton btn_tournerTuileVolante;
    private javax.swing.JDialog dialogueJoueurs;
    private javax.swing.JFrame fenetre_info_jeu;
    private javax.swing.JLabel iconeTimer;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jaune;
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
    private javax.swing.JLabel phrase1;
    private javax.swing.JLabel phrase2;
    private javax.swing.JLabel phrase3;
    private javax.swing.JLabel phrase4;
    private javax.swing.JLabel rouge;
    private javax.swing.JLabel texte_temps;
    private javax.swing.JLabel vert;
    // End of variables declaration//GEN-END:variables
}
