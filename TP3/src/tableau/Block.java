package tableau;
import types.Array;
import types.Tableau;

public class Block<T> implements Tableau<T> {
	
	private int tailleMax; // Capacité du tableau
	private int taille; // Taille actuelle du tableau
	
	private Array<T> Telements;
	
	
	public Block (int capacite){
		
		assert(capacite>0);
		this.tailleMax = capacite;
		this.Telements = new Array<T>(capacite);
	}



	  /**
	   * Déterminer la taille du tableau
	   * @return nombre d'éléments présents dans le tableau
	   */
	  public int size(){
		  return this.taille;
	  }

	  /**
	   * Déterminer si le tableau est vide
	   * @return vrai si le tableau est vide
	   */
	  public boolean empty(){
		  return this.taille == 0;
	  }

	  /**
	   * Déterminer si le tableau est plein
	   * @return vrai s'il n'est plus possible d'ajouter d'élément dans le tableau
	   */
	  public boolean full(){
		  return this.taille == this.tailleMax ;
	  }

	  /**
	   * Renvoyer l'élément d'indice i
	   * @param i : indice de l'élément à consulter
	   * @pre 0 <= i < this.size()
	   * @return valeur de l'élément d'indice i
	   */
	  public T get(int i){
		 assert (i >= 0);
		 assert (i < this.size());
		 return this.Telements.get(i);
	  }

	  /**
	   * Modifier l'élément d'indice i
	   * 
	   * @param i : indice de l'élément à modifier
	   * @pre 0 <= i < this.size()
	   * @param v : nouvelle valeur de l'élément d'indice i
	   */
	  public void set(int i, T v){
		  assert (i >= 0 && i < this.size());
		  this.Telements.set(i, v);
	  }

	  /**
	   * Ajouter un élément en fin de tableau
	   * 
	   * @param x : élément à ajouter en fin de tableau
	   * @pre : ! this.full()
	   */
	  public void push_back(T x){
		  assert (!this.full());
		  this.Telements.set(taille, x);
		  this.taille++;
	  }

	  /**
	   * Supprimer le dernier élément du tableau
	   * @pre : ! this.empty()
	   */
	  public void pop_back(){
		  assert (!this.empty());
		  this.taille--;
	  }

}
