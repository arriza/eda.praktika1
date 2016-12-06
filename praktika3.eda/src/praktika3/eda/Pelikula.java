package praktika3.eda;




import java.util.ArrayList;

public class Pelikula {
	//Atributuak
	
		private String izenburua;
		private ArrayList<Aktorea> listaAktoreak = new ArrayList<Aktorea>();
		
		public Pelikula(String izenburua){
			this.izenburua=izenburua;
		}
		
		public String getIzenburua() {
			return this.izenburua;
		}
		public void gehituAktorea(Aktorea akt) {
			if(!badagoAktorea(akt)){
				this.listaAktoreak.add(akt);
			}
		}
		public boolean badagoAktorea(Aktorea a){
			return this.listaAktoreak.contains(a);
		}
		public int compareTo(Pelikula peli) {
			return this.izenburua.compareTo(peli.izenburua);
		}

		public int aktoreKopurua() {
			return this.listaAktoreak.size();
		}
		
		public void kenduAktorea(Aktorea akt)
		{
			int k=this.listaAktoreak.indexOf(akt);
			this.listaAktoreak.remove(k);
		}
		public ArrayList<Aktorea> getListaAktoreak()
		{
			return this.listaAktoreak;
		}
		public void imprimatuAktoreak(){
			for(int i = 0; i<this.getListaAktoreak().size(); i++){
				System.out.println(this.getListaAktoreak().get(i).getIzena());
			}
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
