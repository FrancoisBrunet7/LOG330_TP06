package app;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Francois
 *
 *Tests pour la classe FileSelector
 */
public class FormulesTest {
	
	private File file;
	private DataExtractor dataExtractor = new DataExtractor();
	private Formules formules = new Formules();
	private ArrayList<Double> donnees = new ArrayList<Double>();
	
	/**
	 * Extrait les données d'un fichier afin d'avoir les données disponibles pour les tests.
	 * @throws IOException
	 */
	@Before
	public void faireAvant() throws IOException{
		file = new File("fichierTest11Donnees.csv");
		dataExtractor.extractData(file);
		donnees = dataExtractor.getDonnees();
	}
	
	/**
	 * Test la formule de la variance
	 */
	@Test
	public void varianceTest() {
		assertTrue(formules.variance(donnees) == 388232.0181818182);
	}
	
	/**
	 * Test la formule de l'écart-type
	 */
	@Test
	public void ecartTypeTest() {
		assertTrue(formules.ecartType(formules.variance(donnees)) == 623.0826736331369);
	}
}
