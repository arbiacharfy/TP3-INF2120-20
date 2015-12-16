package ca.uqam.inf2120.tp3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ca.uqam.inf2120.tp3.modele.*;
import ca.uqam.inf2120.tp3.interfacegraphiques.*;

public class Controller {
	private AnnuaireTelephonique model;
	private InterfacePrincipale view;
	private ActionListener actionListener;

	public Controller(AnnuaireTelephonique model, InterfacePrincipale view) {
		this.model = model;
		this.view = view;

	}

	public Controller() {
		
		
//	    public void contol(){        
//	        actionListener = new ActionListener() {
//	              public void actionPerformed(ActionEvent actionEvent) {                  
//	                  linkBtnAndLabel();
//	              }
//	        };                
//	        view.getButton().addActionListener(actionListener);   
//	    }
//	    
//	    private void linkBtnAndLabel(){
//	        model.incX();                
//	        view.setText(Integer.toString(model.getX()));
//	    } 
//
	}

}
