package praktika.akt;


import praktika2.eda.CircularLinkedList;
import praktika2.eda.Node;
import praktika2.eda.OrderedCircularLinkedList;
import praktika2.eda.UnorderedCircularLinkedList;

public class Aktorea {
	//Atributuak
		private String izenOsoa;
		private UnorderedCircularLinkedList<Pelikula> listaPelikulak;
		private OrderedCircularLinkedList<Pelikula> listaPelikulaOrdenatuak;
		//Eraikitzailea
		
		public Aktorea (String izenOsoa){
			this.izenOsoa=izenOsoa;
			listaPelikulak  = new UnorderedCircularLinkedList<Pelikula>();
			listaPelikulaOrdenatuak= new OrderedCircularLinkedList<Pelikula>();
		}
		
		public String getIzena() {
			return izenOsoa;
		}
		public CircularLinkedList<Pelikula> getListaPelikulak(){
			return listaPelikulak;
		}
		public void gehituPelikula(Pelikula peli){
			if(!listaPelikulak.contains(peli)){
				this.listaPelikulak.addToRear(peli);
			}else{
				System.out.println("Pelikula badago listan");
			}
		}
		public void gehituPelikulaOrdenatua(Pelikula peli){
			if(!listaPelikulaOrdenatuak.contains(peli)){
				this.listaPelikulaOrdenatuak.add(peli);
			}else{
				System.out.println("Pelikula badago zerrendan");
			}
		}
		public void ezabatuPelikula(String izenburua){
			Pelikula p = new Pelikula(izenburua);
			
			p =listaPelikulak.remove(p);
			if(p != null){
				System.out.println("Ezabatutako pelikula"+p.getIzenburua());
			}
		}
		public boolean badagoPelikula(String izenburua){
			Pelikula p = new Pelikula(izenburua);
			return listaPelikulak.contains(p);
		}
		public Pelikula findPeli(String izenburua){
			Pelikula p = new Pelikula(izenburua);
			return listaPelikulak.find(p);
		}
		public void imprimatu(){
			System.out.println(this.getIzena());
		}
		public void azkenPelikulaInprimatu(){
			listaPelikulak.last().imprimatu();
		}
		public void lehenPelikulaInprimatu(){
			listaPelikulak.first().imprimatu();
		}
		public void lehenPelikulaEzabatu(){
			listaPelikulak.removeFirst();
		}
		public void azkenPelikulaEzabatu(){
			listaPelikulak.removeLast();
		}
		public void pelikulakInprimatu() {
			//listaPelikulak.adabegiakInprimatu();
			Node<Pelikula> current = listaPelikulak.getLast();
			if(!listaPelikulak.isEmpty()){
				if(listaPelikulak.getLast().next == listaPelikulak.getLast()){
					//elementu bakarreko lista
					current.data.imprimatu();
				}else{
					//elementu bat baino gehiago
					while(current.next!= listaPelikulak.getLast()){
						current.next.data.imprimatu();
						current = current.next;
					}
					listaPelikulak.getLast().data.imprimatu();
				}
			}
		}
		
		public int pelikulaKopurua() {
			return listaPelikulak.size();
		}
		public void hasieranGehitu(Pelikula p){
			listaPelikulak.addToFront(p);
		}
		public void bukaeranGehitu(Pelikula p){
			listaPelikulak.addToRear(p);
		}
		public void ondorenGehitu(Pelikula p, String izen){
			Pelikula p2 = new Pelikula(izen);
			listaPelikulak.addAfter(p,p2);
		}
		public int compareTo(Aktorea akt) {
			return this.izenOsoa.compareTo(akt.izenOsoa);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((izenOsoa == null) ? 0 : izenOsoa.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Aktorea))
				return false;
			Aktorea other = (Aktorea) obj;
			if (izenOsoa == null) {
				if (other.izenOsoa != null)
					return false;
			} else if (!izenOsoa.equals(other.izenOsoa))
				return false;
			return true;
		}
}
