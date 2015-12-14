package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AfficherEmploye extends JDialog {

	JPanel panneauGlobal ;
	String titre = "Media Pour Tous - Ajout d'un employe";
	
	private JTextField textMatricule;
	private JTextField textPrenom;
	private JTextField textNom;
	private JTextField textTelephone;
	private JTextField textCourriel;
	
	JComboBox<String> comboBoxNumEtage;
	private JTextField textNumBureau;
	
	AfficherEmploye(){
				
		// information sur la fenetre
		setTitle("Media Pour Tous - Affichage d'un employe"); // titre de la fenetre
		setBounds(100,100,500,500);// dimension
		// panneau Global : contient deux pannel
		panneauGlobal = new JPanel();
		setContentPane(panneauGlobal);
		panneauGlobal.setLayout(new BorderLayout(0, 0));
		
		
		// panneau top
		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(new TitledBorder("Informations de l'Etudiant"));
		panneauGlobal.add(panelHaut, BorderLayout.CENTER);
		panelHaut.setLayout(new GridLayout(7, 2, 0, 0));
		// Matricule
		JLabel lblCodePermanent = new JLabel("Code Permanent :");
		panelHaut.add(lblCodePermanent);
		
		textMatricule = new JTextField();
		textMatricule.setEditable(false);
		panelHaut.add(textMatricule);
		textMatricule.setColumns(10);
		
		// Prenom
		JLabel lblPrenom = new JLabel("Prenom :");
		panelHaut.add(lblPrenom);
		
		textPrenom = new JTextField();
		textPrenom.setEditable(false);
		panelHaut.add(textPrenom);
		textPrenom.setColumns(10);
		
		// Nom
		JLabel lblNom = new JLabel("Nom :");
		panelHaut.add(lblNom);
		
		textNom = new JTextField();
		textNom.setEditable(false);
		panelHaut.add(textNom);
		textNom.setColumns(10);
		//Telephone
		JLabel lblTelephone = new JLabel("Telephone :");
		panelHaut.add(lblTelephone);
		
		textTelephone = new JTextField();
		textTelephone.setEditable(false);
		panelHaut.add(textTelephone);
		textTelephone.setColumns(10);
		//Courriel
		JLabel lblCourriel = new JLabel("Courriel :");
		panelHaut.add(lblCourriel);
		
		textCourriel = new JTextField();
		textCourriel.setEditable(false);
		panelHaut.add(textCourriel);
		textCourriel.setColumns(10);
		//Numero Etage
		JLabel lblNumEtage = new JLabel("Numero Etage :");
		panelHaut.add(lblNumEtage);
		
		comboBoxNumEtage =  new JComboBox<String>();
		comboBoxNumEtage.setModel(new DefaultComboBoxModel<String>(new String[] {"01 ", "02", " 03"}));
		panelHaut.add(comboBoxNumEtage);
				
		
		//Numero Bureau
		
		JLabel lblNumBureau = new JLabel("Numero de Bureau :");
		panelHaut.add(lblNumBureau);
		
		textNumBureau = new JTextField();
		textNumBureau.setEditable(false);
		panelHaut.add(textNumBureau);
		textNumBureau.setColumns(10);
		// panneau bottom
		JPanel panelBas = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBas.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panneauGlobal.add(panelBas, BorderLayout.SOUTH);
		
		JButton btnFermer = new JButton("Fermer");
		panelBas.add(btnFermer);
		
		
		
		
	}
	
	/**
	 * Launch the application.
	 */
	public  void runJDialogModifierEmploye() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherEmploye monDialog = new AfficherEmploye();
					monDialog.setModal(true);
					monDialog.setVisible(true);
					monDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					monDialog.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	

}
