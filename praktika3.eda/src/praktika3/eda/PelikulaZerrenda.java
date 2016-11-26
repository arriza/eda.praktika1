package praktika3.eda;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PelikulaZerrenda {
	
	//private ArrayList<Aktorea> zerrenda;
	
	private static PelikulaZerrenda nirePelikulaZerrenda= null;
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
	public Map<String, Pelikula> getHashMap(){
		return z1;
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

	//pelikula baten bilaketa
	public void badagoZerrendan(String izenburua){
		if(!PelikulaZerrenda.getPelikulaZerrenda().zerrendanDago(izenburua)){
			System.out.println(izenburua+" pelikula badago zerrendan! :)");
		}else{
			System.out.println(izenburua+" ez da aurkitu zerrendan... :(");		}
	}
	//pelikula zerrenda imprimatu
	@SuppressWarnings("rawtypes")
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
		Pelikula p;
		if(PelikulaZerrenda.getPelikulaZerrenda().zerrendanDago(izenburua)){
			p = PelikulaZerrenda.getPelikulaZerrenda().z1.get(izenburua);
			p.imprimatuAktoreak();
		}else{
			System.out.println("Ez da aurkitu zerrendan!!");
		}
	}
	public void hasieratu() {
		z1 = null;
		nirePelikulaZerrenda = null;
	}
	public void ezabatuAktorea(Aktorea izenOsoa){
		
		//bilatu aktore hori dagoen pelikula guztietan eta ezabatu
		for (Pelikula key : z1.values()) {
	        key.kenduAktorea(izenOsoa);
	    }
	}
	//fitxategitik datuak atera
		@SuppressWarnings({ "resource", "unused" })
		public void zerrendaKargatu(String nomF){
			String [] peli = null;
			String [] aktore = null;
			Pelikula p = null;
			Aktorea a = null;
			//String 
			try{
				 Scanner entrada = new Scanner(new FileReader(nomF));
				 FileReader f = new FileReader(nomF);
				 BufferedReader reader = new BufferedReader(f);
				 String linea;
				 while (entrada.hasNext()) {
				// lerroko pelikularen izenburua lortu
					 linea = entrada.nextLine();
					 peli = reader.readLine().split("\\s--->\\s");
				//sortu pelikula objektua
				p = new Pelikula(peli[0]);
				//pelikula pelikulen katalogora gehitu
				PelikulaZerrenda.getPelikulaZerrenda().gehituPelikula(p);
				aktore = peli[1].split("\\s&&&\\s");
				for(int i = 0; i<aktore.length;i++){
					//System.out.println(aktore[i]);
					a = new Aktorea(aktore[i]);
					p.gehituAktorea(a);
					
					if(!AktoreZerrenda.getAktoreZerrenda().zerrendanDago(aktore[i])){
						//ez badago zerrendan aktorea zerrendara gehitzen dugu eta pelikula bere zerrendara gehitzen zaio
						a.gehituPelikula(p);
						AktoreZerrenda.getAktoreZerrenda().gehituAktorea(a);
					}else{
						//aktorea badago zerrendan pelikula gehitzen diogu bere zerrendari
						AktoreZerrenda.getAktoreZerrenda().gehitu(p, aktore[i]);
						
					}
				}
				
				 }
				 entrada.close();
				 }
				 catch(IOException e) {
					 //ezdago fitxategia
					 System.out.println("EZ DA FITXATEGIA AURKITZEN");
					 //e.printStackTrace();
					 System.exit(0);
					 }
		}
}
