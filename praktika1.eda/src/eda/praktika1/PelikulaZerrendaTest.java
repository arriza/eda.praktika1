package eda.praktika1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class PelikulaZerrendaTest {
	Aktorea aktore1;
	Aktorea aktore2;
	Aktorea aktore3;
	Aktorea aktore4;
	Pelikula peli1;
	Pelikula peli2;
	Pelikula peli3;
	Pelikula peli4;

	@Before
	public void setUp() throws Exception {
		aktore1=new Aktorea("Unai Viseras");
		aktore2=new Aktorea("Unai Arrizabalaga");
		aktore3=new Aktorea("Leire Viseras");
		aktore3=new Aktorea("Leire Arrizabalaga");
		peli1=new Pelikula("Tetanik");
		peli2=new Pelikula("Don Cipote De La Mancha");
		peli3=new Pelikula("Semental Querido Watson");
		peli4=new Pelikula("Más Adentro");
	}

	@After
	public void tearDown() throws Exception {
		aktore1=null;
		aktore2=null;
		aktore3=null;
		aktore4=null;
		peli1=null;
		peli2=null;
		peli3=null;
		peli4=null;
	}

	@Test
	public void testGehituPelikula() {
		PelikulaZerrenda.getPelikulaZerrenda().hasieratu();
		
		PelikulaZerrenda.getPelikulaZerrenda().gehituPelikula(peli1);
		PelikulaZerrenda.getPelikulaZerrenda().gehituPelikula(peli2);
		PelikulaZerrenda.getPelikulaZerrenda().gehituPelikula(peli3);
		
		assertTrue(PelikulaZerrenda.getPelikulaZerrenda().zerrendanDago(peli1.getIzenburua()));
		
		assertFalse(PelikulaZerrenda.getPelikulaZerrenda().zerrendanDago("egunon"));
	}
	
	@Test 
	public void testHasieratu(){
		
		PelikulaZerrenda.getPelikulaZerrenda().gehituPelikula(peli1);
		PelikulaZerrenda.getPelikulaZerrenda().gehituPelikula(peli2);
		PelikulaZerrenda.getPelikulaZerrenda().gehituPelikula(peli3);
		
		assertTrue(PelikulaZerrenda.getPelikulaZerrenda().zerrendanDago(peli1.getIzenburua()));
		
		PelikulaZerrenda.getPelikulaZerrenda().hasieratu();
		
		assertFalse(AktoreZerrenda.getAktoreZerrenda().zerrendanDago(peli1.getIzenburua()));
		
	}

}
