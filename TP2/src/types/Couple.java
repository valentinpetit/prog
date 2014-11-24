package types;

public class Couple<T1,T2>{

	private T1 First; // Première valeur du couple 

	private T2 Second; // Deuxième valeur du couple

	//Création d'un couple de valeurs
	
	public Couple (T1 first, T2 second){
		this.First = first;
		this.Second = second;
	}

	/*
	 * @return : la première valeur du couple
	 */
	
	public T1 getFirst(){
		return this.First;
	}
	
	/*
	 * @return : la deuxième valeur du couple
	 */
	
	public T2 getSecond(){
		return this.Second;
	}
	
	/*
	 * @return : modifie la valeur de la première valeur du couple
	 */
	/*
	public void setFirst(T1 valeur){
		this.first = valeur;
	}
	
	/*
	 * @return : modifie la valeur de la seconde valeur du couple
	 */
	/*
	public void setSecond(T2 valeur){
		this.second = valeur;	
	}
	*/
}

