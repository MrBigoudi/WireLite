package pobj.res;

/**
 * Director pour le Design Patern Builder
 * @author Sharane et Yannis
 *
 */
public class TrameDirector {
	//le constructeur de trame choisit
	private ITrameBuilder trameBuilder;
	
	/**
	 * Constructeur prenant un argument un builder de trame
	 * @param trameBuilder Le builder de trame
	 */
	public TrameDirector(ITrameBuilder trameBuilder)
	{
		this.trameBuilder = trameBuilder;
	}
	
	/**
	 * Accesseur sur la trame construite par le builder
	 * @return La trame construite par le builder
	 */
	public ITrame getTrame(){return this.trameBuilder.getTrame();}
	
	/**
	 * Construit une trame selon le builder en attribut
	 */
	public void constructTrame()
	{
		this.trameBuilder.buildLiaison();
		this.trameBuilder.buildReseau();
		this.trameBuilder.buildTransport();
		this.trameBuilder.buildApplication();
		this.trameBuilder.buildData();
	}
}
