package Test.Test_Variance;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Formules;

public class test_variance_1 {
	
	Formules formules = new Formules();
	ArrayList<Double> donneesX;
	
	@Before
	public void faireAvant() {
		donneesX = new ArrayList<Double>();
		donneesX.add(1.0);		
	}
	
	@Test
	public void Test() {
		assertTrue(String.valueOf(formules.variance(donneesX)) == "NaN");
	}
}