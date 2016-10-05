package eda.praktika1;

import java.util.ArrayList;
import java.util.Iterator;

public class PelikulaZerrenda {
	
	private ArrayList<Aktorea> zerrenda;
	
	private static PelikulaZerrenda nirePelikulaZerrenda= new PelikulaZerrenda();
	
	private PelikulaZerrenda() {
		zerrenda=new ArrayList<Aktorea>();
	}	

	public static synchronized PelikulaZerrenda getPelikulaZerrenda() 
	{
		if (PelikulaZerrenda.nirePelikulaZerrenda==null){
			PelikulaZerrenda.nirePelikulaZerrenda=new PelikulaZerrenda();
		}
		return PelikulaZerrenda.nirePelikulaZerrenda;
	}
	public void gehituPelikula(Pelikula p){
		
	}
	public int tamaina() {
		return zerrenda.size();
	}
	
	public Iterator<Aktorea> getIteradorea(){
		return zerrenda.iterator();
	}
}
