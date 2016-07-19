package app;

import java.util.ArrayList;

/**
 * Nom : Fran�ois Brunet
 * Description : Formules utilis�es pour les calcules de programme.
 */
public class Formules {
	
	/**
	 * Formule pour l'intervalle de confiance.
	 * @param donneesX Les donn�es en X
	 * @param donneesY Les donn�es en Y
	 * @return L'intervalle de confiance
	 */
	public double intervalleDeConfiance(double estimation, double student, ArrayList<Double> donneesX, ArrayList<Double> donneesY) {
		double intervalle = student * ecartType(variance(donneesX, donneesY)) * Math.sqrt( 1.0 + (1.0 / donneesX.size()) + ((estimation - moyenne(donneesX)) * (estimation - moyenne(donneesX)) / somme(distanceALaMoyenne(donneesX))) );
		return intervalle;
	}
	
	/**
	 * Formule de la corr�lation
	 * @param donneesX Les donn�es en X
	 * @param donneesY Les donn�es en Y
	 * @return La corr�lation
	 */
	public double correlation(ArrayList<Double> donneesX, ArrayList<Double> donneesY) {
		
		double correlation = ( donneesX.size() * somme(xMultiplieParY(donneesX, donneesY)) - somme(donneesX) * somme(donneesY) ) / 
				Math.sqrt((donneesX.size() * somme(mettreAuCarre(donneesX)) - Math.pow(somme(donneesX), 2)) * (donneesY.size() * somme(mettreAuCarre(donneesY)) - Math.pow(somme(donneesY), 2))) ;
		
		return correlation;
	}
	
	/**
	 * Formule de la corr�lation
	 * @param donneesX Les donn�es en X
	 * @param donneesY Les donn�es en Y
	 * @return La corr�lation
	 */
	public double coeffDeDetermination(ArrayList<Double> donneesX, ArrayList<Double> donneesY) {
		
		double rCarre = Math.pow(correlation(donneesX, donneesY), 2);
		
		return rCarre;
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
	 * Formule de la moyenne
	 * @param donnees pour lesquels on calcule la moyenne
	 * @return La moyenne
	 */
	private double moyenne(ArrayList<Double> donnees) {
		double moyenne = somme(donnees) / donnees.size();
		return moyenne;
	}
	
	/**
	 * Formule pour mettre au carr� chaque donn�es d'une s�rie de donn�es
	 * @param donnees La s�rie de donn�es
	 * @return Une s�ries de donn�es dont chaque donn�es ont �t� mises au carr�
	 */
	private ArrayList<Double> mettreAuCarre(ArrayList<Double> donnees) {
		
		ArrayList<Double> donnees2 = new ArrayList<Double>();
		
		for(int i = 0 ; i < donnees.size() ; i++) {
			
			donnees2.add(Math.pow(donnees.get(i), 2));
		}
		return donnees2;
	}

	/**
	 * Formule pour multiplier les donn�es d'une s�rie par les donn�es de l'autre.
	 * @param donneesX La s�rie de donn�es en X
	 * @param donneesY La s�rie de donn�es en Y
	 * @return Une s�rie de donn�es qui est le r�sultat de la multiplication des 2 s�ries initiales.
	 */
	private ArrayList<Double> xMultiplieParY(ArrayList<Double> donneesX, ArrayList<Double> donneesY) {
		
		ArrayList<Double> donnees = new ArrayList<Double>();
		
		for(int i = 0 ; i < donneesX.size() ; i++) {
			
			donnees.add(donneesX.get(i) * donneesY.get(i));
		}
		return donnees;
	}
	 /**
	  * formule de la variance
	  * @param donneesX
	  * @param donneesY
	  * @return variance
	  */
	private double variance(ArrayList<Double> donneesX, ArrayList<Double> donneesY) {
		
		double variance = somme( mettreAuCarre( calcIntermediaireVariance( constanteBeta0(donneesX, donneesY, penteBeta1(donneesX, donneesY)), penteBeta1(donneesX, donneesY), donneesX, donneesY ) ) ) / (donneesX.size() - 2);
		
		return variance;
	}
	
	/**
	 * calcule d'une valeur intermediaire du calcule de la variance
	 * @param b0 constante
	 * @param b1 constante
	 * @param donneesX
	 * @param donneesY
	 * @return valeur intermediaire du calcule
	 */
	private ArrayList<Double> calcIntermediaireVariance(double b0, double b1, ArrayList<Double> donneesX, ArrayList<Double> donneesY) {
		
		ArrayList<Double> valeurIntermediaire = new ArrayList<Double>();
		
		for(int i = 0 ; i < donneesX.size() ; i++) {
			
			valeurIntermediaire.add(donneesY.get(i) - b0 - b1 * donneesX.get(i)) ;
		}
		
		return valeurIntermediaire;
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
	
	/**
	 * Formule de la pente (beta1)
	 * @param donneesX Les donn�es en X
	 * @param donneesY Les donn�es en Y
	 * @return La pente (beta1)
	 */
	private double penteBeta1(ArrayList<Double> donneesX, ArrayList<Double> donneesY) {
		double pente = ( somme(xMultiplieParY(donneesX, donneesY) ) - ( donneesX.size() * moyenne(donneesX) * moyenne(donneesY) ) ) 
				/ ( somme(mettreAuCarre(donneesX)) - ( donneesX.size() * Math.pow(moyenne(donneesX), 2) ) );		
		return pente;
	}
	
	/**
	 * Formule de la constante (beta0)
	 * @param donneesX Les donn�es en X
	 * @param donneesY Les donn�es en Y
	 * @return La constante (beta0)
	 */
	private double constanteBeta0(ArrayList<Double> donneesX, ArrayList<Double> donneesY, double beta1) {
		double constante = moyenne(donneesY) - beta1 * moyenne(donneesX);
		return constante;
	}
	

	
	/**
	 * Formule pour l'estimation de X
	 * @param donneesX Les donn�es en X
	 * @param donneesY Les donn�es en Y
	 * @param valeurDeY Valeur de Y donn�e par l'utilisateur
	 * @return L'estimation de X
	 */
	public double estimerX(ArrayList<Double> donneesX, ArrayList<Double> donneesY, double valeurDeY) {
		double estimationDeX = (valeurDeY - constanteBeta0(donneesX, donneesY, penteBeta1(donneesX, donneesY))) / penteBeta1(donneesX, donneesY);
		return estimationDeX;
	}
	
	/**
	 * Formule pour l'estimation de Y
	 * @param donneesX Les donn�es en X
	 * @param donneesY Les donn�es en Y
	 * @param valeurDeX Valeur de X donn�e par l'utilisateur
	 * @return L'estimation de Y
	 */
	public double estimerY(ArrayList<Double> donneesX, ArrayList<Double> donneesY, double valeurDeX) {
		double estimationDeY = constanteBeta0(donneesX, donneesY, penteBeta1(donneesX, donneesY)) + penteBeta1(donneesX, donneesY) * valeurDeX;	
		return estimationDeY;
	}
	
	/**
	  * formule de la variance
	  * @param donnees
	  * @return variance
	  */
	public double variance(ArrayList<Double> donnees) {
		
		double variance = somme( distanceALaMoyenne(donnees) ) / (donnees.size() - 1);
		
		return variance;
	}

}
