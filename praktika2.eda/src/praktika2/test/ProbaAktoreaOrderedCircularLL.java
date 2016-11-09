package praktika2.test;

import praktika.akt.Aktorea;
import praktika.akt.Pelikula;
import praktika.akt.Stopwatch;

public class ProbaAktoreaOrderedCircularLL {

	public static void main(String[] args) {
		Stopwatch timer = new Stopwatch();
		/*
		 * 1.PROBA KASUA: Elementu bat baino gehiago dituen zerrenda
		 */
		Pelikula p1 = new Pelikula("Bridget Jones I");
		Pelikula p2 = new Pelikula("Bridget Jones II");
		Pelikula p3 = new Pelikula("Bridget Jones III");
		Pelikula p4 = new Pelikula("Harry Potter I");
		Pelikula p5 = new Pelikula("Harry Potter II");
		Pelikula p6 = new Pelikula("Harry Potter III");
		Pelikula p7 = new Pelikula("Harry Potter IV");
		Pelikula p8 = new Pelikula("Harry Potter V");
		Pelikula p9 = new Pelikula("Harry Potter VI");
		Pelikula p10 = new Pelikula("Harry Potter VII");

		Aktorea a = new Aktorea("Colin Firth");
		a.gehituPelikula(p1);
		System.out.println("pelikula bat gehitzen emandako denbora --> " + timer.elapsedTime());
		a.gehituPelikula(p2);
		a.gehituPelikula(p3);
		a.gehituPelikula(p4);
		a.gehituPelikula(p5);
		a.gehituPelikula(p6);
		a.gehituPelikula(p7);
		a.gehituPelikula(p8);
		a.gehituPelikula(p9);
		a.gehituPelikula(p10);

		// elementuak inprimatu
		System.out.println(" Zerrenda ...............");
		System.out.println("");
		a.pelikulakInprimatu();
		System.out.println("Zerrenda inprimatzen emandako denbora --> " + timer.elapsedTime());

		// elementu kopurua
		System.out.println("");
		System.out.println(a.getIzena() + " aktoreak duen pelikula kopurua");
		System.out.println(a.pelikulaKopurua());

		// elementua dagoen konprobatu
		/* elementua ez dago */
		System.out.println("");
		System.out.println("ELEMENTU BAT LISTAN DAGOEN EDO EZ KONPROBATU");
		String ize1 = "Ahora me ves";
		System.out.println(ize1 + " zerrendan dago? " + a.badagoPelikula(ize1));
		System.out.println(ize1 + " pelikula bilatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(ize1 + " zerrendan dago? " + a.findPeli(ize1));

		ize1 = "Harry Potter III";
		System.out.println(ize1 + " zerrendan dago? " + a.badagoPelikula(ize1));
		System.out.println(ize1 + " pelikula bilatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(ize1 + " zerrendan dago? " + a.findPeli(ize1));

		// azken elementua
		System.out.println("");
		System.out.println(" Azken elementua ");
		System.out.println(" ==================================");
		a.getListaPelikulak().last().imprimatu();
		System.out.println(" ==================================");
		
		// lehenengo elementua
		System.out.println("");
		System.out.println(" Lehenengo elementua: ");
		System.out.println(" ==================================");
		a.getListaPelikulak().first().imprimatu();
		System.out.println(" ==================================");

		// bukaeran gehitu
		System.out.println("");
		System.out.println("Elementu bat bukaeran gehitu");
		a.gehituPelikulaOrdenatua(p6);
		System.out.println("Emandako denbora --> " + timer.elapsedTime());
		System.out.println("Elementu bat bukaeran gehitzen lortutako zerrenda berria...");
		System.out.println(" ==================================");
		a.pelikulakInprimatu();
		System.out.println(" ==================================");
	}

}
