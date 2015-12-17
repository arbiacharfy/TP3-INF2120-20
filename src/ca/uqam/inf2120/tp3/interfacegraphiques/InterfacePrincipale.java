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
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JLabel;

import javax.swing.JButton;

import javax.swing.JTextField;
import ca.uqam.inf2120.tp3.controller.ControllerInterfacePrincipale;
import ca.uqam.inf2120.tp3.modele.Employe;


@SuppressWarnings("serial")
public class InterfacePrincipale extends JFrame {

	private JPanel contentPane;
	private JButton btnModifier;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnAfficher;
	private JButton btnFermer;
	private JButton btnRechercher;
	private JTable jTableEmploye;
	private JRadioButton rdbtnMatricule;
	private JRadioButton rdbtntousEmployes;
	private JRadioButton rdbtnPrenom;
	private JRadioButton rdbtnNom;

	private DefaultTableModel modeleTableEmploye;
	private ControllerInterfacePrincipale RechercheControleur;
	private JScrollPane scrollPane;
	private JTextField txtRechercher;

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

		rdbtnMatricule = new JRadioButton("Matricule");
		panelTop.add(rdbtnMatricule);

		rdbtntousEmployes = new JRadioButton("Tous les employes");
		panelTop.add(rdbtntousEmployes);

		JLabel label = new JLabel("");
		panelTop.add(label);

		rdbtnPrenom = new JRadioButton("Prenom");
		panelTop.add(rdbtnPrenom);

		rdbtnNom = new JRadioButton("Nom");
		panelTop.add(rdbtnNom);

		JLabel label_1 = new JLabel("");
		panelTop.add(label_1);

		JPanel panelMiddle = new JPanel();
		panelMiddle.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelMiddle, BorderLayout.CENTER);
		panelMiddle.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel JPanelMiddleTop = new JPanel();
		panelMiddle.add(JPanelMiddleTop);

		txtRechercher = new JTextField();
		JPanelMiddleTop.add(txtRechercher);
		txtRechercher.setColumns(20);

		btnRechercher = new JButton("Rechercher");
		JPanelMiddleTop.add(btnRechercher);

		JPanel JPanelTable = new JPanel();
		panelMiddle.add(JPanelTable);

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
		btnAjouter.addActionListener(RechercheControleur);
		btnModifier.addActionListener(RechercheControleur);
		btnSupprimer.addActionListener(RechercheControleur);
		btnAfficher.addActionListener(RechercheControleur);
		btnFermer.addActionListener(RechercheControleur);
		btnRechercher.addActionListener(RechercheControleur);

		// jTableEmploye.addActionListener(RechercheControleur);

		modeleTableEmploye = new DefaultTableModel() {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			};
		};
		modeleTableEmploye.addColumn("Matricule");
		modeleTableEmploye.addColumn("Nom et Prenom");
		modeleTableEmploye.addColumn("Telephone");
		modeleTableEmploye.addColumn("Numero d'etage");
		modeleTableEmploye.addColumn("Numero de Bureau");

		jTableEmploye = new JTable(modeleTableEmploye);
		jTableEmploye.getTableHeader().setReorderingAllowed(false);
		jTableEmploye.getColumnModel().getColumn(0).setPreferredWidth(275);
		scrollPane = new JScrollPane(jTableEmploye);
		scrollPane.setVisible(false);

		JPanelTable.add(scrollPane);
		// Définir le type de fermeture
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public JButton getBtnRechercher() {
		return btnRechercher;
	}

	public void setBtnRechercher(JButton btnRechercher) {
		this.btnRechercher = btnRechercher;
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

	public JTable getjTableEmploye() {
		return jTableEmploye;
	}

	public void setjTableEmploye(JTable jTableEmploye) {
		this.jTableEmploye = jTableEmploye;
	}

	public DefaultTableModel getModeleTableEmploye() {
		return modeleTableEmploye;
	}

	public void setModeleTableEmploye(DefaultTableModel modeleTableEmploye) {
		this.modeleTableEmploye = modeleTableEmploye;
	}

	public ControllerInterfacePrincipale getRechercheControleur() {
		return RechercheControleur;
	}

	public void setRechercheControleur(ControllerInterfacePrincipale rechercheControleur) {
		RechercheControleur = rechercheControleur;
	}
	
	

	public JRadioButton getRdbtnMatricule() {
		return rdbtnMatricule;
	}

	public void setRdbtnMatricule(JRadioButton rdbtnMatricule) {
		this.rdbtnMatricule = rdbtnMatricule;
	}

	public JRadioButton getRdbtntousEmployes() {
		return rdbtntousEmployes;
	}

	public void setRdbtntousEmployes(JRadioButton rdbtntousEmployes) {
		this.rdbtntousEmployes = rdbtntousEmployes;
	}

	public JRadioButton getRdbtnPrenom() {
		return rdbtnPrenom;
	}

	public void setRdbtnPrenom(JRadioButton rdbtnPrenom) {
		this.rdbtnPrenom = rdbtnPrenom;
	}

	public JRadioButton getRdbtnNom() {
		return rdbtnNom;
	}

	public void setRdbtnNom(JRadioButton rdbtnNom) {
		this.rdbtnNom = rdbtnNom;
	}

	// Rafraîchir la liste des résultats
	public void refresh() {
		// Active le mode refresh
		RechercheControleur.setModeRefresh(true);
		// Crée un nouvel évènement et l'envoie à l'écouteur
		ActionEvent event = new ActionEvent(btnRechercher, 0, null);
		this.RechercheControleur.actionPerformed(event);
	}
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		InterfacePrincipale frame = new InterfacePrincipale();
		frame.setVisible(true);

	}
	
//	jTableEmploye = new JTable(modeleTableEmploye);
	// Afficher la liste des résultats
		public void afficherResultats(List<Employe> liste) {
			
			if (liste.isEmpty()) {
				
				// Suppression de toutes les lignes du tableau
				while (modeleTableEmploye.getRowCount() != 0) {
					modeleTableEmploye.removeRow(0);
				}
				
				// Rend non visible le tableau et les boutons
				// Modifier, Supprimer, Afficher
				scrollPane.setVisible(false);
				btnModifier.setEnabled(false);
				btnSupprimer.setEnabled(false);
				btnAfficher.setEnabled(false);
				
			} else {
				
				// Ajout de chaque ligne de la liste 
				// de résultats dans le tableau
				Locale.setDefault(new Locale("en", "US"));
				DecimalFormat df = new DecimalFormat("##.00");
				
				for (Employe p : liste) {
					Object[] ligne = { p.getMatricule(), 
										p.getNom()+" "+p.getPrenom(),
										p.getNumeroTelephone(),
										p.getBureau().getNumeroEtage(),
										p.getBureau().getNumeroBureau() };
					
					modeleTableEmploye.addRow(ligne);
				}
				
				// Rend visible le tableau et les boutons
				// Modifier, Supprimer, Afficher
				jTableEmploye.setRowSelectionInterval(0, 0);
				scrollPane.setVisible(true);
				btnModifier.setEnabled(true);
				btnSupprimer.setEnabled(true);
				btnAfficher.setEnabled(true);	
			}
		}

}