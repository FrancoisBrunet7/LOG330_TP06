package app;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * Nom : Francois Brunet
 *
 * Description : Tests pour la classe DataExtractor
 */
public class DataExtractorTest {
	
	private File file10Donnees;

	private DataExtractor dataExtractor = new DataExtractor();
	
	/**
	 * Load les fichiers pour les tests
	 */
	@Before
	public void faireAvant(){
		file10Donnees = new File("testTP05.csv");
	}

	/**
	 * Vérifie si le programme reconnait le nombre de données dans un fichier avec 10 paires de données
	 * @throws IOException
	 */
	@Test
	public void taille3DonneesTest() throws IOException{
		dataExtractor.extractData(file10Donnees);
		assertTrue(dataExtractor.getDonneesX().size() == 10 && dataExtractor.getDonneesY().size() == 10);
	}
	
	
}
