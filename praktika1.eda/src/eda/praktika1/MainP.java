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
		

		AktoreZerrenda.getAktoreZerrenda().imprimatuZerrenda();
	}

}
