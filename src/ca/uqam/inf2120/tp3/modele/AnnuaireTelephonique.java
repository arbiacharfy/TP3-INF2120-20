package ca.uqam.inf2120.tp3.modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import ca.uqam.inf2120.tp1.adt.GroupeTda;
import ca.uqam.inf2120.tp1.adt.impl.GroupeImpl;

/**
 * UQAM - Automne 2015 - INF2120 - Groupe 20 - TP3
 *
 * Classe AnnuaireTelephonique : contient les services de gestion des
 * coordonnées des employé(e)s.
 *
 * @author Ismael Doukoure Complété par : VOTRE NOM VOTRE PRÉNOM - VOTRE CODE
 *         PERMANENT
 *
 * @version 24 novembre 2015
 */

public class AnnuaireTelephonique {

	// La liste des employé(e)s
	private GroupeTda<Employe> listeDesEmployes;

	/**
	 * Constructeur sans argument qui crée une liste des Employes vides.
	 */
	public AnnuaireTelephonique() {
		listeDesEmployes = new GroupeImpl<Employe>();
	}

	/**
	 * Ajoute un employé dans la liste des employé(e)s.
	 *
	 * @param unEmploye
	 *            L'employé à ajouter
	 */
	public void ajouterEmploye(Employe unEmploye) {

		listeDesEmployes.ajouterFin(unEmploye);

	}

	/**
	 * Trouve l'employé selon son matricule et le modifie selon les informations
	 * de l'employé passé en paramètre.
	 *
	 * @param unEmploye
	 *            L'employé à modifier
	 */
	public void modifierEmploye(Employe unEmploye) {
		Iterator<Employe> it = listeDesEmployes.iterateur();
		while (it.hasNext()) {

			Employe employeCourant = it.next();

			if (employeCourant.getMatricule() == unEmploye.getMatricule()) {

				employeCourant.setNom(unEmploye.getNom());
				employeCourant.setAdresseCourriel(unEmploye.getAdresseCourriel());
				employeCourant.setBureau(unEmploye.getBureau());
				employeCourant.setNom(unEmploye.getNom());
				employeCourant.setNumeroTelephone(unEmploye.getNumeroTelephone());
				employeCourant.setPrenom(unEmploye.getPrenom());
			}
		}
	}

	/**
	 * Recherche les employés par le matricule de l'employé. La méthode doit
	 * retourner tous les employés dont le matricule est égal ou contient
	 * "matricule" passé en paramètre. La méthode retourne null si aucun employé
	 * ne répond aux critères de recherche.
	 * 
	 * @param matricule
	 *            Le numéro de téléphone de l'employé
	 * @return Le tableau Liste (ArrayList) des employés qui répondent aux
	 *         critères de recherche.
	 */
	public List<Employe> rechercherParMatricule(String matricule) {
		
		Iterator<Employe> it = listeDesEmployes.iterateur();
		List<Employe> malisteDeRetour = new ArrayList<Employe>();

		while (it.hasNext()) {

			Employe employeCourant = it.next();

			if (employeCourant.getMatricule() == matricule) {
				malisteDeRetour.add(employeCourant);
			}

		}

		return malisteDeRetour;
	}

	// retourne null si l'element n'existe pas
	public Employe rechercheParMatricule(String matricule) {
		boolean trouve = false;
		Employe e1 = null;
		int i = 0;
		List<Employe> maliste = rechercherToutesLesEmployes();

		if (!(maliste == null)) {

			while (trouve) {
				if (maliste.get(i).getMatricule().equals(matricule)
						|| maliste.get(i).getMatricule().contains(matricule)) {

					trouve = true;
					e1 = maliste.get(i);

				}

			}

		}

		return e1;
	}

	/**
	 * Recherche les employés par le prénom de l'employé. La méthode doit
	 * retourner tous les employés dont le prénom de l'employé est égal ou
	 * contient "prenomEmploye" passé en paramètre.
	 *
	 * La méthode retourne null si aucun employé ne répond aux critères de
	 * recherche.
	 *
	 * @param prenomEmploye
	 * @return Le tableau Liste (ArrayList) des employés qui répondent aux
	 *         critères de recherche.
	 */
	public List<Employe> rechercherParPrenomEmploye(String prenomEmploye) {
		boolean trouve = false;
		List<Employe> maliste = rechercherToutesLesEmployes();
		List<Employe> malisteDeRetour = new ArrayList<Employe>();

		if (!(maliste.isEmpty() || maliste == null)) {

			for (int i = 0; i < maliste.size(); i++) {

				if (maliste.get(i).getPrenom().equals(prenomEmploye)
						|| maliste.get(i).getPrenom().contains(prenomEmploye)) {

					malisteDeRetour.add(maliste.get(i));
					trouve = true;
				}

			}
		}

		if (!trouve) {
			malisteDeRetour = null;
		}
		return malisteDeRetour;
	}

	/**
	 * Recherche les employés par le nom de l'employé. La méthode doit retourner
	 * tous les employés dont le nom de l'employé est égal ou contient
	 * "nomEmploye" passé en paramètre.
	 *
	 * La méthode retourne null si aucun employé ne répond aux critères de
	 * recherche.
	 *
	 * @param nomEmploye
	 * @return Le tableau Liste (ArrayList) des employés qui répondent aux
	 *         critères de recherche.
	 */
	public List<Employe> rechercherParNomEmploye(String nomEmploye) {

		return null;
	}

	/**
	 * Recherche tous les employés. La méthode retourne toutes les employés.
	 *
	 * @return Le tableau Liste (ArrayList) des employés.
	 */
	public List<Employe> rechercherToutesLesEmployes() {
		List<Employe> listeResultats = new ArrayList<Employe>();
		Iterator<Employe> it = listeDesEmployes.iterateur();
		while (it.hasNext()) {
			Employe EmployeCourant = it.next();
			listeResultats.add(EmployeCourant);
		}

		return listeResultats;
	}

	/**
	 * Supprime l'employé passé en paramètre de la liste des employés. L'employé
	 * supprimé doit avoir le même matricule que celui passé en paramètre.
	 *
	 * @param unEmploye
	 *            L'employé à supprimer.
	 * @return Vrai si la suppression a été faite, sinon faux.
	 */
	public boolean supprimerEmploye(Employe unEmploye) {

		listeDesEmployes.supprimer(unEmploye);

		return false;

	}

	public boolean estVide() {
		return listeDesEmployes.estVide();
	}

	// getters et setters
	public GroupeTda<Employe> getListeDesEmployes() {
		return listeDesEmployes;
	}

	public void setListeDesEmployes(GroupeTda<Employe> listeDesEmployes) {
		this.listeDesEmployes = listeDesEmployes;
	}

}
