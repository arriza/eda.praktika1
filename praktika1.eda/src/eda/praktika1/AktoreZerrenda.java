package eda.praktika1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
	public Iterator<Aktorea> getIteradorea(){
		return zerrenda.iterator();
	}
	//HashMap egitura
	public int sizeHM(){
		return z1.size();
	}
	public boolean badagoZerrendan(String izenOsoa){
		return z1.containsKey(izenOsoa);
	}
	public void gehituAktorea(Aktorea a){
		//konprobatu aktorea zerrendan dagoen jada
		if(!AktoreZerrenda.getAktoreZerrenda().badagoZerrendan(a.getIzena())){
			z1.put(a.getIzena(), a);
		}else{
			System.out.println(a.getIzena()+" aktorea badago zerrendan!!");
		}
		
	}
	
	
}
