package pobj.res.header;

import pobj.exceptions.TrameTooShortException;
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
	 * @throws TrameTooShortException 
	 */
	public UDP(String value) throws TrameTooShortException
	{
		if(value.length()<this.getLength())throw new TrameTooShortException();
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
		StringBuilder sb = new StringBuilder();
		Field srcp = this.getFields().get(0);
		Field destp = this.getFields().get(1);
		Field totl = this.getFields().get(2);
		Field chks = this.getFields().get(3);
		
		sb.append("User Datagram Protocol :\n");
		sb.append("\t"+srcp.getName()+":  "+StringUtility.hexaToInt(srcp.getValue())+" (0x"+srcp.getValue()+")\n");
		sb.append("\t"+destp.getName()+":  "+StringUtility.hexaToInt(destp.getValue())+" (0x"+destp.getValue()+")\n");
		sb.append("\t"+totl.getName()+":  "+StringUtility.hexaToInt(totl.getValue())+" (0x"+totl.getValue()+")\n");
		sb.append("\t"+chks.getName()+":  0x"+chks.getValue()+"\n");
		
		return sb.toString();

	}
	
	/**
	 * Renvoie la longueur de l'entete udp
	 * @return La longueur de l'entete udp
	 */
	@Override
	public int getLength() {
		return 16;
	}

	/**
	 * Renvoie la valeur du champ 'Protocol' de l'entete udp
	 * @return La valeur du champ
	 */
	@Override
	public String getNext() {
		return "";
	}
}
