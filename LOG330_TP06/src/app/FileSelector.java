package app;

import java.io.File;
import java.util.Observable;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Nom : François Brunet
 * Desciption : Demande à l'utilisateur de choisir un fichier avec un extension .csv.
 * Le fichier est ensuite sauvegardé dans une variable pour lire le fichier
 * plus tard.
 */
public class FileSelector extends Observable {
	
	private File file;
	
	/**
	 * Constructeur
	 */
	public FileSelector() {
		addObserver(new DataExtractor());
	}
	
	public File getFile() {
		return file;
	}

	/**
	 * Demande à l'utilisateur de choisir un fichier .csv.
	 * Si le fichier n'est pas de type .csv ou si l'utilisateur cancel,
	 * le programme se termine.
	 */
	public void chooseAFile() {
		
		JOptionPane.showMessageDialog(null, "Veuillez choisir le fichier .csv contenant les données à utiliser");
		
		JFileChooser fileChooser = new JFileChooser();

		int returnValue = fileChooser.showOpenDialog(new JFrame());
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			
            file = fileChooser.getSelectedFile();
            
            if(verifyFileType(file)) {

            	setChanged();
            	notifyObservers();
			
            } else {

            	System.out.println("wrong extension");
            	JOptionPane.showMessageDialog(null, "Veuillez réessayer avec un fichier .csv");
            	System.exit(0);
            }
                 
        } else if(returnValue == JFileChooser.CANCEL_OPTION){
        	
        	System.out.println("canceled");
        	System.exit(0);
        }
	}

	/**
	 * Vérifie si l'extension du fichier est bien csv.
	 * @param file à vérifier
	 * @return Vrai, si l'extension est bien csv.
	 */
	protected boolean verifyFileType(File file) {
		
		boolean correctExtension = false;
		
		String extension = getExtension(file);
		
	    if (extension != null) {
	        if (extension.equals("csv")) {
	        	correctExtension = true;
	        }
	    }
		return correctExtension;
	}
	
	/**
	 * Permet d'obtenir le nom de l'extension du fichier.
	 * @param file à lire le nom de l'extension.
	 * @return le nom de l'extension
	 */
	private String getExtension(File file) {
		
		String extension = null;
        String fileName = file.getName();
        int i = fileName.lastIndexOf('.');

        if (i > 0 &&  i < fileName.length() - 1) {
            extension = fileName.substring(i+1).toLowerCase();
        }
        return extension;
	}
}

	
