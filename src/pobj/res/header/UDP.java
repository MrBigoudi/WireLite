package pobj.res.header;

import java.util.StringJoiner;

import pobj.exceptions.ErrorValueException;
import pobj.res.StringUtility;

/**
 * Classe gerant une entete UDP
 * @author Sharane et Yannis
 *
 */
public class UDP extends Header {
	//constantes representant l'indice des champs de l'entete UDP dans la liste des champs
	public static final int SRC_PORT_INDICE = 0;
	public static final int DEST_PORT_INDICE = 1;
	public static final int TOTAL_LENGTH_INDICE = 2;
	public static final int CHECKSUM_INDICE = 3;

	
	/**
	 * Construit une entete UDP
	 * @param value Chaine de longueur variable composee d'octets sans espaces
	 */
	public UDP(String value)
	{
		String srcPort = value.substring(0, 4);
		String destPort = value.substring(4, 8);
		String totLength = value.substring(8,12);
		String checksum = value.substring(12,16);
		
		
		//TODO options
		
		
		//ajout des champs dans la liste des champs
		this.addField(new Field(srcPort, "Source Port"));
		this.addField(new Field(destPort, "Destination Port"));
		this.addField(new Field(totLength, "Total length"));
		this.addField(new Field(checksum, "Checksum"));

		
	}
		
	@Override
	public String toString()
	{
		StringJoiner sj = new StringJoiner("\n");
		for(Field f : this.getFields())
			sj.add(f.toString());
		return sj.toString();
	}
}
