package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Nom : Francois Brunet
 * Description : Extrait les données en X et Y du fichier et les place dans 2 ArrayList<Double>
 */
public class DataExtractor extends Observable implements Observer {
	
	protected ArrayList<Double> donneesX = new ArrayList<Double>();
	protected ArrayList<Double> donneesY = new ArrayList<Double>();
	
	/**
	 * Constructeur
	 */
	public DataExtractor() {
		addObserver(new Calculator());
	}
	
	public ArrayList<Double> getDonneesX() {
		return donneesX;
	}
	
	public ArrayList<Double> getDonneesY() {
		return donneesY;
	}

	@Override
	public void update(Observable fileSelector, Object arg1) {
		
		try {
			extractData(((FileSelector) fileSelector).getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}

		setChanged();
		notifyObservers();
	}
	
	/**
	 * Lit le fichier place les données en x et y dans 2 ArrayList<Double>
	 * @param file Le fichier à lire
	 * @throws IOException
	 */
	protected void extractData(File file) throws IOException {

		int row = 0;
		int nombreDePaires = 0;
		Scanner scanner = new Scanner(file);

	    while(scanner.hasNext()){

		    String[] paireDeDonnees = scanner.next().split(";");
		    	
		    if(row == 0) {   
		    	nombreDePaires = Integer.parseInt(paireDeDonnees[1]);
		    }
		    
		    if(paireDeDonnees.length == nombreDePaires + 1 && row != 0) {
		    	try {
		    		for(int i = 1 ; i < nombreDePaires + 1 ; i++) { 
		    			if(row == 1) {
		    				donneesX.add(Double.parseDouble(paireDeDonnees[i].replace(",", ".")));
		    			 } else if(row == 2){
		    				donneesY.add(Double.parseDouble(paireDeDonnees[i].replace(",", ".")));
		    			 } 
		    		}
		    	} catch(NumberFormatException e) { 
		    		//Do nothing, just skips the string.
		    	}
		    }
		    row++;
	    }    
	    scanner.close();
	}
}
