package praktika.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import praktika3.eda.Aktorea;
import praktika3.eda.Pelikula;
import praktika3.eda.PelikulaZerrenda;

public class GraphHash {

	HashMap<String, ArrayList<String>> g;
	public GraphHash (){
		g = new HashMap<String, ArrayList<String>>();
	}
	
	public void grafoaSortu(PelikulaZerrenda lPelikulak){
		/*
		 * Post: Pelikulen zerrendatik grafoa sortzen du
		 * 		Adabegiak aktoreen izenak eta pelikulen izenburuak dira
		 */
		for(Map.Entry<String, Pelikula> entry : lPelikulak.getPelikulaZerrenda().getHashMap().entrySet()){
			//Pelikularen izenburua eta bere aktoreak gehituko ditu grafora
			ArrayList<String> zEm = new ArrayList<>();
			zEm = osatuZerrenda(entry.getValue().getListaAktoreak());
			g.put(entry.getKey(), zEm);
			
			//Pelikula horren aktoreak key gisa sartu eta haien adjList bete
			adjSortu(entry.getValue());
			
		}
			
			
		
	}
	public void print(){
		int i = 1;
		for (String s:g.keySet()){
			System.out.println("Element: "+ i++ + " "+ s + "--> ");
			for(String k : g.get(s)){
				System.out.println(k + " ### ");
			}
			System.out.println();
		}
	}
	public boolean erlazionatuta(String p1, String p2){
		boolean erl = false;
		
		return erl;
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
			if(!g.containsKey(p.getListaAktoreak().get(i).getIzena())){
				ArrayList<String> zEm = new ArrayList<>();
				zEm = osatuZerrendaPelikulak(p.getListaAktoreak().get(i).getPelikulaLista());
				g.put(p.getListaAktoreak().get(i).getIzena(), zEm);
			}
		}
	}
}
