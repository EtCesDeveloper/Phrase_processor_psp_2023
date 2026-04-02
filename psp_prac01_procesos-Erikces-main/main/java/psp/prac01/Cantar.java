package psp.prac01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cantar {
	private static String LineAlreadyReplace;
	private static final String UNDERSCORE="_";
	private static final String ALLVOWEL="[AaEeIiOoUu]";//defino las vocales en may�scula y min�scula para luego comprobar si el argumento pasado tiene alguna de ellas
	private static char VOWELSELECTED=' ';
	int id_padre;
	
	public static void main(String[] args) {
		
		switch(args.length) {
		case 0:
				VOWELSELECTED='A';
				System.exit(2); //Salimos con el c�digo dos como se detalla en el enunciado	
			break;
		case 1:
			if(args[0].contains(ALLVOWEL)) { //Si el primer argumento contiene alguna vocal
				VOWELSELECTED=args[0].charAt(0); //Esa vocal ser� la vocal elegida
			}
			break;
		case 2:
			if(!args[0].contains(ALLVOWEL) || args.length > 1) {//Si el primer argumento no contiene ninguna vocal y la suma de los argumentos es mayor que uno
				System.out.println("El argumento/argumentos pasados al programa no es ninguna vocal");
				System.exit(3);//Salimos con el c�digo tres como se detalla en el enunciado
			}
			break;
		}
		
		try(InputStreamReader insertLine = new InputStreamReader(System.in);BufferedReader saveLine = new BufferedReader(insertLine)){//Inicio un try con recursos para que una vez se haya acabado de utilizar, no se sigan consumiendo recursos
			LineAlreadyReplace=saveLine.readLine();//guardo el contenido en una variable est�tica (LineAlreadyReplace)
			LineAlreadyReplace=LineAlreadyReplace.replaceAll(UNDERSCORE, args[0]); //Cambio las barras bajas por el primer argumento pasado y le asigno ese valor a la misma variable
			System.out.println(LineAlreadyReplace);//Imprimo la frase en pantalla
		}catch(NullPointerException e) {
			System.out.println("nulldsafsdfasd");
		}catch(IOException e) {
			System.out.printf("no se ha podido encontrar la frase que has introducido",e.getMessage());
		}

		
	}

}
