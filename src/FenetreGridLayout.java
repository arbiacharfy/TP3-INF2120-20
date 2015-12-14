

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Fen�tre avec d�monstration de positionnement des composants
 * dans un conteneur selon GridLayout..
 *  
 * Universit� du  Qu�bec � Montr�al
 * INF2120 - Programmation II   
 *    
 * @author Ismael Doukoure
 * @version Mars 2014
 * 
 */
public class FenetreGridLayout {

	public static void main(String[] args) {
		
       // Cr�ation de la fen�tre 
       JFrame fenetre = new JFrame("GridLayout ");
       
       // D�finir la taille de la fen�tre et 
       // son positionnement sur l�cran.
       fenetre.setBounds(400, 300, 300, 200);
       
       // D�finir le gestionnaire de disposition
       GridLayout gridLayout = new GridLayout(5,2,13,13);
       
       // Ajouter le gestionnaire de disposition � la fen�tre
       fenetre.setLayout(gridLayout);
       
       // D�finir le type de fermeture
       fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // Cr�ation des boutons 
       JButton bouton1  = new JButton("BOUTON 1");
       JButton bouton2  = new JButton("BOUTON 2");
       JButton bouton3  = new JButton("BOUTON 3");
       JButton bouton4  = new JButton("BOUTON 4");
      
       
       
     
       // Ajout des boutons � la fen�tre
       fenetre.add(bouton1);  
       fenetre.add(bouton2); 
       fenetre.add(bouton3); 
       fenetre.add(bouton4); 
      
      
      
       // Rendre visible la fen�tre
       fenetre.setVisible(true); 
      

	}
} // FenetreGridLayout

