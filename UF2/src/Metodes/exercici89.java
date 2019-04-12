package Metodes;

public class exercici89 {

	public static void main(String[] args) {
		/*89. Fer  un  programa  on  l�usuari  anir�  introduint  n�meros,  finalitzant  la  s�rie  amb  el  0.  
		 * Per  cada dos n�meros introdu�ts s�haur� de mostrar com a resultat si el segon n�mero es divisor del primer n�mero. 
		 * Caldr� desenvolupar els seg�ents m�todes
		 * �int LlegirEnter();
		 * �boolean esDivisor(int Divisor, int Divident);*/
		
		
		exercici89 programa = new exercici89();
		programa.inici();
	}
	
	//Metode principal
	private void inici() {
		System.out.println("Programma per a mirar numeros divisors!");
		cLector teclat = new cLector();
		int num = teclat.llegirEnter("Introdueix un numero: ");
		int[] vector = new int[999];//Variable on emmagatzemo tots els numeros introduits
		int cont=0, i = 0;
		boolean divisor;
		while(num != 0) {//El bucle s'acaba si el numero introduit �s 0
			cont++;
			vector[i] = num;
			if(cont >= 2) {
				cont = 0;
				divisor = esDivisor(vector[i], vector[(i-1)]);//Quan contem 2 numeros mirem si son divisors o no
				if(divisor) {
					System.out.println("El numero " + vector[i-1] + " �s divisor de "+ vector[i]);
				}else {
					System.out.println("El numero " + vector[i-1] + " NO �s divisor de "+ vector[i]);
				}
				System.out.println();
			}
			
			num = teclat.llegirEnter("Introdueix el seg�ent numero: ");
			i++;
		}
		System.out.println("Ad�u!");
	}
	
	private boolean esDivisor(int Divisor, int Divident) {
		
		if(Divident%Divisor == 0) {
			return true;//Si que �s divisor
		}
		return false;//Retornem que no �s un divisor
	}

}
