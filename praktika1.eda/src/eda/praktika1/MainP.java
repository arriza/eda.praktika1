package eda.praktika1;

import java.util.Scanner;

public class MainP {

	public static void main(String[] args) {
		//datuak kargatu fitxategitik
		//fitxategia proiektuaren barruan dago, baina irakurtzeko klase bat erabiliko da
		System.out.println("Datuak kargatzen...");
		String nomF = "fitxategiak/fitx1.txt";
		Reader.getReader().zerrendaKargatu(nomF);
		System.out.println("Datuak kargatuta! :)");
		
		//menu bat, apikazioak dauzkan aukera guztiak proban jartzeko
		paintMenu();
		
		
		/*Aktoreen zerrendan aktore baten bilaketa, izena eta abizena erabilita
		IzenAbizen formatua --> Abizena, Izena
		
		Proba kasu 1: Aktorea zerrendan dago
		Hudson, Annette;
		
		
		Proba kasu 2: Aktorea ez dago zerrendan
		Perez, Pepita;
		*/
		
		
		/*aktore baten pelikula zerrenda lortu
		Britt, Eva*/
		
		/*aktore zerrenda osoa inprimatu*/
		
		/*Pelikula bateko aktoreak bueltatu
		Pantailan agertuko dira formatu honekin --> Abizena, Izena
		Eager to Die
		*/
		
		/*pelikula zerrenda osoa imprimatu
		*/
		
		/*zerrendatik aktore bat ezabatu
		Proba kasu 1: aktorea ez dago zerrendan
		Ez, Dago
		
		Proba kasu 2: aktorea badago zerrendan
		Britt, Eva
		*/
		
		/*aktoreen zerrenda fitxategi batean gorde
		 * */
		 
		
		/*aktoreen zerrenda ordenatua lortu --> Abizena, Izena
		*/
		
		
	}
	private static void paintMenu(){
		//String aukera="";
		int select = 0;
		Scanner sc = new Scanner(System.in);
		while (select != 8){
			System.out.println("=======================================================");
			System.out.println("=======1-etik 7-rainoko aukeren artean bat hartu=======");
			System.out.println("1 - Aktore baten bilaketa");
			System.out.println("2 - Aktore berri baten txertaketa");
			System.out.println("3 - Aktore baten pelikulak bueltatu");
			System.out.println("4 - Pelikula bateko aktoreak bueltatu");
			System.out.println("5 - Aktore baten ezabaketa");
			System.out.println("6 - Aktoreen zerrenda fitxategi batean gorde");
			System.out.println("7 - Aktoreen zerrenda ordenatua (Abizena, Izena)");
			System.out.println("8 - Irten");
			System.out.println("=======================================================");
			select = Integer.parseInt(sc.nextLine());
			aukeraHartu(select);
		}
	}
	private static void aukeraHartu(int aukera){
		
		//Scanner sc = new Scanner(System.in);
		//aukera = sc.nextLine();
			
		
		switch (aukera) {
		case 1:
			//bilaketa
			badagoZerrendan();
			break;
		case 2:
			//txertaketa
			gehituAktorea();
			break;
		case 3:
			//pelikulak bueltatu
			aktorePelikulak();
			break;
		case 4:
			//aktoreak bueltatu
			pelikulaAktoreak();
			break;
		case 5:
			//ezabaketa
			ezabatuAktorea();
			break;
		case 6:
			//fitxategia sortu
			idatziFitxategia();
			break;
		case 7:
			//zerrenda ordenatua
			zerrendaOrdenatua();
			break;
		case 8:
			System.out.println("Programa amaitu da :(");
			System.exit(0);
		default:
			System.out.println("EZ DAGO AUKERA HORI!");
			//aukeraHartu();
			break;
		}
	}
	private static void badagoZerrendan(){
		String aIzena= "";
		System.out.println("Sartu aktorearen Abizen, Izena");
		Scanner sc = new Scanner(System.in);
		aIzena = sc.nextLine();
		AktoreZerrenda.getAktoreZerrenda().badagoZerrendan(aIzena);
	}
	private static void gehituAktorea(){
		String aIzena= "";
		System.out.println("Sartu aktorearen Abizen, Izena");
		Scanner sc = new Scanner(System.in);
		aIzena = sc.nextLine();
		Aktorea a = new Aktorea(aIzena);
		AktoreZerrenda.getAktoreZerrenda().gehituAktorea(a);;
	}
	private static void aktorePelikulak(){
		String aIzena= "";
		System.out.println("Sartu aktorearen Abizen, Izena");
		Scanner sc = new Scanner(System.in);
		aIzena = sc.nextLine();
		AktoreZerrenda.getAktoreZerrenda().pelikulakImprimatu(aIzena);
	}
	private static void pelikulaAktoreak(){
		String pIzena= "";
		System.out.println("Sartu pelikularen izenburua");
		Scanner sc = new Scanner(System.in);
		pIzena = sc.nextLine();
		PelikulaZerrenda.getPelikulaZerrenda().aktoreakimprimatu(pIzena);
	}
	private static void ezabatuAktorea(){
		String aIzena= "";
		System.out.println("Sartu aktorearen Abizen, Izena");
		Scanner sc = new Scanner(System.in);
		aIzena = sc.nextLine();
		AktoreZerrenda.getAktoreZerrenda().ezabatuAktorea(aIzena);
	}
	private static void idatziFitxategia(){
		Writer.getWriter().idatziAktoreenFitx();
	}
	private static void zerrendaOrdenatua(){
		AktoreZerrenda.getAktoreZerrenda().zerrendaOrdenatua();;
	}
}
