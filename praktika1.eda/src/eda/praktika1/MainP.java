package eda.praktika1;

public class MainP {

	public static void main(String[] args) {
		//datuak kargatu fitxategitik
		//fitxategia proiektuaren barruan dago, baina irakurtzeko klase bat erabiliko da
		String nomF = "fitxategiak/fitx1.txt";
		Reader.getReader().zerrendaKargatu(nomF);
		
		//Aktoreen zerrendan aktore baten bilaketa, izena eta abizena erabilita
		//IzenAbizen formatua --> Abizena, Izena
		
		//Proba kasu 1: Aktorea zerrendan dago
		String a1Izena = "Hudson, Annette";
		//AktoreZerrenda.getAktoreZerrenda().badagoZerrendan(a1Izena);
		
		//Proba kasu 2: Aktorea ez dago zerrendan
		a1Izena = "Perez, Pepita";
		//AktoreZerrenda.getAktoreZerrenda().badagoZerrendan(a1Izena);
		

		//aktore baten pelikula zerrenda lortu
		a1Izena = "Britt, Eva";
		//AktoreZerrenda.getAktoreZerrenda().pelikulakImprimatu(a1Izena);
		
		//aktore zerrenda osoa inprimatu
		//AktoreZerrenda.getAktoreZerrenda().imprimatuZerrenda();
		
		//Pelikula bateko aktoreak bueltatu
		//Pantailan agertuko dira formatu honekin --> Abizena, Izena
		String izenburua = "Eager to Die";
		//PelikulaZerrenda.getPelikulaZerrenda().aktoreakimprimatu(izenburua);
		
		//pelikula zerrenda osoa imprimatuko du
		//PelikulaZerrenda.getPelikulaZerrenda().imprimatuZerrenda();
		
		//zerrendatik aktore bat ezabatu
		//aktorea ez dago zerrendan
		String iz ="Ez, Dago";
		AktoreZerrenda.getAktoreZerrenda().ezabatuAktorea(iz);
		
		//aktorea badago zerrendan
		iz= "Britt, Eva";
		AktoreZerrenda.getAktoreZerrenda().ezabatuAktorea(iz);
		AktoreZerrenda.getAktoreZerrenda().badagoZerrendan(iz);
	}

}
