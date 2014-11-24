package types;

public class Couple<T1,T2>{

	private T1 First; // Premi�re valeur du couple 

	private T2 Second; // Deuxi�me valeur du couple

	//Cr�ation d'un couple de valeurs
	
	public Couple (T1 first, T2 second){
		this.First = first;
		this.Second = second;
	}

	/*
	 * @return : la premi�re valeur du couple
	 */
	
	public T1 getFirst(){
		return this.First;
	}
	
	/*
	 * @return : la deuxi�me valeur du couple
	 */
	
	public T2 getSecond(){
		return this.Second;
	}
	
	/*
	 * @return : modifie la valeur de la premi�re valeur du couple
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

