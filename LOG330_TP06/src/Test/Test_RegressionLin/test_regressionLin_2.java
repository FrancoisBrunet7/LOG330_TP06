package Test.Test_RegressionLin;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Formules;

public class test_regressionLin_2 {
	
	Formules formules = new Formules();
	ArrayList<Double> donneesX;
	ArrayList<Double> donneesY;
	
	@Before
	public void faireAvant() {
		donneesX = new ArrayList<Double>();
		donneesX.add(130.0);
		donneesX.add(650.0);
		donneesX.add(99.0);
		donneesX.add(150.0);
		donneesY = new ArrayList<Double>();
		donneesY.add(186.0);
		donneesY.add(699.0);
		donneesY.add(132.0);
		donneesY.add(272.0);
	}
	
	@Test
	public void Test() {
		assertTrue(formules.estimerX(donneesX, donneesY, 5) == -69.77647467477414);
	}
}
