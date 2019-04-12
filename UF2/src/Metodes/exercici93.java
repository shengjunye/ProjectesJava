package Metodes;

public class exercici93 {

	public static void main(String[] args) {
		/*93. Igual que l’anterior però caldrà dir quantes lletres diferents s’han introduït per a cada paraula i per  a  cada  lletra  quantes  vegades  està  dins  de  la  paraula. 
		 * Caldrà  desenvolupar  els  següents mètodes
		 * •String llegirString();
		 * •char[]lletresDiferents(String  paraula); ‘retorna  taula  de caràcters amb  els caràctersdiferents
		 * •int comptarLletra(String paraula, char lletra);‘retorna el número de vegades lletra dins de paraula*/
		
		exercici93 programa = new exercici93();
		programa.iniciar();
		
	}
	
	private void iniciar() {
		System.out.println("Programma per a comptar quantes lletres diferents hi han en una paraula");
		cLector teclat = new cLector();
		String paraula = teclat.llegirString("Introdueix una paraula! ('stop' per sortir): ");
		int quantesa;
		while(!(paraula.equals("stop"))) {
			if(paraula.length() == 0) {
				System.out.println("No hi ha cap caracter amic!");
			}else {
				char[] diferents = lletresDiferents(paraula);
				System.out.println("Lletres diferents que conté la paraula [" + paraula + "]: ");
				
				//Funcio per a comptar el numero de lletres diferents
				for(int i = 0; i<diferents.length;i++) {
					System.out.print(diferents[i] + " ");
					quantesa = comptarA(paraula, Character.toLowerCase(diferents[i]), Character.toUpperCase(diferents[i]));
					if(quantesa!=0) {
						System.out.println("La paraula [" + paraula + "] conté " + quantesa + " vegades la lletra " + diferents[i] + " ");
					}
				}
				System.out.println();
			}
			
			paraula = teclat.llegirString("\nIntrodueix la següent paraula! ('stop' per sortir): ");
			System.out.println();
		}
		System.out.print("Adèu!");
		
	}
	//funcio que retorna les diferents lletres de una paraula
	private char[] lletresDiferents(String  paraula){
		char[] diferents = new char[paraula.length()];
		int cont = 0;//Contador de les lletres diferents
		int j;
		boolean trobat;
		char lletra;
		//Bucle inicial per recorrer la paraula
		for(int i = 0; i<paraula.length();i++) {
			j = 0; trobat = false; lletra = paraula.charAt(i);
			while(j <= i && !trobat) {//Segon bucle per mirar si la lletra està repetida
				if(diferents[j] == lletra) {
					trobat = true;
				}
				j++;
			}
			if(!trobat) {//Si la lletra no hi és, la introduim en el vector resultant
				diferents[cont] = lletra;
				cont++;
			}
		}
		return diferents;
	}
	//Funcio per a comptar el numero de vocoals que hi ha en una paraula
	private int comptarA(String paraula, char lletra, char lletrA) {
		int cont = 0;
		for(int i = 0; i<paraula.length();i++) {
			if(paraula.charAt(i)==lletra || paraula.charAt(i)==lletrA) cont++;
		}
		return cont;
	}
}
