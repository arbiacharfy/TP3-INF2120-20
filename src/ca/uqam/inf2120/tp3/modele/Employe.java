package ca.uqam.inf2120.tp3.modele;

/**
 * UQAM - Automne 2015 - INF2120 - Groupe 20 - TP3
 *
 * Classe Employe : contient les informations de l'employ�(e).
 *
 * @author Ismael Doukoure Compl�t� par : VOTRE NOM VOTRE PR�NOM - VOTRE CODE
 *         PERMANENT
 *
 * @version 24 novembre 2015
 */
public class Employe {

	private String matricule;
	private String nom;
	private String prenom;
	private String adresseCourriel;
	private String numeroTelephone;
	private EmplacementBureau bureau;

	/**
	 * @param matricule
	 *            Le matricule de l'employ�(e)
	 * @param nom
	 *            Le nom de l'employ�(e)
	 * @param prenom
	 *            Le pr�nom de l'employ�(e)
	 * @param adresseCourriel
	 *            L'adresse courriel de l'�mploy�
	 * @param numeroTelephone
	 *            Le num�ro de t�l�phone de l'�mploy�
	 * @param bureau
	 *            L'emplacement du bureau de l'�mploy�
	 */

	public Employe(String matricule, String nom, String prenom, String adresseCourriel, String numeroTelephone,
			EmplacementBureau bureau) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseCourriel = adresseCourriel;
		this.numeroTelephone = numeroTelephone;
		this.bureau = bureau;
	}
	public Employe() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object unAutreObjet) {

		boolean estEgal = false;

		// Si les 2 objets sont identiques, on doit retourner
		// vrai comme r�sultat.
		if (this == unAutreObjet) {
			estEgal = true;

		} else if (unAutreObjet != null && this.getClass() == unAutreObjet.getClass()) {

			// Sachant que unAutreObjet n'est pas null et que unAutreObjet
			// et l'objet courant sont de m�me type, on peut se permettre
			// la conversion de UnAutreObjet en Employe
			Employe unEmploye = (Employe) unAutreObjet;

			// Tester si les deux (2) objets ont le m�me matricule.
			estEgal = (matricule.equals(unEmploye.matricule));
		}

		return estEgal;

	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresseCourriel() {
		return adresseCourriel;
	}

	public void setAdresseCourriel(String adresseCourriel) {
		this.adresseCourriel = adresseCourriel;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public EmplacementBureau getBureau() {
		return bureau;
	}

	public void setBureau(EmplacementBureau bureau) {
		this.bureau = bureau;
	}

	/*
	 * INFORMATIONS IMPORTANTES :
	 *
	 * Ajoutez les getters, les setters et toute autre m�thode que vous jugez
	 * n�cessaire pour accomplir ce travail.
	 *
	 */



}
