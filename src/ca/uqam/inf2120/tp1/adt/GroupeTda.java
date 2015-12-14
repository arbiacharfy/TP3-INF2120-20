package ca.uqam.inf2120.tp1.adt;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * UQAM - Automne 2015
 * INF2120 - Groupe 20 - TP1 
 * 
 * GroupeTda : Interface d�finissant des services de base pour 
 * 			   la gestion des membres d'un groupe donn�. Le type T est
 *             la repr�sentation g�n�rique de nos futurs membres. Un groupe
 *             est repr�sent� par un tableau liste (ArrayList<T>) dont des 
 *             �l�ments peuvent �tre ajout�s ou supprim�s � une position donn�e. 
 * 
 * @author Ismael Doukoure
 * @version 6 octobre 2015
 */
public interface GroupeTda<T> {

	/**
     * Ajoute un �l�ment au d�but du groupe courant.
     * 
     * Si l'�l�ment n'est pas null, il n'existe pas dans le groupe courant, il est ajout�
     * et la m�thode retourne vrai, sinon elle retourne faux. 
     *   
     * @param element L'�l�ment � ajouter
     * @return true si l'�l�ment n'est pas null, il n'existe pas dans le groupe et qu'il a 
     *         �t� ajout� sinon false
     */
    public boolean ajouterDebut(T element);
    
    /**
     * Ajoute un �l�ment � la fin du groupe courant.
     *  
     * Si l'�l�ment n'est pas null, il n'existe pas dans le groupe courant, il est ajout� 
     * et la m�thode retourne vrai, sinon elle retourne faux. 
     *   
     * @param element L'�l�ment � ajouter
     * @return true si l'�l�ment n'est pas null, il n'existe pas dans le groupe et qu'il a �t� ajout�
     *         sinon false
     */
    public boolean ajouterFin(T element);
    
    /**
     * Ajoute un �l�ment � une position donn�e dans le groupe courant.
     * 
     * Si l'indice est dans le bon intervalle (indice est sup�rieur ou �gal � 0 et inf�rieur 
     * ou �gal � la taille du groupe courant), l'�l�ment n'est pas null, il n'existe pas dans le 
     * groupe courant, il est ajout� dans le groupe courant et la m�thode retourne vrai, sinon 
     * elle retourne faux. L'�l�ment doit �tre ajout� � l'indice en �crasant l'ancien �l�ment 
     * du groupe courant. La position du premier �l�ment du groupe est consid�r� comme 0. 
     *   
     * @param indice o� l'�l�ment doit �tre ajout�
     * @param element L'�l�ment � ajouter
     * @throws PositionException si l'indice n'est pas dans le bon intervalle 
     * @return true si l'indice est bon, l'�l�ment n'est pas null, il n'existe pas dans le groupe et 
     *         qu'il est ajout� sinon false
     */
    public boolean ajouter(int indice, T element) throws PositionException;
     
    /**
     * Ajoute les �l�ments du groupe pass� en param�tre au d�but du groupe courant.
     * 
     * Tous les �l�ments du groupe pass� en param�tre sont ajout�s dans le groupe courant et 
     * retourne un tableau liste des �l�ments qui n'ont pas �t� ajout�, car ils existent d�j�. 
     *   
     * @param groupe Le groupe dont les �l�ments doivent �tre ajout�s
     * @return Le tableau liste (ArrayList<T>) des �l�ments qui n'ont pas �t� ajout�s, null si tous 
     * les �l�ments ont �t� ajout�s ou si le groupe pass� en param�tre est nul ou vide 
     */
    public List<T> ajouterDebut(GroupeTda<T> groupe);
    
