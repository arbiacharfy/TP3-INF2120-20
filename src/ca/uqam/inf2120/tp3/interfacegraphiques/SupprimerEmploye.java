package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.border.TitledBorder;
import ca.uqam.inf2120.tp3.controller.ControllerSupprimerEmploye;
import ca.uqam.inf2120.tp3.modele.AnnuaireTelephonique;
import ca.uqam.inf2120.tp3.modele.Employe;
import java.awt.GridLayout;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SupprimerEmploye extends JDialog {

	
	private JPanel panneauHaut;
	private GridLayout gestionnairePanneauHaut = new GridLayout(2, 2);
	private JLabel nomEtPrenom;
	private JTextField txtNomPrenom;	
	private JPanel panneauBas;
	private FlowLayout gestionnairePanneauBas = new FlowLayout(FlowLayout.RIGHT);
	private JButton boutonSupprimer;
	private JButton boutonAnnuler;
	
	// Controlleur 
	private ControllerSupprimerEmploye controlleurSupprimerEmploye;
	private Employe employe;

	// Constructeur
	public SupprimerEmploye(InterfacePrincipale vue, boolean modal, Employe employe, AnnuaireTelephonique modele) {
		super(vue, modal);
		this.employe = employe;
		init();
		// Création du contrôleur 
		controlleurSupprimerEmploye = new ControllerSupprimerEmploye(this, employe, modele);
		boutonSupprimer.addActionListener(controlleurSupprimerEmploye);
		boutonAnnuler.addActionListener(controlleurSupprimerEmploye);
	}

	// Crée tous les conteneurs et composants de la fenêtre
	private void init() {

		// Création du panneau de haut avec ses composants.
		panneauHaut = new JPanel(gestionnairePanneauHaut);
		panneauHaut.setBorder(
				new TitledBorder(null, "Informations du pneu", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		// Création saisie Nom et Prenom 
		nomEtPrenom = new JLabel("Nom et Prenom :");
		txtNomPrenom = new JTextField(employe.getNom()+" - "+employe.getPrenom()+ "(Matricule : "+employe.getMatricule()+")");
		txtNomPrenom.setEditable(false);

		panneauHaut.add(nomEtPrenom);
		panneauHaut.add(txtNomPrenom);

			// Création du panneau de bas avec ses composants.
		panneauBas = new JPanel(gestionnairePanneauBas);
		boutonSupprimer = new JButton("Supprimer");
		boutonAnnuler = new JButton("Annuler");
		panneauBas.add(boutonSupprimer);
		panneauBas.add(boutonAnnuler);

		// Personnalisation du cadre central
		setTitle("Message Suppression");
		setSize(600, 150);
		setResizable(false);
		setLocationRelativeTo(this.getParent());

		add(panneauHaut, BorderLayout.CENTER);
		add(panneauBas, BorderLayout.SOUTH);

		// Définir le type de fermeture
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public JLabel getNomEtPrenom() {
		return nomEtPrenom;
	}

	public void setNomEtPrenom(JLabel nomEtPrenom) {
		this.nomEtPrenom = nomEtPrenom;
	}

	public JTextField getTxtNomPrenom() {
		return txtNomPrenom;
	}

	public void setTxtNomPrenom(JTextField txtNomPrenom) {
		this.txtNomPrenom = txtNomPrenom;
	}

	public JButton getBoutonSupprimer() {
		return boutonSupprimer;
	}

	public void setBoutonSupprimer(JButton boutonSupprimer) {
		this.boutonSupprimer = boutonSupprimer;
	}

	public JButton getBoutonAnnuler() {
		return boutonAnnuler;
	}

	public void setBoutonAnnuler(JButton boutonAnnuler) {
		this.boutonAnnuler = boutonAnnuler;
	}

	public ControllerSupprimerEmploye getControlleurSupprimerEmploye() {
		return controlleurSupprimerEmploye;
	}

	public void setControlleurSupprimerEmploye(ControllerSupprimerEmploye controlleurSupprimerEmploye) {
		this.controlleurSupprimerEmploye = controlleurSupprimerEmploye;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	

}
