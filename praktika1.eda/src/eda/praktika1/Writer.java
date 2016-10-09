package eda.praktika1;

public class Writer {
	private static Writer mWriter=null;
	private Writer(){}
	public static synchronized Writer getWriter(){
		if(mWriter == null){
			mWriter = new Writer();
		}return mWriter;
	}
	public void idatziAktoreenFitx(){
		
	}
}
