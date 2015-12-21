package ca.uqam.inf2120.tp1.adt.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ca.uqam.inf2120.tp1.adt.GroupeTda;
import ca.uqam.inf2120.tp1.adt.PositionException;

/**
 * Universite : UQAM Session : Automne 2015 Matiere : INF2120 Groupe : 20
 * Travail : TP1 Nom de l'enseignant : Ismael Doukoure Code Permanent :
 * CHAA14597805 GroupeImplTest : la Classe GroupeImplTest.java implemente
 * l'interface GroupeTda. a l'aide d'un ArrayList. On trouvera une
 * implementation de toutes les methodes de l'interface. Comme on trouvera des
 * methodes utilities.
 * 
 * @author Arbia CHARFI
 * @version 1.0
 * @since 27 Octobre 2015
 * 
 */

public class GroupeImpl<T> implements GroupeTda<T> {

	// Liste dans laquelle les éléments sont stockés.
	List<T> membres;

	/**
	 * Constructeur sans Parametres
	 */
	public GroupeImpl() {
		membres = new ArrayList<T>();

	}

	/**
	 * Permet de tester si un element non null et n'existe pas dans une liste
	 * donnee
	 * 
	 * @param element
	 *            : l'element a tester
	 * @param liste
	 *            : la liste des elements
	 * @return <code>true</code> si l'element non null et n'existe pas dans la
	 *         liste sinon <code>false</code>
	 */
	public boolean ElementNotNullAndDontExist(T element, List<T> liste) {
		boolean exist = false;
		if (!(element.equals(null) || liste.contains(element))) {
			exist = true;
		}
		return exist;
	}

	/**
	 * Ajoute les éléments du groupe passé en paramètre au début du groupe
	 * courant.
	 * 
	 * Tous les éléments du groupe passé en paramètre sont ajoutés dans le
	 * groupe courant et retourne un tableau liste des éléments qui n'ont pas
	 * été ajouté, car ils existent déjà.
	 * 
	 * @param groupe
	 *            : Le groupe dont les éléments doivent être ajoutés
	 * @param pos
	 *            : la position ou on va ajouter le groupe
	 * @return Le tableau liste (ArrayList<T>) des éléments qui n'ont pas été
	 *         ajoutés, null si tous les éléments ont été ajoutés ou si le
	 *         groupe passé en paramètre est nul ou vide
	 */
	public List<T> ajouterAvecPosition(int pos, GroupeTda<T> groupe) {
		// liste des éléments qui n'ont pas été ajoutés, car ils existent déjà
		List<T> listeRetour;
		// liste des éléments ajoutés
		List<T> listeAjoute;
		// Itérateur pour parcourir le groupe passe en paramètre
		Iterator<T> itGroupe = groupe.iterateur();
		if (groupe == null || groupe.estVide()) {
			listeRetour = null;
		} else {

			listeRetour = new ArrayList<>();
			listeAjoute = new ArrayList<>();
			T temp = null;
			while (itGroupe.hasNext()) {
				temp = itGroupe.next();
				// si l'element du groupe existe déjà on l'ajoute à la liste de
				// retour sinon on l'ajoute à la liste des éléments ajoutés
				if (membres.contains(temp)) {
					listeRetour.add(temp);

				} else {

					listeAjoute.add(temp);
				}

			}
			// Ajout des éléments du groupe dans ma liste courante
			// éléments du groupe dans ma liste courante dans la position "pos"
			membres.addAll(pos, listeAjoute);

		}
		// retour liste des éléments non ajoutés
		return listeRetour;
	}

	/**
	 * Permet d'ajouter un element au debut d'une liste si l'element non null &
	 * n'existe pas dans la liste donnee
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#ajouterDebut(T element)
	 */

	@Override
	public boolean ajouterDebut(T element) {

		boolean add = false;

		if (ElementNotNullAndDontExist(element, membres)) {

			membres.add(0, element);
			add = true;
		}
		return add;
	}

	/**
	 * Permet d'ajouter l'element passe en paramètre à la fin de la liste
	 * courante
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#ajouterFin(T element)
	 */

	@Override
	public boolean ajouterFin(T element) {
		boolean add = false;

		if (ElementNotNullAndDontExist(element, membres)) {

			membres.add(element);
			add = true;
		}
		return add;
	}

	/**
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#ajouter(int indice, T element)
	 */

	@Override
	public boolean ajouter(int indice, T element) throws PositionException {

		boolean add = false;
		// si la position non valide lever une exception
		if (indice < 0 || indice >= membres.size()) {
			throw new PositionException("Position non valide");
		} else if (ElementNotNullAndDontExist(element, membres)) {
			membres.add(indice, element); // ajout
			add = true;
		}
		return add;
	}

