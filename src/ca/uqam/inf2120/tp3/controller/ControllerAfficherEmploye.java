package ca.uqam.inf2120.tp3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ca.uqam.inf2120.tp3.interfacegraphiques.AfficherEmployer;

public class ControllerAfficherEmploye implements ActionListener {
	// D�claration des attributs
	private AfficherEmployer fenetre;
				
	// Constructeur avec la fenetreAfficher � contr�ler comme param�tre
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
