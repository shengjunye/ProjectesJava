package Metodes;

public class exercici91 {

	public static void main(String[] args) {
		/*91. Fer un programa on l�usuari anir� introduint paraules. 
		 * Per cada paraula se li mostrar� al usuari quantes �a� hi ha a la paraula. 
		 * Cadr� desenvolupar els seg�ents m�todes
		 * �String llegirString();
		 * �int comptarA(String paraula);
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
				if(quantesa!=0) System.out.println("La paraula [" + paraula + "] cont� " + quantesa + " A's");
				else System.out.println("La paraula ["+paraula+"] no contt� cap A");
			}
			
			paraula = teclat.llegirString("Introdueix la seg�ent paraula! ('stop' per sortir): ");
			System.out.println();
		}
		System.out.print("Ad�u!");
		
	}
	
	private int comptarA(String paraula) {
		int cont = 0;
		for(int i = 0; i<paraula.length();i++) {
			if(paraula.charAt(i)=='A' || paraula.charAt(i)=='a') cont++;
		}
		return cont;
	}

}
