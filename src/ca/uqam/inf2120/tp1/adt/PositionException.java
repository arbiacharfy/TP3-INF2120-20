package ca.uqam.inf2120.tp1.adt;

/**
 * UQAM - Automne 2015
 * INF2120 - Groupe 20 - TP1  
 * 
 * Classe pour gérer les exceptions liées à une position dans un intervalle
 * 
 * @author Ismael Doukoure
 * @version 6 octobre 2015
 */
@SuppressWarnings("serial")
public class PositionException extends Exception{
	
	/**
	 * Constructeur sans argument
	 */	
	public PositionException() {
        super();
    }
	
	/**
	 * Permet d'initialiser le message
	 * @param message Message à afficher
	 */
	public PositionException(String message) {
        super(message);
    }

}

