package pobj.res.header;

import java.util.StringJoiner;

import pobj.exceptions.ErrorValueException;
import pobj.res.StringUtility;

/**
 * Classe gerant une entete ip
 * @author Sharane et Yannis
 *
 */
public class IP extends Header {
	//constantes representant l'indice des champs de l'entete IP dans la liste des champs
	public static final int VERSION_INDICE = 0;
	public static final int IHL_INDICE = 1;
	public static final int TOS_INDICE = 2;
	public static final int TOTAL_LENGTH_INDICE = 3;
	public static final int IDENTIFICATION_INDICE = 4;
	public static final int R_INDICE = 5;
	public static final int DF_INDICE = 6;
	public static final int MF_INDICE = 7;
	public static final int FRAGMENT_OFFSET_INDICE = 8;
	public static final int TTL_INDICE = 9;
	public static final int PROTOCOL_INDICE = 10;
	public static final int HEADER_CHECKSUM_INDICE = 11;
	public static final int SRC_ADDR_INDICE = 12;
	public static final int DEST_ADDR_INDICE = 13;
	
	/**
	 * Construit une entete ip
	 * @param value Chaine de longueur variable composee d'octets sans espaces
	 */
	public IP(String value)
	{
		String version = value.substring(0, 1);
		String headerLength = value.substring(1, 2);
		String tos = value.substring(2,4);
		String dataLength = value.substring(4,8);
		
		
		String identifier = value.substring(8,12);
		
		String[] tmp = initFragmentOffset(value.substring(12,16)); //variable temporaire pour initialiser les elements du fragment offset
		String R = tmp[0];
		String DF = tmp[1];
		String MF = tmp[2];
		String fragmentOffset = tmp[3];
		
		
		String ttl = value.substring(16,18);
		String protocol = value.substring(18,20);
		String checksum = value.substring(20,24);
		String srcIp = value.substring(24,32);
		String dstIp = value.substring(32,40);	
		
		//TODO options
		
		//test de validité des champs
		try
		{
			this.testVersion(version);
			this.testHeaderLength(headerLength, value);
		}catch(ErrorValueException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		//ajout des champs dans la liste des champs
		this.addField(new Field(version, "Version"));
		this.addField(new Field(headerLength, "Header Length"));
		this.addField(new Field(tos, "TOS"));
		this.addField(new Field(dataLength, "Total Length"));
		this.addField(new Field(identifier, "Identification"));
		this.addField(new Field(R, "R"));
		this.addField(new Field(DF, "DF"));
		this.addField(new Field(MF, "MF"));
		this.addField(new Field(fragmentOffset, "Fragment Offset"));
		this.addField(new Field(ttl, "TTL"));
		this.addField(new Field(protocol, "Protocol"));
		this.addField(new Field(checksum, "Header Checksum"));
		this.addField(new Field(srcIp, "Source Address"));
		this.addField(new Field(dstIp, "Destination Address"));
		
	}
	
	/**
	 * Test si la valeur du champ 'Version' est correcte
	 * @param version La valeure du champ
	 * @throws ErrorValueException
	 */
	private void testVersion(String version) throws ErrorValueException
	{
		if(!version.equals("4"))
			throw new ErrorValueException("Mauvaise valeure pour le champ 'Version' de IP!");
	}
	
	/**
	 * Test si la valeur du champ 'HeaderLength' est coherente
	 * @param headerLength La valeur du champ sous forme de chaine de characteres
	 * @param ipValue La valeur de l'entete ip sous forme de chaine de characteres
	 * @throws ErrorValueException
	 */
	private void testHeaderLength(String headerLength, String ipValue) throws ErrorValueException
	{
		int theoreticalLength = StringUtility.hexaToInt(headerLength);
		if(ipValue.length() != 2*theoreticalLength*4) //2* car length renvoie le nombre de demi-octets (ie le nombre de characteres en hexa)
			throw new ErrorValueException("Valeure incohérente pour le champ 'HeaderLength' de IP!");
	}
	
	/**
	 * Initialise un tableau contenant les valeurs des elements du fragment offset
	 * @param value La valeur en hexa des 2 octets du champ
	 * @return Le tableau contenant les valeurs des sous champs sous forme de chaines de characteres
	 */
	private String[] initFragmentOffset(String value)
	{
		String[] res = new String[4];
		String binary = StringUtility.hexaToBinary(value);
		//System.out.println(value+"\n\n"+binary);
		//set de R, DF et MF
		for(int i=0; i<3; i++) {res[i]=binary.charAt(i)+"";}
		//set de fragment offset
		res[3]=binary.substring(3);
		return res;
	}
	
	public static String convertHexToIP(String hex)
	{
	    String ip= "";

	    for (int j = 0; j < hex.length(); j+=2) {
	        String sub = hex.substring(j, j+2);
	        int num = Integer.parseInt(sub, 16);
	        ip += num+".";
	    }

	    ip = ip.substring(0, ip.length()-1);
	    return ip;
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
