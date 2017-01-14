package pageRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import praktika4.eda.AktoreZerrenda;
import praktika4.eda.Aktorea;
import praktika4.eda.GraphHash;

public class PageRank {

	private HashMap<String, ArrayList<String>> aktoreenErlazioak;
	private HashMap<String, Double> pageRankAk;
	private double d;
	private int n;
	
	public PageRank(){
		aktoreenErlazioak = new HashMap<String, ArrayList<String>>();
		pageRankAk = new HashMap<String, Double>();
		d = 0.85;
		n = 0;
	}
	public void setN(int pN){
		n = pN;
	}
	public int getN(){
		return n;
	}
	public void setD(int pD){
		d = pD;
	}
	public double getD(){
		return d;
	}
	/*
	 * aktoreen arteko erlazioen grafoa sortuko du
	 */
	public void aktoreenErlazioak(){
		GraphHash grafoa = new GraphHash();
		grafoa.sortu();
		double pr = 1.0/((double)AktoreZerrenda.getAktoreZerrenda().sizeHM());
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
							/*//hasieratu pagerank guztiak probabilitate berdina izango dute
							ak.setNpageRank(1/AktoreZerrenda.getAktoreZerrenda().sizeHM());*/
							aktoreenErlazioak.put(unekoAk.getIzena(), unekoErlazioak);
							//bueltatuko den page rank taula hasieratu aktore guztientzat balio berdinarekin
							pageRankAk.put(unekoAk.getIzena(), pr);
						}
						
					}
				}
			}
			
			setN(aktoreenErlazioak.size());
	}
	public HashMap<String, Double> pRank(){
		/*
		 * Aktore bakoitzeko bere pageRank kalkulatuko duen algoritmoa
		 * informazioa HashMap batean gordeko da
		 */
		//POST: emaitza aktore zerrendaren aktore bakoitzaren PageRank algoritmoaren
		//balioa da
		int iterazioKop = 10;
		while (iterazioKop>=0){
			//aktoreenErlazioak taulan sortutako erlazioen pagerank kalkulatuko da
			for(Map.Entry<String, ArrayList<String>> entry: aktoreenErlazioak.entrySet()){
				double kideenBatukaria = 0.0;
				for(int kide = 0; kide < entry.getValue().size() ; kide++){
					double prKide = pageRankAk.get(entry.getValue().get(kide));
					int kideKop = entry.getValue().get(kide).length();
					kideenBatukaria = kideenBatukaria + (prKide/(double)kideKop);
				}
				double unekoPr = ((1-getD())/getN())+(getD()*kideenBatukaria);
				//uneko aktorearen pageRank berria kalkulatu eta esleitua
				pageRankAk.put(entry.getKey(), unekoPr);
			}iterazioKop --;
		}
		//print();
		return pageRankAk;
	}
	
	public ArrayList<String> pageRankOrdenatua (){
		//Post: PageRank balioan oinarritzat hartuta beheruntz ordenaturiko zerrenda, aktoreen izenekin
		ArrayList<String> zerrendaOrd = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Map<String, Double> map = sortByValues(pageRankAk);
		for (String s:map.keySet()){
			zerrendaOrd.add(s);
		}
		//zerrendari buelta eman 
		Collections.reverse(zerrendaOrd);
		for(int i = 0; i<zerrendaOrd.size(); i++){
			System.out.println(zerrendaOrd.get(i));
		}
		 
		return zerrendaOrd;
	}
	//map ordenatuko duen metodoa balioen arabera
	@SuppressWarnings("rawtypes")
	private static HashMap sortByValues(HashMap map) { 
	       List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });

	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	  }
	
	public void print(){
		/*Aurrebaldintza: grafoa ez da hutsa
		 * Postbaldintza: grafoan dauden elementuak pantailaratuko dira
		 */
		
		for (String s:pageRankAk.keySet()){
			System.out.println(s+" aktorearen PageRank -->"+ pageRankAk.get(s));
			
			System.out.println();
		}
	}
	public void printErlazioak(){
		for (String s:aktoreenErlazioak.keySet()){
			System.out.println(s+ "--> ");
			for(String k : aktoreenErlazioak.get(s)){
				System.out.println(k + " ### ");
			}
			System.out.println();
		}
	}
	
	
}
