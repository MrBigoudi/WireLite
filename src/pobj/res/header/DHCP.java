package pobj.res.header;

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
	public static final int CLIENT_HARDWARE_ADDRESS_PADDING_INDICE = 12;
	public static final int SERVER_NAME_INDICE = 13;
	public static final int BOOT_FILE_NAME_INDICE = 14;
	public static final int MAGIC_COOKIE_INDICE = 15;
	
	
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
		String clientMACAddress = value.substring(56,68);
		String clientHardwareAddressPad = value.substring(68,88);	
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
		this.addField(new Field(clientMACAddress, "Client MAC Address"));
		this.addField(new Field(clientHardwareAddressPad, "Client Hardware Address Padding"));
		this.addField(new Field(serverName, "Server Host Name"));
		this.addField(new Field(bootFileName, "Boot File Name"));
		this.addField(new Field(magicCookie, "Magic Cookie"));
		
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		Field op = this.getFields().get(0);
		Field hardtype = this.getFields().get(1);
		Field hardadlen = this.getFields().get(2);
		Field hop = this.getFields().get(3);
		Field transId = this.getFields().get(4);
		Field sec = this.getFields().get(5);
		Field fl = this.getFields().get(6);
		Field cliIp = this.getFields().get(7);
		Field yIp = this.getFields().get(8);
		Field srvIp = this.getFields().get(9);
		Field gateIp = this.getFields().get(10);
		Field clihardadd = this.getFields().get(11);
		Field clipad = this.getFields().get(12);
		Field srvname = this.getFields().get(13);
		Field bootfname = this.getFields().get(14);
		Field magic = this.getFields().get(15);
		
		sb.append("Dynamic Host Configuration Protocol : \n");
		if (Integer.parseInt(op.getValue(),16)==1)
			sb.append("\t"+op.getName()+" : Boot Request ("+StringUtility.hexaToInt(op.getValue())+") (0x"+op.getValue()+")\n");
		if (Integer.parseInt(op.getValue(),16)==2)
			sb.append("\t"+op.getName()+" : Boot Reply ("+StringUtility.hexaToInt(op.getValue())+") (0x"+op.getValue()+")\n");
		if (Integer.parseInt(hardtype.getValue(),16)==1)
			sb.append("\t"+hardtype.getName()+" :  Ethernet (0x"+hardtype.getValue()+")\n");
		else
			sb.append("\t"+hardtype.getName()+" :  "+ StringUtility.hexaToInt(hardtype.getValue()) +" (0x"+hardtype.getValue()+")\n");
		sb.append("\t"+hardadlen.getName()+" :  "+StringUtility.hexaToInt(hardadlen.getValue())+" (0x"+hardadlen.getValue()+")\n");
		sb.append("\t"+hop.getName()+" :  "+StringUtility.hexaToInt(hop.getValue())+" (0x"+hop.getValue()+")\n");
		sb.append("\t"+transId.getName()+" : 0x"+transId.getValue()+"\n");
		sb.append("\t"+sec.getName()+" :  "+StringUtility.hexaToInt(sec.getValue())+" (0x"+sec.getValue()+")\n");
		sb.append("\t"+fl.getName()+" :  "+StringUtility.hexaToInt(fl.getValue())+" (0x"+fl.getValue()+")\n");
		sb.append("\t"+cliIp.getName()+" :  "+IP.convertHexToIP(cliIp.getValue())+" (0x"+cliIp.getValue()+")\n");
		sb.append("\t"+yIp.getName()+" :  "+IP.convertHexToIP(yIp.getValue())+" (0x"+yIp.getValue()+")\n");
		sb.append("\t"+srvIp.getName()+" :  "+IP.convertHexToIP(srvIp.getValue())+" (0x"+srvIp.getValue()+")\n");
		sb.append("\t"+gateIp.getName()+" :  "+IP.convertHexToIP(gateIp.getValue())+" (0x"+gateIp.getValue()+")\n");
		sb.append("\t"+clihardadd.getName()+" :  "+Ethernet.strToMacAddress(clihardadd.getValue())+" (0x"+clihardadd.getValue()+")\n");
		sb.append("\t"+clipad.getName()+" : (0x"+clipad.getValue()+")\n");
		if (Integer.parseInt(srvname.getValue(),16)==0)
			sb.append("\t"+srvname.getName()+" not given \n");
		else
			sb.append("\t"+srvname.getName()+" :  "+Integer.parseInt(srvname.getValue(),16)+" (0x"+srvname.getValue()+")\n");
		if (Integer.parseInt(bootfname.getValue(),16)==0)
			sb.append("\t"+bootfname.getName()+" not given \n");
		else
			sb.append("\t"+bootfname.getName()+" :  "+Integer.parseInt(bootfname.getValue(),16)+" (0x"+bootfname.getValue()+")\n");
		
		if (Integer.parseInt(magic.getValue(),16)==1669485411)// vérifier avec un split en 4 de 0x63825363 
			sb.append("\t"+magic.getName()+" :  DHCP\n");

		return sb.toString();
	}
	
	/**
	 * Renvoie la longueur de l'entete dhcp
	 * @return La longueur de l'entete dhcp
	 */
	@Override
	public int getLength() {
		return 474;
	}

	/**
	 * Renvoie la valeur du champ 'Protocol' de l'entete dhcp
	 * @return La valeur du champ
	 */
	@Override
	public String getNext() {
		return "";
	}

}

