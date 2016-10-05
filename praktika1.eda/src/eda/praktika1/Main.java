package eda.praktika1;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	private static String path;
	private static Scanner sc = new Scanner(System.in);
	private static Stopwatch timer;
	
	public static void main(String[] args) throws IOException {

	try{
		path=Kargatu.pathLortu();
		if(args.length>0 && args[0].equals("-t"))
		{
			timer = new Stopwatch();
		}
		Kargatu.datuakKargatu(path);
//		PelikulaZerrenda.getPelikulaZerrenda().ordenatuPelikulaZerrenda();
//		AktoreZerrenda.getAktoreZerrenda().ordenatuAktoreZerrenda();
		if(args.length>0 && args[0].equals("-t"))
		{
			System.out.println("Denbora totala: " +timer.elapsedTime() +"s\n");
		}
	}
	catch(IOException siErrorea)
		{
		System.out.println("Fitxategia ez da aurkitu");
		siErrorea.getMessage();
		siErrorea.getStackTrace();
		System.exit(1);
		}
	Main.menuNagusiaTextua(path, args);
	}
	
	static void menuNagusiaTextua(String path,String[] args) throws NoSuchElementException, NullPointerException, IOException
	{
		System.out.println("Menu nagusia:\n");
		System.out.println("Kargatu duzun fitxategia " + path + " da\n");
		System.out.println("Aktorea bat bilatzeko sakatu 'AB'");
		System.out.println("Aktorea berri bat gehitzeko sakatu 'AG'");
		System.out.println("Aktorea baten pelikula korupua ikusteko sakatu 'PK'");
		System.out.println("Pelikula bateko Aktorea kopurua ikusteko sakatu 'AK'");
		System.out.println("Aktorea bat ezabatzeko sakatu 'AE'");
		System.out.println("Pelikula zerrenda fitxategi batean gordetzeko sakatu 'GF'");
		System.out.println("Aktoreaen zerrenda ordenatuta ikusteko sakatu 'ZO'");
		System.out.println("Programa bukatzeko sakatu 'PB'\n");
		System.out.println("Sartu aukeraren bat:");
		Main.menuNagusiaAukera(args);
	}
	
	private static void menuNagusiaAukera(String[] args) throws NoSuchElementException, NullPointerException, IOException
	{
		String aukera=null;
		try{
		aukera=sc.nextLine();
			if(args.length>0 && args[0].equals("-t"))
			{
				timer = new Stopwatch();
			}
		}
		catch (NoSuchElementException elementuaEzDaExistitzenErrorea)
		{
			elementuaEzDaExistitzenErrorea.getMessage();
			elementuaEzDaExistitzenErrorea.getStackTrace();
			Main.menuNagusiaAukera(args); 
		}
		switch (aukera.toUpperCase()) {
		case "AB":
			Main.AktoreaBilatu();
			break;
		case "AG":
			Main.gehituAktorea();
			break;
		case "PK":
			Main.pelikulaKopuruaIkusi();
			break;
		case "AK":
			Main.AktoreKopuruaIkusi();
			break;
		case "AE":
			Main.AktoreaEzabatu();
			break;
		case "GF":
//			PelikulaZerrenda.PelikulaZerrendaGorde();
			break;
		case "ZO":
			Main.AktoreZerrendaOrdenatuaInprimatu();
			break;
		case "PB":
			System.out.println("Programa bukatzea erabaki duzu");
			System.exit(0);
		default:
			System.out.println("Aukera ez da baliozkoa");
			Main.menuNagusiaAukera(args);
			break;
		}
		if(args.length>0 && args[0].equals("-t"))
		{
			System.out.println("Denbora totala: " +timer.elapsedTime() +"s\n");
		}
		Main.menuNagusiaTextua(path, args);
	}
	
	private static void AktoreaBilatu() {
		String izena=Main.getAktorearenIzenOsoa();
		Aktorea akt= new Aktorea(izena);
//		AktoreZerrenda.getAktoreZerrenda().bilatuAktorea(akt);
		return;
	}
	 
	private static void gehituAktorea()
	{
//		String izena=Main.getAktorearenIzenOsoa();
//		Aktorea akt= new Aktorea(izena);
//		if (AktoreZerrenda.getAktoreZerrenda().bilatuAktorea(akt)==null) {
//			System.out.println("Gehitu nahi duzun Aktorea ez dago lista barruan, beraz, gehitu egingo dugu. \n");
//			AktoreZerrenda.getAktoreZerrenda().gehituAktoreaBilatuz(akt);
//		}
//		else {
//			System.out.println("Gehitu nahi duzun Aktorea listan dago jada! \n");			
//		}
//		return;
	}
	
	private static void pelikulaKopuruaIkusi() throws NoSuchElementException, NullPointerException, IOException	{
//		String izena=Main.getAktorearenIzenOsoa();
//		Aktorea akt= new Aktorea(izena);
//		Aktorea gureAktorea=AktoreZerrenda.getAktoreZerrenda().bilatuAktorea(akt);
//		if (gureAktorea!=null) {
//			System.out.println("Aktorea aurkitu da eta pelikula kopuru honetan hartu du parte: \n");
//			System.out.println(gureAktorea.pelikulaKopurua()+ "\n \n");
//		}
//		else {
//			System.out.println("Ez da Aktorea aurkitu. \n");
//			return;
//			}
//		return;
	}
	
	private static void AktoreKopuruaIkusi() throws NoSuchElementException, NullPointerException, IOException
	{
//		System.out.println("Sartu pelikularen izenburua:");
//		String izenburua=sc.nextLine();
//		Pelikula peli= new Pelikula(izenburua);
//		Pelikula gurePeli= PelikulaZerrenda.getPelikulaZerrenda().bilatuPelikula(peli);
//		if (gurePeli!=null) {
//			System.out.println("Pelikula honetan Aktorea kopuru honek hartu du parte: \n");
//			System.out.println(gurePeli.AktoreKopurua() + "\n \n");
//		}
//		return;
	}
	
	private static void AktoreaEzabatu() throws NoSuchElementException, NullPointerException, IOException
	{
//		String izena=Main.getAktorearenIzenOsoa();
//		Aktorea akt= new Aktorea(izena);
//		Aktorea gureAktorea=AktoreZerrenda.getAktoreZerrenda().bilatuAktorea(akt);
//		if (gureAktorea!=null) {
//			System.out.println("Aktorea aurkitu da eta ezabatua izango da. \n");
//			//Parte hartzen duen pelikula guztietatik bere izena kendu(metodoa inplementatu)
//			AktoreZerrenda.getAktoreZerrenda().AktoreaEzabatu(akt);
//		}
//		else {
//			System.out.println("Ez da ezabatu nahi duzun Aktorea aurkitu. \n");
//			return;
//		}
//		return;
	}
	
	private static void AktoreZerrendaOrdenatuaInprimatu()
	{
//		System.out.println("Ordenatutako Aktorea guztien zerrenda inprimatuko da jarraian: \n \n");
//		AktoreZerrenda.getAktoreZerrenda().irakurriAktoreZerrenda();
//		return;
	}
	
	private static String getAktorearenIzenOsoa(){
		System.out.println("Sartu Aktorearen izena: \n");
		String izena = sc.next();
		System.out.println("Sartu Aktorearen abizena: \n");
		String abizena = sc.next();
		String izenOsoa;
		abizena = abizena.concat(", ");
		izenOsoa = abizena.concat(izena);
		System.out.println(izenOsoa);
		return izenOsoa;
	}
}
