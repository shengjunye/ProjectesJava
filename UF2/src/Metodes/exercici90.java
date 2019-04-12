package Metodes;

public class exercici90 {

	public static void main(String[] args) {
		/*90. Fer  un  programa  on  l�usuari  anir�  introduint  n�meros,  finalitzant  la  s�rie  amb  el  0.  
		 * Tots  els n�meros s�aniran guardant en una taula i al final caldr� donar com a resultat, el n�mero m�s gran de  la  s�rie,  
		 * el  n�mero  m�s  petit,  la  mitjana  i  quants  son  m�s  grans  que  la  mitjana.
		 * Caldr� desenvolupar els seg�ents m�todes
		 * �int Llegirenter();
		 * �int mesGran(int[] valors);
		 * �int mesPetit(int[] valors);
		 * �double mitjana(int[] valors);*/
		
		exercici90 programa = new exercici90();
		programa.inici();
	}
	private void inici() {
			cLector teclat = new cLector();
			int[] vector = new int[999];//Taula on guardarem tots els numeros
			System.out.println("Programa per a calcular el numero m�s gran, el numero m�s petit i la mitjana!");
			int num = teclat.llegirEnter("Introdueix el primer numero: "); 
			int i=0;
			
			while(num != 0 && i < 999) {
				vector[i] = num; i++;
				num = teclat.llegirEnter("Introdueix el seg�ent numero: ");
			}
			if(i<=0) {
				System.out.print("No hi ha cap numero introduit!");
			}else {
				
				double mitjana = mitjana(vector,i);
				int[] quantsmesgran = quantsmesgran(vector,i,mitjana);
				System.out.println("El numero m�s gran �s " + mesGran(vector,i));
				System.out.println("El numero m�s petit �s " + mesPetit(vector,i));
				System.out.println("La mitjana de tot el vector �s " + mitjana);
				
				if(quantsmesgran.length <= 0) {
					System.out.println("No hi ha cap numero que sigui m�s gran que la mitjana");
				}else {
					System.out.print("Els numeros m�s grans que la mitjana s�n: ");
					for(int j = 0; j<quantsmesgran.length;j++) {
						if(quantsmesgran[j] != 0) {
							System.out.print(quantsmesgran[j]+" ");
						}
						
					}
				}
			}
			
	}
	//Funci� per a trobar el numero m�s gran
	private int mesGran(int[] vector,int mida) {
		int gran = vector[0];
		for(int i = 1; i<mida; i++) {
			if(gran < vector[i]) {
				gran = vector[i];
			}
		}
		return gran;
	}
	//Funcio per a trobar el numero m�s petit
	private int mesPetit(int[] vector,int mida) {
		int petit = vector[0];
		for(int i = 1; i<mida; i++) {
			if(petit > vector[i]) {
				petit = vector[i];
			}
		}
		return petit;
	}
	//Funcio per a calcular mitjana
	private double mitjana(int[] vector,int mida) {
		double mitjana = 0;
		for(int i = 0; i<mida;i++) {
			mitjana += vector[i];
		}
		mitjana /= ((mida*100)/100);
		return mitjana;
	}
	//Funci� per a trobar quins numeros s�n m�s gran que la mitjana
	private int[] quantsmesgran(int[] vector,int mida, double mitjana) {
		int[] mesgranquemitjana = new int[999];//Vector on li ficarem els numeros m�s grans que la mitjana
		int cont = 0;
		for(int i = 0; i<=mida; i++) {
			if(mitjana < vector[i]) {
				mesgranquemitjana[cont] = vector[i];
				cont++;
			}
		}
		return mesgranquemitjana;
	}
}
