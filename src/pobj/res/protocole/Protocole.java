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
	private Header head;
}
