package guiAvecGestionEvenements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * FenetreRechercheEtudiants : Fenêtre (JFrame) de recherche d’étudiant avec des
 * étudiants dans la liste .
 * 
 * @author Ismael Doukoure
 * @version Avril 2014
 * 
 */
public class FenetreRechercheEtudiants extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable tableEtudiants;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		FenetreRechercheEtudiants fenetreRecherche = new FenetreRechercheEtudiants();
		fenetreRecherche.setVisible(true);
			
	}

	/**
	 * Constructeurs
	 */
	public FenetreRechercheEtudiants() {
		
		setTitle("Recherche - \u00C9tudiant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panelHaut = new JPanel();
		panelHaut.setBorder(new TitledBorder(null, "Recherche par : ", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelHaut);
		panelHaut.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pr\u00E9nom");
		rdbtnNewRadioButton.setSelected(true);
		panelHaut.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNom = new JRadioButton("Nom");
		panelHaut.add(rdbtnNom);
		
		JRadioButton rdbtnCodePermanent = new JRadioButton("Code Permanent");
		panelHaut.add(rdbtnCodePermanent);
		
		JRadioButton rdbtnNombreDeCours = new JRadioButton(" >= Nombre de Cours");
		panelHaut.add(rdbtnNombreDeCours);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNom);
		buttonGroup.add(rdbtnCodePermanent);
		buttonGroup.add(rdbtnNombreDeCours);
		
		JPanel panelCenter = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelCenter.getLayout();
		flowLayout_1.setVgap(15);
		contentPane.add(panelCenter);
		
		textField = new JTextField();
		panelCenter.add(textField);
		textField.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		panelCenter.add(btnRechercher);
		
		JPanel panelTable = new JPanel();
		panelTable.setPreferredSize(new Dimension(10, 15));
		panelTable.setOpaque(true);
		contentPane.add(panelTable);
		
		tableEtudiants = new JTable();
		tableEtudiants.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableEtudiants.setFillsViewportHeight(true);
		tableEtudiants.setPreferredScrollableViewportSize(new Dimension(479, 70));
		tableEtudiants.setModel(creerModeleAvecColonnesNonEditables());
		tableEtudiants.setRowSelectionInterval(0, 0);
		
		tableEtudiants.getColumnModel().getColumn(0).setResizable(false);
		tableEtudiants.getColumnModel().getColumn(1).setResizable(false);
		tableEtudiants.getColumnModel().getColumn(1).setPreferredWidth(65);
		tableEtudiants.getColumnModel().getColumn(2).setResizable(false);
		tableEtudiants.getColumnModel().getColumn(2).setPreferredWidth(92);
		tableEtudiants.getColumnModel().getColumn(3).setResizable(false);
		
		JScrollPane scrollPane = new JScrollPane(tableEtudiants);
		scrollPane.setPreferredSize(new Dimension(481, 60));
		panelTable.add(scrollPane);
		
		JPanel panelBoutons = new JPanel();
		FlowLayout fl_panelBoutons = (FlowLayout) panelBoutons.getLayout();
		fl_panelBoutons.setVgap(20);
		fl_panelBoutons.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelBoutons);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FenetreAjoutEtudiant fenetreAjout = new FenetreAjoutEtudiant();
				fenetreAjout.setVisible(true);
				fenetreAjout.pack();
			}
		});
		panelBoutons.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		panelBoutons.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		panelBoutons.add(btnSupprimer);
		
		JButton btnFermer = new JButton("Fermer");
		panelBoutons.add(btnFermer);
		
	}

	@SuppressWarnings("serial")
	/**
	 * Créer le modèle avec les colonnes non éditables.
	 * 
	 * @return LE modèle de la table.
	 */
	private DefaultTableModel creerModeleAvecColonnesNonEditables() {
		return new DefaultTableModel(
			new Object[][] {
				{"Ismael", "Doukoure", "DOUI01010101", "3"},
				{"Fr\u00E9d\u00E9ric", "Costin", "COSF02020202", "2"},
				{"Naila", "H\u00E9raux", "HERN03030303", "4"},
				{"Moussa", "Fakoly", "FAKM09090911", null},
			}, new String[] {
				"Pr\u00E9nom", "Nom", "Code Permanent", "Nb. de cours"
			}) {
				boolean[] columnEditables = new boolean[] { false, false, false, false };
				
			    public boolean isCellEditable(int row, int column) {
				     return columnEditables[column];
			    }
		};
	}

}
