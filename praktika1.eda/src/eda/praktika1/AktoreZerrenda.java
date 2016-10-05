package eda.praktika1;

import java.util.ArrayList;
import java.util.Iterator;

public class AktoreZerrenda {
	
	private ArrayList<Aktorea> zerrenda;
	
	private static AktoreZerrenda nireAktoreZerrenda= new AktoreZerrenda();
	
	private AktoreZerrenda() {
		zerrenda=new ArrayList<Aktorea>();
	}	

	public static synchronized AktoreZerrenda getAktoreZerrenda() 
	{
		if (AktoreZerrenda.nireAktoreZerrenda==null){
			AktoreZerrenda.nireAktoreZerrenda=new AktoreZerrenda();
		}
		return AktoreZerrenda.nireAktoreZerrenda;
	}
	
	public int tamaina() {
		return zerrenda.size();
	}
	
	public Iterator<Aktorea> getIteradorea(){
		return zerrenda.iterator();
	}
}
