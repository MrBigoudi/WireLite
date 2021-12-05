package pobj.res;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de faire des operations sur les fichiers passes en argument
 * @author Sharane et Yannis
 *
 */
public class InputFileManager {
	//le nom du fichier en entree du programme
	private String fileName;
	//list contenant les trames sous forme de chaines sans espaces
	private List<String> listTrames = new ArrayList<>();
	
	/**
	 * Construteur classique
	 * @param file Le nom du fichier en entree du programme
	 */
	private InputFileManager(String file)
	{
		//TODO cree une copie du fichier sur laquelle on travaillera
		testCoherenceFichier();
		removeUselessChars();
		listTrames = this.parseTramesInFiles();
	}
	
	/**
	 * Verifie que le fichier en entree n'a pas d'erreur d'offset, une erreur d'offset implque le retrait de la trame dans le fichier
	 */
	private void testCoherenceFichier()
	{
		//TODO
	}
	
	/**
	 * Enleve les charcateres en trop dans le fichier d'entree
	 */
	private void removeUselessChars()
	{
		//TODO
	}
	
	/**
	 * Transforme chaque trames du fichier en chaine de characteres et l'ajoute dans la liste des trames
	 */
	private List<String> parseTramesInFiles()
	{
		//TODO
		return new ArrayList<String>();
	}
}
