package pobj.res.protocole;

import pobj.res.Header;
import pobj.res.IData;

/**
 * Classe abstraite gerant un protocole
 * @author Sharane et Yannis
 *
 */
public abstract class Protocole implements IData {
	//les donnes ou protocole encapsules
	private IData data;
	//l'entete du protocole
	private Header header;
	
	/**
	 * Constructeur prenant en argument des donnees
	 * @param data
	 */
	public Protocole(IData data)
	{
		//TODO
	}

	/**
	 * Accesseur sur les donnees
	 * @return Les donnees encapsulees
	 */
	public IData getData() {return data;}
	/**
	 * Accesseur sur l'entete
	 * @return L'entete
	 */
	public Header getHeader() {return header;}
	
	
}
