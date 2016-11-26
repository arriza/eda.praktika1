package praktika.graph;

import java.util.ArrayList;
import java.util.HashMap;
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
			ArrayList<String> zEm = new ArrayList<>();
			zEm = osatuZerrenda(entry.getValue().getListaAktoreak());
			g.put(entry.getKey(), zEm);		
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
	private ArrayList<String> osatuZerrenda(ArrayList<Aktorea> lista){
		ArrayList<String> z = new ArrayList<>();
		for(int i = 0; i<lista.size() ; i++){
			z.add(lista.get(i).getIzena());
		}
		return z;
	}
}
