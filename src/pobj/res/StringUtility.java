package pobj.res;

public class StringUtility {
	
	private static StringUtility instance = null;
	
	private StringUtility()
	{
		
	}
	
	public static StringUtility getInstance()
	{
		if(instance == null)
			instance = new StringUtility();
		return instance;
	}
	
}
