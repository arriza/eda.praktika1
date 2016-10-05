package eda.praktika1;

public class SortAndSearch <T extends Comparable <T>>{
	//eraikitzaile hutsa
		public SortAndSearch(){}
		
		//MERGESORT
		
		public void mergeSort(T[] peli) {
			mergeSort(peli, 0, peli.length-1);
		}
		
		private void mergeSort(T[] peli, int hasiera, int bukaera){
			
			if (hasiera < bukaera) { 
				//taulan elementu bat baino gehiago badago
				mergeSort(peli, hasiera, (hasiera+bukaera)/2);
				mergeSort(peli, ((hasiera+bukaera)/2)+1,bukaera);
				bateratze(peli, hasiera,(hasiera+bukaera)/2, bukaera);
			}
		}
		private void bateratze(T[] peli, int i, int erdikoa, int f)
		{
			@SuppressWarnings("unchecked")
			T[] bateratua = (T[])(new Comparable[f-i+1]);
			int ezker = i;
			int eskuin = erdikoa+1;
			int k = 0;
			while (ezker <= erdikoa && eskuin <=f) {
				if(peli[ezker].compareTo(peli[eskuin])<=0) {
					bateratua[k] = peli[ezker];
					k++;
					ezker++;
				}
				else {
					bateratua[k]=peli[eskuin];
					k++;
					eskuin++;
				}	
			}
			if(ezker > erdikoa) {
				while(eskuin<=f) {
					bateratua[k]=peli[eskuin];
					k++;
					eskuin++;
				}
			}
			else {
				while(ezker<=erdikoa) {
					bateratua[k]=peli[ezker];
					k++;
					ezker++;
				}
			}
			for(int j=i; j<=f; j++) {
				peli[j]=bateratua[j-i];
			}
		}
		
		//QUICKSORT
		
		public void quickSort(T[] peli) {
			quickSort(peli, 0, peli.length-1);
		}
		
		private void quickSort(T[] peli, int hasiera, int bukaera){
			if (bukaera-hasiera>0) { 
				//taulan elementu bat baino gehiago
				int indizeaZatiketa = zatiketa(peli, hasiera, bukaera);
				quickSort(peli, hasiera, indizeaZatiketa-1);
				quickSort(peli, indizeaZatiketa+1, bukaera);
			}
		}
		
		private int zatiketa(T[] peli, int i, int f) {
			T lag= peli[i];
			int ezker = i;
			int eskuin = f;
			while (ezker<eskuin) {
				while (peli[ezker].compareTo(lag)<=0 && ezker<eskuin) {
					ezker++;
				}
				while (peli[eskuin].compareTo(lag)>0) {
					eskuin--;
				}
				if (ezker<eskuin) {
					swap(peli, ezker, eskuin);
				}
			}
			peli[i]=peli[eskuin];
			peli[eskuin]=lag;
			return eskuin;
		}
		
		private void swap(T[] peli, int bat, int bi) {
			T temp = peli[bat];
			peli[bat]=peli[bi];
			peli[bi]=temp;
		}
}
