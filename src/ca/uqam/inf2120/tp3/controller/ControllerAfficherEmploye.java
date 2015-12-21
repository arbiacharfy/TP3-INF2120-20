package ca.uqam.inf2120.tp3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ca.uqam.inf2120.tp3.interfacegraphiques.AfficherEmployer;

public class ControllerAfficherEmploye implements ActionListener {
	// Déclaration des attributs
	private AfficherEmployer fenetre;
				
	// Constructeur avec la fenetreAfficher à contrôler comme paramètre
	public ControllerAfficherEmploye(AfficherEmployer uneFenetre) {		
		fenetre = uneFenetre ;	
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source == fenetre.getBtnFermer()) {
		   	fenetre.dispose();
		}
	}

}
