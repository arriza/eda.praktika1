package eda.praktika1;

import java.util.ArrayList;

public class Aktorea {
	//Atributuak
		private String izenOsoa;
		private ArrayList<Pelikula> listaPelikulak=new ArrayList<Pelikula>();
		
		//Eraikitzailea
		
		public Aktorea (String izenOsoa){
			this.izenOsoa=izenOsoa;
		}
		
		//Getters & Setters

		
		public String getIzena() {
			return izenOsoa;
		}

		public void setIzena(String izenOsoa) {
			this.izenOsoa = izenOsoa;
		}


		public ArrayList<Pelikula> getPelikulaLista() {
			return this.listaPelikulak;

		}

		public void gehituPelikula(Pelikula peli) {
			this.listaPelikulak.add(peli);
		}
		
		//Metodoak
		
		public void pelikulakInprimatu() {
			int i;
			for (i=0;i==this.listaPelikulak.size()-1;i++) {
				System.out.println(this.listaPelikulak.get(i).getIzenburua());
			}
		}
		
		public int pelikulaKopurua() {
			return this.listaPelikulak.size();
		}
		
	/*	public int compareTo(Aktorea akt) {
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
		}*/
}
