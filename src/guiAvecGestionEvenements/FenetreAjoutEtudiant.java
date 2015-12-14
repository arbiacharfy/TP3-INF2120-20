package guiAvecGestionEvenements;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * FenetreAjoutEtudiant : Fenêtre (JDialog) d'ajout d'un étudiant.
 * 
 * @author Ismael Doukoure
 * @version Avril 2014 
 * 
 */
public class FenetreAjoutEtudiant extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		FenetreAjoutEtudiant fenetreAjout = new FenetreAjoutEtudiant();
		fenetreAjout.setVisible(true);
		fenetreAjout.pack();
				
	}

	/**
	 * Create the frame.
	 */
	public FenetreAjoutEtudiant() {
		setTitle("Ajout - \u00C9tudiant");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHaut = new JPanel();
		contentPane.add(panelHaut, BorderLayout.CENTER);
		panelHaut.setLayout(new GridLayout(4, 2, 0, 8));
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setMaximumSize(new Dimension(23, 14));
		lblPrnom.setMinimumSize(new Dimension(23, 14));
		lblPrnom.setPreferredSize(new Dimension(23, 14));
		panelHaut.add(lblPrnom);
		
		textField = new JTextField();
		panelHaut.add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		panelHaut.add(lblNom);
		
		textField_1 = new JTextField();
		panelHaut.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCodePermanent = new JLabel("Code Permanent :");
		panelHaut.add(lblCodePermanent);
		
		textField_2 = new JTextField();
		panelHaut.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNombreDeCours = new JLabel("Nombre de cours :");
		panelHaut.add(lblNombreDeCours);
		
		textField_3 = new JTextField();
		panelHaut.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panelBas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBas.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelBas, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Soumettre");
		panelBas.add(btnNewButton);
		
		JButton btnAnnuler = new JButton("Annuler");
		panelBas.add(btnAnnuler);
	}

}
