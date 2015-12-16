package ca.uqam.inf2120.tp3.modele;

import java.util.ArrayList;

import java.util.List;

import ca.uqam.inf2120.tp1.adt.GroupeTda;
import ca.uqam.inf2120.tp1.adt.impl.GroupeImpl;

/**
 * UQAM - Automne 2015 - INF2120 - Groupe 20 - TP3
 *
 * Classe AnnuaireTelephonique : contient les services de gestion des
 * coordonn�es des employ�(e)s.
 *
 * @author Ismael Doukoure Compl�t� par : VOTRE NOM VOTRE PR�NOM - VOTRE CODE
 *         PERMANENT
 *
 * @version 24 novembre 2015
 */

public class AnnuaireTelephonique {

	// La liste des employ�(e)s
	private GroupeTda<Employe> listeDesEmployes;

	/**
	 * Constructeur sans argument qui cr�e une liste des Employes vides.
	 */
	public AnnuaireTelephonique() {
		listeDesEmployes = new GroupeImpl<Employe>();
	}
	
	

	public GroupeTda<Employe> getListeDesEmployes() {
		return listeDesEmployes;
	}



	public void setListeDesEmployes(GroupeTda<Employe> listeDesEmployes) {
		this.listeDesEmployes = listeDesEmployes;
	}



	/**
	 * Ajoute un employ� dans la liste des employ�(e)s.
	 *
	 * @param unEmploye
	 *            L'employ� � ajouter
	 */
	public void ajouterEmploye(Employe unEmploye) {

		listeDesEmployes.ajouterFin(unEmploye);

	}

	/**
	 * Trouve l'employ� selon son matricule et le modifie selon les informations
	 * de l'employ� pass� en param�tre.
	 *
	 * @param unEmploye
	 *            L'employ� � modifier
	 */
	public void modifierEmploye(Employe unEmploye) {
		
		String matricule = unEmploye.getMatricule();
		Employe e1 = rechercheParMatricule(matricule);
		e1.setNom(unEmploye.getNom());
		e1.setAdresseCourriel(unEmploye.getAdresseCourriel());
		e1.setBureau(unEmploye.getBureau());
		e1.setNom(unEmploye.getNom());
		e1.setNumeroTelephone(unEmploye.getNumeroTelephone());
		e1.setPrenom(unEmploye.getPrenom());
		
		

	}

	/**
	 * Recherche les employ�s par le matricule de l'employ�. La m�thode doit
	 * retourner tous les employ�s dont le matricule est �gal ou contient
	 * "matricule" pass� en param�tre.
	 *
	 * La m�thode retourne null si aucun employ� ne r�pond aux crit�res de
	 * recherche.
	 *
	 * @param matricule
	 *            Le num�ro de t�l�phone de l'employ�
	 * @return Le tableau Liste (ArrayList) des employ�s qui r�pondent aux
	 *         crit�res de recherche.
	 */
	public List<Employe> rechercherParMatricule(String matricule) {
		boolean trouve = false;
		List<Employe> maliste = rechercherToutesLesEmployes();
		List<Employe> malisteDeRetour = new ArrayList<Employe>();

		if (!(maliste.isEmpty() || maliste == null)) {

			for (int i = 0; i < maliste.size(); i++) {

				if (maliste.get(i).getMatricule().equals(matricule)
						|| maliste.get(i).getMatricule().contains(matricule)) {

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
	 * Recherche les employ�s par le pr�nom de l'employ�. La m�thode doit
	 * retourner tous les employ�s dont le pr�nom de l'employ� est �gal ou
	 * contient "prenomEmploye" pass� en param�tre.
	 *
	 * La m�thode retourne null si aucun employ� ne r�pond aux crit�res de
	 * recherche.
	 *
	 * @param prenomEmploye
	 * @return Le tableau Liste (ArrayList) des employ�s qui r�pondent aux
	 *         crit�res de recherche.
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
	 * Recherche les employ�s par le nom de l'employ�. La m�thode doit retourner
	 * tous les employ�s dont le nom de l'employ� est �gal ou contient
	 * "nomEmploye" pass� en param�tre.
	 *
	 * La m�thode retourne null si aucun employ� ne r�pond aux crit�res de
	 * recherche.
	 *
	 * @param nomEmploye
	 * @return Le tableau Liste (ArrayList) des employ�s qui r�pondent aux
	 *         crit�res de recherche.
	 */
	public List<Employe> rechercherParNomEmploye(String nomEmploye) {
		

		return null;
	}

	/**
	 * Recherche tous les employ�s. La m�thode retourne toutes les employ�s.
	 *
	 * @return Le tableau Liste (ArrayList) des employ�s.
	 */
	public List<Employe> rechercherToutesLesEmployes() {

		List<Employe> list = new ArrayList<Employe>(listeDesEmployes.elements().values());

		return list;
	}

	/**
	 * Supprime l'employ� pass� en param�tre de la liste des employ�s. L'employ�
	 * supprim� doit avoir le m�me matricule que celui pass� en param�tre.
	 *
	 * @param unEmploye
	 *            L'employ� � supprimer.
	 * @return Vrai si la suppression a �t� faite, sinon faux.
	 */
	public boolean supprimerEmploye(Employe unEmploye) {

		return listeDesEmployes.supprimer(unEmploye);
	}

	// retourne null si l'element n'existe pas
	public Employe rechercheParMatricule(String matricule) {
		boolean trouve = false;
		Employe e1 =null;
		int i = 0;
		List<Employe> maliste = rechercherToutesLesEmployes();

		if (!( maliste == null)) {

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

}
