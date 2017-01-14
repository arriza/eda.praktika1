package pageRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import praktika4.eda.AktoreZerrenda;
import praktika4.eda.Aktorea;
import praktika4.eda.Pelikula;
import praktika4.eda.PelikulaZerrenda;

import java.util.Queue;



public class GraphHash {

	HashMap<String, ArrayList<String>> g;
	public GraphHash (){
		g = new HashMap<String, ArrayList<String>>();
	}
	
	public void grafoaSortu(){
		/* Aurre: kargatutako zerrenda ez da hutsa
		 * Post: Pelikulen zerrendatik grafoa sortzen du
		 * 		Adabegiak aktoreen izenak eta pelikulen izenburuak dira
		 */
		Iterator<Entry<String, Pelikula>> itP = PelikulaZerrenda.getPelikulaZerrenda().getIteradorea();
		while(itP.hasNext()){
			Pelikula p = itP.next().getValue();
			ArrayList<String> zEm = new ArrayList<>();
			zEm = osatuZerrenda(p.getListaAktoreak());
			g.put(p.getIzenburua(), zEm);
			Iterator<Aktorea> itA = p.getIterator();
			while(itA.hasNext()){
				Aktorea a = itA.next();
				
				if(g.get(a.getIzena())==null){
				ArrayList<String> zPeli = new ArrayList<>();
				Iterator<Pelikula> itPel = a.getIteradore();
				while(itPel.hasNext()){
					Pelikula pA = itPel.next();
					zPeli.add(p.getIzenburua());
				}
				//zPeli = osatuZerrendaPelikulak(a.getPelikulaLista());
				g.put(a.getIzena(), zPeli);
			}}
		}
		/*for(Map.Entry<String, Pelikula> entry : PelikulaZerrenda.getPelikulaZerrenda().getHashMap().entrySet()){
			//Pelikularen izenburua eta bere aktoreak gehituko ditu grafora
			ArrayList<String> zEm = new ArrayList<>();
			zEm = osatuZerrenda(entry.getValue().getListaAktoreak());
			g.put(entry.getKey(), zEm);
			//Pelikula horren aktoreak key gisa sartu eta haien adjList bete
			
			for(int a = 0; a<entry.getValue().aktoreKopurua() ; a++){
				AktoreZerrenda.getAktoreZerrenda().pelikulakImprimatu(entry.getValue().getListaAktoreak().get(a).getIzena());
				ArrayList<String> zpeli = new ArrayList<>();
				/*Aktorea ak = entry.getValue().getListaAktoreak().get(a);
				if(!g.containsKey(ak.getIzena())){
					ArrayList<String> zpeli = new ArrayList<>();
					for(int p = 0; p<entry.getValue().getListaAktoreak().get(a).pelikulaKopurua() ; p++){
						zpeli.add(entry.getValue().getListaAktoreak().get(a).getPelikulaLista().get(p).getIzenburua());
					}*/
				/*zpeli = osatuZerrendaPelikulak(entry.getValue().getListaAktoreak().get(a).getPelikulaLista());
				g.put(entry.getValue().getListaAktoreak().get(a).getIzena(), zpeli);
				//}
			}
		}*/
			
			
		
	}
	public void print(){
		/*Aurrebaldintza: grafoa ez da hutsa
		 * Postbaldintza: grafoan dauden elementuak pantailaratuko dira
		 */
		int i = 1;
		for (String s:g.keySet()){
			System.out.println("Element: "+ i++ + " "+ s + "--> ");
			for(String k : g.get(s)){
				System.out.println(k + " ### ");
			}
			System.out.println();
		}
	}
	@SuppressWarnings("unchecked")
	public boolean erlazionatuta(String p1, String p2){
		/*
		 * Aurrebaldintza: grafoa ez da hutsa
		 * Postbaldintza: bi elementu erlazionatuta dauden
		 *  edo ez esango digu
		 */
		if(p1.equals(p2)){
			return true;
		}else{
			boolean erl = false;
			@SuppressWarnings("rawtypes")
			Queue aztGabeak = new LinkedList<String>();
			HashSet<String> bisitatuak = new HashSet<String>();
			aztGabeak.add(p1);
			bisitatuak.add(p1);
			while(!erl && !aztGabeak.isEmpty()){
				String current = aztGabeak.poll().toString();
				//for(int i=0; i<aztGabeak.size(); i++){
				if(current.equals(p2)){
					erl = true;
				}else{
					for(String kidea: g.get(current)){
						if(!bisitatuak.contains(kidea)){
							aztGabeak.add(kidea);
							bisitatuak.add(kidea);
						}
					}
				}
				//}
			}
			return erl;
		}
	}
	
	
	public ArrayList<String> erlazioBidea(String p1, String p2){
			/*
			 * Aurrebaldintza: grafoa ez da hutsa
			 * Postbaldintza: bi elementu erlazionatuta badaude
			 * haien artean dagoen "bidea" pantailaratuko da
			 */
		ArrayList<String> bidea = new ArrayList<>();
		boolean badago = false;
		if(p1.equals(p2)){
			bidea.add(p1);
			bidea.add(p2);
			
		}else{
			Queue<String> aztGabeak = new LinkedList<>();
			aztGabeak.add(p1);
			HashSet<String> bisitatuak = new HashSet<>();
			bisitatuak.add(p1);
			//bidea.add(p1);
			while(!badago && !aztGabeak.isEmpty()){
				String current = aztGabeak.poll();
				if(current.equals(p2)){
					badago = true;
					bidea.add(current);
				}else{
					for(String kidea: g.get(current)){
						if(!bisitatuak.contains(kidea)){
							aztGabeak.add(kidea);
							bisitatuak.add(current);
							
						}
					}
				}
			}
			
		}
		
		if(badago){
			
			return bidea;
		}else{
			return null;	
		}
	}
	
