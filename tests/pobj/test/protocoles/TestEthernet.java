package pobj.test.protocoles;

//import static org.junit.Assert.*;
import org.junit.Test;

import pobj.res.header.Ethernet;


/**
 * Classe testant l'initialisation d'un header ethernet
 * @author Sharane et Yannis
 *
 */
public class TestEthernet {

	/**
	 * Test un header Ethernet de type IPv4
	 */
	@Test
	public void testIPv4() {
		Ethernet eth = new Ethernet("5c514fe6da5cdc00b066346e0800");
		System.out.println(eth);
	}
	
	/**
	 * Test un header Ethernet de type ARP
	 */
	@Test(expected = RuntimeException.class)
	public void testARP() {
		Ethernet eth = new Ethernet("dc00b066346e5c514fe6da5c0806");
		System.out.println(eth);
	}
	
	/**
	 * Test un header Ethernet de type IPv6
	 */
	@Test(expected = RuntimeException.class)
	public void testIPv6() {
		Ethernet eth = new Ethernet("5c514fe6da5cdc00b066346e86dd");
		System.out.println(eth);
	}
	
	/**
	 * Test un header Ethernet de type inconnu
	 */
	@Test(expected = RuntimeException.class)
	public void testUnknown() {
		Ethernet eth = new Ethernet("5c514fe6da5cdc00b08914cc888e");
		System.out.println(eth);
	}

}
