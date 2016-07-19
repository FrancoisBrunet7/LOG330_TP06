package app;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * @author Francois
 *
 *Tests pour la class Calculator
 */
public class CalculatorTest {
	
	private DataExtractor dataExtractor = new DataExtractor();
	private Calculator calculator = new Calculator();
	
	@Before
	public void faireAvant() throws IOException{
		dataExtractor.extractData(new File("fichierTest11Donnees.csv"));
	}
	
	@Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	/**
	 * Vérifie si la variance et l'écart-type sont bien affichés.
	 */
    @Test
    public void overrideProperty() {
    	
    	calculator.update(dataExtractor, null);
    	String string = systemOutRule.getLog();
    	
    	//Des espaces blancs empêchent le bon fonctionnement du equals.
    	//Ces espaces blancs sont donc enlevés.
    	string = string.substring(0, string.length()-2);
    	
        assertEquals("Variance = " + calculator.getVariance() + "\n" + "Écart-Type = " + calculator.getEcartType(),
        		string);
    }
	
}
