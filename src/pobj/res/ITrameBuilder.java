package pobj.res;

/**
 * Interface permettant de construire une trame selon le Design Pattern Builder
 * @author Sharane et Yannis
 *
 */
public interface ITrameBuilder {
	/**
	 * Initialise l'entete liaison de la trame
	 */
	public void buildLiaison();
	
	/**
	 * Initialise l'entete reseau de la trame
	 */
	public void buildReseau();
	
	/**
	 * Initialise l'entete transport de la trame
	 */
	public void buildTransport();
	
	/**
	 * Initialise l'entete application de la trame
	 */
	public void buildApplication();
	
	/**
	 * Initialise les donnees de la trame
	 */
	public void buildData();
	
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
