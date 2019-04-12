package Metodes;

public class exercici90 {

	public static void main(String[] args) {
		/*90. Fer  un  programa  on  l’usuari  anirà  introduint  números,  finalitzant  la  sèrie  amb  el  0.  
		 * Tots  els números s’aniran guardant en una taula i al final caldrà donar com a resultat, el número més gran de  la  sèrie,  
		 * el  número  més  petit,  la  mitjana  i  quants  son  més  grans  que  la  mitjana.
		 * Caldrà desenvolupar els següents mètodes
		 * •int Llegirenter();
		 * •int mesGran(int[] valors);
		 * •int mesPetit(int[] valors);
		 * •double mitjana(int[] valors);*/
		
		exercici90 programa = new exercici90();
		programa.inici();
	}
	private void inici() {
			cLector teclat = new cLector();
			int[] vector = new int[999];//Taula on guardarem tots els numeros
			System.out.println("Programa per a calcular el numero més gran, el numero més petit i la mitjana!");
			int num = teclat.llegirEnter("Introdueix el primer numero: "); 
			int i=0;
			
			while(num != 0 && i < 999) {
				vector[i] = num; i++;
				num = teclat.llegirEnter("Introdueix el següent numero: ");
			}
			if(i<=0) {
				System.out.print("No hi ha cap numero introduit!");
			}else {
				
				double mitjana = mitjana(vector,i);
				int[] quantsmesgran = quantsmesgran(vector,i,mitjana);
				System.out.println("El numero més gran és " + mesGran(vector,i));
				System.out.println("El numero més petit és " + mesPetit(vector,i));
				System.out.println("La mitjana de tot el vector és " + mitjana);
				
				if(quantsmesgran.length <= 0) {
					System.out.println("No hi ha cap numero que sigui més gran que la mitjana");
				}else {
					System.out.print("Els numeros més grans que la mitjana són: ");
					for(int j = 0; j<quantsmesgran.length;j++) {
						if(quantsmesgran[j] != 0) {
							System.out.print(quantsmesgran[j]+" ");
						}
						
					}
				}
			}
			
	}
	//Funció per a trobar el numero més gran
	private int mesGran(int[] vector,int mida) {
		int gran = vector[0];
		for(int i = 1; i<mida; i++) {
			if(gran < vector[i]) {
				gran = vector[i];
			}
		}
		return gran;
	}
	//Funcio per a trobar el numero més petit
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
	//Funció per a trobar quins numeros són més gran que la mitjana
	private int[] quantsmesgran(int[] vector,int mida, double mitjana) {
		int[] mesgranquemitjana = new int[999];//Vector on li ficarem els numeros més grans que la mitjana
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
