package pobj.test;

import java.util.List;

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
		List<String> trames = ifm.getTrames();
		for(String s : trames)
			System.out.println(s+"\n");
	}

}
