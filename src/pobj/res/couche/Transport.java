package pobj.res.couche;

import pobj.res.protocole.UDP;

/**
 * Classe gerant une couche Transport
 * @author Sharane et Yannis
 *
 */
public class Transport extends Couche {
	/**
	 * Constructeur prenant en argument un protocole UDP
	 * @param udp Le protocole de la couche
	 */
	public Transport(UDP udp)
	{
		super(udp);
	}
}
