package Metodes;

public class exercici89 {

	public static void main(String[] args) {
		/*89. Fer  un  programa  on  l’usuari  anirà  introduint  números,  finalitzant  la  sèrie  amb  el  0.  
		 * Per  cada dos números introduïts s’haurà de mostrar com a resultat si el segon número es divisor del primer número. 
		 * Caldrà desenvolupar els següents mètodes
		 * •int LlegirEnter();
		 * •boolean esDivisor(int Divisor, int Divident);*/
		
		
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
		while(num != 0) {//El bucle s'acaba si el numero introduit és 0
			cont++;
			vector[i] = num;
			if(cont >= 2) {
				cont = 0;
				divisor = esDivisor(vector[i], vector[(i-1)]);//Quan contem 2 numeros mirem si son divisors o no
				if(divisor) {
					System.out.println("El numero " + vector[i-1] + " és divisor de "+ vector[i]);
				}else {
					System.out.println("El numero " + vector[i-1] + " NO és divisor de "+ vector[i]);
				}
				System.out.println();
			}
			
			num = teclat.llegirEnter("Introdueix el següent numero: ");
			i++;
		}
		System.out.println("Adèu!");
	}
	
	private boolean esDivisor(int Divisor, int Divident) {
		
		if(Divident%Divisor == 0) {
			return true;//Si que és divisor
		}
		return false;//Retornem que no és un divisor
	}

}
