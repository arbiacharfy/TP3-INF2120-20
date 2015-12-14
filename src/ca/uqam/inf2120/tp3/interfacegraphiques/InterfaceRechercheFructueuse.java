package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import ca.uqam.inf2120.tp3.modele.AnnuaireTelephonique;
import ca.uqam.inf2120.tp3.modele.Employe;

@SuppressWarnings("serial")
public class InterfaceRechercheFructueuse extends JFrame {

	private JPanel contentPane;
	private JTextField txtRechercher;
	private JButton btnModifier;
	private JButton btnRechercher;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnAfficher;
	
	AnnuaireTelephonique monAnnuaire ;
	List<Employe> maListeEmploye ;
	Employe e1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceRechercheFructueuse frame = new InterfaceRechercheFructueuse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceRechercheFructueuse() {
		e1 = new Employe();
		maListeEmploye = new ArrayList<Employe>();
		monAnnuaire = new AnnuaireTelephonique();
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
		
		btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMatricule.isSelected()){
					
					e1 = monAnnuaire.rechercheParMatricule(txtRechercher.getText()) ;
					if(e1 == null){
						
						JOptionPane.showMessageDialog(null,
								 "Aucune information ne correspond a votre recherche",
								 "INFORMATION",
								 JOptionPane.INFORMATION_MESSAGE); 
					}
				}
				
				
			}
		});
		panelMiddle.add(btnRechercher);
		
		JPanel panelBottom = new JPanel();
		contentPane.add(panelBottom, BorderLayout.SOUTH);
		panelBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AjouterEmploye JDialogAjoutEmploye = new AjouterEmploye();
				JDialogAjoutEmploye.runJDialogAjoutEmploye();
				
			}
		});
		panelBottom.add(btnAjouter);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ModifierEmploye JDialogAjoutEmploye = new ModifierEmploye();
				JDialogAjoutEmploye.runJDialogModifierEmploye();
				
			}
		});
		btnModifier.setEnabled(false);
		panelBottom.add(btnModifier);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSupprimer.setEnabled(false);
		panelBottom.add(btnSupprimer);
		
		btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AfficherEmploye JDialogAfficherEmploye = new AfficherEmploye();
				JDialogAfficherEmploye.runJDialogModifierEmploye();
				
			}
		});
		btnAfficher.setEnabled(false);
		panelBottom.add(btnAfficher);
		
		JButton btnFermer = new JButton("Fermer");
		panelBottom.add(btnFermer);
	}

}