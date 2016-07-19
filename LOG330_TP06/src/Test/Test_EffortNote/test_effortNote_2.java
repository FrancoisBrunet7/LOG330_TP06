package Test.Test_EffortNote;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import app.Formules;

public class test_effortNote_2 {
	
	Formules formules = new Formules();
	ArrayList<Double> donneesX;
	ArrayList<Double> donneesY;
	
	@Before
	public void faireAvant() {
		donneesX = new ArrayList<Double>();
		donneesX.add(0.0);
		donneesX.add(4.0);
		donneesX.add(0.0);
		donneesX.add(-4.0);
		donneesY = new ArrayList<Double>();
		donneesY.add(10.0);
		donneesY.add(0.0);
		donneesY.add(30.0);
		donneesY.add(0.0);
	}
	
	@Test
	public void Test() {
		assertTrue(formules.coeffDeDetermination(donneesX, donneesY) == 0.0);
	}
}
