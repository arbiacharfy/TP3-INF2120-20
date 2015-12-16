package ca.uqam.inf2120.tp3.controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.uqam.inf2120.tp3.interfacegraphiques.AjouterEmploye;
import ca.uqam.inf2120.tp3.interfacegraphiques.InterfacePrincipale;
import ca.uqam.inf2120.tp3.modele.AnnuaireTelephonique;
import ca.uqam.inf2120.tp3.modele.EmplacementBureau;
import ca.uqam.inf2120.tp3.modele.Employe;

public class ControllerAjouterEmploye implements ActionListener {
	private AjouterEmploye vue;
	private AnnuaireTelephonique modele;
	private InterfacePrincipale vu;
	

	public ControllerAjouterEmploye(AjouterEmploye uneVue, AnnuaireTelephonique modele) {

		vue = uneVue;
		this.modele = modele;
		//System.out.println(modele.getListeDesEmployes().nbElements());

	}

	@Override
	public void actionPerformed(ActionEvent e){
		vu = new InterfacePrincipale();
		ControllerInterfacePrincipale t = new ControllerInterfacePrincipale(vu);

		Object source = e.getSource();
		 if(source == vue.getBtnAjouter()) {			
			Employe e1 = new Employe();
			EmplacementBureau Etage_Bureau = new EmplacementBureau(0,0);
			e1.setMatricule(vue.getTextMatricule().getText());
			e1.setNom(vue.getTextNom().getText());
			e1.setAdresseCourriel(vue.getTextCourriel().getText());
			e1.setPrenom(vue.getTextPrenom().getText());
			Etage_Bureau.setNumeroBureau(Integer.parseInt(vue.getTextNumBureau().getText()));	
			Etage_Bureau.setNumeroBureau(Integer.parseInt(vue.getComboBoxNumEtage().getSelectedItem().toString()));
			e1.setBureau(Etage_Bureau);
					
			modele.ajouterEmploye(e1);
			
			
		

		}else  if(source == vue.getBtnAnnuler()) {
			System.out.println("annuler");			
		}

	}


}
