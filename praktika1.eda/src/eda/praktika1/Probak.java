package eda.praktika1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Probak {

	public static void main(String[] args) {
		String nomF = "C:\\Escritorio\\fitx1.txt";
		//String 
		try{
			 Scanner entrada = new Scanner(new FileReader(nomF));
			 FileReader f = new FileReader(nomF);
			 BufferedReader reader = new BufferedReader(f);
			 String linea;
			 //while (entrada.hasNext()) {
			 while (reader.readLine()!=null) {
				 //linea = entrada.nextLine();
				 linea = reader.readLine();
				 String[] peli = linea.split("\\s--->");
				 System.out.println(peli);
			
			 }
			 //entrada.close();
			 reader.close();
			 }
			 catch(IOException e) {e.printStackTrace();}

	}

}
