package praktika.graph;


import praktika3.eda.AktoreZerrenda;
import praktika3.eda.PelikulaZerrenda;
import praktika3.eda.Stopwatch;

public class MainProbaGrafoa {

	public static void main(String[] args) {
		String nomF = "fitxategiak/geureFitx.txt";
		Stopwatch timer = new Stopwatch();
		PelikulaZerrenda.getPelikulaZerrenda().zerrendaKargatu(nomF);
		//PelikulaZerrenda.getPelikulaZerrenda().imprimatuZerrenda();
		//AktoreZerrenda.getAktoreZerrenda().imprimatuZerrenda();
		GraphHash g = new GraphHash();
		g.sortu();
		//g.grafoaSortu();
		g.print();
		System.out.println("Grafoa eraikia! :), emandako denbora --> "+timer.elapsedTime());
		System.out.println("==============================================================");
		
		//System.out.println("Erlazionatuta daude Seven eta A team ???? ");
		//System.out.println(g.erlazionatuta("Casino", "A team"));
		//System.out.println("Erlazioa aurkitzeko emandako denbora --> "+timer.elapsedTime());
		
		System.out.println(g.erlazioBidea("F&F", "Godfather"));
		System.out.println("Erlazioaren bidea aurkitzeko emandako denbora --> "+timer.elapsedTime());
	}

}
