package eda.praktika1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PelikulaZerrenda {
	
	//private ArrayList<Aktorea> zerrenda;
	
	private static PelikulaZerrenda nirePelikulaZerrenda= new PelikulaZerrenda();
	
	private Map<String,Pelikula> z1;
	
	private PelikulaZerrenda() {
		//zerrenda=new ArrayList<Aktorea>();
		z1 = new HashMap<String, Pelikula>();
	}	

	public static synchronized PelikulaZerrenda getPelikulaZerrenda() 
	{
		if (PelikulaZerrenda.nirePelikulaZerrenda==null){
			PelikulaZerrenda.nirePelikulaZerrenda=new PelikulaZerrenda();
		}
		return PelikulaZerrenda.nirePelikulaZerrenda;
	}
	//pelikula berria zerrendan gehituko du
	public void gehituPelikula(Pelikula p){
		if(!PelikulaZerrenda.getPelikulaZerrenda().zerrendanDago(p.getIzenburua())){
			PelikulaZerrenda.getPelikulaZerrenda().z1.put(p.getIzenburua(), p);
		}else{
			System.out.println(p.getIzenburua()+" pelikula badago zerrendan");
		}
	}
	//pelikula zerrendaren tamaina
	public int tamaina() {
		return PelikulaZerrenda.getPelikulaZerrenda().z1.size();
	}
	//pelikula baten izenburua emanda zerrendan dagoen edo ez esango digu
	public boolean zerrendanDago(String izenburua){
		return PelikulaZerrenda.getPelikulaZerrenda().z1.containsKey(izenburua);
	}
	
	/*public Iterator<Aktorea> getIteradorea(){
		return zerrenda.iterator();
	}*/
	//pelikula baten bilaketa
	public void badagoZerrendan(String izenburua){
		if(!PelikulaZerrenda.getPelikulaZerrenda().zerrendanDago(izenburua)){
			System.out.println(izenburua+" pelikula badago zerrendan! :)");
		}else{
			System.out.println(izenburua+" ez da aurkitu zerrendan... :(");		}
	}
	//pelikula zerrenda imprimatu
	public void imprimatuZerrenda(){
		Iterator it = z1.entrySet().iterator();
		System.out.println("Pelikula Zerrenda:");
		System.out.println("========================================================");
		while (it.hasNext()) {
		    Map.Entry p = (Map.Entry)it.next();
		    System.out.println(p.getKey());
		}
		
	}
	//pelikula batek dituen aktoreen zerrenda imprimatuko du
	public void aktoreakimprimatu(String izenburua){
		Pelikula p = null;
		p = PelikulaZerrenda.getPelikulaZerrenda().z1.get(izenburua);
		p.imprimatuAktoreak();
	}
}
