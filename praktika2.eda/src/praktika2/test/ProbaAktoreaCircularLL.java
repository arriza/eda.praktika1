package praktika2.test;

import praktika.akt.Aktorea;
import praktika.akt.Pelikula;

public class ProbaAktoreaCircularLL {

	public static void main(String[] args) {
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
		a.gehituPelikula(p2);
		a.gehituPelikula(p3);
		a.gehituPelikula(p4);
		a.gehituPelikula(p5);
		a.gehituPelikula(p6);
		a.gehituPelikula(p7);
		a.gehituPelikula(p8);
		a.gehituPelikula(p9);
		a.gehituPelikula(p10);
		
		//elementuak inprimatu
		System.out.print(" Lista ...............");
		a.imprimatu();
		
		//elementu kopurua
		System.out.print(a.getIzena()+" aktoreak duen pelikula kopurua");
		System.out.println(a.pelikulaKopurua());
		
		//elementua dagoen konprobatu
		String ize1 = "Ahora me ves";
		System.out.println(ize1+" zerrendan dago? "+ a.badagoPelikula(ize1));

	}

}
