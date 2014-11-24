package Rationnel;

import types.Couple;
import types.Rationnel;


public class RationnelCouples implements Rationnel{ 
	
	private Couple<Integer,Integer> C1; 
	
	/** 
	 * initialiser un rationnel � partir d'un entier : nb/1 
	 * @param num : valeur du numérateur
	 */ 
	
	public RationnelCouples(int num){ 
		
		this(num, 1);  
		
	}

	/** 
	 * initialiser un rationnel avec numerateur et dénominateur
	 * @param num : valeur du numérateur 
	 * @param den : valeur du dénominateur 
	 * @pre den != 0 
	 * @post fraction irréductible et dénominateur > 0 
	 */ 
	
	public RationnelCouples(int num, int den){ 
		
		assert den != 0 ;
		
		// changement de signe si les deux parties sont de signes differents
		 if ( num <0 && den < 0)
		 {
			 num = - num;
			 den = - den;
		 }
		 
		// simplification de la fraction
		 if ( num % den == 0 && den !=1)
		 {
			 num = num / den;
			 den = 1;
		 }
		  int a = num;
		  int b = den;
		  
		  // pgcd pour la simplification
		  
		 while(b >0 )
		 {
			 int c = a % b ;
			 a = b;
			 b = c;
		 }
		 
		 num /= a ;
		 den /= a ;
		 
		 this.C1 = new Couple<Integer, Integer>(num, den);
		}

	/** 
	 * initialiser un rationnel � partir d'un autre 
	 * @param r : rationnel � dupliquer 
	*/ 
	
	public RationnelCouples(Rationnel copie){ 
		
		this(copie.getNumerateur(), copie.getDenominateur()); 
		
	} 
	
	 /**
	   * comparer (égalité) deux rationnels
	   * @param r : rationnel à comparer au rationnel courant
	   * @return vrai si le rationnel courant est égal au rationnel paramètre
	   */
	
	public boolean equals(Rationnel r){ 
		
		if((C1.getFirst() == r.getNumerateur())&&(C1.getSecond() == r.getDenominateur())){ 
			return true; 
			} 
		else { 
			return false; 
			} 
		} 
	
	/**
	   * additionner deux rationnels
	   * @param r : rationnel à additionner avec le rationnel courant
	   * @return nouveau Rationnel somme du rationnel courant et du rationnel paramètre
	   */
	
	public Rationnel somme(Rationnel r){ 
		
		int num = this.C1.getFirst()*r.getDenominateur()+r.getNumerateur()*this.C1.getSecond(); 
		int den = this.C1.getSecond()*r.getDenominateur();
		Rationnel res = new RationnelCouples(num,den); 
		return res; 
		
	} 
	
	 /**
	   * inverser le rationnel courant
	   * @return nouveau Rationnel inverse du rationnel courant
	   * @pre numérateur != 0
	   */
	
	public Rationnel inverse(){ 
		
		assert this.C1.getFirst() != 0; 
		Rationnel res = new RationnelCouples(this.C1.getSecond(),this.C1.getFirst()); 
		return res; 
		
	} 
	
	/**
	   * calculer la valeur réelle du rationnel courant
	   * @return valeur réelle du rationnel courant
	   */
	  
	
	public double valeur(){ 
		
		double res = (this.C1.getFirst() / this.C1.getSecond()); 
		return res; 
		
	} 
	
	/**
	   *  @return représentation affichable d'un rationnel
	   */
	
	public String toString(){ 
		
		String res = this.C1.getFirst()+"/"+this.C1.getSecond();
		return res; 
		
	} 
	
	// Accesseurs
	
	public int getNumerateur(){ 
		
		return C1.getFirst(); 
		
	} 
	
	public int getDenominateur(){ 
		
		return C1.getSecond(); 
		
	} 
	
	// méthode de l'interface Comparable<Rationnel>
	  
		  
	/*
	 * comparer deux rationnels
	 * @param autre : le rationnel � comparer avec le rationnel courant
	 * @return : Comparaison (si 1 : courant>autre, si -1 : courant<autre et si 0 : courant=autre) 
	 */
	
	public int compareTo(Rationnel autre){ 
		
		if (this.equals(autre)) { 
			return 0; 
			} 
		
		else if(this.valeur()< autre.valeur()){ 
			return -1; 
			} 
		
		else { 
			return 1; 
			} 
		} 
	}