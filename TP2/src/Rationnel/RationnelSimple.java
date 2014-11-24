package Rationnel;

import types.Rationnel;

public class RationnelSimple implements Rationnel{
	
	int numerateur;
	int denominateur;
	
	/**
	   * initialiser un rationnel à partir d'un entier : nb/1
	   * @param num : valeur du numérateur
	   */
	  
	public RationnelSimple (int num)
	{
		this.numerateur = num;
		this.denominateur = 1;
	}
	

	/**
	   * initialiser un rationnel avec numerateur et dénominateur
	   * @param num : valeur du numérateur
	   * @param den : valeur du dénominateur
	   * @pre den != 0
	   * @post fraction irréductible et dénominateur > 0
	   */
	
	 public RationnelSimple (int num, int den)
	 {
		 assert ( den != 0 );
		 
		 int pgcd = 0;
		 int a = Math.abs(num);
		 int b = Math.abs(den);
		 
		 
		 while (a*b != 0 ) 
		 {
			 if (a>b) {a=a-b;}
			 else {b=b-a;}
		 }
		 if(a==0) {pgcd = b;}
		 else {pgcd = a;}
		 
		 num=num/pgcd;
		 den=den/pgcd;
		 
		 if ((num<0 && den<0) || (num>0 && den <0))
		 {
	   	 num= -num;
		 den= -den;
		 }
		
		 this.numerateur = num;
		 this.denominateur = den;
	 }



	  /**
	   * initialiser un rationnel à partir d'un autre
	   * @param r : rationnel à dupliquer
	   */
	 
	 public RationnelSimple(Rationnel r)
	 {
		 this.numerateur = r.getNumerateur();
		 this.denominateur = r.getDenominateur();
		 
	 }

	  /**
	   * comparer (égalité) deux rationnels
	   * @param r : rationnel à comparer au rationnel courant
	   * @return vrai si le rationnel courant est égal au rationnel paramètre
	   */
	 
	 public boolean equals(Rationnel r)
	 {
		return (this.numerateur == r.getNumerateur() && this.denominateur == r.getDenominateur() );
		 
	 }

	  /**
	   * additionner deux rationnels
	   * @param r : rationnel à additionner avec le rationnel courant
	   * @return nouveau Rationnel somme du rationnel courant et du rationnel paramètre
	   */
	 
	  public Rationnel somme(Rationnel r)
	  {
		  return(new RationnelSimple(r.getNumerateur()*this.getDenominateur()+r.getDenominateur()*this.getNumerateur(),r.getDenominateur()*this.getDenominateur()));		  
	  }

	  /**
	   * inverser le rationnel courant
	   * @return nouveau Rationnel inverse du rationnel courant
	   * @pre numérateur != 0
	   */
	  
	  public Rationnel inverse()
	  {
		  assert (numerateur != 0);  
		  return (new RationnelSimple(this.getDenominateur(), this.getNumerateur() ) );
	  }

	  /**
	   * calculer la valeur réelle du rationnel courant
	   * @return valeur réelle du rationnel courant
	   */
	  
	  public double valeur()
	  {
		  
		  return ((double) this.getNumerateur() / this.getDenominateur() );
	  }

	  /**
	   *  @return représentation affichable d'un rationnel
	   */
	  
	  public String toString(){
		  
		  if (this.getDenominateur() == 1){
			  return ("" + this.getNumerateur());
		  }
		  else{
		  return (this.getNumerateur() + "/" + this.getDenominateur());
		  }
	  }

	  // accesseurs
	  
	  public int getNumerateur()
	  {
		  return this.numerateur; // consulter le numérateur
	  }
	  public int getDenominateur()
	  {
		  return this.denominateur;  // consulter le dénominateur
	  }

	  // méthode de l'interface Comparable<Rationnel>
	  
	  /*
	   * comparer deux rationnels
	   * @param autre : le rationnel � comparer avec le rationnel courant
	   * @return : Comparaison (si 1 : courant>autre, si -1 : courant<autre et si 0 : courant=autre) 
	   */
	  
	  public int compareTo(Rationnel autre)
	  {
		  if (this.getNumerateur() * autre.getDenominateur() > this.getDenominateur() * autre.getNumerateur())
		  	{
				return 1;
		  	}
		  if (this.getNumerateur() * autre.getDenominateur() < this.getDenominateur() * autre.getNumerateur())
			{
				return -1;
			}
		  else{
		  return 0;  
	  }
   }
}
