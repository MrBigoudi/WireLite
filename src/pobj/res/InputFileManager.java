package pobj.res;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

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
		//met le fichier sous forme de liste de String representant les lignes du fichier
		List<String> tmp = this.getLinesFromFile(filePath);
		/**
		for(String s : tmp)
		{
			System.out.println(s);
		}
		**/
		List<String[]> tmp2 = this.removeSpaces(tmp);
		//this.afficheListStringTab(tmp2);
		List<List<String[]>> tmp3 = this.splitTrames(tmp2);
		for(List<String[]> l : tmp3)
		{
			System.out.println("trame:");
			this.afficheListStringTab(l);
		}
	}
		
	/**
	 * Affiche une liste de String[]
	 * @param liste La liste a afficher
	 */
	private void afficheListStringTab(List<String[]> liste)
	{
		for(String[] tab : liste)
		{
			StringJoiner sj = new StringJoiner(",","[","]");
			for(int i=0; i<tab.length; i++)
				sj.add(tab[i]);
			System.out.println(sj.toString());
		}
	}
	
	/**
	 * Accesseur sur la liste des trames
	 * @return La liste des trames
	 */
	public List<String> getTrames(){return this.listTrames;}
	
	/**
	 * Copy les ignes d'un fichier dans une liste de String
	 * @param file Le fichier lus
	 * @return La liste des lignes du fichier
	 */
	private List<String> getLinesFromFile(String file)
	{
		List<String> res = new ArrayList<>();
		
		//ouverture du fichier
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while(line!=null)
			{
				res.add(line);
				line = br.readLine();	
			}				
		}catch(IOException ie) {
			System.out.println("Impossible d'ouvrir le fichier!");
			ie.printStackTrace();
		}
		
		return res;		
	}
	
	/**
	 * Cree une liste de tableau de String representant chacun une ligne du fichier sans espaces
	 * @param fileContent Le contenu du fichier sous forme de liste de String
	 * @return La liste des tableau de String
	 */
	private List<String[]> removeSpaces(List<String> fileContent)
	{
		List<String[]> res = new ArrayList<>();
		for(String s : fileContent)
		{
			String[] tmp = s.split(" ");
			tmp = Arrays.stream(tmp).filter(e -> e.trim().length() > 0).toArray(String[]::new);
			//si la ligne n'est pas vide
			if(tmp.length!=0)
				res.add(tmp);
		}
		return res;
	}
	
	/**
	 * Repartis les trames en sous liste de liste
	 * @param fileContent Les trames sous forme de list de tableau de String
	 * @return Une liste de liste de tableau de String representant les differentes trames contenue dans le fichier
	 */
	private List<List<String[]>> splitTrames(List<String[]> fileContent)
	{
		List<List<String[]>> res = new ArrayList<>();
		int indiceLigne=0;
		List<String[]> tmp = new ArrayList<>();
		//pour chaque ligne du fichier
		while(indiceLigne<fileContent.size())
		{
			//si on a un offset a 0
			int t = StringUtility.hexaToInt(fileContent.get(indiceLigne)[0]);
			if(t==0)
			{
				if(!tmp.isEmpty())
					//on ajoute la liste representant la trame au resultat (si elle n'est pas vide)
					res.add(tmp);
				//on reset la liste temporaire
				tmp = new ArrayList<>();
			}
			//on ajoute la ligne a la liste temporaire
			tmp.add(fileContent.get(indiceLigne));
			indiceLigne++;
		}
		res.add(tmp);
		return res;
	}
	
	/**
	 * Transforme le contenu du fichier en enlevenat les elements de fin en trop
	 * @param fileContent
	 * @return
	 */
	private List<String[]> removeNotCorrectOffset(List<String[]> fileContent)
	{
		return null;
	}
}
