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
		IP ip = new IP("45000034238440004006d00bc0a801c225305f9a");
		System.out.println(ip);
	}
}
