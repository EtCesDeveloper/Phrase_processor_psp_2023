package psp.prac01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReemplazarVocales {

	private static String LINE=" ";//Esta será la línea con la que trabajaremos y a la que cambiaremos las vocales
	private static final String UNDERSCORE="_";//Declaro la barra baja como constante porque las vocales siempre se van a sustituir por ella
	private static final String ALLVOWEL="[AaEeIiOoUu]";//defino las vocales en mayúscula y minúscula para luego  comprobar si cada posición tiene alguna de ellas y reemplazarla
	
	public static void main(String[] args) {
		
		try(InputStreamReader insertLine = new InputStreamReader(System.in);BufferedReader readLine = new BufferedReader(insertLine)){
		//Primeramente inicio un try con recursos para que cuando dejemos de usar el inputStreamReader y el BufferedReader se cierren y no sigan consumiendo recursos 
			LINE = readLine.readLine();
			if (LINE=="") {//Hago este if para avisar al usuario en caso de que la cadena esté vacía
				System.out.println("Esta cadena no tiene contenido");
			}
			
			LINE = LINE.replaceAll(ALLVOWEL, UNDERSCORE);//Reemplazo todas las vocales por _
			System.out.println(LINE); //Imprimo en pantalla la línea después de haberla procesado
		} catch(NullPointerException e) {
			System.out.println("null");
		}catch(IOException e) {//Recojo la excepción y aviso al usuario que el motivo es que no se ha encontrado la clase
			System.out.printf("La frase de entrada no se ha podido encontrar",e.getLocalizedMessage());
		} 
	}

}//End Class
