package praktika.graph;

import praktika3.eda.PelikulaZerrenda;

public class MainProbaGrafoa {

	public static void main(String[] args) {
		String nomF = "fitxategiak/listaHandiagoa.txt";
		PelikulaZerrenda.getPelikulaZerrenda().zerrendaKargatu(nomF);
		GraphHash g = new GraphHash();
		g.grafoaSortu(PelikulaZerrenda.getPelikulaZerrenda());
		g.print();

	}

}
