package pobj.exceptions;

/**
 * Exception levee si un protocole est utilise dans une mauvaise couche
 * @author Sharane et Yannis
 *
 */
public class WrongProtocoleException extends Exception {
	public WrongProtocoleException(String m)
	{
		super(m);
	}
}
