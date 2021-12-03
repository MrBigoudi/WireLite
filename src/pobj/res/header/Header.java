package pobj.res.header;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe gerant les Entetes
 * @author Sharane et Yannis
 *
 */
public class Header {
	//liste de champs
	private List<Field> a_fields = new ArrayList<>();
	
	/**
	 * Ajoute un champ dans l'entete
	 * @param f Le champ a ajouter
	 */
	public void addField(Field f) {a_fields.add(f);}
	
	/**
	 * Accesseur sur la liste des champs de l'entete
	 * @return
	 */
	public List<Field> getFields(){return a_fields;}
}
