package ca.uqam.inf2120.tp3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ca.uqam.inf2120.tp3.interfacegraphiques.AjouterEmploye;
import ca.uqam.inf2120.tp3.interfacegraphiques.InterfacePrincipale;
import ca.uqam.inf2120.tp3.modele.AnnuaireTelephonique;
import ca.uqam.inf2120.tp3.modele.EmplacementBureau;
import ca.uqam.inf2120.tp3.modele.Employe;

public class ControllerInterfacePrincipale implements ActionListener {

	private AnnuaireTelephonique modele;
	private InterfacePrincipale vue;
	private List<Employe> listeEmploye;
	private boolean modeRefresh;
	private final String MESSAGE_MATRICULE = "Aucun(e) employe(e) avec la matricule ";

	// Constructeur avec la vue à controler comme paramètre
	public ControllerInterfacePrincipale(InterfacePrincipale uneVue) {
		this.modele = new AnnuaireTelephonique();
		vue = uneVue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Obtenir la source de l'événement.
		Object source = e.getSource();
		if (vue.getRdbtntousEmployes().isSelected()) {
			vue.getTxtRechercher().setText(null);
			vue.getTxtRechercher().setEditable(false);

		} else {
			vue.getTxtRechercher().setEditable(true);
		}
		if (source == vue.getBtnAjouter()) {
			AjouterEmploye JDialogAjoutEmploye = new AjouterEmploye(vue, true, modele);
			JDialogAjoutEmploye.setVisible(true);
		} else if (source == vue.getBtnRechercher()) {
			listeEmploye = new ArrayList<Employe>();
			// Appelle la fonction rechercher tous les employes
			if (vue.getRdbtntousEmployes().isSelected()) {
				listeEmploye = modele.rechercherToutesLesEmployes();

				// Message information si aucun employe trouvé
				if (listeEmploye != null && listeEmploye.isEmpty() && !modeRefresh) {

					JOptionPane.showMessageDialog(vue, "Veuillez remplir tout les champs", "champs manquants",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					vue.afficherResultats(listeEmploye);

				}

			} else {

				// Récupère la valeur saisie pour la recherche
				String valeurSaisie = "";
				valeurSaisie = vue.getTxtRechercher().getText();

				// Appeler la fonction Rechercher par matricule
				if (vue.getRdbtnMatricule().isSelected()) {

					listeEmploye = modele.rechercherParPrenomEmploye(valeurSaisie);
					// Message information si aucun pneu trouvé
					if (listeEmploye == null ) {

						JOptionPane.showMessageDialog(null, MESSAGE_MATRICULE + valeurSaisie + " !",
								"WARNING MATRICULE", JOptionPane.WARNING_MESSAGE);

					} else if (listeEmploye.isEmpty()) {

						JOptionPane.showMessageDialog(null, MESSAGE_MATRICULE + valeurSaisie + " !",
								"WARNING MATRICULE", JOptionPane.WARNING_MESSAGE);

					} else {
						vue.afficherResultats(listeEmploye);

					} // Appelle la fonction Rechercher par prenom
				} else if (vue.getRdbtnPrenom().isSelected()) {

					// Appelle la fonction Rechercher par nom
				} else if (vue.getRdbtnNom().isSelected()) {
					listeEmploye = modele.rechercherParNomEmploye(valeurSaisie);

					if (listeEmploye != null && !listeEmploye.isEmpty()) {

						String[] boutons = { "Fermer" };
						String information = "Aucun employe trouve" + " avec un nombre de pneus > " + valeurSaisie
								+ " !";

						JOptionPane.showOptionDialog(vue, information, "Message", JOptionPane.CLOSED_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null, boutons, boutons[0]);

					}
				}

			}

			// Appelle la fonction afficherResultats
			// de la fenêtre principale
			vue.afficherResultats(listeEmploye);
			modeRefresh = false;

		} else if (source == vue.getBtnAfficher()) {
			listeEmploye = new ArrayList<Employe>();
			vue.afficherResultats(listeEmploye);

		} else if (source == vue.getBtnModifier()) {

		} else if (source == vue.getBtnSupprimer()) {

		} else if (source == vue.getBtnFermer()) {
			System.exit(0);

		}

	}

	public AnnuaireTelephonique getModele() {
		return modele;
	}

	public void setModele(AnnuaireTelephonique modele) {
		this.modele = modele;
	}

	public InterfacePrincipale getVue() {
		return vue;
	}

	public void setVue(InterfacePrincipale vue) {
		this.vue = vue;
	}

	public boolean isModeRefresh() {
		return modeRefresh;
	}

	public void setModeRefresh(boolean modeRefresh) {
		this.modeRefresh = modeRefresh;
	}

}
