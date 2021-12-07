package pobj.test.protocoles;

//import static org.junit.Assert.*;
import org.junit.Test;

import pobj.exceptions.TrameTooShortException;
import pobj.res.header.UDP;


/**
* Classe testant l'initialisation d'un header UDP
* @author Sharane et Yannis
*
*/

public class TestUDP {

	/**
	 * Test un header UDP
	 * @throws TrameTooShortException 
	 */
	@Test
	public void test() throws TrameTooShortException {
		UDP udp = new UDP("004400430118591f");
		System.out.println(udp);
	}
	
}
