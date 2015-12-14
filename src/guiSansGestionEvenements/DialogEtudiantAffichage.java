package guiSansGestionEvenements;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

/**
 * DialogEtudiantAffichage : Fenêtre (JDialog) d'affichage d'un étudiant 
 * avec les champs non éditables.
 * 
 * @author Ismael Doukoure
 * @version Avril 2014 
 * 
 */
public class DialogEtudiantAffichage extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCosf;
	private JTextField txtCostin;
	private JTextField txtFrederic;
	private JTextField textField_2;

	/**
	 *Créer un dialogue et le rendre visible.
	 */
	public static void main(String[] args) {
		

			DialogEtudiantAffichage frame = new DialogEtudiantAffichage();
			frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		
		
	}

	/**
	 * Create the frame.
	 */
	public DialogEtudiantAffichage() {
		setTitle("\u00C9tudiant - Affichage");
		setBounds(100, 100, 340, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informations de l'\u00E9tudiant", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelHaut, BorderLayout.CENTER);
		panelHaut.setLayout(new GridLayout(5, 2, 0, 5));
		
		JLabel lblCodePermanent = new JLabel("Code Permanent :");
		panelHaut.add(lblCodePermanent);
		
		txtCosf = new JTextField();
		txtCosf.setEditable(false);
		txtCosf.setText("COSF1202199001");
		panelHaut.add(txtCosf);
		txtCosf.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		panelHaut.add(lblNom);
		
		txtCostin = new JTextField();
		txtCostin.setEditable(false);
		txtCostin.setText("Costin");
		panelHaut.add(txtCostin);
		txtCostin.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom :");
		panelHaut.add(lblPrenom);
		
		txtFrederic = new JTextField();
		txtFrederic.setEditable(false);
		txtFrederic.setText("Frederic");
		panelHaut.add(txtFrederic);
		txtFrederic.setColumns(10);
		
		JLabel lblNbCours = new JLabel("Nombre de cours :");
		panelHaut.add(lblNbCours);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("5");
		panelHaut.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblProgramme = new JLabel("Code / Titre Programme :");
		panelHaut.add(lblProgramme);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"7316 - Baccalaur\u00E9at en informatique et g\u00E9nie logiciel ", "4702 - Certificat en informatique et en d\u00E9veloppement de logiciel", " Ajouter ou Modifier un programmme"}));
		panelHaut.add(comboBox);
		
		JPanel panelBas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBas.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelBas, BorderLayout.SOUTH);
		
		JButton btnFermer = new JButton("Fermer");
		panelBas.add(btnFermer);
	}

}
