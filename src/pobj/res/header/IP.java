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
	public static final int IP_VERSION_INDICE = 0;
	public static final int IP_IHL_INDICE = 1;
	public static final int IP_TOS_INDICE = 2;
	public static final int IP_TOTAL_LENGTH_INDICE = 3;
	public static final int IP_IDENTIFICATION_INDICE = 4;
	public static final int IP_R_INDICE = 5;
	public static final int IP_DF_INDICE = 6;
	public static final int IP_MF_INDICE = 7;
	public static final int IP_FRAGMENT_OFFSET_INDICE = 8;
	public static final int IP_TTL_INDICE = 9;
	public static final int IP_PROTOCOL_INDICE = 10;
	public static final int IP_HEADER_CHECKSUM_INDICE = 11;
	public static final int IP_SRC_ADDR_INDICE = 12;
	public static final int IP_DEST_ADDR_INDICE = 13;
	
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
			//this.testHeaderLength(headerLength, value);
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
	
	
	/**************** TODO a modifier
	/**
	 * Test si la valeur du champ 'HeaderLength' est coherente
	 * @param headerLength La valeur du champ sous forme de chaine de characteres
	 * @param ipValue La valeur de l'entete ip sous forme de chaine de characteres
	 * @throws ErrorValueException
	 */
	/**
	private void testHeaderLength(String headerLength, String ipValue) throws ErrorValueException
	{
		int theoreticalLength = StringUtility.hexaToInt(headerLength);
		if(ipValue.length() != 2*theoreticalLength*4) //2* car length renvoie le nombre de demi-octets (ie le nombre de characteres en hexa)
			throw new ErrorValueException("Valeure incohérente pour le champ 'HeaderLength' de IP!");
	}
	**************************/
	
	
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
		StringBuilder sb = new StringBuilder();
		Field vers = this.getFields().get(0);
		Field headLen = this.getFields().get(1);
		Field tos = this.getFields().get(2);
		Field dLen = this.getFields().get(3);
		Field ident = this.getFields().get(4);
		Field r = this.getFields().get(5);
		Field df = this.getFields().get(6);
		Field mf = this.getFields().get(7);
		Field fOff = this.getFields().get(8);
		Field ttl = this.getFields().get(9);
		Field proto = this.getFields().get(10);
		Field chks = this.getFields().get(11);
		Field srcIP = this.getFields().get(12);
		Field destIP = this.getFields().get(13);

		sb.append("Internet Protocol Version 4 :\n");
		sb.append("\t"+vers.getName()+" :  "+StringUtility.hexaToInt(vers.getValue())+" (0x"+vers.getValue()+")\n");
		sb.append("\t"+headLen.getName()+" :  "+StringUtility.hexaToInt(headLen.getValue())*4+" bytes (0x"+headLen.getValue()+")\n");
		sb.append("\t"+tos.getName()+" :  "+StringUtility.hexaToInt(tos.getValue())+" (0x"+tos.getValue()+")\n");
		sb.append("\t"+dLen.getName()+" :  "+StringUtility.hexaToInt(dLen.getValue())+" (0x"+dLen.getValue()+")\n");
		sb.append("\t"+ident.getName()+" :  0x"+ident.getValue()+" ("+StringUtility.hexaToInt(ident.getValue())+")\n");		
		sb.append("\t"+r.getName()+" :  "+StringUtility.hexaToInt(r.getValue())+" (0x"+r.getValue()+")\n");
		sb.append("\t"+df.getName()+" :  "+StringUtility.hexaToInt(df.getValue())+" (0x"+df.getValue()+")\n");
		sb.append("\t"+mf.getName()+" :  "+StringUtility.hexaToInt(mf.getValue())+" (0x"+mf.getValue()+")\n");
		sb.append("\t"+fOff.getName()+" :  "+StringUtility.hexaToInt(fOff.getValue())+" (0x"+fOff.getValue()+")\n");
		sb.append("\t"+ttl.getName()+" :  "+StringUtility.hexaToInt(ttl.getValue())+" (0x"+ttl.getValue()+")\n");
		sb.append("\t"+proto.getName()+" :  "+StringUtility.hexaToInt(proto.getValue())+" (0x"+proto.getValue()+")\n");
		sb.append("\t"+chks.getName()+" :  0x"+chks.getValue()+"\n");
		sb.append("\t"+srcIP.getName()+" :  "+IP.convertHexToIP(srcIP.getValue())+" (0x"+srcIP.getValue()+")\n");
		sb.append("\t"+destIP.getName()+" :  "+IP.convertHexToIP(destIP.getValue())+" (0x"+destIP.getValue()+")\n");

		return sb.toString();
	}

	/**
	 * Renvoie la longueur de l'entete ip
	 * @return La longueur de l'entete ip
	 */
	@Override
	public int getLength() {
		return (2*4*StringUtility.hexaToInt(this.getFields().get(IP.IP_IHL_INDICE).getValue()));
	}

	/**
	 * Renvoie la valeur du champ 'Protocol' de l'entete ip
	 * @return La valeur du champ
	 */
	@Override
	public String getNext() {
		return this.getFields().get(IP.IP_PROTOCOL_INDICE).getValue();
	}
}
