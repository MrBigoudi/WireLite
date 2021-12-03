package pobj.exceptions;

/**
 * Exception levee si un protocole est utilise dans une mauvaise couche
 * @author Sharane et Yannis
 *
 */
@SuppressWarnings("serial")
public class UnsupportedProtocolException extends Exception {
	public UnsupportedProtocolException(String m)
	{
		super(m);
	}
}
