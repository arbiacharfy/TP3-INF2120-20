package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.border.TitledBorder;

import ca.uqam.inf2120.tp3.controller.ControllerAfficherEmploye;
import ca.uqam.inf2120.tp3.modele.AnnuaireTelephonique;
import ca.uqam.inf2120.tp3.modele.Employe;
import ca.uqam.inf2120.tp3.modele.GestionnaireInventairePneus;
import ca.uqam.inf2120.tp3.modele.Pneu;

import java.awt.GridLayout;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SupprimerEmploye extends JDialog {

	private Employe employe;

	// Panneau de haut et ses composants
	private JPanel panneauHaut;
	private GridLayout gestionnairePanneauHaut = new GridLayout(2, 2);
	private JLabel description;
	private JTextField saisieDescription;
	private JLabel nbPneus;
	private JTextField saisieNbPneus;

	// Panneau de bas et ses composants
	private JPanel panneauBas;
	private FlowLayout gestionnairePanneauBas = new FlowLayout(FlowLayout.RIGHT);
	private JButton boutonSupprimer;
	private JButton boutonAnnuler;

	// Constructeur sans argument
	public SupprimerEmploye(InterfacePrincipale vue, boolean modal, Employe employe, AnnuaireTelephonique modele) {
		super(vue, modal);
		this.employe = employe;
		init();

		// Création du contrôleur (Controller du MVC)
		ecouteur = new EcouteurSupprimer(this, unPneu, unGestionnaire);

		// Ajouter le contrôleur (écouteur) aux composants
		boutonSupprimer.addActionListener(ecouteur);
		boutonAnnuler.addActionListener(ecouteur);
	}

	// Crée tous les conteneurs et composants de la fenêtre
	private void init() {

		// Création du panneau de haut avec ses composants.
		panneauHaut = new JPanel(gestionnairePanneauHaut);
		panneauHaut.setBorder(
				new TitledBorder(null, "Informations du pneu", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		// Création saisie Description
		description = new JLabel("Description :");
		saisieDescription = new JTextField(pneu.construireDecription());
		saisieDescription.setEditable(false);

		panneauHaut.add(description);
		panneauHaut.add(saisieDescription);

		// Création saisie Nombre Pneus
		nbPneus = new JLabel("Nombre de pneus :");
		saisieNbPneus = new JTextField(String.valueOf(pneu.obtenirNbCopies()));

		panneauHaut.add(nbPneus);
		panneauHaut.add(saisieNbPneus);

		// Création du panneau de bas avec ses composants.
		panneauBas = new JPanel(gestionnairePanneauBas);

		boutonSupprimer = new JButton("Supprimer");
		boutonAnnuler = new JButton("Annuler");

		panneauBas.add(boutonSupprimer);
		panneauBas.add(boutonAnnuler);

		// Personnalisation du cadre central
		setTitle("Nordic Pneus (SGI) - Suppression");
		setSize(600, 150);
		setResizable(false);
		setLocationRelativeTo(this.getParent());

		add(panneauHaut, BorderLayout.CENTER);
		add(panneauBas, BorderLayout.SOUTH);

		// Définir le type de fermeture
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

}
