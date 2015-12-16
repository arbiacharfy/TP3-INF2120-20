package ca.uqam.inf2120.tp3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ca.uqam.inf2120.tp1.adt.GroupeTda;
import ca.uqam.inf2120.tp3.interfacegraphiques.AfficherEmploye;
import ca.uqam.inf2120.tp3.interfacegraphiques.AjouterEmploye;
import ca.uqam.inf2120.tp3.interfacegraphiques.InterfacePrincipale;
import ca.uqam.inf2120.tp3.interfacegraphiques.ModifierEmploye;
import ca.uqam.inf2120.tp3.modele.AnnuaireTelephonique;
import ca.uqam.inf2120.tp3.modele.Employe;
import mvc.CompteurModele;
import mvc.CompteurVue;

public class ControllerRecherche implements ActionListener {
	
	private AnnuaireTelephonique modele;
	
	private InterfacePrincipale vue;
    // Constructeur avec la vue à controler comme paramètre
//    CompteurControleur(CompteurVue uneVue){
//        this.modele = new CompteurModele();
//        vue = uneVue ;
//        vue.refresh(modele.getValeur());
//      }

	public ControllerRecherche(InterfacePrincipale uneVue) {
		
		this.modele = new AnnuaireTelephonique();
		this.vue = uneVue;
//		vue.refresh(modele.getValeur());
	}
	public static JTable creerJTable(GroupeTda<Employe> liste){
		
		System.out.println("Je suis ICI");

		//On crée une entête et des champs vides
		 String[] entete = {"Matricule", "Nom et Prénom", "Téléphone", "No Étage", "No Bureau"};
		 Object[][] data = null;

		// Si la liste n'est pas vide
		// on met tous les éléments dans notre JTable à 2 dimensions
		 System.out.println(liste == null);
		 System.out.println(liste.estVide());
		 
		if(liste.estVide()){
			System.out.println("table vide");

		//On crée le tableau statique
		data = new Object[liste.nbElements()][5];
		//On met tous les éléments
		 Iterator<Employe> iter = liste.iterateur();
		int index = 0;
		while(iter.hasNext()){
		 Employe employe = iter.next();
		 data[index][0] = employe.getMatricule();
		 data[index][1] = employe.getNom() + " " + employe.getPrenom();
		 data[index][2] = employe.getNumeroTelephone();
		 data[index][3] = employe.getBureau().getNumeroEtage();
		 data[index][4] = employe.getBureau().getNumeroBureau();
		 index++;
		 }
		 }
		
		 DefaultTableModel modele = new DefaultTableModel(data, entete);
		return new JTable(modele);
		 } 


	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Obtenir la source de l'événement.
        Object source = e.getSource();
        if(source == vue.getBtnAjouter()) {
        	
        	AjouterEmploye JDialogAjoutEmploye = new AjouterEmploye();
        	JDialogAjoutEmploye.runJDialogAjoutEmploye();        	
//        	// Appeler la fonction "incrementer"
//        	// du modèle
//        	modele.ajouterEmploye();
//        	// Rafraichir la vue
        
//        	vue.refresh(modele.getValeur());
//        
//          // Sinon si l'événement a été généré par le bouton
//          // "Initialiser"
        	System.out.println(modele.getListeDesEmployes().nbElements());
        }else  if(source == vue.getBtnRechercher()){
        	vue.setTableEtudiants(creerJTable(modele.getListeDesEmployes()));
       	vue.getTableEtudiants().setVisible(true);
       	
        	
        }else if(source == vue.getBtnAfficher()){
        	
        	AfficherEmploye JDialogAfficherEmploye = new AfficherEmploye();
        	
        	
        	
        	
        }else if(source == vue.getBtnModifier()){
        	
        	
        }else if(source == vue.getBtnSupprimer()){
        	
        	
        }else if(source == vue.getBtnFermer()){
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
	
	


}
