package pobj.res.header;

import pobj.exceptions.ErrorValueException;

/**
 * Classe gerant une entete ip
 * @author Sharane et Yannis
 *
 */
public class IP extends Header {
	/**
	 * Construit une entete ip
	 * @param value Chaine de longueur variable composee d'octets sans espaces
	 */
	public IP(String value)
	{
		String version = value.substring(0, 2);
		String headerLength = value.substring(2, 4);
		String tos = value.substring(4,8);
		String dataLength = value.substring(8,16);
		String identifier = value.substring(16,24);
		//TODO fragment offset
		String ttl = value.substring(32,36);
		String protocol = value.substring(36,40);
		String checksum = value.substring(40,48);
		String srcIp = value.substring(48,64);
		String dstIp = value.substring(64,80);
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
	}
	
	/**
	 * Test si la valeur du champ 'Version' est correcte
	 * @param version La valeure du champ
	 * @throws ErrorValueException
	 */
	private void testVersion(String version) throws ErrorValueException
	{
		if(!version.equals("04"))
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
		int theoreticalLength = Integer.parseInt(headerLength, 16); //convert hex in a string to an int
		if(ipValue.length() != 2*theoreticalLength*4) //2* car length renvoie le nombre de demi-octets (ie le nombre de characteres en hexa)
			throw new ErrorValueException("Valeure incohérente pour le champ 'HeaderLength' de IP!");
	}
}
