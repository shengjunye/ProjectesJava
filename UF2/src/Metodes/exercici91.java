package Metodes;

public class exercici91 {

	public static void main(String[] args) {
		/*91. Fer un programa on l’usuari anirà introduint paraules. 
		 * Per cada paraula se li mostrarà al usuari quantes ‘a’ hi ha a la paraula. 
		 * Cadrà desenvolupar els següents mètodes
		 * •String llegirString();
		 * •int comptarA(String paraula);
		 */

		exercici91 programa = new exercici91();
		programa.iniciar();
	}
	
	private void iniciar() {
		System.out.println("Programma per a comptar quantes A's hi han en una paraula");
		cLector teclat = new cLector();
		String paraula = teclat.llegirString("Introdueix una paraula! ('stop' per sortir): ");
		int quantesa;
		while(!(paraula.equals("stop"))) {
			if(paraula.length() <= 0) {
				System.out.println("No hi ha cap caracter amic!");
			}else {
				quantesa = comptarA(paraula);
				if(quantesa!=0) System.out.println("La paraula [" + paraula + "] conté " + quantesa + " A's");
				else System.out.println("La paraula ["+paraula+"] no contté cap A");
			}
			
			paraula = teclat.llegirString("Introdueix la següent paraula! ('stop' per sortir): ");
			System.out.println();
		}
		System.out.print("Adèu!");
		
	}
	
	private int comptarA(String paraula) {
		int cont = 0;
		for(int i = 0; i<paraula.length();i++) {
			if(paraula.charAt(i)=='A' || paraula.charAt(i)=='a') cont++;
		}
		return cont;
	}

}
