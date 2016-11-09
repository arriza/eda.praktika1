package praktika2.test;

import praktika.akt.Aktorea;
import praktika.akt.Pelikula;
import praktika.akt.Stopwatch;

public class ProbaPelikulaOrderedCircularLL {

	public static void main(String[] args) {
		Stopwatch timer = new Stopwatch();
		/*
		 * 1.PROBA KASUA: Elementu bat baino gehiago dituen zerrenda
		 */
		Aktorea a1 = new Aktorea("Bridget Jones I");
		Aktorea a2 = new Aktorea("Bridget Jones II");
		Aktorea a3 = new Aktorea("Bridget Jones III");
		Aktorea a4 = new Aktorea("Harry Potter I");
		Aktorea a5 = new Aktorea("Harry Potter II");
		Aktorea a6 = new Aktorea("Harry Potter III");
		Aktorea a7 = new Aktorea("Harry Potter IV");
		Aktorea a8 = new Aktorea("Harry Potter V");
		Aktorea a9 = new Aktorea("Harry Potter VI");
		Aktorea a10 = new Aktorea("Harry Potter VII");

		Pelikula p = new Pelikula("Colin Firth");
		p.gehituAktorea(a1);
		System.out.println("pelikula bat gehitzen emandako denbora --> " + timer.elapsedTime());
		p.gehituAktorea(a2);
		p.gehituAktorea(a3);
		p.gehituAktorea(a4);
		p.gehituAktorea(a5);
		p.gehituAktorea(a6);
		p.gehituAktorea(a7);
		p.gehituAktorea(a8);
		p.gehituAktorea(a9);
		p.gehituAktorea(a10);

		// elementuak inprimatu
		System.out.println(" Zerrenda ...............");
		System.out.println("");
		p.imprimatuAktoreak();
		System.out.println("Zerrenda inprimatzen emandako denbora --> " + timer.elapsedTime());

		// elementu kopurua
		System.out.println("");
		System.out.println(p.getIzenburua() + " aktoreak duen pelikula kopurua");
		System.out.println(p.aktoreKopurua());

		// elementua dagoen konprobatu
		/* elementua ez dago */
		System.out.println("");
		System.out.println("ELEMENTU BAT LISTAN DAGOEN EDO EZ KONPROBATU");
		System.out.println(a1.getIzena() + " zerrendan dago? " + p.badagoAktorea(a1));
		System.out.println(a1.getIzena() + " pelikula bilatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(a1.getIzena() + " zerrendan dago? " + p.findAktorea(a1.getIzena()));

		Aktorea a15 = new Aktorea("Harry PoPoPoPotter VII");
		System.out.println(a15.getIzena() + " zerrendan dago? " + p.badagoAktorea(a15));
		System.out.println(a15.getIzena() + " pelikula bilatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(a15.getIzena() + " zerrendan dago? " + p.findAktorea(a15.getIzena()));

		// azken elementua
		System.out.println("");
		System.out.println(" Azken elementua ");
		System.out.println(" ==================================");
		p.getListaAktoreak().last().imprimatu();
		System.out.println(" ==================================");
		
		// lehenengo elementua
		System.out.println("");
		System.out.println(" Lehenengo elementua: ");
		System.out.println(" ==================================");
		p.getListaAktoreak().first().imprimatu();
		System.out.println(" ==================================");

		// txertatu
		System.out.println("");
		System.out.println("Elementu bat txertatu");
		Aktorea proba=new Aktorea("Proba");
		p.gehituAktoreOrdenatua(proba);
		System.out.println("Emandako denbora --> " + timer.elapsedTime());
		System.out.println("Elementu bat txertatzean lortutako zerrenda berria...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");

	}

}
