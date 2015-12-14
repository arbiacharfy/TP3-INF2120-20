package guiAvecGestionEvenements;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Inventaire : Gestion de l'inventaire.
 * 
 * @author Ismael Doukoure
 * @version Avril 2008
 * Modifié en Avril 2014
 * 
 */
@SuppressWarnings("serial")
public class FenetreInventaire extends JFrame implements ActionListener {

	
	JTextField nbCaisses;
	JTextField piecesParCaisses;
	JTextField total;

	JButton boutonCalculer;

	public FenetreInventaire() {
		
		JLabel etiqNbCaisses = new JLabel("Nombre de caisses: ");
		JLabel etiqPiecesCaisses = new JLabel("Pièces par caisses: ");
		JLabel etiqTotal = new JLabel("Total:");

		
		nbCaisses = new JTextField(4);
		nbCaisses.setHorizontalAlignment(JTextField.RIGHT);
		nbCaisses.setText("0");

		piecesParCaisses = new JTextField(4);
		piecesParCaisses.setHorizontalAlignment(JTextField.RIGHT);
		piecesParCaisses.setText("0");
		
		total = new JTextField(5);
		total.setHorizontalAlignment(JTextField.RIGHT);
		total.setText("0");
		total.setEditable(false);
		

		boutonCalculer = new JButton("Calculer");
		boutonCalculer.addActionListener(this);

		setTitle("Inventaire");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(etiqNbCaisses);
		add(nbCaisses);
		add(etiqTotal);
		add(total);
		add(etiqPiecesCaisses);
		add(piecesParCaisses);
		add(boutonCalculer);
		setBounds(100, 100, 300, 100);
		setVisible(true);

	}

	
	// Gestion des événements
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		if (source == boutonCalculer) {
			calculerTotal();
		}
		


	}


	/**
	 * Calculer le total selon le nombre de caisses et de pièces saisies.
	 * 
	 */
	private void calculerTotal() {
		
		try {
			
			float nbCaisse = Float.parseFloat(nbCaisses.getText().trim());
			float nbPieces = Float.parseFloat(piecesParCaisses.getText().trim());
			if (nbCaisse < 0 || nbPieces < 0) {
				JOptionPane.showMessageDialog(null, "Aucune valeur négative n'est permise !",
						"Message d'erreur", JOptionPane.ERROR_MESSAGE);
			} else {

			    total.setText("" + nbCaisse * nbPieces);
			}

		} catch (NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Le texte saisi n'est pas numérique !",
					"Message d'erreur", JOptionPane.ERROR_MESSAGE);
		}

	}

	// Main
	public static void main(String[] args) {
		new FenetreInventaire();
	}
}
