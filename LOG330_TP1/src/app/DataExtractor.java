package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * @author Francois
 *
 *Extrait les données du fichier et les place dans un ArrayList<Double>
 */
public class DataExtractor extends Observable implements Observer {
	
	protected ArrayList<Double> donnees = new ArrayList<Double>();
	
	/**
	 * Constructeur
	 */
	public DataExtractor() {
		addObserver(new Calculator());
	}
	
	public ArrayList<Double> getDonnees() {
		return donnees;
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
	 * Lit le fichier place les données dans un ArrayList<Double>
	 * @param file Le fichier à lire
	 * @throws IOException
	 */
	protected void extractData(File file) throws IOException {

		 Scanner scanner = new Scanner(file);
	     while(scanner.hasNext()){
	    	 donnees.add(Double.parseDouble(scanner.next()));
	     }
	     scanner.close();
	}
}
