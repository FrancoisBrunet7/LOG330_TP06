package Test.Test_IntervalleConf;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Formules;

public class test_intervalleConf_1 {
	
	Formules formules = new Formules();
	ArrayList<Double> donneesX;
	ArrayList<Double> donneesY;
	
	@Before
	public void faireAvant() {
		donneesX = new ArrayList<Double>();
		donneesX.add(1000000.0);
		donneesX.add(1000.0);
		donneesX.add(100.0);
		donneesX.add(1.0);
		donneesY = new ArrayList<Double>();
		donneesY.add(1.0);
		donneesY.add(2.0);
		donneesY.add(3.0);
		donneesY.add(4.0);
	}
	
	@Test
	public void Test() {
		assertTrue(formules.intervalleDeConfiance(5, 1.108, donneesX, donneesY) == 1.278245069566092);
	}
}
