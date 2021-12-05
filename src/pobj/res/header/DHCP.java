package pobj.res.header;

import java.util.StringJoiner;

import pobj.exceptions.ErrorValueException;
import pobj.res.StringUtility;

/**
 * Classe gerant une entete DHCP
 * @author Sharane et Yannis
 *
 */
public class DHCP extends Header {
	//constantes representant l'indice des champs de l'entete DHCP dans la liste des champs
	public static final int OPCODE_INDICE = 0;
	public static final int HARDWARE_TYPE_INDICE = 1;
	public static final int HARDWARE_ADDRESS_LENGTH_INDICE = 2;
	public static final int HOPS_INDICE = 3;
	public static final int TRANSACTION_ID_INDICE = 4;
	public static final int SECONDS_INDICE = 5;
	public static final int FLAGS_INDICE = 6;
	public static final int CLIENT_IP_INDICE = 7;
	public static final int YOUR_IP_INDICE = 8;
	public static final int SERVER_IP_INDICE = 9;
	public static final int GATEWAY_IP_INDICE = 10;
	public static final int CLIENT_HARDWARE_ADDRESS_INDICE = 11;
	public static final int SERVER_NAME_INDICE = 12;
	public static final int BOOT_FILE_NAME_INDICE = 13;
	public static final int MAGIC_COOKIE_INDICE = 14;
	
	
	/**
	 * Construit une entete DHCP
	 * @param value Chaine de longueur variable composee d'octets sans espaces
	 */
	public DHCP(String value)
	{
		String opcode = value.substring(0, 2);
		String hardwareType = value.substring(2, 4);
		String hardwareAddressLength = value.substring(4,6);
		String hops = value.substring(6,8);
		
		
		String transactionId = value.substring(8,16);
		
		String seconds = value.substring(16,20);
		String flags = value.substring(20,24);
		
		String clientIp = value.substring(24,32);
		String yourIp = value.substring(32,40);
		String serverIp = value.substring(40,48);
		String gatewayIp = value.substring(48,56);
		String clientHardwareAddress = value.substring(56,88);	
		String serverName = value.substring(88,216);	
		String bootFileName = value.substring(216,472);	
		String magicCookie = value.substring(472,480);	
		
		//TODO options
		
		
		//ajout des champs dans la liste des champs
		this.addField(new Field(opcode, "Message Type"));
		this.addField(new Field(hardwareType, "Hardware Type"));
		this.addField(new Field(hardwareAddressLength, "Hardware Address Length"));
		this.addField(new Field(hops, "Hops"));
		this.addField(new Field(transactionId, "Transaction ID"));
		this.addField(new Field(seconds, "Secons elapsed"));
		this.addField(new Field(flags, "Bootp flags"));
		this.addField(new Field(clientIp, "Client IP address"));
		this.addField(new Field(yourIp, "Your (client) IP address"));
		this.addField(new Field(serverIp, "Next server IP address"));
		this.addField(new Field(gatewayIp, "Relay agent IP address"));
		this.addField(new Field(clientHardwareAddress, "Client MAC Address"));
		this.addField(new Field(serverName, "Server Host Name"));
		this.addField(new Field(bootFileName, "Boot File Name"));
		this.addField(new Field(magicCookie, "Magic Cookie"));
		
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

