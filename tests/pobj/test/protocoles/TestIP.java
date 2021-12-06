package pobj.test.protocoles;

//import static org.junit.Assert.*;
import org.junit.Test;

import pobj.res.header.IP;


/**
 * Classe testant l'initialisation d'un header ethernet
 * @author Sharane et Yannis
 *
 */
public class TestIP {

	/**
	 * Test un header IP
	 */
	@Test
	public void test() {
		IP ip = new IP("4500012ca8360000fa11178b00000000ffffffff");
		System.out.println(ip);
	}
}
