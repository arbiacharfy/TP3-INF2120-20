package ca.uqam.inf2120.tp1.adt;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * UQAM - Automne 2015
 * INF2120 - Groupe 20 - TP1 
 * 
 * GroupeTda : Interface définissant des services de base pour 
 * 			   la gestion des membres d'un groupe donné. Le type T est
 *             la représentation générique de nos futurs membres. Un groupe
 *             est représenté par un tableau liste (ArrayList<T>) dont des 
 *             éléments peuvent être ajoutés ou supprimés à une position donnée. 
 * 
 * @author Ismael Doukoure
 * @version 6 octobre 2015
 */
public interface GroupeTda<T> {

	/**
     * Ajoute un élément au début du groupe courant.
     * 
     * Si l'élément n'est pas null, il n'existe pas dans le groupe courant, il est ajouté
     * et la méthode retourne vrai, sinon elle retourne faux. 
     *   
     * @param element L'élément à ajouter
     * @return true si l'élément n'est pas null, il n'existe pas dans le groupe et qu'il a 
     *         été ajouté sinon false
     */
    public boolean ajouterDebut(T element);
    
    /**
     * Ajoute un élément à la fin du groupe courant.
     *  
     * Si l'élément n'est pas null, il n'existe pas dans le groupe courant, il est ajouté 
     * et la méthode retourne vrai, sinon elle retourne faux. 
     *   
     * @param element L'élément à ajouter
     * @return true si l'élément n'est pas null, il n'existe pas dans le groupe et qu'il a été ajouté
     *         sinon false
     */
    public boolean ajouterFin(T element);
    
    /**
     * Ajoute un élément à une position donnée dans le groupe courant.
     * 
     * Si l'indice est dans le bon intervalle (indice est supérieur ou égal à 0 et inférieur 
     * ou égal à la taille du groupe courant), l'élément n'est pas null, il n'existe pas dans le 
     * groupe courant, il est ajouté dans le groupe courant et la méthode retourne vrai, sinon 
     * elle retourne faux. L'élément doit être ajouté à l'indice en écrasant l'ancien élément 
     * du groupe courant. La position du premier élément du groupe est considéré comme 0. 
     *   
     * @param indice où l'élément doit être ajouté
     * @param element L'élément à ajouter
     * @throws PositionException si l'indice n'est pas dans le bon intervalle 
     * @return true si l'indice est bon, l'élément n'est pas null, il n'existe pas dans le groupe et 
     *         qu'il est ajouté sinon false
     */
    public boolean ajouter(int indice, T element) throws PositionException;
     
    /**
     * Ajoute les éléments du groupe passé en paramètre au début du groupe courant.
     * 
     * Tous les éléments du groupe passé en paramètre sont ajoutés dans le groupe courant et 
     * retourne un tableau liste des éléments qui n'ont pas été ajouté, car ils existent déjà. 
     *   
     * @param groupe Le groupe dont les éléments doivent être ajoutés
     * @return Le tableau liste (ArrayList<T>) des éléments qui n'ont pas été ajoutés, null si tous 
     * les éléments ont été ajoutés ou si le groupe passé en paramètre est nul ou vide 
     */
    public List<T> ajouterDebut(GroupeTda<T> groupe);
    
    /**
     * Ajoute les éléments du groupe passé en paramètre à la fin du groupe courant.
     * 
     * Tous les éléments du groupe passé en paramètre dans le groupe courant sont ajoutés et 
     * retourne un tableau liste  des éléments qui n'ont pas été ajouté, car ils existent déjà.  
     *   
     * @param groupe Le groupe dont les éléments doivent être ajoutés
     * @return Le tableau liste (ArrayList<T>) des éléments qui n'ont pas été ajoutés, null si tous 
     * les éléments ont été ajoutés ou si le groupe passé en paramètre est nul ou vide 
     */
    public List<T> ajouterFin(GroupeTda<T> groupe);

    
    /**
     * Compare le group courant à cellui passé en paramètre. 
     * 
     * Si le groupe courant contient tous les éléments de celui passé en paramètre, la méthode 
     * retourne null, sinon un tableau liste  (ArrayList<T>) est retourné. Ce tableau liste contient
     * les éléments du groupe passé en paramètre qui n'existent pas dans le groupe courant.
     *
     * @param groupe  Le groupe à comparer par rapport au groupe courant
     * @return null si le groupe courant contient tous les éléments du groupe passé en paramétre, 
     *         sinon un tableau liste (ArrayList<T>) des éléments qui n'existent pas dans le groupe courant
     *         est retourné
     */
    public List<T> comparer(GroupeTda<T> groupe);
    
    
    /**
     * Vérifie si le groupe courant contient l'élément passé en paramètre.
     * 
     * Si le groupe courant contient l'élément passé en paramètre, la methode retourne 
     * vrai, sinon elle retourne faux.
     * 
     * @param element L'élement dont l'existence doit être vérifiée
     * @return true si l'élément existe, sinon faux
     */
     public boolean estElement(T element);
     
     /**
      * Retourne le nombre d'éléments du groupe courant.
      * 
      * Le nombre total des éléments dans le groupe courant doit être retourné.
      * 
      * @return Le nombre total des éléments du groupe courant
      */
      public int nbElements();
      
    
    /**
     * Supprime l'élément passé en paramètre du groupe courant.
     * 
     * L'élément passé en paramètre doit être supprimé s'il existe dans le groupe courant.
     * 
     * @param element L'élément à supprimer
     * @return true si l'élément est supprimé, sinon faux 
     */
      
     public boolean supprimer(T element);
    
    /**
     * Supprime tous les éléments du groupe passé en paramètre du groupe courant.
     * 
     * Tous les éléments du groupe passé en paramètre doivent être supprimés dans le groupe
     * courant s'ils existent.     
     *  
     * @param groupe Le groupe dont les éléments doivent être supprimés
     * @return Le tableau (ArrayList<T>) des éléments qui n'ont pas été supprimés, null si tous 
     * les éléments ont été supprimés ou si le groupe passé en paramètre est null ou vide
     */
     public List<T> supprimer(GroupeTda<T> groupe);
    
    /**
     * Remplace un élément par un autre dans le groupe courant. L'élément à remplacer doit 
     * exister et le nouveau élément ne doit pas être null. Aucun remplacement si le groupe
     * courant contient déjà le nouveau élément.
     * 
     * @param elementARemplacer L'élement du groupe courant à remplacer
     * @param nouveauElement Le nouveau élément à ajouter
     * @return true si le remplacement a été fait, sinon faux
     */
     public boolean remplacer(T elementARemplacer, T nouveauElement);
    
     /**
      * Retourne tous les éléments du group courant et leurs positions dans un HashMap<K,T>
      * (HashMap Clé = position de type Integer, HashMap valeur = élément de type T). 
      *
      * @return Le HashMap de tous les éléments du groupe courant et leurs positions,
      * 		null, si le groupe courant est vide.
      */
      public Map<Integer, T> elements();
    
	 /**
     * Vérifie si le groupe courant est vide.
     * 
     * @return true si le groupe courant est vide, sinon false.
     */
     public boolean estVide();

    /**
     * Vide le groupe courant.
     */
     public void vider();
    
     /**
      * Retourne un itérateur sur le groupe courant.
      *
      * @return Iterator sur le groupe courant.
      */
     public Iterator<T> iterateur();
    
    
}


