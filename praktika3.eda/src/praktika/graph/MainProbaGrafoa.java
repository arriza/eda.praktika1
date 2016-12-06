package praktika.graph;


import praktika3.eda.PelikulaZerrenda;
import praktika3.eda.Stopwatch;

public class MainProbaGrafoa {

	public static void main(String[] args) {
		String nomF = "fitxategiak/geureFitx.txt";
		Stopwatch timer = new Stopwatch();
		PelikulaZerrenda.getPelikulaZerrenda().zerrendaKargatu(nomF);
		GraphHash g = new GraphHash();
		g.grafoaSortu();
		g.print();
		System.out.println("Grafoa eraikia! :), emandako denbora --> "+timer.elapsedTime());
		System.out.println("==============================================================");
		
		//System.out.println("Erlazionatuta daude Seven eta A team ???? ");
		System.out.println(g.erlazionatuta("Casino", "La loca"));
		//System.out.println("Erlazioa aurkitzeko emandako denbora --> "+timer.elapsedTime());
		
		System.out.println(g.erlazioBidea("Casino", "La loca"));
		//System.out.println("Erlazioaren bidea aurkitzeko emandako denbora --> "+timer.elapsedTime());
	}

}
