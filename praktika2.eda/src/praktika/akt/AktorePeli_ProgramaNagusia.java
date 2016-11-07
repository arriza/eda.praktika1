package praktika.akt;

import java.util.Scanner;

public class AktorePeli_ProgramaNagusia {

	private static Stopwatch timer;
	public static void main(String[] args) {
		hasieratuZerrendak();
		//datuak kargatu fitxategitik
		//fitxategia proiektuaren barruan dago, baina irakurtzeko klase bat erabiliko da
		timer = new Stopwatch();
		System.out.println("Datuak kargatzen...");
		String nomF = "fitxategiak/listaHandiagoa.txt";
		PelikulaZerrenda.getPelikulaZerrenda().zerrendaKargatu(nomF);
		System.out.println("Datuak kargatuta! :), emandako denbora --> "+timer.elapsedTime());
		
		//menu bat, apikazioak dauzkan aukera guztiak proban jartzeko
		paintMenu();
		
		/*
		 * Probak *
		 */
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
	@SuppressWarnings("resource")
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
	@SuppressWarnings("resource")
	private static void badagoZerrendan(){
		
		String aIzena= "";
		System.out.println("Sartu aktorearen Abizen, Izena");
		Scanner sc = new Scanner(System.in);
		aIzena = sc.nextLine();
		timer = new Stopwatch();
		AktoreZerrenda.getAktoreZerrenda().badagoZerrendan(aIzena);
		System.out.println(aIzena+" aktorearen bilaketan emandako denbora --> "+timer.elapsedTime());
	}
	@SuppressWarnings("resource")
	private static void gehituAktorea(){
		String aIzena= "";
		System.out.println("Sartu aktorearen Abizen, Izena");
		Scanner sc = new Scanner(System.in);
		aIzena = sc.nextLine();
		Aktorea a = new Aktorea(aIzena);
		timer = new Stopwatch();
		AktoreZerrenda.getAktoreZerrenda().gehituAktorea(a);
		System.out.println(aIzena+" gehitzeko emandako denbora --> "+timer.elapsedTime());
	}
	@SuppressWarnings("resource")
	private static void aktorePelikulak(){
		String aIzena= "";
		System.out.println("Sartu aktorearen Abizen, Izena");
		Scanner sc = new Scanner(System.in);
		aIzena = sc.nextLine();
		timer = new Stopwatch();
		AktoreZerrenda.getAktoreZerrenda().pelikulakImprimatu(aIzena);
		System.out.println(aIzena+" aktorearen pelikulak inprimatzen emandako denbora --> "+timer.elapsedTime());
	}
	@SuppressWarnings("resource")
	private static void pelikulaAktoreak(){
		String pIzena= "";
		System.out.println("Sartu pelikularen izenburua");
		Scanner sc = new Scanner(System.in);
		pIzena = sc.nextLine();
		timer = new Stopwatch();
		PelikulaZerrenda.getPelikulaZerrenda().aktoreakimprimatu(pIzena);
		System.out.println(pIzena+" pelikularen aktoreak inprimatzeko emandako denbora --> "+timer.elapsedTime());
	}
	@SuppressWarnings("resource")
	private static void ezabatuAktorea(){
		String aIzena= "";
		System.out.println("Sartu aktorearen Abizen, Izena");
		Scanner sc = new Scanner(System.in);
		aIzena = sc.nextLine();
		timer = new Stopwatch();
		AktoreZerrenda.getAktoreZerrenda().ezabatuAktorea(aIzena);
		System.out.println(aIzena+" ezabatzeko emandako denbora --> "+timer.elapsedTime());
	}
	private static void idatziFitxategia(){
		timer = new Stopwatch();
		AktoreZerrenda.getAktoreZerrenda().idatziAktoreenFitx();
		System.out.println("Fitxategia idazteko emandako denbora --> "+timer.elapsedTime());
	}
	private static void zerrendaOrdenatua(){
		timer = new Stopwatch();
		AktoreZerrenda.getAktoreZerrenda().zerrendaOrdenatua();
		System.out.println("Aktoreen zerrenda ordenatzeko emandako denbora --> "+timer.elapsedTime());
	}
	private static void hasieratuZerrendak(){
		AktoreZerrenda.getAktoreZerrenda().hasieratu();
		PelikulaZerrenda.getPelikulaZerrenda().hasieratu();
	}
}

