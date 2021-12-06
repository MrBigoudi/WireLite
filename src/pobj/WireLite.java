package pobj;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import pobj.res.*;

/**
 * Classe representant le wireshark lite
 * @author Sharane et Yannis
 *
 */
public class WireLite {
	//file temporaire dans laquelle sera copie le contenu du fichier en entree
	//private static final String TMP_COPY_FILE_PATH = "tmpFile";
	
	public static void main(String[] args)
	{
		//erreur si pas d'arguments
		if(args.length==0)
		{
			System.out.println("This application need a file as an input !");
			return;
		}
		
		//test du parametre
		String filePath = args[0];
		File originFile = new File(filePath);
		//erreur si ce n'est pas un fichier
		if(!originFile.isFile())
		{
			System.out.println("The given argument is not a file !");
			return;
		}
		
		//mise en place des trames au bon format
		InputFileManager ifm = new InputFileManager(originFile.getPath());
		List<String> list = ifm.getTrames();
		
		//creation de la liste des trames
		List<ITrame> listTrames = new ArrayList<>();
		for(String s : list)
		{
			TrameBuilder trBuild = new TrameBuilder(s);
			TrameDirector trDirector = new TrameDirector(trBuild);
			//creation de la trame
			trDirector.constructTrame();
			listTrames.add(trDirector.getTrame());
		}
		
		//affichage des trames
		for(ITrame trame : listTrames)
			System.out.println(trame.toString());
		
	}
}
