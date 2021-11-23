package pobj.res.couche;

import pobj.res.protocole.Ethernet;

/**
 * Classe gerant une couche liaison
 * @author Sharane et Yannis
 *
 */
public class Liaison extends Couche {
	/**
	 * Constructeur prenant en argument un protocole Ethernet
	 * @param e Le protocole Ethernet de la couche
	 */
	public Liaison(Ethernet e)
	{
		super(e);
	}
}
