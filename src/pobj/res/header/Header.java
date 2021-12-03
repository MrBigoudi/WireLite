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
	
	public void addField(Field f) {a_fields.add(f);}
	
	public List<Field> getFields(){return a_fields;}
}
