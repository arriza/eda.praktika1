package praktika.graph;

import praktika3.eda.PelikulaZerrenda;
import praktika3.eda.Stopwatch;

public class MainProbaGrafoa {

	public static void main(String[] args) {
		String nomF = "fitxategiak/fitx1.txt";
		Stopwatch timer = new Stopwatch();
		PelikulaZerrenda.getPelikulaZerrenda().zerrendaKargatu(nomF);
		GraphHash g = new GraphHash();
		g.grafoaSortu(PelikulaZerrenda.getPelikulaZerrenda());
		g.print();
		System.out.println("Grafoa eraikia! :), emandako denbora --> "+timer.elapsedTime());
		System.out.println("==============================================================");
		
		System.out.println("Erlazionatuta daude Devon, Tony eta Einsatz in 4 W nden ???? ");
		System.out.println(g.erlazionatuta("Devon, Tony", "Einsatz in 4 W nden"));
		System.out.println("Erlazioa aurkitzeko emandako denbora --> "+timer.elapsedTime());
	}

}
