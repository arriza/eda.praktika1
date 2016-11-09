package praktika2.eda;

public class UnorderedCircularLinkedList<T> extends CircularLinkedList<T> implements UnorderedListADT<T> {
	/**
	 * Kostua konstantea O(1) esleipenak bakarrik egiten direlako eta esleipenen kostua kte. da
	 */
	public void addToFront(T elem) {
	// hasieran gehitu
		Node<T> elemN = new Node<T>(elem);
		if(isEmpty()){
			elemN.next = elemN;
			last = elemN;
			
		}else{
			elemN.next = last.next;
			last.next = elemN;
		}
		
		count++;
		System.out.println(elemN.data);
	}
	/**
	 * Kostua konstantea O(1) esleipenak bakarrik egiten direlako eta esleipenen kostua kte. da
	 */
	public void addToRear(T elem) {
	// bukaeran gehitu
		Node<T> elemN = new Node<T>(elem);
		if(last == null){
			last = elemN;
			last.next = last;
			
		}else{
			elemN.next = last.next;
			last.next = elemN;
			last = elemN;
		}
		count++;
		//System.out.println(elemN.data);
		
		
	}
	
	/**
	 * Kostua konstantea O(n)izango da zerrenda osoa zeharkatu behar delako
	 * n=zerrendan dauden elementu kopurua izanda
	 * esleipenenen kostua kte. da
	 */
	public void addAfter(T elem, T target) {
		//target elementua listan dagoela suposatu behar da
		Node<T> current = last;
		boolean aurkitu = false;
		Node<T> berria = new Node<T>(elem);
		if(current.data.equals(target)){
			berria.next = current.next;
			current.next = berria;
			last = berria;
		}else{
			while(!aurkitu){
				if(current.data.equals(target)){
					aurkitu = true;
				}else{
					current = current.next;
				}
			}
		
		
			berria.next = current.next;
			current.next = berria;
		}
		count++;
	}

}