	//GRAFOA SORTZEKO AZPIPROGRAMAK
	/*
	 * Pelikula bateko adj zerrenda sortuko du
	 */
	private ArrayList<String> osatuZerrenda(ArrayList<Aktorea> lista){
		ArrayList<String> z = new ArrayList<>();
		for(int i = 0; i<lista.size() ; i++){
			z.add(lista.get(i).getIzena());
		}
		return z;
	}
	/*
	 * Aktore bateko adj zerrenda sortuko du
	 */
	private ArrayList<String> osatuZerrendaPelikulak(ArrayList<Pelikula> lista){
		ArrayList<String> z = new ArrayList<>();
		for(int i = 0; i<lista.size() ; i++){
			z.add(lista.get(i).getIzenburua());
			//System.out.println(lista.get(i).getIzenburua());
		}
		return z;
	}
	private void adjSortu(Pelikula p){
		ArrayList<String> zEm = new ArrayList<>();
		for(int i = 0; i<p.getListaAktoreak().size(); i++){
			System.out.println("Aktorea: "+p.getListaAktoreak().get(i).getIzena()+" bere pelikulak");
			if(!g.containsKey(p.getListaAktoreak().get(i).getIzena())){
				zEm = osatuZerrendaPelikulak(p.getListaAktoreak().get(i).getPelikulaLista());
				g.put(p.getListaAktoreak().get(i).getIzena(), zEm);
			}
			
			
		}
	}
	
	public void sortu(){
		/*
		 * Fitxategitik sortutako egitura berrietatik
		 * erlazioen grafoa sortuko du
		 */
		Iterator<Entry<String, Pelikula>> itP = PelikulaZerrenda.getPelikulaZerrenda().getIteradorea();
		while(itP.hasNext()){
			Pelikula p = itP.next().getValue();
			ArrayList<String> zAkt = new ArrayList<>();
			zAkt = osatuZerrenda(p.getListaAktoreak());
			g.put(p.getIzenburua(), zAkt);
		}
		Iterator<Entry<String, Aktorea>> itA = AktoreZerrenda.getAktoreZerrenda().getIteradorea();
		while(itA.hasNext()){
			Aktorea ak = itA.next().getValue();
			ArrayList<String> zPeli = new ArrayList<>();
			zPeli = osatuZerrendaPelikulak(ak.getPelikulaLista());
			g.put(ak.getIzena(), zPeli);
		}
		
	}
	
	
}
