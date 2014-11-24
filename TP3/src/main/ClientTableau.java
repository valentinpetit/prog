package main;

import tableau.Block;
import java.util.Scanner;


public class ClientTableau {
	
	/**
	 * Determine si un entier n est premier
	 * @param n : entier a tester
	 * @pre : n >= 2
	 * @param TPremiers : tableau contenant tout les entiers premiers compris entre [2;n-1]
	 * @return : vrai si l'entier teste est premier
	 */
	
	public static boolean estPremier (int n, Block<Integer> TPremiers){
		assert ( n >= 2) ;
		int i = 0;
		while( TPremiers.get(i) != TPremiers.size())
		{
			if( n != TPremiers.get(i)){
				i++;
			}
			else {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Calcule l'ensemble des entiers premiers dans l'intervalle [2;N]
	 * @param N : entier a tester
	 * @pre : N >= 2
	 * @param TResult : tableau initialement vide, qui servira a stocker l'ensemble des entiers premiers trouves dans cet intervalle
	 * @return : Tableau contenant l'ensemble des entiers premiers trouves dans cet intervalle
	 */
	
	public static int calculerNombresPremiers (int N, Block<Integer> TResult){
		int lastIntTest = 2; // Dernier entier testé (2 au départ)
	
		for (int i = 2; TResult.size()<100 && i<=N; i++){ //On se déplace dans l'intervalle [2;N]
			lastIntTest = i; //Mise a jour du dernier entier testé
			if (!estPremier(i, TResult)){
				boolean prem = true; 
				for ( int j = 0 ; j<TResult.size(); j++){
					if (i%TResult.get(j)==0){
						prem = false;
						break;
					}
				}
				if(prem) {TResult.push_back(i);
				}
		/*	if (TResult.full()){
				return lastIntTest;*/
			}
		}
		return /*N*/ lastIntTest;
	}
	

	public static void main(String [] args) {
		
		Block <Integer> TableauMain = new Block<Integer> (100);
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entre un entier supérieur ou égale à 2 : ");
		int N = sc.nextInt();
		assert (N>=2);
		int last = calculerNombresPremiers(N, TableauMain);
		for (int i=0; i<TableauMain.size(); i++){
			System.out.println(TableauMain.get(i));
		}
		System.out.println("Dernier element testé :" + last);
	}
CHANGER CALCULERENTIERPREMIER !!!!!!!!!!!!!
	

}
