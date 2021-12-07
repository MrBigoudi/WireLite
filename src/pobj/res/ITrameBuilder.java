package pobj.res;

import pobj.exceptions.ErrorValueException;
import pobj.exceptions.TrameTooShortException;
import pobj.exceptions.UnsupportedProtocolException;

/**
 * Interface permettant de construire une trame selon le Design Pattern Builder
 * @author Sharane et Yannis
 *
 */
public interface ITrameBuilder {
	/**
	 * Initialise l'entete liaison de la trame
	 * @throws UnsupportedProtocolException
	 * @throws TrameTooShortException 
	 */
	public void buildLiaison() throws UnsupportedProtocolException, TrameTooShortException;
	
	/**
	 * Initialise l'entete reseau de la trame
	 * @throws ErrorValueException 
	 */
	public void buildReseau() throws ErrorValueException;
	
	/**
	 * Initialise l'entete transport de la trame
	 */
	public void buildTransport();
	
	/**
	 * Initialise l'entete application de la trame
	 */
	public void buildApplication();
	
	/**
	 * Renvoie la trame cree
	 * @return La trame cree
	 */
	public ITrame getTrame();
	
	/**
	 * Reinitialise le constructeur de trame
	 */
	public void reset();
}
