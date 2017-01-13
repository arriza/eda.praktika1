package pageRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import praktika4.eda.AktoreZerrenda;
import praktika4.eda.Aktorea;
import praktika4.eda.GraphHash;

public class PageRank {

	private HashMap<Aktorea, ArrayList<String>> aktoreenErlazioak;
	private HashMap<String, Double> pageRankAk;
	private double d;
	
	public PageRank(){
		aktoreenErlazioak = new HashMap<>();
		pageRankAk = new HashMap<>();
		d = 0.85;
	}
	
	/*
	 * aktoreen arteko erlazioen grafoa sortuko du
	 */
	public void aktoreenErlazioak(){
		GraphHash grafoa = new GraphHash();
		grafoa.sortu();
		//aktoreen zerrenda zeharkatu, aktoreen arteko erlazioen grafoa sortzeko
			Iterator<Entry<String, Aktorea>> itA = AktoreZerrenda.getAktoreZerrenda().getIteradorea();
			while(itA.hasNext()){
				Aktorea unekoAk = itA.next().getValue();
				ArrayList<String> unekoErlazioak = new ArrayList<>();
				Iterator<Entry<String, Aktorea>> itB = AktoreZerrenda.getAktoreZerrenda().getIteradorea();
				while(itB.hasNext()){
					Aktorea ak = itB.next().getValue();
					if(!unekoAk.getIzena().equals(ak.getIzena())){
						if(grafoa.erlazionatuta(unekoAk.getIzena(),ak.getIzena())){
							unekoErlazioak.add(ak.getIzena());
							//hasieratu pagerank guztiak probabilitate berdina izango dute
							ak.setNpageRank(1/AktoreZerrenda.getAktoreZerrenda().sizeHM());
							aktoreenErlazioak.put(unekoAk, unekoErlazioak);
						}
						
					}
				}
			}
	}
	public HashMap<String, Double> pRank(){
		/*
		 * Aktore bakoitzeko bere pageRank kalkulatuko duen algoritmoa
		 * informazioa HashMap batean gordeko da
		 */
		int iterazioKop = 40;
		while (iterazioKop>=0){
			
		}
		
		return pageRankAk;
	}

}
