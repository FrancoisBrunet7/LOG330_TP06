package Test.Test_RegressionLin;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Formules;

public class test_regressionLin_3 {
	
	Formules formules = new Formules();
	ArrayList<Double> donneesX;
	ArrayList<Double> donneesY;
	
	@Before
	public void faireAvant() {
		donneesX = new ArrayList<Double>();
		donneesX.add(1.0);
		donneesX.add(6.0);
		donneesX.add(10.0);
		donneesX.add(5.0);
		donneesY = new ArrayList<Double>();
		donneesY.add(3.0);
		donneesY.add(3.0);
		donneesY.add(3.0);
		donneesY.add(3.0);
	}
	
	@Test
	public void Test() {
		assertTrue(String.valueOf(formules.estimerX(donneesX, donneesY, 5)) == "Infinity");
	}
}
