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

	// Constructeur avec la vue à controler comme paramètre
	public ControllerInterfacePrincipale(InterfacePrincipale uneVue) {

		modele = new AnnuaireTelephonique();
		vue = uneVue;

		Employe e1 = new Employe();
		EmplacementBureau Etage_Bureau = new EmplacementBureau(0, 0);
		e1.setMatricule("122");
		e1.setNom("arbia");
		e1.setAdresseCourriel("xxxx@yya.ca");
		e1.setPrenom("charfi");
		Etage_Bureau.setNumeroBureau(1);
		Etage_Bureau.setNumeroBureau(2);
		e1.setBureau(Etage_Bureau);

		Employe e2 = new Employe();
		Employe e3 = new Employe();
		EmplacementBureau Etage_Bureau2 = new EmplacementBureau(0, 2);
		e2.setMatricule("123");
		e2.setNom("arbia");
		e2.setAdresseCourriel("xxxx@yya.ca");
		e2.setPrenom("charfi");
		Etage_Bureau2.setNumeroBureau(1);
		Etage_Bureau2.setNumeroBureau(2);
		e3.setBureau(Etage_Bureau);
		e3.setMatricule("121");
		e3.setNom("arbia");
		e3.setAdresseCourriel("xxxx@yya.ca");
		e3.setPrenom("charfi");

		modele.ajouterEmploye(e1);
		modele.ajouterEmploye(e2);
		modele.ajouterEmploye(e3);

		System.out.println(modele.getListeDesEmployes().nbElements());

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
			vue.afficherResultats(listeEmploye);

			// Appelle la fonction rechercher tous les pneus
			if (vue.getRdbtntousEmployes().isSelected()) {
				listeEmploye = modele.rechercherToutesLesEmployes();

				// Message information si aucun pneu trouvé
				if (listeEmploye.isEmpty() && !modeRefresh) {

					String[] boutons = { "Fermer" };
					String information = "Aucun element dans la liste";

					JOptionPane.showOptionDialog(vue, information, "Message", JOptionPane.CLOSED_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, boutons, boutons[0]);

				}

			} else {

				// Récupère la valeur saisie pour la recherche
				String valeurSaisie = "";

				valeurSaisie = vue.getTxtRechercher().getText();

				// Appeler la fonction Rechercher par matricule
				if (vue.getRdbtnMatricule().isSelected()) {

					listeEmploye = modele.rechercherParMatricule(valeurSaisie);

					// Message information si aucun employe trouvé
					if (listeEmploye.isEmpty() && !modeRefresh) {

						String[] boutons = { "Fermer" };
						String information = "Aucun Employe n'est trouve avec la matricule " + valeurSaisie + " !";

						JOptionPane.showOptionDialog(vue, information, "Message", JOptionPane.CLOSED_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null, boutons, boutons[0]);
					}

					// Appelle la fonction Rechercher par prenom
				} else if (vue.getRdbtnPrenom().isSelected()) {
					listeEmploye = modele.rechercherParPrenomEmploye(valeurSaisie);
					// Message information si aucun pneu trouvé
					if (listeEmploye.isEmpty() && !modeRefresh) {

						String[] boutons = { "Fermer" };
						String information = "Aucun Employe n'est trouve avec la matricule  " + valeurSaisie + " !";

						JOptionPane.showOptionDialog(vue, information, "Message", JOptionPane.CLOSED_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null, boutons, boutons[0]);

					}

					// Appelle la fonction Rechercher par nom
				} else if (vue.getRdbtnNom().isSelected()) {
					listeEmploye = modele.rechercherParNomEmploye(valeurSaisie);

					if (listeEmploye.isEmpty() && !modeRefresh) {

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
