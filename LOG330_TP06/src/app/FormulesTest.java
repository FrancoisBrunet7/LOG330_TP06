package app;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * Nom : Francois Brunet
 *
 * Description : Tests pour la classe FileSelector
 */
public class FormulesTest {
	
	private File file;
	private DataExtractor dataExtractor = new DataExtractor();
	private Formules formules = new Formules();
	
	/**
	 * Extrait les données d'un fichier afin d'avoir les données disponibles pour les tests.
	 * @throws IOException
	 */
	@Before
	public void faireAvant() throws IOException{
		file = new File("testTP05.csv");
		dataExtractor.extractData(file);
	}
	
	/**
	 * Test la formule de la variance
	 */
	@Test
	public void intervalleTest() {
		assertTrue(formules.intervalleDeConfiance(1119, 1.86, dataExtractor.getDonneesX(), dataExtractor.getDonneesY()) == 466.2082192948007);
	}
}
