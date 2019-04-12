package Metodes;

public class exercici92 {

	public static void main(String[] args) {
		/*92. Igual  que  l’anterior  però  caldrà  dir  quantes  ‘a’,  ‘e’,  ‘i’,  ‘o’,  ‘u’  per  separat  hi  ha  a  la  paraula. 
		 * Caldrà desenvolupar els següents mètodes
		 * •String llegirString();
		 * •int comptarLletra(String paraula, char lletra); ‘retorna el número de vegades lletra dins de paraula*/

		exercici92 programa = new exercici92();
		programa.iniciar();
	}
	private void iniciar() {
		System.out.println("Programma per a comptar quantes a,e,i,o,u hi han en una paraula");
		cLector teclat = new cLector();
		String paraula = teclat.llegirString("Introdueix una paraula! ('stop' per sortir): ");
		int quantesa;
		while(!(paraula.equals("stop"))) {
			if(paraula.length() <= 0) {
				System.out.println("No hi ha cap caracter amic!");
			}else {
				quantesa = comptarA(paraula, 'a', 'A');
				if(quantesa!=0) {
					System.out.println("La paraula [" + paraula + "] conté " + quantesa + " A's");
				}
				else System.out.println("La paraula ["+paraula+"] no conté cap A");
				
				quantesa = comptarA(paraula, 'e', 'E');
				if(quantesa!=0) {
					System.out.println("La paraula [" + paraula + "] conté " + quantesa + " E's");
				}
				else System.out.println("La paraula ["+paraula+"] no conté cap E");
				
				quantesa = comptarA(paraula, 'o', 'O');
				if(quantesa!=0) {
					System.out.println("La paraula [" + paraula + "] conté " + quantesa + " O's");
				}
				else System.out.println("La paraula ["+paraula+"] no conté cap O");
				
				quantesa = comptarA(paraula, 'i', 'I');
				if(quantesa!=0) {
					System.out.println("La paraula [" + paraula + "] conté " + quantesa + " I's");
				}
				else System.out.println("La paraula ["+paraula+"] no conté cap I");
				
				quantesa = comptarA(paraula, 'u', 'U');
				if(quantesa!=0) {
					System.out.println("La paraula [" + paraula + "] conté " + quantesa + " U's");
				}
				else System.out.println("La paraula ["+paraula+"] no conté cap U");
				
				
				paraula = teclat.llegirString("Introdueix la següent paraula! ('stop' per sortir): ");
				System.out.println();
			}
			
		}
		System.out.print("Adèu!");
		
	}
	//Funcio epr a comptar quantes vocals hi ha en una paraula
	private int comptarA(String paraula, char lletra, char lletrA) {
		int cont = 0;
		for(int i = 0; i<paraula.length();i++) {
			if(paraula.charAt(i)==lletra || paraula.charAt(i)==lletrA) cont++;
		}
		return cont;
	}
}
