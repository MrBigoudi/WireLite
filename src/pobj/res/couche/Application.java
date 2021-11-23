package pobj.res.couche;

import pobj.res.protocole.DHCP;
import pobj.res.protocole.DNS;

/**
 * Classe gerant une couche Application
 * @author Sharane et Yannis
 *
 */
public class Application extends Couche {	
	/**
	 * Constructeur avec un protocole DHCP en argument
	 * @param p Le protocole DHCP ou DNS a utiliser
	 */
	public Application(DHCP dhcp)
	{
		super(dhcp);
	}
	/**
	 * Constructeur avec un protocole DNS en argument
	 * @param p Le protocole DHCP ou DNS a utiliser
	 */
	public Application(DNS dns)
	{
		super(dns);
	}
}
