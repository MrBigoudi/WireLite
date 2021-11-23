package pobj.res.couche;

import pobj.res.protocole.IP;

/**
 * Classe gerant une couche Reseau
 * @author Sharane et Yannis
 *
 */
public class Reseau extends Couche {
	/**
	 * Consturcteur prenant un protocole ip en parametre
	 * @param i Le protocole ip de la couche
	 */
	public Reseau(IP i)
	{
		super(i);
	}
}
