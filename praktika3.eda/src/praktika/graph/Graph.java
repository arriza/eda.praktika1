package praktika.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import praktika3.eda.Aktorea;
import praktika3.eda.Pelikula;
import praktika3.eda.PelikulaZerrenda;

public class Graph {
    HashMap<String, Integer> th;
    String[] keys;
    ArrayList<Integer>[] adjList;
	
	public void grafoaSortu(PelikulaZerrenda lPelikulak){
		// Post: pelikulen zerrendatik grafoa sortzen du
		//       Adabegiak aktoreen izenak eta pelikulen izenburuak dira 
		
		// 1. pausoa: th bete
		for(Map.Entry<String, Pelikula> entry : lPelikulak.getPelikulaZerrenda().getHashMap().entrySet()){
			//Pelikularen izenburua eta bere aktoreak gehituko ditu grafora
			ArrayList<String> zEm = new ArrayList<>();
			zEm = osatuZerrenda(entry.getValue().getListaAktoreak());
			th.put(entry.getKey(), null);
			
			//Pelikula horren aktoreak key gisa sartu eta haien adjList bete
			adjSortu(entry.getValue());
			
		}
			
			

          // 2. pausoa: keys bete
		keys = new String[th.size()];
		for (String k: th.keySet()) keys[th.get(k)] = k;

          // 3. pausoa: adjList bete
          // KODEA OSATU
	}
	
	public void print(){
	   for (int i = 0; i < adjList.length; i++){
		System.out.print("Element: " + i + " " + keys[i] + " --> ");
		for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
		
		System.out.println();
	   }
	}
	
	public boolean erlazionatuta(String p1, String p2){
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		
		int pos1 = th.get(p1);
		int pos2 = th.get(p2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];

               // KODEA OSATU
		
		return aurkitua;

	}
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
		}
		return z;
	}
	private void adjSortu(Pelikula p){
		for(int i = 0; i<p.getListaAktoreak().size(); i++){
			if(!th.containsKey(p.getListaAktoreak().get(i).getIzena())){
				ArrayList<String> zEm = new ArrayList<>();
				zEm = osatuZerrendaPelikulak(p.getListaAktoreak().get(i).getPelikulaLista());
				th.put(p.getListaAktoreak().get(i).getIzena(), null);
			}
		}
	}
}
