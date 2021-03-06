package praktika2.eda;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unused")
public class CircularLinkedList<T> implements ListADT<T> {
	// Atributuak
	protected Node<T> last; // azkenaren erreferentzia
	protected String deskr;  // deskribapena
	protected int count;
	public CircularLinkedList() {
		last = null;
		deskr = "";
		count = 0;
	}
	public Node<T> getLast(){
		return last;
	}
	public void setDeskr(String ize) {
	  deskr = ize;
	}

	public String getDeskr() {
	  return deskr;
	}

	/**
	 * Kostua konstantea O(1) esleipenak bakarrik egiten direlako eta esleipenen kostua kte. da
	 */
	public T removeFirst() {
	/* Aurrebaldintza: zerrenda ez da hutsa
	Postbaldintza: zerrendako lehenengo elementua bueltatuko du 
	 * eta listako lehen elementua kendu da
	 */
		T firstNode;
		if(last.next.equals(last)){
			firstNode = last.data;
			last = null;
		}else{
			firstNode = last.next.data;
			last.next = last.next.next;
		}
		
		count --;
		//listako lehen elementua bueltatzen du
		return(firstNode);
		
	}

	/**
	 * Kostua O(n)izango da zerrenda osoa zeharkatu behar delako
	 * n=zerrendan dauden elementu kopurua izanda
	 * esleipenenen kostua kte. da
	 */
	public T removeLast() {
		/* Aurrebaldintza: zerrenda ez da hutsa
		Postbaldintza: zerrendako azken elementua bueltatuko du 
		 * eta listako azken elementua kendu da
		 */
		T lastNode;
		if(last.next.equals(last)){
			lastNode = last.data;
			last = null;
		}else{
			lastNode = last.data;
			Node<T> current = last;
			//last -en aurreko nodoa aurkitu beharra dago
			while(current.next != last){
				current = current.next;
			}
			current.next = last.next;
			last = current;
		}
		
		count --;
		return(lastNode);
		
    }

	/**
	 * Kostua O(n)izango da zerrenda zeharkatu behar delako, kasurik txarrenean zerrenda osoa zeharkatuko da
	 * n=zerrendan dauden elementu kopurua izanda
	 * esleipenenen kostua kte. da
	 */
	public T remove(T elem) {
	// Aurrebaldintza: zerrenda ez da hutsa
	// Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia 
        //  bueltatuko du (null ez baldin badago)
		T r = null;
		//elementu bakarreko zerrenda
		if(last.next.equals(last)){
			if(last.data.equals(elem)){
				r = last.data;
				last = null;
			}
		}else{
			Node<T> current = last.next;
			
			if(current.data.equals(elem)){
				r = current.data;
				last.next = current.next;
			}else{
				boolean jarraitu = true;
				while(jarraitu && current != last){
					if(current.next.data.equals(elem)){
						jarraitu = false;
					}else{
						current = current.next;
					}
				}
				if(!jarraitu){
					r = current.next.data;
					if( current.next == last){
						last = current;
					}
					current.next = current.next.next;
				}
			
			}
		}
	return(r);
    }
	/**
	 * Kostua konstantea O(1) esleipenak bakarrik egiten direlako eta esleipenen kostua kte. da
	 */
	public T first() {
	// listako lehen elementua ematen du
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}
	/**
	 * Kostua konstantea O(1) esleipenak bakarrik egiten direlako eta esleipenen kostua kte. da
	 */
	public T last() {
	// listako azken elementua ematen du
	      if (isEmpty())
	          return null;
	      else return last.data;
	}
	/**
	 * Kostua O(n)izango da zerrenda zeharkatu behar delako, kasurik txarrenean zerrenda osoa zeharkatuko da
	 * n=zerrendan dauden elementu kopurua izanda
	 * esleipenenen kostua kte. da
	 */
	public boolean contains(T elem) {
	// Egiazkoa bueltatuko du aurkituz gero, eta false bestela
		boolean badago = false;
		Node<T> current = last;
		if(last != null){
			if(current.data.equals(elem)){
				badago = true;
			
			}else{
				while(!badago && current.next != last){
					if(current.next.data.equals(elem)){
						badago = true;
					}else{
					current = current.next;
					}
				}
			}
		}return(badago);
	
		   }
	/**
	 * Kostua O(n)izango da zerrenda zeharkatu behar delako, kasurik txarrenean zerrenda osoa zeharkatuko da
	 * n=zerrendan dauden elementu kopurua izanda
	 * esleipenenen kostua kte. da
	 */
	@SuppressWarnings("unchecked")
	public T find(T elem) {
		//Aurre.: 
	// Elementua bueltatuko du aurkituz gero, eta null bestela
		T r = (T)new Object();
		Node<T> current = last;
		boolean badago = false;
		if(last != null){
				
			if(current.data.equals(elem)){
					badago = true;
					r = current.data;
				
			}else{
				while(!badago && current.next != last){
					if(current.next.data.equals(elem)){
						badago = true;
						r = current.next.data;
					}else{
						current = current.next;
					}
				}	
			}
		}
		if(!badago){
			r = null;
		}
		return(r);
	}
	/**
	 * Kostua konstantea O(1) esleipenak bakarrik egiten direlako eta esleipenen kostua kte. da
	 */
	public boolean isEmpty() 
	{ return last == null;};
	/**
	 * Kostua konstantea O(1) esleipenak bakarrik egiten direlako eta esleipenen kostua kte. da
	 */
	public int size() 
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 
		   private Node<T> current;
		   private ListIterator(){
			   current = last;
		   }
		   public boolean hasNext(){
			   return current != null;
		   }
		   public T next(){
			   if(hasNext()){
				   T next = current.data;
				   current = current.next;
				   return next;
			   }
			   //ez badago elementurik 
			   throw new java.util.NoSuchElementException("linked list.next");
		   }

		   public void remove(){
			   throw new UnsupportedOperationException("Linked list iterator remove not supported");
		   }
	   } // private class
	   
	   
		public void imprimatu(){
			Node<T> current = last.next;
			if(!isEmpty()){
				if(last.next == last){
					//elementu bakarreko lista
					System.out.println(current.data.toString());
				}else{
					//elementu bat baino gehiago
					while(current!= last){
						System.out.println(current.data.toString());
						current = current.next;
					}
				}
			}
		}
		
		public void adabegiakInprimatu() {
			System.out.println(this.toString());
		}

		
		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result + "]";
		}

}
