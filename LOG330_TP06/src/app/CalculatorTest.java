package app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * Nom : Francois Brunet
 *
 * Description : Tests pour la class Calculator
 */
public class CalculatorTest {
	
	private DataExtractor dataExtractor = new DataExtractor();
	private Calculator calculator = new Calculator();
	
	@Before
	public void faireAvant() throws IOException{
		dataExtractor.extractData(new File("testTP05.csv"));
	}
	
	@Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	/**
	 * Vérifie si la variance et l'écart-type sont bien affichés.
	 */
    @Test
    public void affichageConsoleTest() {
    	
    	calculator.update(dataExtractor, null);
    	String string = systemOutRule.getLog();
    	
    	//Des espaces blancs empêchent le bon fonctionnement du equals.
    	//Ces espaces blancs sont donc enlevés.
    	string = string.substring(0, string.length()-2);
    	
        assertEquals("La taille variera entre " + calculator.getLimiteInf70Cert() + " et " + calculator.getLimiteSup70Cert() + " avec 70% de certitude. \n"
				+ "La taille variera entre " + calculator.getLimiteInf90Cert() + " et " + calculator.getLimiteSup90Cert() + " avec 90% de certitude.", string);
    }
	
    /**
	 * Test indépendant 1
	 * Estimé 250 LOC
	 * 90% certitude
	 */
	@Test
	public void testIndep1() {
		int estimation = 250;
		calculator.setIntervallePour90DeCertitude(calculator.calcIntervalleDeConfiance(estimation, 1.86, dataExtractor.getDonneesX(), dataExtractor.getDonneesY()));
		calculator.calcLimites(estimation);
		
		assertTrue(calculator.getLimiteInf90Cert() == 0 && calculator.getLimiteSup90Cert() == 638.9199580901131);
	}
	
	/**
	 * Test indépendant 2
	 * Estimé 250 LOC
	 * 70% certitude
	 */
	@Test
	public void testIndep2() {
		int estimation = 250;
		calculator.setIntervallePour70DeCertitude(calculator.calcIntervalleDeConfiance(estimation, 1.108, dataExtractor.getDonneesX(), dataExtractor.getDonneesY()));
		calculator.calcLimites(estimation);
		
		assertTrue(calculator.getLimiteInf70Cert() == 18.32079915922293 && calculator.getLimiteSup70Cert() == 481.67920084077707);
	}
	
	/**
	 * Test indépendant 3
	 * estimé 1119 LOC
	 * 90% certitude
	 */
	@Test
	public void testIndep3() {
		int estimation = 1119;
		calculator.setIntervallePour90DeCertitude(calculator.calcIntervalleDeConfiance(estimation, 1.86, dataExtractor.getDonneesX(), dataExtractor.getDonneesY()));
		calculator.calcLimites(estimation);
		
		assertTrue(calculator.getLimiteInf90Cert() == 652.7917807051992 && calculator.getLimiteSup90Cert() == 1585.2082192948008);
	}
	
	/**
	 * Test indépendant 4
	 * estimé 1119 LOC
	 * 70% certitude
	 */
	@Test
	public void testIndep4() {
		int estimation = 1119;
		calculator.setIntervallePour70DeCertitude(calculator.calcIntervalleDeConfiance(estimation, 1.108, dataExtractor.getDonneesX(), dataExtractor.getDonneesY()));
		calculator.calcLimites(estimation);
		
		assertTrue(calculator.getLimiteInf70Cert() == 841.2802650652477 && calculator.getLimiteSup70Cert() == 1396.7197349347523);
	}
	
	/**
	 * Test indépendant 5
	 * estimé 400
	 * 90% certitude
	 * @throws IOException 
	 */
	@Test
	public void testIndep5() throws IOException {
		dataExtractor.extractData(new File("TP5-Test02.csv"));
		
		int estimation = 400;
		calculator.setIntervallePour90DeCertitude(calculator.calcIntervalleDeConfiance(estimation, 1.86, dataExtractor.getDonneesX(), dataExtractor.getDonneesY()));
		calculator.calcLimites(estimation);
		
		assertTrue(calculator.getLimiteInf90Cert() == 65.22718095992616 && calculator.getLimiteSup90Cert() == 734.7728190400738);
	}
	
	/**
	 * Test indépendant 6
	 * estimé 400
	 * 70% certitude
	 * @throws IOException 
	 */
	@Test
	public void testIndep6() throws IOException {
		dataExtractor.extractData(new File("TP5-Test02.csv"));
		
		int estimation = 400;
		calculator.setIntervallePour70DeCertitude(calculator.calcIntervalleDeConfiance(estimation, 1.108, dataExtractor.getDonneesX(), dataExtractor.getDonneesY()));
		calculator.calcLimites(estimation);
		
		assertTrue(calculator.getLimiteInf70Cert() == 200.57619166860113 && calculator.getLimiteSup70Cert() == 599.4238083313988);
	}
}
