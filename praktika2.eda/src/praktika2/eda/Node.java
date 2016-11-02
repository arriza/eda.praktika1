package praktika2.eda;

	public class Node<T> implements Comparable<T>{
		public T data; 			// dato del nodo
		public Node<T> next; 	// puntero al siguiente nodo de la lista
		// -------------------------------------------------------------

		public Node(T dd) 		// constructor
		{
			data = dd;
			next = null;
		}
		@Override
		public int compareTo(T o) {
			// TODO Auto-generated method stub
			return this.compareTo(o);
		}
	}


