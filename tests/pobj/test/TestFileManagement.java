package pobj.test;

import org.junit.Test;

import pobj.res.InputFileManager;

/**
 * Modele de classe de test
 * @author Sharane et Yannis
 *
 */
public class TestFileManagement {

	@Test
	public void test() {
		InputFileManager ifm = new InputFileManager("data/traceExemple");
	}

}
