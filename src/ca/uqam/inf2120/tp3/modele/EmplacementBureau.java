package ca.uqam.inf2120.tp3.modele;

/**
 * UQAM - Automne 2015 - INF2120 - Groupe 20 - TP3
 *
 * Classe EmplacementBureau : contient les informations de l'emplacement
 *  					      du bureau d'un(e) employ�(e).
 *
 * @author Ismael Doukoure
 * Compl�t� par : VOTRE NOM  VOTRE PR�NOM - VOTRE CODE PERMANENT
 *
 * @version 24 novembre 2015
 */
public class EmplacementBureau {

	private int numeroEtage;
	private int numeroBureau;


	/**
	 * @param numeroEtage		Le num�ro de l'�tage
	 * @param numeroBureau		Le num�ro du bureau
	 */
	public EmplacementBureau(int numeroEtage, int numeroBureau) {
		this.numeroEtage = numeroEtage;
		this.numeroBureau = numeroBureau;
	}


	public int getNumeroEtage() {
		return numeroEtage;
	}


	public void setNumeroEtage(int numeroEtage) {
		this.numeroEtage = numeroEtage;
	}


	public int getNumeroBureau() {
		return numeroBureau;
	}


	public void setNumeroBureau(int numeroBureau) {
		this.numeroBureau = numeroBureau;
	}

	

	/* INFORMATIONS IMPORTANTES :
	 *
	 * Ajoutez les getters, les setters et toute autre m�thode que vous jugez
	 * n�cessaire pour accomplir ce travail.
     *
     */


}
