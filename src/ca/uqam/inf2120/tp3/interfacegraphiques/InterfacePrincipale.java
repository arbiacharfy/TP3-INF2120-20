package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;


import java.awt.GridLayout;
import javax.swing.JLabel;

import javax.swing.JButton;

import javax.swing.JTextField;
import ca.uqam.inf2120.tp3.controller.ControllerInterfacePrincipale;


@SuppressWarnings("serial")
public class InterfacePrincipale extends JFrame {



	private JPanel contentPane;
	private JTextField txtRechercher;
	private JButton btnModifier;
	private JButton btnRechercher;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnAfficher;
	private JButton btnFermer;
	private JTable tableEtudiants;
	private ControllerInterfacePrincipale RechercheControleur;
	private JScrollPane scrollPane;



	/**
	 * Create the frame.
	 */
	public InterfacePrincipale() {
	

	
		

			setTitle("Media Pour Tous (MPT) Annuaire Telephonique");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 624, 346);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(2, 2));

			JPanel panelTop = new JPanel();
			panelTop.setBorder(new TitledBorder(null, "Recherche", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPane.add(panelTop, BorderLayout.NORTH);
			panelTop.setLayout(new GridLayout(0, 3, 0, 0));

			JRadioButton rdbtnMatricule = new JRadioButton("Matricule");
			panelTop.add(rdbtnMatricule);

			JRadioButton rdbtntousEmployes = new JRadioButton("Tous les employes");
			panelTop.add(rdbtntousEmployes);

			JLabel label = new JLabel("");
			panelTop.add(label);

			JRadioButton rdbtnPrenom = new JRadioButton("Prenom");
			panelTop.add(rdbtnPrenom);

			JRadioButton rdbtnNom = new JRadioButton("Nom");
			panelTop.add(rdbtnNom);

			JLabel label_1 = new JLabel("");
			panelTop.add(label_1);

			JPanel panelMiddle = new JPanel();
			panelMiddle.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPane.add(panelMiddle, BorderLayout.CENTER);

			txtRechercher = new JTextField();
			panelMiddle.add(txtRechercher);
			txtRechercher.setColumns(20);
			scrollPane = new JScrollPane(tableEtudiants);
			scrollPane.setPreferredSize(new Dimension(481, 120));
			//panelMiddle.add(tableEtudiants);
			btnRechercher = new JButton("Rechercher");
			panelMiddle.add(btnRechercher);
			
			JPanel panelBottom = new JPanel();
			contentPane.add(panelBottom, BorderLayout.SOUTH);
			panelBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

			btnAjouter = new JButton("Ajouter");
			panelBottom.add(btnAjouter);

			btnModifier = new JButton("Modifier");
			btnModifier.setEnabled(false);
			panelBottom.add(btnModifier);
			btnSupprimer = new JButton("Supprimer");
			btnSupprimer.setEnabled(false);
			panelBottom.add(btnSupprimer);

			btnAfficher = new JButton("Afficher");
			btnAfficher.setEnabled(false);
			panelBottom.add(btnAfficher);

			btnFermer = new JButton("Fermer");
			panelBottom.add(btnFermer);
			
			// Création du controleur (Controller du MVC)
			RechercheControleur = new ControllerInterfacePrincipale(this);

			// Ajouter le controleur (écouteur) aux composants
			btnRechercher.addActionListener(RechercheControleur);
			btnAjouter.addActionListener(RechercheControleur);
			btnModifier.addActionListener(RechercheControleur);
			btnSupprimer.addActionListener(RechercheControleur);		
			btnAfficher.addActionListener(RechercheControleur);
			btnFermer.addActionListener(RechercheControleur);
		}

	public JTextField getTxtRechercher() {
		return txtRechercher;
	}

	public void setTxtRechercher(JTextField txtRechercher) {
		this.txtRechercher = txtRechercher;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}

	public JButton getBtnRechercher() {
		return btnRechercher;
	}

	public void setBtnRechercher(JButton btnRechercher) {
		this.btnRechercher = btnRechercher;
	}

	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public JButton getBtnAfficher() {
		return btnAfficher;
	}

	public void setBtnAfficher(JButton btnAfficher) {
		this.btnAfficher = btnAfficher;
	}

	public JButton getBtnFermer() {
		return btnFermer;
	}

	public void setBtnFermer(JButton btnFermer) {
		this.btnFermer = btnFermer;
	}

	public JTable getTableEtudiants() {
		return tableEtudiants;
	}

	public void setTableEtudiants(JTable tableEtudiants) {
		this.tableEtudiants = tableEtudiants;
	}
	
	public ControllerInterfacePrincipale getRechercheControleur() {
		return RechercheControleur;
	}

	public void setRechercheControleur(ControllerInterfacePrincipale rechercheControleur) {
		RechercheControleur = rechercheControleur;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePrincipale frame = new InterfacePrincipale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}