

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Fenêtre avec démonstration de positionnement des composants
 * dans un conteneur selon GridLayout..
 *  
 * Université du  Québec à Montréal
 * INF2120 - Programmation II   
 *    
 * @author Ismael Doukoure
 * @version Mars 2014
 * 
 */
public class FenetreGridLayout {

	public static void main(String[] args) {
		
       // Création de la fenêtre 
       JFrame fenetre = new JFrame("GridLayout ");
       
       // Définir la taille de la fenêtre et 
       // son positionnement sur lécran.
       fenetre.setBounds(400, 300, 300, 200);
       
       // Définir le gestionnaire de disposition
       GridLayout gridLayout = new GridLayout(5,2,13,13);
       
       // Ajouter le gestionnaire de disposition à la fenêtre
       fenetre.setLayout(gridLayout);
       
       // Définir le type de fermeture
       fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // Création des boutons 
       JButton bouton1  = new JButton("BOUTON 1");
       JButton bouton2  = new JButton("BOUTON 2");
       JButton bouton3  = new JButton("BOUTON 3");
       JButton bouton4  = new JButton("BOUTON 4");
      
       
       
     
       // Ajout des boutons à la fenêtre
       fenetre.add(bouton1);  
       fenetre.add(bouton2); 
       fenetre.add(bouton3); 
       fenetre.add(bouton4); 
      
      
      
       // Rendre visible la fenêtre
       fenetre.setVisible(true); 
      

	}
} // FenetreGridLayout

