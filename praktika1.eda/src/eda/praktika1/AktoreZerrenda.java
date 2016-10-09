package eda.praktika1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class AktoreZerrenda {
	
	private ArrayList<Aktorea> zerrenda;
	private Map<String,Aktorea> z1;
	private static AktoreZerrenda nireAktoreZerrenda= new AktoreZerrenda();
	
	private AktoreZerrenda() {
		zerrenda=new ArrayList<Aktorea>();
		z1 = new HashMap<String, Aktorea>();
	}	

	public static synchronized AktoreZerrenda getAktoreZerrenda() 
	{
		if (AktoreZerrenda.nireAktoreZerrenda==null){
			AktoreZerrenda.nireAktoreZerrenda=new AktoreZerrenda();
		}
		return AktoreZerrenda.nireAktoreZerrenda;
	}
	//ArrayList egitura
	public int tamaina() {
		return zerrenda.size();
	}
	public Iterator<Entry<String, Aktorea>> getIteradorea(){
		return z1.entrySet().iterator();
	}
	//HashMap egitura
	public int sizeHM(){
		return z1.size();
	}
	public void badagoZerrendan(String izenOsoa){
		if(zerrendanDago(izenOsoa)){
			System.out.println(izenOsoa+" aktorea badago zerrendan! :)");
		}else{
			System.out.println(izenOsoa+" ez da aurkitu zerrendan... :(");
		}
		
	}
	public boolean zerrendanDago(String izenOsoa){
		
		//Aktorea a1 = new Aktorea(izenOsoa);
		return z1.containsKey(izenOsoa);
	}
	public void gehituAktorea(Aktorea a){
		//konprobatu aktorea zerrendan dagoen jada
		if(!AktoreZerrenda.getAktoreZerrenda().zerrendanDago(a.getIzena())){
			z1.put(a.getIzena(), a);
		}else{
			System.out.println(a.getIzena()+" aktorea badago zerrendan!!");
		}
		
	}
	//aktore baten ezabaketa
	public void ezabatuAktorea(String izenOsoa){
		if(AktoreZerrenda.getAktoreZerrenda().zerrendanDago(izenOsoa)){
			AktoreZerrenda.getAktoreZerrenda().z1.remove(izenOsoa);
			System.out.println(izenOsoa+" aktorea ezabatu da.");
		}else{
			System.out.println("Ezin da "+izenOsoa+" ezabatu, zerrendan ez dagoelako");
		}
		
	}
	//aktoreen zerrenda inprimatu
	public void imprimatuZerrenda(){
		Iterator it = z1.entrySet().iterator();
		System.out.println("Aktoreen Zerrenda:");
		System.out.println("========================================================");
		while (it.hasNext()) {
		    Map.Entry a = (Map.Entry)it.next();
		    System.out.println(a.getKey());
		}
	}
	//aktore baten pelikula zerrenda pantailaratuko du
	public void pelikulakImprimatu(String izenOsoa){
		Aktorea a1 = z1.get(izenOsoa);
		if(a1 == null){
			System.out.println("Ez dago aktore hori!!");
		}else{
			a1.pelikulakInprimatu();
		}
	}
	
	//aktoreen zerrenda ordenatua lortu (abizenak, izena)
	public void zerrendaOrdenatua(){
		List<Map.Entry<String, Aktorea>> l = new LinkedList<Map.Entry<String, Aktorea>>(z1.entrySet());
		Collections.sort(l, new Comparator<Map.Entry<String, Aktorea>>() {
			public int compare(Map.Entry<String, Aktorea> o1, Map.Entry<String, Aktorea> o2){
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		Map<String, Aktorea> sortMap = new LinkedHashMap<String, Aktorea>();
		for(Map.Entry<String, Aktorea> a: l){
			sortMap.put(a.getKey(), a.getValue());
		}
		for(Map.Entry<String, Aktorea> ord: sortMap.entrySet()){
			System.out.println(ord.getValue().getIzena());
		}
			
		
	}
	
}
