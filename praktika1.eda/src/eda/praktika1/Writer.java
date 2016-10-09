package eda.praktika1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Writer {
	private static Writer mWriter=null;
	private FileWriter file;
	private Writer(){
		
	}
	public static synchronized Writer getWriter(){
		if(mWriter == null){
			mWriter = new Writer();
		}return mWriter;
	}
	//aktoreen zerrenda fitxategi batean gorde
	@SuppressWarnings("rawtypes")
	public void idatziAktoreenFitx(){
		Iterator it = AktoreZerrenda.getAktoreZerrenda().getIteradorea();
		try {
			file = new FileWriter("fitxategiak/AktoreZerrenda.txt");
			
			while (it.hasNext()) {
			    Map.Entry a = (Map.Entry)it.next();
			    //System.out.println(a.getKey());
			    file.write(a.getKey()+"\r\n");
			}
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * // parent component of the dialog
JFrame parentFrame = new JFrame();
 
JFileChooser fileChooser = new JFileChooser();
fileChooser.setDialogTitle("Specify a file to save");   
 
int userSelection = fileChooser.showSaveDialog(parentFrame);
 
if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
}
	 */
}
