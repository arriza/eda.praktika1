package eda.praktika1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AktoreZerrendaTest {
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
	public void testEzabatuAktorea() {
		AktoreZerrenda.getAktoreZerrenda().hasieratu();
		
		AktoreZerrenda.getAktoreZerrenda().gehituAktorea(aktore1);
		AktoreZerrenda.getAktoreZerrenda().gehituAktorea(aktore2);
		AktoreZerrenda.getAktoreZerrenda().gehituAktorea(aktore3);
		assertTrue(AktoreZerrenda.getAktoreZerrenda().zerrendanDago(aktore3.getIzena()));
		AktoreZerrenda.getAktoreZerrenda().ezabatuAktorea(aktore3.getIzena());
		assertFalse(AktoreZerrenda.getAktoreZerrenda().zerrendanDago(aktore3.getIzena()));
	}
	
	@Test
	public void testGehituAktorea() {
		AktoreZerrenda.getAktoreZerrenda().hasieratu();
		
		AktoreZerrenda.getAktoreZerrenda().gehituAktorea(aktore1);
		AktoreZerrenda.getAktoreZerrenda().gehituAktorea(aktore2);
		AktoreZerrenda.getAktoreZerrenda().gehituAktorea(aktore3);
		
		assertTrue(AktoreZerrenda.getAktoreZerrenda().zerrendanDago(aktore3.getIzena()));
		
		assertFalse(AktoreZerrenda.getAktoreZerrenda().zerrendanDago("egunon"));
	}
	
	@Test 
	public void testHasieratu(){
		AktoreZerrenda.getAktoreZerrenda().gehituAktorea(aktore1);
		AktoreZerrenda.getAktoreZerrenda().gehituAktorea(aktore2);
		AktoreZerrenda.getAktoreZerrenda().gehituAktorea(aktore3);
		
		assertTrue(AktoreZerrenda.getAktoreZerrenda().zerrendanDago(aktore3.getIzena()));
		
		AktoreZerrenda.getAktoreZerrenda().hasieratu();
		
		assertFalse(AktoreZerrenda.getAktoreZerrenda().zerrendanDago(aktore3.getIzena()));
		
	}
}
