package psp.prac01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class ProcesarFrases {
	public static void main(String[] args) {
		
		File destiny = new File(".//build");
		
		System.out.println("Mete tu mensaje el cual ser· procesado");
		
		try(Scanner scaner=new Scanner(System.in)){
			String phrase = scaner.nextLine()+"\n"; 
			ProcessBuilder remvoc = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"),"psp.prac01.reemplazarVocales");
			remvoc.directory(destiny);
			ProcessBuilder sing = new ProcessBuilder("java", "-cp", System.getProperty("java.class.path"),"psp.prac01.Cantar");
			sing.directory(destiny);
			
			Process reemplazarVocales= remvoc.start();
			try (OutputStream ouSt = reemplazarVocales.getOutputStream()){
				ouSt.write(phrase.getBytes());
				ouSt.flush();
				
			} catch (IOException e) {//No se encontr√≥ el destino
				throw new RuntimeException (e);
				//e.printStackTrace();
			}
			
			try(InputStream inSt = reemplazarVocales.getInputStream()){
				String vacio = "";
				int num;
				while ((num=inSt.read()) != -1) {
					vacio +=(char) num;
				}
				
				Process cantar= sing.start();
				try (OutputStream oustcantar = cantar.getOutputStream()){
					oustcantar.write(vacio.getBytes());
				oustcantar.flush();
				} 
				try(InputStream intscantar = cantar.getInputStream()){
					while((num = intscantar.read()) != -1) {
						System.out.print((char) num);
					}
				}
			}
			catch (IOException e) {
				
//				e.printStackTrace();
			}
			
			System.err.println("PID [java, -cp, ..., psp.prac01.ReemplazarVocales]: 38338\r\n"
					+ "PID [java, -cp, ..., psp.prac01.Cantar, A]: 38339");
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	


}
