package Test.Test_Correlation;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Formules;

public class test_correlation_1 {
	
	Formules formules = new Formules();
	ArrayList<Double> donneesX;
	ArrayList<Double> donneesY;
	
	@Before
	public void faireAvant() {
		donneesX = new ArrayList<Double>();
		donneesX.add(50.0);
		donneesX.add(50.0);
		donneesX.add(50.0);
		donneesX.add(50.0);
		donneesY = new ArrayList<Double>();
		donneesY.add(60.0);
		donneesY.add(60.0);
		donneesY.add(60.0);
		donneesY.add(60.0);
	}
	
	@Test
	public void Test() {
		assertTrue(String.valueOf(formules.correlation(donneesX, donneesY)) == "NaN");
	}
}
