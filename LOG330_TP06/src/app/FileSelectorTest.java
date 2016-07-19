package app;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

/**
 * Nom : Francois Brunet
 *
 * Description : Tests pour la classe FileSelector
 */
public class FileSelectorTest {
	
	private File fileCSV;
	private File fileXLSX;
	private FileSelector fileSelector = new FileSelector();
	
	/**
	 * Load les fichiers pour les tests
	 */
	@Before
	public void faireAvant(){
		fileCSV = new File("correlationTest.csv");
		fileXLSX = new File("fichierTest.xlsx");
	}

	/**
	 * Vérifie que le programme fonctionne pour une extension .csv
	 */
	@Test
	public void extensionCSVTest(){
		assertTrue(fileSelector.verifyFileType(fileCSV));
	}
	
	/**
	 * Vérifie que le programme ne fonctionne pas pour une extension autre que .csv
	 */
	@Test
	public void extensionXLSXTest(){
		assertFalse(fileSelector.verifyFileType(fileXLSX));
	}
}
