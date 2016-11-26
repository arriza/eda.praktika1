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

	}

}
