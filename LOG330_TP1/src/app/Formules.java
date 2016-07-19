package app;

import java.util.ArrayList;

public class Formules {
	
	/**
	  * formule de la variance
	  * @param donneesX
	  * @param donneesY
	  * @return variance
	  */
	public double variance(ArrayList<Double> donnees) {
		
		double variance = somme( distanceALaMoyenne(donnees) ) / (donnees.size() - 1);
		
		return variance;
	}
	
	/**
	 * Formule de la moyenne
	 * @param donnees pour lesquels on calcule la moyenne
	 * @return La moyenne
	 */
	private double moyenne(ArrayList<Double> donnees) {
		
		double moyenne = somme(donnees) / donnees.size();
		
		return moyenne;
	}

	/**
	 * Formule pour la somme des donn�es.
	 * @param donnees La donn�es � additionner
	 * @return La somme des donn�es
	 */
	private double somme(ArrayList<Double> donnees) {
		
		double somme = 0;
		
		for(int i = 0 ; i < donnees.size() ; i++) {
			
			somme= somme + donnees.get(i);
		}
		return somme;
	}

	/**
	 * Retourne un tableau avec la distance � la moyen de chaque valeur avec la moyenne.
	 * @param donnees
	 * @return Array avec les distances � la moyenne
	 */
	private ArrayList<Double> distanceALaMoyenne(ArrayList<Double> donnees) {
		
		ArrayList<Double> distances = new ArrayList<Double>();
		
		for(int i = 0 ; i < donnees.size() ; i++) {
			
			distances.add(Math.pow( Math.abs(donnees.get(i) - moyenne(donnees) ), 2)) ;
		}
		
		return distances;
	}

	/**
	 * formule de l'�cart type
	 * @param variance
	 * @return l'�cart type
	 */
	public double ecartType(double variance) {
		return Math.sqrt(variance);
	}

}
