package eda.praktika1;

public class Reader {
	private static Reader mReader = null;
	private String path;
	private Reader(){}
	public static synchronized Reader getReader(){
		if(mReader == null){
			mReader = new Reader();
		}return mReader;
	}
	
	public void zerrendaKargatu(String nomF){
		
	}
	/*public void cargarLista(String nomF){
 try{
 Scanner entrada = new Scanner(new FileReader(nomF));

 String linea;
 while (entrada.hasNext()) {
 linea = entrada.nextLine();
 ...
 }
 entrada.close();
 }
 catch(IOException e) {e.printStackTrace();}
}
*/
}
