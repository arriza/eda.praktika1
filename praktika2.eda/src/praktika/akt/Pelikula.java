package praktika.akt;



import praktika2.eda.CircularLinkedList;
import praktika2.eda.Node;
import praktika2.eda.OrderedCircularLinkedList;
import praktika2.eda.UnorderedCircularLinkedList;

public class Pelikula {
	//Atributuak
	
		private String izenburua;
		private UnorderedCircularLinkedList<Aktorea> listaAktoreak ;
		private OrderedCircularLinkedList<Aktorea> listaAktoreOrdenatuak;
		
		public Pelikula(String izenburua){
			this.izenburua=izenburua;
			listaAktoreak = new UnorderedCircularLinkedList<Aktorea>();
		}
		
		public String getIzenburua() {
			return this.izenburua;
		}
		public CircularLinkedList<Aktorea> getListaAktoreak(){
			return listaAktoreak;
		}
		public void gehituAktorea(Aktorea akt){
			if(!listaAktoreak.contains(akt)){
				listaAktoreak.addToRear(akt);
			}else{
				System.out.println("Aktorea badago listan");
			}
		}
		public void gehituPelikulaOrdenatua(Aktorea akt){
			if(!listaAktoreOrdenatuak.contains(akt)){
				this.listaAktoreOrdenatuak.add(akt);
			}else{
				System.out.println("Aktorea badago zerrendan");
			}
		}
		public boolean badagoAktorea(Aktorea a){
			return listaAktoreak.contains(a);
		}
		public Aktorea findAktorea(String izena){
			Aktorea a = new Aktorea(izena);
			return listaAktoreak.find(a);
		}
		public int compareTo(Pelikula peli) {
			return this.izenburua.compareTo(peli.izenburua);
		}
		public void ezabatuAktorea(String izenOsoa){
			Aktorea a = new Aktorea(izenOsoa);
			//nodoaren .data konparatzen ditu
			a =listaAktoreak.remove(a);
			if(a != null){
				System.out.println("Ezabatutako pelikula"+a.getIzena());
			}
		}
		public int aktoreKopurua() {
			return listaAktoreak.size();
		}
		public void imprimatu(){
			System.out.println(this.getIzenburua());
		}
		public void azkenAktoreaInprimatu(){
			listaAktoreak.last().imprimatu();
		}
		public void lehenAktoreaInprimatu(){
			listaAktoreak.first().imprimatu();
		}
		public void lehenAktoreaEzabatu(){
			listaAktoreak.removeFirst();
		}
		public void azkenAktoreaEzabatu(){
			listaAktoreak.removeLast();
		}
		public void imprimatuAktoreak(){
			//listaAktoreak.adabegiakInprimatu();
			Node<Aktorea> current = listaAktoreak.getLast();
			if(!listaAktoreak.isEmpty()){
				if(listaAktoreak.getLast().next == listaAktoreak.getLast()){
					//elementu bakarreko lista
					current.data.imprimatu();
				}else{
					//elementu bat baino gehiago
					while(current.next!= listaAktoreak.getLast()){
						current.next.data.imprimatu();
						current = current.next;
					}listaAktoreak.getLast().data.imprimatu();
				}
			}
		}
		public void hasieranGehitu(Aktorea p){
			listaAktoreak.addToFront(p);
		}
		public void bukaeranGehitu(Aktorea p){
			listaAktoreak.addToRear(p);
		}
		public void ondorenGehitu(Aktorea p, String izen){
			Aktorea p2 = new Aktorea(izen);
			listaAktoreak.addAfter(p,p2);
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((izenburua == null) ? 0 : izenburua.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Pelikula))
				return false;
			Pelikula other = (Pelikula) obj;
			if (izenburua == null) {
				if (other.izenburua != null)
					return false;
			} else if (!izenburua.equals(other.izenburua))
				return false;
			return true;
		}
}
