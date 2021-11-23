package pobj.res.couche;

import pobj.res.protocole.Protocole;

/**
 * Classe abstraite gerant une couche
 * @author Sharane et Yannis
 *
 */
public abstract class Couche {
	//Le protocole utilise dans la couche
	private Protocole a_protocole;
	
	/**
	 * Constructeur avec un protocole en argument
	 * @param p Le protocole a utiliser
	 */
	public Couche(Protocole p)
	{
		a_protocole = p;
	}
	
	/**
	 * Accesseur sur le protocole de la couche
	 * @return Le protocole dans la couche
	 */
	public Protocole getProtocole() {return a_protocole;}
}
