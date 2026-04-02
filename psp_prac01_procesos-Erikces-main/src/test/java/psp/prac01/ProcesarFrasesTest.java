package psp.prac01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class ProcesarFrasesTest {

	private static final String INTRO = "Introduce tu mensaje a procesar:";
	
	@Test
	void okVocalATest() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		InputStream originalIn = System.in;
		ByteArrayInputStream bis = new ByteArrayInputStream("Hola mis nuevos amigos".getBytes());
		System.setIn(bis);

		String[] args = { };
		ProcesarFrases.main(args);
		String salida = bos.toString();
		// assertion
		assertTrue(salida.startsWith(INTRO));
		assertTrue(salida.contains("HAlA mAs nAAvAs AmAgAs"));
		
		System.setIn(originalIn);
		System.setOut(originalOut);
	}
	
	@Test
	void okVocalETest() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		InputStream originalIn = System.in;
		ByteArrayInputStream bis = new ByteArrayInputStream("Hola mis nuevos amigos".getBytes());
		System.setIn(bis);

		String[] args = { "e" };
		ProcesarFrases.main(args);
		String salida = bos.toString();
		// assertion
		assertTrue(salida.startsWith(INTRO));
		assertTrue(salida.contains("Hele mes neeves emeges"));
		
		System.setIn(originalIn);
		System.setOut(originalOut);
	}
	
	@Test
	void okProcessTest() {
		PrintStream originalErr = System.err;
		ByteArrayOutputStream bosErr = new ByteArrayOutputStream();
		System.setErr(new PrintStream(bosErr));

		InputStream originalIn = System.in;
		ByteArrayInputStream bis = new ByteArrayInputStream("Hola mis nuevos amigos".getBytes());
        System.setIn(bis);

		String[] args = { "e" };
		ProcesarFrases.main(args);
		String error = bosErr.toString();
		String[] errores = error.split(System.lineSeparator());
	
		// assertion
		assertEquals(2, errores.length);
		assertTrue(errores[0].contains("psp.prac01.ReemplazarVocales"));
		assertTrue(errores[1].contains("psp.prac01.Cantar, e"));
		
		int pidVoc = Integer.parseInt((errores[0].split("]:")[1]).trim());
		int pidCan = Integer.parseInt((errores[1].split("]:")[1]).trim());
		assertTrue(pidCan > pidVoc);

		System.setIn(originalIn);
		System.setErr(originalErr);
	}
	
	@Test
	void koETest() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		InputStream originalIn = System.in;
		ByteArrayInputStream bis = new ByteArrayInputStream(" ".getBytes());
		System.setIn(bis);

		String[] args = { "e" };
		ProcesarFrases.main(args);
		String salida = bos.toString();
		// assertion
		assertEquals(INTRO.trim(), salida.trim());

		System.setIn(originalIn);
		System.setOut(originalOut);
	}
	
	@Test
	void koXTest() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		InputStream originalIn = System.in;
		ByteArrayInputStream bis = new ByteArrayInputStream("bien hecho".getBytes());
		System.setIn(bis);

		String[] args = { "x" };
		ProcesarFrases.main(args);
		String salida = bos.toString();
		// assertion
		assertTrue(salida.startsWith(INTRO));
		assertTrue(salida.contains("ERROR > El argumento recibido no es una vocal"));
		
		System.setIn(originalIn);
		System.setOut(originalOut);
	}

}

