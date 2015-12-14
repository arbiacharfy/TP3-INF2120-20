package ca.uqam.inf2120.tp3.interfacegraphiques;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;


import javax.swing.JRadioButton;
import javax.swing.border.Border;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Component;
import javax.swing.border.LineBorder;


public class InterfaceDeRecherche {

	private JFrame frmMediaPourTous;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceDeRecherche window = new InterfaceDeRecherche();
					window.frmMediaPourTous.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceDeRecherche() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// fenetre
		frmMediaPourTous = new JFrame();
		frmMediaPourTous.setResizable(true);
		frmMediaPourTous.setTitle("Media pour tous (MPT) - Annuaire Telephonique");
		frmMediaPourTous.setBounds(100, 100, 572, 435);
		frmMediaPourTous.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMediaPourTous.pack();
		
		// JPanel

		JPanel panel = new JPanel();
		
		panel.setBounds(0, 0, 566, 106);

		Border border = BorderFactory.createTitledBorder("Type de recherche");

		panel.setBorder(border);

		// Groupe de boutons radio
		ButtonGroup group = new ButtonGroup();
		JRadioButton btnRadioMatricule = new JRadioButton("Matricule");
		btnRadioMatricule.setBounds(41, 30, 126, 20);
		JRadioButton btnRadioTousEmployes = new JRadioButton("tous les employes");
		btnRadioTousEmployes.setBounds(333, 30, 126, 20);
		JRadioButton btnRadioPrenom = new JRadioButton("Prenom");
		btnRadioPrenom.setBounds(41, 60, 126, 20);
		JRadioButton btnRadioNom = new JRadioButton("Nom");
		btnRadioNom.setBounds(333, 60, 126, 20);

		// ajout des boutons radio au groupe
		group.add(btnRadioMatricule);
		group.add(btnRadioTousEmployes);
		group.add(btnRadioPrenom);
		group.add(btnRadioNom);

		// ajouter groupe au paneau
		panel.add(btnRadioMatricule);
		panel.add(btnRadioTousEmployes);
		panel.add(btnRadioPrenom);
		panel.add(btnRadioNom);

		
		// ajout Panel a la fenetre
		frmMediaPourTous.getContentPane().setLayout(null);
		panel.setLayout(null);
		frmMediaPourTous.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 105, 566, 106);
		frmMediaPourTous.getContentPane().add(panel_1);
		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.CENTER,10,50);
		fl_panel_1.setAlignOnBaseline(true);
		panel_1.setLayout(fl_panel_1);
		
		textField = new JTextField();
		textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.add(textField);
		textField.setColumns(30);
		
		JButton btnRechercher = new JButton("Rechercher");
		panel_1.add(btnRechercher);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 211, 566, 195);
		frmMediaPourTous.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnAjouter = new JButton("Ajouter");
		panel_2.add(btnAjouter , BorderLayout.SOUTH);
		
		JButton btnModifier = new JButton("Modifier");
		panel_2.add(btnModifier, BorderLayout.SOUTH);
		
		JButton btnSupprimer = new JButton("Supprimer");
		panel_2.add(btnSupprimer, BorderLayout.SOUTH);
		
		JButton btnAfficher = new JButton("Afficher");
		panel_2.add(btnAfficher, BorderLayout.SOUTH);
		
		JButton btnFermer = new JButton("Fermer");
		panel_2.add(btnFermer, BorderLayout.SOUTH);

	}
}
