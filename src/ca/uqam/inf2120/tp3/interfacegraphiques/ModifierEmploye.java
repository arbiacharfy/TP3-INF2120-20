package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.border.TitledBorder;

import ca.uqam.inf2120.tp3.controller.ControllerModifierEmploye;
import ca.uqam.inf2120.tp3.modele.AnnuaireTelephonique;
import ca.uqam.inf2120.tp3.modele.Employe;

import java.awt.GridLayout;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ModifierEmploye extends JDialog {

	// *********** Déclarations des attributs **********//

	JPanel panneauGlobal;
	private final String MESSAGE_SELECT_NUM_RTAGE = "Select le no d'etage";
	String titre = "Media Pour Tous - Ajout d'un employe";
	private final String[] NUMERO_ETAGE = { MESSAGE_SELECT_NUM_RTAGE, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" };
	private JTextField textMatricule;
	private JTextField textPrenom;
	private JTextField textNom;
	private JTextField textTelephone;
	private JTextField textCourriel;
	private JComboBox<String> comboBoxNumEtage;
	private JTextField textNumBureau;
	private JButton btnAnnuler;
	private JButton btnModifier;
	// declaration de l'ecouteur
	private ControllerModifierEmploye modifierEmployerControlleur;
	// classe Employe
	private Employe employe;

	// Constructeur
	public ModifierEmploye(InterfacePrincipale fenetrePrincipale, boolean modal, Employe employe, AnnuaireTelephonique modele) {
		super(fenetrePrincipale, modal);
		this.employe = employe;		
		init();
		// Création du controleur (Controller du MVC)
		modifierEmployerControlleur = new ControllerModifierEmploye(this, employe,  modele);
		// Ajouter le écouteur aux composants
		btnModifier.addActionListener(modifierEmployerControlleur);
		btnAnnuler.addActionListener(modifierEmployerControlleur);
		textMatricule.addActionListener(modifierEmployerControlleur);
		textPrenom.addActionListener(modifierEmployerControlleur);
		textNom.addActionListener(modifierEmployerControlleur);
		textTelephone.addActionListener(modifierEmployerControlleur);
		textCourriel.addActionListener(modifierEmployerControlleur);
		comboBoxNumEtage.addActionListener(modifierEmployerControlleur);
		textNumBureau.addActionListener(modifierEmployerControlleur);
		
	}

	/**
	 * Launch the application.
	 */
	private void init() {
		// information sur la fenetre
		setTitle(titre); // titre de la fenetre
		setBounds(100, 100, 500, 500);// dimension
		// panneau Global : contient deux pannel
		panneauGlobal = new JPanel();
		setContentPane(panneauGlobal);
		panneauGlobal.setLayout(new BorderLayout(0, 0));
		// panneau top
		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(
				new TitledBorder(null, "Information de l'employe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panneauGlobal.add(panelHaut, BorderLayout.CENTER);
		panelHaut.setLayout(new GridLayout(7, 2, 0, 0));
		// Matricule
		JLabel lblMatricule = new JLabel("Matricule :");
		panelHaut.add(lblMatricule);
		
		textMatricule = new JTextField(employe.getMatricule());
		panelHaut.add(textMatricule);
		textMatricule.setColumns(10);
		// Prenom
		JLabel lblPrenom = new JLabel("Prenom :");
		panelHaut.add(lblPrenom);
		textPrenom = new JTextField(employe.getPrenom());
		panelHaut.add(textPrenom);
		textPrenom.setColumns(10);
		// Nom
		JLabel lblNom = new JLabel("Nom :");
		panelHaut.add(lblNom);

		textNom = new JTextField(employe.getNom());
		panelHaut.add(textNom);
		textNom.setColumns(10);
		// Telephone
		JLabel lblTelephone = new JLabel("Telephone :");
		panelHaut.add(lblTelephone);

		textTelephone = new JTextField(employe.getNumeroTelephone());
		panelHaut.add(textTelephone);
		textTelephone.setColumns(10);
		// Courriel
		JLabel lblCourriel = new JLabel("Courriel :");
		panelHaut.add(lblCourriel);

		textCourriel = new JTextField(employe.getAdresseCourriel());
		panelHaut.add(textCourriel);
		textCourriel.setColumns(10);
		// Numero Etage
		JLabel lblNumEtage = new JLabel("Numero Etage :");
		panelHaut.add(lblNumEtage);

		comboBoxNumEtage = new JComboBox<String>();

		comboBoxNumEtage.setEditable(false);
		for (String i : NUMERO_ETAGE) {
			comboBoxNumEtage.addItem(i);
		}
		comboBoxNumEtage.setSelectedItem(employe.getBureau().getNumeroEtage());
		panelHaut.add(comboBoxNumEtage);
		// Numero Bureau
		JLabel lblNumBureau = new JLabel("Numero de Bureau :");
		panelHaut.add(lblNumBureau);
		textNumBureau = new JTextField(employe.getBureau().getNumeroBureau());
		panelHaut.add(textNumBureau);
		textNumBureau.setColumns(10);
		// panneau bottom
		JPanel panelBas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBas.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panneauGlobal.add(panelBas, BorderLayout.SOUTH);
		btnModifier = new JButton("Modifier");
		panelBas.add(btnModifier);
		btnAnnuler = new JButton("Annuler");
		panelBas.add(btnAnnuler);
	}

	public JTextField getTextMatricule() {
		return textMatricule;
	}

	public void setTextMatricule(JTextField textMatricule) {
		this.textMatricule = textMatricule;
	}

	public JTextField getTextPrenom() {
		return textPrenom;
	}

	public void setTextPrenom(JTextField textPrenom) {
		this.textPrenom = textPrenom;
	}

	public JTextField getTextNom() {
		return textNom;
	}

	public void setTextNom(JTextField textNom) {
		this.textNom = textNom;
	}

	public JTextField getTextTelephone() {
		return textTelephone;
	}

	public void setTextTelephone(JTextField textTelephone) {
		this.textTelephone = textTelephone;
	}

	public JTextField getTextCourriel() {
		return textCourriel;
	}

	public void setTextCourriel(JTextField textCourriel) {
		this.textCourriel = textCourriel;
	}

	public JComboBox<String> getComboBoxNumEtage() {
		return comboBoxNumEtage;
	}

	public void setComboBoxNumEtage(JComboBox<String> comboBoxNumEtage) {
		this.comboBoxNumEtage = comboBoxNumEtage;
	}

	public JTextField getTextNumBureau() {
		return textNumBureau;
	}

	public void setTextNumBureau(JTextField textNumBureau) {
		this.textNumBureau = textNumBureau;
	}

	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public void setBtnAnnuler(JButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}

	public ControllerModifierEmploye getModifierEmployerControlleur() {
		return modifierEmployerControlleur;
	}

	public void setModifierEmployerControlleur(ControllerModifierEmploye modifierEmployerControlleur) {
		this.modifierEmployerControlleur = modifierEmployerControlleur;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public String getMESSAGE_SELECT_NUM_RTAGE() {
		return MESSAGE_SELECT_NUM_RTAGE;
	}

	public String[] getNUMERO_ETAGE() {
		return NUMERO_ETAGE;
	}
	
	

}
