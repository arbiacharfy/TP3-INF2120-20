package ca.uqam.inf2120.tp3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ca.uqam.inf2120.tp3.interfacegraphiques.AjouterEmploye;
import ca.uqam.inf2120.tp3.interfacegraphiques.InterfacePrincipale;
import ca.uqam.inf2120.tp3.interfacegraphiques.ModifierEmploye;
import ca.uqam.inf2120.tp3.modele.AnnuaireTelephonique;
import ca.uqam.inf2120.tp3.modele.EmplacementBureau;
import ca.uqam.inf2120.tp3.modele.Employe;

public class ControllerModifierEmploye implements ActionListener {

	private ModifierEmploye vue; // JDialog AjouterEmploye
	private AnnuaireTelephonique modele; // annuaire telephonique
	private Employe employe;
	private final String MESSAGE_ERROR_NUM_BUREAU = "Le numero du bureau doit etre un nombre entier superieur a 0!";
	private final String MESSAGE = "Message";
	private final String MESSAGE_CHAMPS_VIDE = "Veuillez remplir tous les champs!";
	private final String MESSAGE_MATRICULE_EXIST = "matricule existe deja! ";

	public ControllerModifierEmploye(ModifierEmploye vue, Employe employe, AnnuaireTelephonique modele) {
		this.vue = vue;
		this.employe = employe;
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == vue.getBtnModifier()) {


			String matricule = vue.getTextMatricule().getText();
			String prenom = vue.getTextPrenom().getText();
			String nom = vue.getTextNom().getText();
			String tel = vue.getTextTelephone().getText();
			String courriel = vue.getTextCourriel().getText();
			String msgNumeroBureau = (String) vue.getComboBoxNumEtage().getSelectedItem();
			int numeroBureau = 0;
			try {
				numeroBureau = Integer.parseInt((String) vue.getComboBoxNumEtage().getSelectedItem());

			} catch (Exception exc) {
			}
			int numeroEtage = 0;
			try {
				numeroEtage = Integer.parseInt(vue.getTextNumBureau().getText());

			} catch (Exception exc) {
			}

			if (numeroEtage <= 0) {
				JOptionPane.showMessageDialog(null, MESSAGE_ERROR_NUM_BUREAU, MESSAGE, JOptionPane.INFORMATION_MESSAGE);

			} else if (matricule.trim() == "" || prenom.trim() == "" || nom.trim() == "" || tel.trim() == ""
					|| courriel.trim() == "" || msgNumeroBureau.equals(vue.getMESSAGE_SELECT_NUM_RTAGE())) {

				JOptionPane.showMessageDialog(null, MESSAGE_CHAMPS_VIDE, MESSAGE, JOptionPane.INFORMATION_MESSAGE);

			} else {
				EmplacementBureau Etage_Bureau = new EmplacementBureau(numeroEtage, numeroBureau);

				// Employe e1 = new Employe(matricule, nom, prenom, courriel,
				// tel, Etage_Bureau);
				// if (modele.employeExist(e1)) {
				// JOptionPane.showMessageDialog(null, MESSAGE_MATRICULE_EXIST,
				// MESSAGE,
				// JOptionPane.INFORMATION_MESSAGE);
				//
				// } else {

				// cree un nouveau employe

				Employe nouveauEmploye = new Employe(matricule, nom, prenom, courriel, tel, Etage_Bureau);

				nouveauEmploye.setMatricule(employe.getMatricule());

				// Appelle la fonction Modifier un pneu du gestionnaire
				modele.modifierEmploye(nouveauEmploye);

				// Appelle la fonction Rafraîchir de la fenêtre principale
				vue.dispose();
				((InterfacePrincipale) vue.getParent()).refresh();
			}

			// }

		} else if (source == vue.getBtnAnnuler()) {
			// Fermer la fenêtre
			vue.dispose();
		}

	}

}
