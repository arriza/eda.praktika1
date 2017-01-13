package praktika4.eda;


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
		
		System.out.println(g.erlazionatuta("Mitologia do submundo", "Prueba Peli"));
		System.out.println("Erlazioa aurkitzeko emandako denbora --> "+timer.elapsedTime());
		
		System.out.println(g.erlazioBidea("Mitologia do submundo", "Prueba Peli"));
		System.out.println("Erlazioaren bidea aurkitzeko emandako denbora --> "+timer.elapsedTime());
		
		
	}

}
