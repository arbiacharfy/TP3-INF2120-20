package ca.uqam.inf2120.tp3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ca.uqam.inf2120.tp3.interfacegraphiques.InterfacePrincipale;
import ca.uqam.inf2120.tp3.interfacegraphiques.SupprimerEmploye;
import ca.uqam.inf2120.tp3.modele.AnnuaireTelephonique;
import ca.uqam.inf2120.tp3.modele.Employe;


public class ControllerSupprimerEmploye implements ActionListener {
	// D�claration des attributs
	private SupprimerEmploye vue;
	private Employe employe;
	private AnnuaireTelephonique modele;
				
	// Constructeur avec la fenetreAfficher � contr�ler comme param�tre
	public ControllerSupprimerEmploye(SupprimerEmploye vue, Employe employe, AnnuaireTelephonique modele ) {		
		this.vue = vue;
		this.employe = employe;
		this.modele = modele;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == vue.getBoutonSupprimer()) {
			
			Employe nouveauEmploye = new Employe(employe.getMatricule(), employe.getNom(), employe.getPrenom(), employe.getAdresseCourriel(), employe.getNumeroTelephone(), employe.getBureau());
			
			// Remplace l'idenfiant du nouveau pneu
			nouveauEmploye.setMatricule(employe.getMatricule());
					
			// Appelle la fonction supprimer un pneu du gestionnaire
			modele.supprimerEmploye(nouveauEmploye);
			
			// Appelle la fonction rafra�chir de la fen�tre principale
			vue.dispose();
			((InterfacePrincipale) vue.getParent()).refresh();


		// Sinon si l'�v�nement a �t� g�n�r� par le bouton "Annuler"  
		} else if (source == vue.getBoutonAnnuler()) {
			vue.dispose();
		}

	}

}
