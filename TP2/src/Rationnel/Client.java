package Rationnel; 

import java.util.Scanner;

import types.Rationnel;
import Rationnel.RationnelSimple;

public class Client  {
 
	/*
	 * crÃ©er un rationnel entrÃ© par saisie
	 * @param input : scanner permettant l'entrÃ©e des donnÃ©es concernant le rationnel (numÃ©rateur, dÃ©nominateur)
	 * @return : ce nouveau rationnel simple (num/den)
	 */
	
	static Rationnel lireRationnel(Scanner input)
	{
		System.out.println("Veuillez entrer le numerateur svp : ");
		int num = input.nextInt();

		System.out.println("Veuillez entrer le denominateur (non nul) svp : ");
		int den = input.nextInt();
		assert (den != 0);
		
		return makeRationnel(num,den);
	}
	
	//Programme client
	
	public static void main(String [] args){
		
		Rationnel [] lesRationnels = new RationnelSimple [999999];
		int nb = 0;
		int lastPos = -1;
		Scanner input = new Scanner (System.in);
		Rationnel r1 = null ;
		Rationnel r2 = null ;
		
		
		while (true){
			if (r1 !=null){
				r2 = makeRationnel(r1.getNumerateur(), r1.getDenominateur());
			}
			Rationnel rat = lireRationnel(input);
			r1 = makeRationnel(rat.getNumerateur(), rat.getDenominateur());
			
			
			lastPos++;
			lesRationnels[lastPos] = r1;
			
			if (r1.getNumerateur() == 0){
				System.out.println("Le rationnel vaut 0. Arret.");
				break;
			}
			
			System.out.println("Rationnel actuel : " + r1.toString());
			
			if(r2 != null)
			{
				System.out.println("Somme : " + r1.somme(r2));
			}
			
			System.out.println("Inverse" + r1.inverse());
			
			System.out.println("Valeur : " + r1.valeur());
			
			if( r2 != null ) {
				System.out.println("Plus petit que le precedent : " + r1.compareTo(r2));
				
				System.out.println ("Egal au precedent : " + r1.equals(r2));
			}
			
			nb++;
			System.out.println (" Affichage du tableau actuel");
			afficher(lesRationnels, nb);
			sommeRationnels(lesRationnels, nb);
			System.out.println("================================================================");
			
		}
	}
	
                                                                     /////////////////
                                                                    /// Version 2 ///
                                                                   /////////////////
	
	/*
	 * créer et renvoie une instance de RationnelSimple ou RationnelCouple selon la parité du numérateur
	 * @pre : denominateur non nul
	 * @param num : numérateur du rationnel crée
	 * @param den : denominateur du rationnel crée
	 * @return : le nouveau rationnel crée (num/den)
	 */
	
	static Rationnel makeRationnel (int num, int den)
	{
	assert (den != 0);
	Rationnel r1;
	if (num%2 == 0){
		r1= new RationnelSimple(num,den);
	}
	else{
		r1 = new RationnelCouples(num,den);
	}
	return r1;
}
	
	/*
	 * affiche (fraction et valeur) les nb premiers éléments d'un tableau de rationnels
	 * @pre : le tableau est crée et initialisée avant l'appel
	 * @pre : 0 <= nb <= lesRationnels.length
	 * @param lesRationnels : tableau de rationnels
	 * @param nb : nombre d'éléments dans le tableau
	 * @return : les nb premiers éléments du tableau lesRationnels
	 */
	
	static void afficher (Rationnel [] lesRationnels, int nb)
	{
		assert nb >= 0;
		assert nb <= lesRationnels.length;
		for(int i=0;  i < nb && nb<lesRationnels.length; i ++)
		{
		 System.out.print(lesRationnels[i]);
		 System.out.print("|");
		 System.out.println(lesRationnels[i].valeur()+ "|");
		}	
	}
	
	
	/* 
	 * inserer le rationnel nouveau dans le tableau lesRationnels
	 * @pre : tableau trie (ordre croissant)
	 * @param nb : nombres d'elements dans le tableau avant ajour
	 * @pre : 0<nb<lesRationnels.length
	 * @post : tableau trie (ordre croissant)
	 */
	
	static void insererRationnel (Rationnel nouveau, Rationnel[] lesRationnels, int nb)
	{		
		lesRationnels[nb]=nouveau;
		nb ++;
		
		for( int i =1; i < nb; i++){
			int cpt = i; 
			
			while ( cpt >0 && lesRationnels[cpt -1].valeur() > lesRationnels[cpt].valeur())
			{
				Rationnel tmp = lesRationnels[cpt];
				lesRationnels[cpt] = lesRationnels[cpt - 1];
				lesRationnels[cpt-1] = tmp;
			}
		}
	}
	
	
	/* 
	 * calcule et renvoie la somme des nb premiers éléments d'un tableau de rationnels
	 * @pre : le tableau est crée et initialisée avant l'appel
	 * @pre : 0 <= nb <= lesRationnels.length
	 * @param lesRationnels : tableau de rationnels
	 * @param nb : nombre d'éléments dans le tableau
	 * @return : somme des nb premiers éléments du tableau lesRationnels
	 */
	
	
	static Rationnel sommeRationnels (Rationnel[] lesRationnels, int nb)
	{
		assert nb >= 0;
		assert nb <= lesRationnels.length;
		Rationnel somme = new RationnelSimple(0,1);
		for(int i=0; i<nb; i++)
		{
			somme = somme.somme(lesRationnels[i]);
		}
		return somme;
	}
	
	
}


