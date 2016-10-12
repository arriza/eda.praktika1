package eda.praktika1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
	private static Reader mReader = null;
	//private String path;
	private Reader(){}
	public static synchronized Reader getReader(){
		if(mReader == null){
			mReader = new Reader();
		}return mReader;
	}
	
	//fitxategitik datuak atera
	@SuppressWarnings({ "resource", "unused" })
	public void zerrendaKargatu(String nomF){
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
				 peli = reader.readLine().split("\\s--->\\s");
				// peli = linea.split("\\s--->\\s");
				 //System.out.println("Pelikula izenburua: "+peli[0]);
			//sortu pelikula objektua
			p = new Pelikula(peli[0]);
			//pelikula pelikulen katalogora gehitu
			PelikulaZerrenda.getPelikulaZerrenda().gehituPelikula(p);
			//System.out.println("Pelikula horren aktoreak:");
			aktore = peli[1].split("\\s&&&\\s");
			for(int i = 0; i<aktore.length;i++){
				//System.out.println(aktore[i]);
				a = new Aktorea(aktore[i]);
				p.gehituAktorea(a);
				
				if(!AktoreZerrenda.getAktoreZerrenda().zerrendanDago(aktore[i])){
					a.gehituPelikula(p);
					AktoreZerrenda.getAktoreZerrenda().gehituAktorea(a);
				}else{
					AktoreZerrenda.getAktoreZerrenda().gehitu(p, aktore[i]);
				}
			}
			//System.out.println("============================================");
			
			 }
			 entrada.close();
			 //reader.close();
			 }
			 catch(IOException e) {e.printStackTrace();}

		//AktoreZerrenda.getAktoreZerrenda().imprimatuZerrenda();
	}
}