package app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

/**
 * @author Francois
 *
 *Calcule la variance et l'�cart-type et affiche ensuite le r�sultat
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
	 * Affiche les r�sultats de la variance et de l'�cartype dans la console et 
	 * dans une fen�tre contenant un message.
	 */
	private void afficheResultats() {
		System.out.println("Variance = " + variance + "\n" + "�cart-Type = " + ecartType);
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		JOptionPane.showMessageDialog(null, "Variance = " + decimalFormat.format(variance) + "\n" + "�cart-type = " + decimalFormat.format(ecartType));
	}

	/**
	 * Calcule l'�cart-type
	 * @param variance variance des donn�es
	 * @return L'�cart-type des donn�es
	 */
	private double calcEcartType(double variance) {
		return formules.ecartType(variance);
	}

	/**
	 * �alcule la variance
	 * @param donnees pour lesquels la variance est calcul�e
	 * @return La variance des donn�es
	 */
	private double calcVariance(ArrayList<Double> donnees) {
		
		return formules.variance(donnees);
	}

}
