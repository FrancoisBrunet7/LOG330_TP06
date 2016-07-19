package app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

/**
 * @author Francois
 *
 *Calcule la variance et l'écart-type et affiche ensuite le résultat
 */
public class Calculator implements Observer {
	
	private Formules formules = new Formules();
	private ArrayList<Double> donnees = new ArrayList<Double>();
	protected double variance;
	protected double ecartType;

	@Override
	public void update(Observable dataExtractor, Object arg) {
		
		donnees = ((DataExtractor) dataExtractor).getDonnees();
		variance = calcVariance(donnees);
		ecartType = calcEcartType(variance);
		afficheResultats();
	}
	
	public double getVariance() {
		return variance;
	}
	
	public double getEcartType() {
		return ecartType;
	}

	/**
	 * Affiche les résultats de la variance et de l'écartype dans la console et 
	 * dans une fenêtre contenant un message.
	 */
	private void afficheResultats() {
		System.out.println("Variance = " + variance + "\n" + "Écart-Type = " + ecartType);
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		JOptionPane.showMessageDialog(null, "Variance = " + decimalFormat.format(variance) + "\n" + "Écart-type = " + decimalFormat.format(ecartType));
	}

	/**
	 * Calcule l'écart-type
	 * @param variance variance des données
	 * @return L'écart-type des données
	 */
	private double calcEcartType(double variance) {
		return formules.ecartType(variance);
	}

	/**
	 * Çalcule la variance
	 * @param donnees pour lesquels la variance est calculée
	 * @return La variance des données
	 */
	private double calcVariance(ArrayList<Double> donnees) {
		
		return formules.variance(donnees);
	}

}
