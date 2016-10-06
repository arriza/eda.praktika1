package eda.praktika1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Probak {

	public static void main(String[] args) {
		//String nomF = "C:\\Users\\Leire\\Desktop\\fitx1.txt";
		String nomF = "fitxategiak/fitx1.txt";
		String [] peli = null;
		String [] aktore = null;
		Pelikula p = null;
		Aktorea a = null;
		//String 
		try{
			 Scanner entrada = new Scanner(new FileReader(nomF));
			 FileReader f = new FileReader(nomF);
			 BufferedReader reader = new BufferedReader(f);
			 String linea;
			 while (entrada.hasNext()) {
			// lerroko pelikularen izenburua lortu
				 linea = entrada.nextLine();
				 peli = reader.readLine().split("\\s--->");
				// peli = linea.split("\\s--->\\s");
				 System.out.println("Pelikula izenburua: "+peli[0]);
			//sortu pelikula objektua
			p = new Pelikula(peli[0]);
			//pelikula pelikulen katalogora gehitu
			PelikulaZerrenda.getPelikulaZerrenda().gehituPelikula(p);
			System.out.println("Pelikula horren aktoreak:");
			aktore = peli[1].split("\\s&&&");
			for(int i = 0; i<aktore.length;i++){
				System.out.println(aktore[i]);
				a = new Aktorea(aktore[i]);
				a.gehituPelikula(p);
				if(!AktoreZerrenda.getAktoreZerrenda().badagoZerrendan(aktore[i])){
					AktoreZerrenda.getAktoreZerrenda().gehituAktorea(a);
				}
			}
			System.out.println("============================================");
			
			 }
			 entrada.close();
			 //reader.close();
			 }
			 catch(IOException e) {e.printStackTrace();}

		
		
		
		
	}

}
