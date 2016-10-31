package praktika2.eda;

public class UnorderedCircularLinkedList<T> extends CircularLinkedList<T> implements UnorderedListADT<T> {
	/**
	 * Kostua konstantea O(1) esleipenak bakarrik egiten direlako eta esleipenen kostua kte. da
	 */
	public void addToFront(T elem) {
	// hasieran gehitu
		Node<T> elemN = new Node<T>(elem);
		elemN.next = last.next;
		last.next = elemN;
	}
	/**
	 * Kostua konstantea O(1) esleipenak bakarrik egiten direlako eta esleipenen kostua kte. da
	 */
	public void addToRear(T elem) {
	// bukaeran gehitu
		Node<T> elemN = new Node<T>(elem);
		elemN.next = last.next;
		last.next = elemN;
		last = elemN;
		
	}
	//target elementua listan dagoela suposatu behar da
	public void addAfter(T elem, T target) {
		Node<T> current = last;
		boolean aurkitu = false;
		
		while(!aurkitu){
			if(current.data.equals(target)){
				aurkitu = true;
			}else{
				current = current.next;
			}
		}
		Node<T> berria = new Node<T>(elem);
		berria.next = current.next;
		current.next = berria;
		if(current == last){
			last = berria;
		}
		
	}

}
