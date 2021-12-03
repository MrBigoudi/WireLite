package pobj.exceptions;

/**
 * Exception levee si un protocole est utilise dans une mauvaise couche
 * @author Sharane et Yannis
 *
 */
@SuppressWarnings("serial")
public class ErrorValueException extends Exception {
	public ErrorValueException(String m)
	{
		super(m);
	}
}
