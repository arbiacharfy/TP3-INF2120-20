package ca.uqam.inf2120.tp3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.uqam.inf2120.tp3.interfacegraphiques.AjouterEmploye;
import ca.uqam.inf2120.tp3.interfacegraphiques.InterfacePrincipale;
import ca.uqam.inf2120.tp3.modele.AnnuaireTelephonique;
import ca.uqam.inf2120.tp3.modele.Employe;

public class ControllerAjouterEmploye implements ActionListener {
	private AjouterEmploye vue;
	private InterfacePrincipale vue1;
	private ControllerRecherche ctr;

	public ControllerAjouterEmploye(AjouterEmploye uneVue) {
			
		this.vue = uneVue;
		ctr = new ControllerRecherche(vue1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 Object source = e.getSource();
		
		if(source == vue.getBtnAjouter()){
			Employe e1 = new Employe();
			e1.setMatricule(vue.getTextMatricule().getText());
			e1.setNom(vue.getTextNom().getText());
			
        	ctr.getModele().getListeDesEmployes().ajouterDebut(e1);
        	
        }

		

	}

}
