package psp.prac01;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class ReemplazarVocalesTest {

	@Test
	void okHolaTest() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		InputStream originalIn = System.in;
		ByteArrayInputStream bis = new ByteArrayInputStream("Hola Amigos".getBytes());
		System.setIn(bis);

		String[] args = { };
		ReemplazarVocales.main(args);
		String salida = bos.toString();
		// assertion
		assertEquals("H_l_ _m_g_s", salida.trim());

		// undo the binding in System
		System.setOut(originalOut);
		System.setIn(originalIn);
	}

	@Test
	void koNadaTest() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		InputStream originalIn = System.in;
		ByteArrayInputStream bis = new ByteArrayInputStream("".getBytes());
		System.setIn(bis);

		String[] args = { };
		ReemplazarVocales.main(args);
		String salida = bos.toString();
		// assertion
		assertEquals("null", salida.trim());

		// undo the binding in System
		System.setOut(originalOut);
		System.setIn(originalIn);
	}
}
