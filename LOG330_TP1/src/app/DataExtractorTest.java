package app;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Francois
 *
 *Tests pour la classe DataExtractor
 */
public class DataExtractorTest {
	
	private File file3Donnees;
	private File file11Donnees;
	private DataExtractor dataExtractor = new DataExtractor();
	
	/**
	 * Load les fichiers pour les tests
	 */
	@Before
	public void faireAvant(){
		file3Donnees = new File("fichierTest3Donnees.csv");
		file11Donnees = new File("fichierTest11Donnees.csv");
	}

	/**
	 * Vérifie si le programme reconnait le nombre de données dans un fichier avec 3 données
	 * @throws IOException
	 */
	@Test
	public void taille3DonneesTest() throws IOException{
		dataExtractor.extractData(file3Donnees);
		assertTrue(dataExtractor.getDonnees().size() == 3);
	}
	
	/**
	 * Vérifie si le programme reconnait le nombre de données dans un fichier avec 11 données
	 * @throws IOException
	 */
	@Test
	public void taille10DonneesTest() throws IOException{
		dataExtractor.extractData(file11Donnees);
		assertTrue(dataExtractor.getDonnees().size() == 11);
	}
}
