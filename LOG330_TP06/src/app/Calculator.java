package app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

/**
 * Nom : François Brunet
 * Description : Calcule l'intervalle de confiance et affiche ensuite le résultat
 */
public class Calculator implements Observer {
	
	public static final double STUDENT70POURCENT = 1.108;
	public static final double STUDENT90POURCENT = 1.860;
	public static final double ESTIMATION = 900;
	
	private Formules formules = new Formules();
	private ArrayList<Double> donneesX = new ArrayList<Double>();
	private ArrayList<Double> donneesY = new ArrayList<Double>();
	protected double intervallePour70DeCertitude;
	protected double intervallePour90DeCertitude;
	double limiteInf70Cert;
	double limiteSup70Cert;
	double limiteInf90Cert;
	double limiteSup90Cert;

	@Override
	public void update(Observable dataExtractor, Object arg) {
		
		donneesX = ((DataExtractor) dataExtractor).getDonneesX();
		donneesY = ((DataExtractor) dataExtractor).getDonneesY();
		intervallePour70DeCertitude = calcIntervalleDeConfiance(ESTIMATION, STUDENT70POURCENT, donneesX, donneesY);
		intervallePour90DeCertitude = calcIntervalleDeConfiance(ESTIMATION, STUDENT90POURCENT, donneesX, donneesY);
		calcLimites(ESTIMATION);
		afficheResultatsDansLaConsole();
	}
	
	public double getIntervallePour70DeCertitude() {
		return intervallePour70DeCertitude;
	}
	
	public double getIntervallePour90DeCertitude() {
		return intervallePour70DeCertitude;
	}
	
	public double getLimiteInf70Cert() {
		return limiteInf70Cert;
	}
	
	public double getLimiteSup70Cert() {
		return limiteSup70Cert;
	}
	
	public double getLimiteInf90Cert() {
		return limiteInf90Cert;
	}
	
	public double getLimiteSup90Cert() {
		return limiteSup90Cert;
	}
	
	
	public void setIntervallePour70DeCertitude(double intervallePour70DeCertitude) {
		this.intervallePour70DeCertitude = intervallePour70DeCertitude;
	}
	
	public void setIntervallePour90DeCertitude(double intervallePour90DeCertitude) {
		this.intervallePour90DeCertitude = intervallePour90DeCertitude;
	}
	
	/**
	 * Affiche les résultats dans la console
	 */
	protected void afficheResultatsDansLaConsole() {

		System.out.println("La taille variera entre " + limiteInf70Cert + " et " + limiteSup70Cert + " avec 70% de certitude. \n"
				+ "La taille variera entre " + limiteInf90Cert + " et " + limiteSup90Cert + " avec 90% de certitude.");
	}

	/**
	 * Affiche les résultats de la correlation dans la console et 
	 * dans une fenêtre contenant un message.
	 */
	private void afficheResultats() {
		
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		JOptionPane.showMessageDialog(null, "La taille variera entre " + decimalFormat.format(limiteInf70Cert) + " et " + decimalFormat.format(limiteSup70Cert) + " avec 70% de certitude. \n"
				+ "La taille variera entre " + decimalFormat.format(limiteInf90Cert) + " et " + decimalFormat.format(limiteSup90Cert) + " avec 90% de certitude.");
		System.exit(0);
	}

	/**
	 * Calcule la correlation
	 * @param donneesX Les données en X
	 * @param donneesY Les données en Y
	 * @return La corrélation des données
	 */
	protected double calcIntervalleDeConfiance(double estimation, double student, ArrayList<Double> donneesX, ArrayList<Double> donneesY) {
		return formules.intervalleDeConfiance(estimation, student, donneesX, donneesY);
	}
	
	/**
	 * Calcule les limites pour 70% et 90% de certitude
	 */
	protected void calcLimites(double estimation) {
		
		limiteInf70Cert = estimation - intervallePour70DeCertitude;
		
		if(limiteInf70Cert < 0.0) {
			limiteInf70Cert = 0;
		}
		
		limiteSup70Cert = estimation + intervallePour70DeCertitude;
		
		limiteInf90Cert = estimation - intervallePour90DeCertitude;
		
		if(limiteInf90Cert < 0.0) {
			limiteInf90Cert = 0;
		}
		
		limiteSup90Cert = estimation + intervallePour90DeCertitude;
	}
	
}
