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
		//pr.printErlazioak();
		pr.pRank();
		pr.pageRankOrdenatua();

	}

}

