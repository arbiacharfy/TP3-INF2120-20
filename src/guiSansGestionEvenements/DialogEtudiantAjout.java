package guiSansGestionEvenements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * DialogEtudiantAjout : Fenêtre (JDialog) d'ajout d'un étudiant.
 * 
 * @author Ismael Doukoure
 * @version Avril 2014 
 * 
 */
public class DialogEtudiantAjout extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	JComboBox<String> comboBox;

	/**
	 *Créer un dialogue et le rendre visible.
	 */
	public static void main(String[] args) {
		
			DialogEtudiantAjout frame = new DialogEtudiantAjout();
			frame.setModal(true);
			frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
	
		
	}

	/**
	 * Create the frame.
	 */
	public DialogEtudiantAjout() {
		setTitle("\u00C9tudiant - Ajout");
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
		
		textField = new JTextField();
		panelHaut.add(textField);
		textField.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom :");
		panelHaut.add(lblNom);
		
		textField_1 = new JTextField();
		panelHaut.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Pr\u00E9nom :");
		panelHaut.add(lblPrenom);
		
		textField_3 = new JTextField();
		panelHaut.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNbCours = new JLabel("Nombre de cours :");
		panelHaut.add(lblNbCours);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		panelHaut.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblProgramme = new JLabel("Code / Titre Programme :");
		panelHaut.add(lblProgramme);
		
		comboBox = new JComboBox<String>();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"7316 - Baccalaur\u00E9at en informatique et g\u00E9nie logiciel ", "4702 - Certificat en informatique et en d\u00E9veloppement de logiciel", " Ajouter un programmme"}));
		panelHaut.add(comboBox);
		
		JPanel panelBas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBas.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelBas, BorderLayout.SOUTH);
		
		JButton btnAjouter = new JButton("Ajouter");
		panelBas.add(btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		panelBas.add(btnAnnuler);
	}

}
