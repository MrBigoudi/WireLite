package pobj.res;

public abstract class StringUtility {
	/**
	 * Transforme une chaine de characteres representant un hexa en chaine de characteres representant un binaire
	 * @param hex La chaine representant l'hexa a convertir
	 * @return Le nombre binaire sous forme de chaine
	 */
	public static String hexaToBinary(String hex)
	{
		hex = hex.replaceAll("0", "0000");
		hex = hex.replaceAll("1", "0001");
	    hex = hex.replaceAll("2", "0010");
	    hex = hex.replaceAll("3", "0011");
	    hex = hex.replaceAll("4", "0100");
	    hex = hex.replaceAll("5", "0101");
	    hex = hex.replaceAll("6", "0110");
	    hex = hex.replaceAll("7", "0111");
	    hex = hex.replaceAll("8", "1000");
	    hex = hex.replaceAll("9", "1001");
	    hex = hex.replaceAll("A", "1010");
	    hex = hex.replaceAll("B", "1011");
	    hex = hex.replaceAll("C", "1100");
	    hex = hex.replaceAll("D", "1101");
	    hex = hex.replaceAll("E", "1110");
	    hex = hex.replaceAll("F", "1111");
	    return hex;
	}
	
	/**
	 * Transforme une chaine de characteres representnant un hexa en entier
	 * @param hex L'hexa a convertir
	 * @return L'hexa sous forme d'entier
	 */
	public static int hexaToInt(String hex)
	{
		return Integer.parseInt(hex, 16); //convert hex in a string to an int
	}
}