    /**
     * Ajoute les �l�ments du groupe pass� en param�tre � la fin du groupe courant.
     * 
     * Tous les �l�ments du groupe pass� en param�tre dans le groupe courant sont ajout�s et 
     * retourne un tableau liste  des �l�ments qui n'ont pas �t� ajout�, car ils existent d�j�.  
     *   
     * @param groupe Le groupe dont les �l�ments doivent �tre ajout�s
     * @return Le tableau liste (ArrayList<T>) des �l�ments qui n'ont pas �t� ajout�s, null si tous 
     * les �l�ments ont �t� ajout�s ou si le groupe pass� en param�tre est nul ou vide 
     */
    public List<T> ajouterFin(GroupeTda<T> groupe);

    
    /**
     * Compare le group courant � cellui pass� en param�tre. 
     * 
     * Si le groupe courant contient tous les �l�ments de celui pass� en param�tre, la m�thode 
     * retourne null, sinon un tableau liste  (ArrayList<T>) est retourn�. Ce tableau liste contient
     * les �l�ments du groupe pass� en param�tre qui n'existent pas dans le groupe courant.
     *
     * @param groupe  Le groupe � comparer par rapport au groupe courant
     * @return null si le groupe courant contient tous les �l�ments du groupe pass� en param�tre, 
     *         sinon un tableau liste (ArrayList<T>) des �l�ments qui n'existent pas dans le groupe courant
     *         est retourn�
     */
    public List<T> comparer(GroupeTda<T> groupe);
    
    
    /**
     * V�rifie si le groupe courant contient l'�l�ment pass� en param�tre.
     * 
     * Si le groupe courant contient l'�l�ment pass� en param�tre, la methode retourne 
     * vrai, sinon elle retourne faux.
     * 
     * @param element L'�lement dont l'existence doit �tre v�rifi�e
     * @return true si l'�l�ment existe, sinon faux
     */
     public boolean estElement(T element);
     
     /**
      * Retourne le nombre d'�l�ments du groupe courant.
      * 
      * Le nombre total des �l�ments dans le groupe courant doit �tre retourn�.
      * 
      * @return Le nombre total des �l�ments du groupe courant
      */
      public int nbElements();
      
    
    /**
     * Supprime l'�l�ment pass� en param�tre du groupe courant.
     * 
     * L'�l�ment pass� en param�tre doit �tre supprim� s'il existe dans le groupe courant.
     * 
     * @param element L'�l�ment � supprimer
     * @return true si l'�l�ment est supprim�, sinon faux 
     */
      
     public boolean supprimer(T element);
    
    /**
     * Supprime tous les �l�ments du groupe pass� en param�tre du groupe courant.
     * 
     * Tous les �l�ments du groupe pass� en param�tre doivent �tre supprim�s dans le groupe
     * courant s'ils existent.     
     *  
     * @param groupe Le groupe dont les �l�ments doivent �tre supprim�s
     * @return Le tableau (ArrayList<T>) des �l�ments qui n'ont pas �t� supprim�s, null si tous 
     * les �l�ments ont �t� supprim�s ou si le groupe pass� en param�tre est null ou vide
     */
     public List<T> supprimer(GroupeTda<T> groupe);
    
    /**
     * Remplace un �l�ment par un autre dans le groupe courant. L'�l�ment � remplacer doit 
     * exister et le nouveau �l�ment ne doit pas �tre null. Aucun remplacement si le groupe
     * courant contient d�j� le nouveau �l�ment.
     * 
     * @param elementARemplacer L'�lement du groupe courant � remplacer
     * @param nouveauElement Le nouveau �l�ment � ajouter
     * @return true si le remplacement a �t� fait, sinon faux
     */
     public boolean remplacer(T elementARemplacer, T nouveauElement);
    
     /**
      * Retourne tous les �l�ments du group courant et leurs positions dans un HashMap<K,T>
      * (HashMap Cl� = position de type Integer, HashMap valeur = �l�ment de type T). 
      *
      * @return Le HashMap de tous les �l�ments du groupe courant et leurs positions,
      * 		null, si le groupe courant est vide.
      */
      public Map<Integer, T> elements();
    
	 /**
     * V�rifie si le groupe courant est vide.
     * 
     * @return true si le groupe courant est vide, sinon false.
     */
     public boolean estVide();

    /**
     * Vide le groupe courant.
     */
     public void vider();
    
     /**
      * Retourne un it�rateur sur le groupe courant.
      *
      * @return Iterator sur le groupe courant.
      */
     public Iterator<T> iterateur();
    
    
}


