package praktika2.eda;

public class OrderedCircularLinkedList<T> extends CircularLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		//elementua dagokion posizioan gehitu
		boolean jarraitu = true;
		Node<T> current = last;
		Node<T> berria = new Node<T>(elem);
		//lista hutsik badago
		if(isEmpty()){
			berria.next = berria;
			last = berria;
		}else{
			//lista ez dago hutsik
			while(jarraitu){
				if(current.compareTo(elem)<0 && current.next.compareTo(elem)>0){
					berria.next = current.next;
					current.next = berria;
					jarraitu = false;
				}else{
					current = current.next;
				}
			}
			if(current == last){
				last = berria;
			}
		}
		count++;
	}


}
