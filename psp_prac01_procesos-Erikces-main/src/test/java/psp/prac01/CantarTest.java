package psp.prac01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class CantarTest {

	@Test
	void okATest() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		InputStream originalIn = System.in;
		ByteArrayInputStream bis = new ByteArrayInputStream("H_l_ _m_g_s".getBytes());
		System.setIn(bis);

		String[] args = { "A" };
		Cantar.main(args);
		String salida = bos.toString();
		// assertion
		assertEquals("HAlA AmAgAs", salida.trim());

		// undo the binding in System
		System.setOut(originalOut);
		System.setIn(originalIn);
	}

	@Test
	void koNoArgsTest() {
		try {
			String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
			String classPath = getClass().getClassLoader().getResource(".").getFile() + File.pathSeparator
					+ System.getProperty("java.class.path");
			String[] cmd = { java, "-cp", classPath, "psp.prac01.Cantar" };
			Process process = Runtime.getRuntime().exec(cmd);
			int ret = process.waitFor();
			assertEquals(2, ret);
		} catch (IOException ioe) {
			fail(ioe);
		} catch (InterruptedException ie) {
			fail(ie);
		}
	}

	@Test
	void koBTest() {
		try {
			String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
			String classPath = getClass().getClassLoader().getResource(".").getFile() + File.pathSeparator
					+ System.getProperty("java.class.path");
			String[] cmd = { java, "-cp", classPath, "psp.prac01.Cantar", "B"};
			Process process = Runtime.getRuntime().exec(cmd);
			int ret = process.waitFor();
			assertEquals(3, ret);
		} catch (IOException ioe) {
			fail(ioe);
		} catch (InterruptedException ie) {
			fail(ie);
		}
	}
}
