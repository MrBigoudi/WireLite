package pobj.res;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de faire des operations sur les fichiers passes en argument
 * @author Sharane et Yannis
 *
 */
public class InputFileManager {
	//list contenant les trames sous forme de chaines sans espaces
	private List<String> listTrames = new ArrayList<>();
	
	/**
	 * Construteur classique
	 * @param file Le nom du fichier en entree du programme
	 */
	public InputFileManager(String filePath)
	{
		testCoherenceFichier(filePath);
		removeUselessChars(filePath);
		listTrames = this.parseTramesInFiles(filePath);
	}
	
	/**
	 * Verifie que le fichier en entree n'a pas d'erreur d'offset, une erreur d'offset implique le retrait de la trame dans le fichier
	 * @param filePath Le fichier modifie
	 */
	private void testCoherenceFichier(String filePath)
	{
		//TODO
	}
	
	/**
	 * Enleve les characteres en trop dans le fichier d'entree
	 * @param filePath Le fichier modifie
	 */
	private void removeUselessChars(String filePath)
	{
		//TODO
	}
	
	/**
	 * Transforme chaque trames du fichier en chaine de characteres et l'ajoute dans la liste des trames
	 * @param filePath Le fichier modifie
	 */
	private List<String> parseTramesInFiles(String filePath)
	{
		//TODO
		return new ArrayList<String>();
	}
	
	/**
	 * Accesseur sur la liste des trames
	 * @return La liste des trames
	 */
	public List<String> getTrames(){return this.listTrames;}
}
