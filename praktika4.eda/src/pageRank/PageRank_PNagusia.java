package pageRank;


import praktika4.eda.PelikulaZerrenda;
import praktika4.eda.Stopwatch;

public class PageRank_PNagusia {

	public static void main(String[] args) {
		String nomF = "fitxategiak/listaHandiagoa.txt";
		Stopwatch timer = new Stopwatch();
		PelikulaZerrenda.getPelikulaZerrenda().zerrendaKargatu(nomF);
		PageRank pr = new PageRank();
		pr.aktoreenErlazioak();
		System.out.println("Aktoreen arten dauden erlazioak eraikita! :), emandako denbora --> "+timer.elapsedTime());
		pr.pRank();
		System.out.println("PageRank balioak kalkulatuta! :), emandako denbora --> "+timer.elapsedTime());
		pr.pageRankOrdenatua();
		System.out.println("Zerrenda ordenatua eraikia! :), emandako denbora --> "+timer.elapsedTime());

	}

}

