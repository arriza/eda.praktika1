package eda.praktika1;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.PatternSyntaxException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Kargatu {
	//Atributuak
	
		private static Component frame;

		static String pathLortu() throws IOException, HeadlessException	{
			String path = null;
			String userhome = System.getProperty("user.home");
			JFileChooser fc = new JFileChooser(new File(userhome + "\\Dropbox\\EDA\\1"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("movies-actors", "txt", "text");
			fc.setFileFilter(filter);
			fc.setDialogTitle("Pelikula Zerrenda Ireki");
			try{
			fc.showOpenDialog(frame);
			path = fc.getSelectedFile().getAbsolutePath();
			}
			catch (Exception textuErrorea)
			{
				System.out.println("Ezin da fitxategia kargatu\n");
				textuErrorea.getMessage();
				textuErrorea.getStackTrace();
				System.exit(1);
			}
			return path;
		}

		private static int lerroakKontatu(String path) throws IOException{
		
			FileReader fr = new FileReader(path);
			BufferedReader kontatuLerroak = new BufferedReader(fr);
			int lerroKopurua = 0;
			while (kontatuLerroak.readLine()!= null)
			{
				lerroKopurua++;
			}
			kontatuLerroak.close();
			return lerroKopurua;
		}
		
		static void datuakKargatu(String path) throws IOException, ArrayIndexOutOfBoundsException, PatternSyntaxException, NullPointerException, StackOverflowError {
			
			String[] pelikulaAktoreak = null;
			Pelikula peli=null;
			FileReader fr = new FileReader(path);
			BufferedReader irakurriDatuak = new BufferedReader(fr);
			int bukatu = Kargatu.lerroakKontatu(path);
			int i;
			for(i=0; i<bukatu; i++)
			{
				if(i>0 && i % 10000 == 0){
					System.out.println(i+" Pelikula kargatu dira.");
				}
				pelikulaAktoreak=irakurriDatuak.readLine().split("\\s[\\\\]\\s");
				peli=new Pelikula(pelikulaAktoreak[0].toString());
				int j = 1;
				Aktorea akt;
				try {
				while (!pelikulaAktoreak[j].isEmpty()){
					akt= new Aktorea((pelikulaAktoreak[j].toString()));
					peli.gehituAktorea(akt);
					akt.gehituPelikula(peli);
//					AktoreZerrenda.getAktoreZerrenda().gehituAktorea(akt);
					j++;
				}
				if(i>0 && i % 10000 == 0){
					System.out.println(i+" Pelikula kargatu dira.");
				}
			}
				catch (ArrayIndexOutOfBoundsException arrayaBukatuta){
					arrayaBukatuta.getMessage();
					arrayaBukatuta.getStackTrace();
				}
				
//				PelikulaZerrenda.getPelikulaZerrenda().gehituPelikula(peli);
			}
			System.out.println("Pelikulak kargatu dira\n");
			irakurriDatuak.close();
		}
}
