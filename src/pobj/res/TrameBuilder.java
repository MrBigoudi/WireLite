package pobj.res;

import pobj.exceptions.UnsupportedProtocolException;
import pobj.res.header.*;

/**
 * Constructeur de trames
 * @author Sharane et Yannis
 *
 */
public class TrameBuilder implements ITrameBuilder {
	private Trame trame;//la trame a construire
	private String content;//le contenu de la trame
	private int contentPointer = 0;//pointeur de characteres du champ content
	private String nextType; //valeur representant le type de la prochaine couche
	
	/**
	 * Constructeur prenant en argument le contenu d'une trame sous forme d'une liste d'hexa sans espaces
	 * @param content Le contenu d'une trame valide
	 */
	public TrameBuilder(String content)
	{
		this.trame = new Trame();
		this.content = content;
	}
	
	/**
	 * Initialise l'entete liaison de la trame
	 */
	@Override
	public void buildLiaison() {
		//creation de l'entete ethernet
		Ethernet eth = new Ethernet(content.substring(contentPointer));
		//ajout de l'entete ethernet dans la trame
		this.getTrame().setLiaison(eth);
		//mise a jour du pointeur de la chaine representant la trame
		contentPointer += eth.getLength();
		//mise a jour du prochain type encapsule
		nextType = eth.getNext();
	}

	/**
	 * Initialise l'entete reaseau de la trame
	 */
	@Override
	public void buildReseau() {
		Header reseau = null;
		//on test le type du paquet de la couche Reseau
		switch(nextType)
		{
		//cas couche Reseau = IP
		case "0800":
			//creation de l'entete ip
			reseau = new IP(content.substring(this.contentPointer));
			break;
		default:
			return;
		}
		//ajout de l'entete ip
		this.getTrame().setReseau(reseau);
		//mise a jour du pointeur
		contentPointer += reseau.getLength(); 
		//mise a jour du prochain type encapsule
		nextType = reseau.getNext();
	}

	/**
	 * Initialise l'entete transport de la trame
	 */
	@Override
	public void buildTransport() {
		// TODO Auto-generated method stub

	}

	/**
	 * Initialise l'entete application de la trame
	 */
	@Override
	public void buildApplication() {
		// TODO Auto-generated method stub

	}

	/**
	 * Initialise le champ data de la trame
	 */
	@Override
	public void buildData() {
		// TODO Auto-generated method stub

	}

	/**
	 * Renvoie la trame cree
	 */
	@Override
	public ITrame getTrame() {
		return this.trame;
	}

	/**
	 * Reinitialise le pointeur de donnees du constructeur
	 */
	@Override
	public void reset() {
		this.contentPointer = 0;
		this.nextType = "";
		this.trame = new Trame();
	}

}