	/**
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#ajouterDebut(GroupeTda<T> groupe)
	 */
	@Override
	public List<T> ajouterDebut(GroupeTda<T> groupe) {

		// retour liste des éléments non ajoutés
		return ajouterAvecPosition(0, groupe);
	}

	/**
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#ajouterFin(GroupeTda<T> groupe)
	 */
	@Override
	public List<T> ajouterFin(GroupeTda<T> groupe) {

		// retour liste des éléments non ajoutés
		return ajouterAvecPosition(membres.size(), groupe);

	}

	/**
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#comparer(GroupeTda<T> groupe)
	 */
	@Override
	public List<T> comparer(GroupeTda<T> groupe) {

		// liste des éléments du groupe passé en paramètre qui n'existent pas
		// dans le groupe courant
		List<T> listeDesElementsNonExistants = new ArrayList<>();

		Iterator<T> itGroupe = groupe.iterateur();

		T temp = null;
		while (itGroupe.hasNext()) {
			temp = itGroupe.next();

			if (!membres.contains(temp)) {

				listeDesElementsNonExistants.add(temp);
			}

		}

		// si tous les éléments existent déjà dans le groupe courant
		if (listeDesElementsNonExistants.size() == 0) {
			listeDesElementsNonExistants = null;
		}

		return listeDesElementsNonExistants;
	}

	/**
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#estElement(T element)
	 */
	@Override
	public boolean estElement(T element) {

		boolean estElement = false;

		if (membres.contains(element)) {

			estElement = true;
		}

		return estElement;
	}

	/**
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#nbElements()
	 */
	@Override
	public int nbElements() {

		return membres.size();

	}

	/**
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#supprimer(T element)
	 */
	@Override
	public boolean supprimer(T element) {
		
		boolean elementSupprime = false;
		if (estElement(element)) {
			membres.remove(element);
			elementSupprime = true;
		}

		return elementSupprime;
	}

	/**
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#supprimer(GroupeTda<T> groupe)
	 */
	@Override
	public List<T> supprimer(GroupeTda<T> groupe) {

		// liste des éléments qui n'ont pas été supprimés
		List<T> listeRetour;
		// liste des éléments supprimés
		List<T> listeToRemove;

		Iterator<T> itGroupe = groupe.iterateur();

		// retour null si le groupe passé en paramètre est null ou vide
		if (groupe == null || groupe.estVide()) {
			listeRetour = null;
		} else {
			listeRetour = new ArrayList<>();
			listeToRemove = new ArrayList<>();

			T temp = null;
			while (itGroupe.hasNext()) {
				temp = itGroupe.next();
				if (membres.contains(temp)) {
					listeToRemove.add(temp);
				} else {
					listeRetour.add(temp);
				}
			}

			// retour null si tous les éléments ont été supprimés
			if (listeToRemove.size() == 0) {
				listeRetour = null;
			} else {
				membres.removeAll(listeToRemove);
			}
		}
		return listeRetour;
	}

	/**
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#remplacer(T elementARemplacer, T
	 *      nouveauElement)
	 */
	@Override
	public boolean remplacer(T elementARemplacer, T nouveauElement) {
		// true si le remplacement a été fait, sinon faux
		boolean remplacementFait = false;
		// L'élément à remplacer existe et le nouveau élément non null
		if (nouveauElement != null && membres.contains(elementARemplacer)) {
			membres.set(membres.indexOf(elementARemplacer), nouveauElement);
			remplacementFait = true;
		}

		return remplacementFait;
	}

	/**
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#elements()
	 */

	@Override
	public Map<Integer, T> elements() {
		Map<Integer, T> monMap;

		// null, si le groupe courant est vide
		if (membres.isEmpty()) {
			monMap = null;
		} else {
			monMap = new Hashtable<Integer, T>();
			for (int i = 0; i < membres.size(); i++) {
				monMap.put(i, membres.get(i));
			}
		}

		return monMap;
	}

	/**
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#estVide()
	 */

	@Override
	public boolean estVide() {
		return membres.isEmpty();
	}

	/**
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#vider()
	 */

	@Override
	public void vider() {
		membres.clear();
	}

	/**
	 * 
	 * @see ca.uqam.inf2120.tp1.adt.GroupeTda#iterateur()
	 */

	@Override
	public Iterator<T> iterateur() {

		return membres.iterator();
	}

}
