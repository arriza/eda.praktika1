package praktika.akt;


import praktika2.eda.CircularLinkedList;
import praktika2.eda.UnorderedCircularLinkedList;

public class Aktorea {
	//Atributuak
		private String izenOsoa;
		private UnorderedCircularLinkedList<Pelikula> listaPelikulak;
		
		//Eraikitzailea
		
		public Aktorea (String izenOsoa){
			this.izenOsoa=izenOsoa;
			listaPelikulak  = new UnorderedCircularLinkedList<Pelikula>();
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
		public void pelikulakInprimatu() {
			listaPelikulak.adabegiakInprimatu();
		}
		
		public int pelikulaKopurua() {
			return listaPelikulak.size();
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
