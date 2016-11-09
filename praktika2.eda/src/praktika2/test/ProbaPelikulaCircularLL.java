package praktika2.test;

import praktika.akt.Aktorea;
import praktika.akt.Pelikula;
import praktika.akt.Stopwatch;

public class ProbaPelikulaCircularLL {

	public static void main(String[] args) {
		Stopwatch timer = new Stopwatch();
		/*
		 * 1.PROBA KASUA: Elementu bat baino gehiago dituen zerrenda
		 */
		Aktorea a1 = new Aktorea("George Clooney");
		Aktorea a2 = new Aktorea("Brad Pitt");
		Aktorea a3 = new Aktorea("Matt Damon");
		Aktorea a4 = new Aktorea("Scott Caan");
		Aktorea a5 = new Aktorea("Casey Affleck");
		Aktorea a6 = new Aktorea("Shaobo Qin");
		Aktorea a7 = new Aktorea("Bernie Mac");
		Aktorea a8 = new Aktorea("Don Cheadle");
		Aktorea a9 = new Aktorea("Carl Reiner");
		Aktorea a10 = new Aktorea("Eddie Jemison");
		Aktorea a11 = new Aktorea("Elliott Gould");
		Aktorea a12 = new Aktorea("Julia Roberts");
		Aktorea a13 = new Aktorea("Andy García");

		Pelikula p = new Pelikula("Ocean's Eleven");
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
		p.gehituAktorea(a11);
		p.gehituAktorea(a12);
		p.gehituAktorea(a13);

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
		Aktorea a14 = new Aktorea("Carl Urban");
		;
		System.out.println(a14.getIzena() + " zerrendan dago? " + p.badagoAktorea(a14));
		System.out.println(a14.getIzena() + " aktorea bilatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(a14.getIzena() + " zerrendan dago? " + p.findAktorea(a14.getIzena()));

		System.out.println(a7.getIzena() + " zerrendan dago? " + p.badagoAktorea(a7));
		System.out.println(a7.getIzena() + " pelikula bilatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(a7.getIzena() + " zerrendan dago? " + p.findAktorea(a7.getIzena()));

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

		// ezabatu lehenengoa
		System.out.println("");
		System.out.println("LISTAKO LEHENENGO ELEMENTUA EZABATU");
		p.getListaAktoreak().removeFirst();
		System.out.println("Lehenengo pelikula ezabatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(a1.getIzena() + " zerrendan dago? " + p.badagoAktorea(a1));
		System.out.println("Lista berria lehenengo elementua ezabatuta...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");

		// azkena ezabatu
		System.out.println("");
		System.out.println("LISTAKO AZKEN ELEMENTUA EZABATU");
		p.getListaAktoreak().removeLast();
		System.out.println("Azken pelikula ezabatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(a13.getIzena() + " zerrendan dago? " + p.badagoAktorea(a13));
		System.out.println("Zerrenda berria azkenengo elementua ezabatuta...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");

		// elementu bat ezabatu
		/* P1: elementua ez dago zerrendan */
		System.out.println("");
		System.out.println("Elementu bat ezabatzen... elementua ez dago zerrendan");
		System.out.println(" ==================================");
		String proba = "Probak";
		p.ezabatuAktorea(proba);
		System.out.println("Elementu bat ezabatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(" ==================================");
		/* P2: elementua badago zerrendan */
		System.out.println("");
		System.out.println("Elementu bat ezabatzen... elementua badago zerrendan");
		p.ezabatuAktorea(a2.getIzena());
		System.out.println(a2.getIzena() + " ezabatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(a2.getIzena() + " zerrendan dago? " + p.badagoAktorea(a2));
		System.out.println("Elementu bat ezabatzen lortutako zerrenda berria...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");

		// aurrean gehitu
		System.out.println("");
		System.out.println("Elementu bat aurrean gehitu");
		p.hasieranGehitu(a10);
		System.out.println("Emandako denbora --> " + timer.elapsedTime());
		System.out.println("Elementu bat hasieran gehitzen lortutako zerrenda berria...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");

		// bukaeran gehitu
		System.out.println("");
		System.out.println("Elementu bat bukaeran gehitu");
		p.bukaeranGehitu(a6);
		System.out.println("Emandako denbora --> " + timer.elapsedTime());
		System.out.println("Elementu bat bukaeran gehitzen lortutako zerrenda berria...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");

		/*
		 * 2.PROBA KASUA: Elementu bakarra duen zerrenda
		 */
		System.out.println("2.PROBA KASUA: Elementu bakarra duen zerrenda ");
		p = null;
		p = new Pelikula("300");
		a1 = new Aktorea("Gerard Butler");
		p.gehituAktorea(a1);

		// elementuak inprimatu
		System.out.println("Zerrenda ...............");
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
		Aktorea a302 = new Aktorea("Eva Green");
		System.out.println(a302.getIzena() + " zerrendan dago? " + p.badagoAktorea(a302));
		System.out.println(a302.getIzena() + " pelikula bilatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(a302.getIzena() + " zerrendan dago? " + p.findAktorea(a302.getIzena()));

		System.out.println(a1.getIzena() + " zerrendan dago? " + p.badagoAktorea(a1));
		System.out.println(a1.getIzena() + " pelikula bilatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(a1.getIzena() + " zerrendan dago? " + p.findAktorea(a1.getIzena()));

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

		// ezabatu lehenengoa
		System.out.println("");
		System.out.println("LISTAKO LEHENENGO ELEMENTUA EZABATU");
		p.getListaAktoreak().removeFirst();
		System.out.println("Lehenengo pelikula ezabatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(a1.getIzena() + " zerrendan dago? " + p.badagoAktorea(a1));
		System.out.println("Zerrenda berria lehenengo elementua ezabatuta...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");
		p.gehituAktorea(a1);
		// azkena ezabatu
		System.out.println("");
		System.out.println("LISTAKO AZKEN ELEMENTUA EZABATU");
		p.getListaAktoreak().removeLast();
		System.out.println("Azken pelikula ezabatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(a1.getIzena() + " zerrendan dago? " + p.badagoAktorea(a1));
		System.out.println("Zerrenda berria azkenengo elementua ezabatuta...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");
		p.gehituAktorea(a1);

		// elementu bat ezabatu
		/* P1: elementua ez dago zerrendan */
		System.out.println("");
		System.out.println("Elementu bat ezabatzen... elementua ez dago zerrendan");
		System.out.println(" ==================================");
		p.ezabatuAktorea(a302.getIzena());
		System.out.println("Elementu bat ezabatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(" ==================================");
		/* P2: elementua badago zerrendan */
		System.out.println("");
		System.out.println("Elementu bat ezabatzen... elementua badago zerrendan");
		p.ezabatuAktorea(a1.getIzena());
		System.out.println(a1.getIzena() + " ezabatzen emandako denbora --> " + timer.elapsedTime());
		System.out.println(a1.getIzena() + " zerrendan dago? " + p.badagoAktorea(a1));
		System.out.println("Elementu bat ezabatzen lortutako zerrenda berria...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");
		p.gehituAktorea(a1);
		
		// aurrean gehitu
		System.out.println("");
		System.out.println("Elementu bat aurrean gehitu");
		p.hasieranGehitu(a10);
		System.out.println("Emandako denbora --> " + timer.elapsedTime());
		System.out.println("Elementu bat hasieran gehitzen lortutako zerrenda berria...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");
		p.ezabatuAktorea(a10.getIzena());

		// bukaeran gehitu
		System.out.println("");
		System.out.println("Elementu bat bukaeran gehitu");
		p.bukaeranGehitu(a6);
		System.out.println("Emandako denbora --> " + timer.elapsedTime());
		System.out.println("Elementu bat bukaeran gehitzen lortutako zerrenda berria...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");
		p.ezabatuAktorea(a6.getIzena());
		
		// elementu baten ondoren gehitu
		System.out.println("");
		System.out.println("Gerard Butler elementuaren ondoren gehitu...");
		Aktorea aBerria=new Aktorea("Lena Headey");
		p.ondorenGehitu(aBerria,a1.getIzena());
		System.out.println("Emandako denbora --> " + timer.elapsedTime());
		System.out.println("Elementu baten ondoren gehitzen lortutako zerrenda berria...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");
		
		/*
		 * 3.PROBA KASUA: Zerrenda hutsa
		 */
		System.out.println("3.PROBA KASUA: Zerrenda hutsa ");
		p = null;
		p = new Pelikula("Silence");
		a1 = new Aktorea("Liam Neeson");

		// aurrean gehitu
		System.out.println("");
		System.out.println("Elementu bat aurrean gehitu");
		p.hasieranGehitu(a1);
		System.out.println("Emandako denbora --> " + timer.elapsedTime());
		System.out.println("Elementu bat hasieran gehitzen lortutako zerrenda berria...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");
		p.ezabatuAktorea("Liam Neeson");

		// bukaeran gehitu
		System.out.println("");
		System.out.println("Elementu bat bukaeran gehitu");
		p.bukaeranGehitu(a1);
		System.out.println("Emandako denbora --> " + timer.elapsedTime());
		System.out.println("Elementu bat bukaeran gehitzen lortutako zerrenda berria...");
		System.out.println(" ==================================");
		p.imprimatuAktoreak();
		System.out.println(" ==================================");

	}

}
