package Test.Test_Variance;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Formules;

public class test_variance_2 {
	
	Formules formules = new Formules();
	ArrayList<Double> donneesX;
	
	@Before
	public void faireAvant() {
		donneesX = new ArrayList<Double>();
		donneesX.add(1000000000.0);
		donneesX.add(1000000.0);
		donneesX.add(10000.0);
		donneesX.add(100.0);
		donneesX.add(10.0);
		donneesX.add(1.0);
	}
	
	@Test
	public void Test() {
		assertTrue(formules.variance(donneesX) == 1.66599491942527584E17);
	}
}
