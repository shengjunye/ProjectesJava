package Projectes;

import Metodes.cLector;

public class JocVaixells {
	private static final int TAMANY = 7;//mida de la taula
	
	public static void main(String[] args) {
		/*95.Joc dels vaixells simpleCaldrà desenvolupar un joc del vaixells amb les següents premisses.
		 * •Es juga en un taulell de 5x5
		 * •Jugaran dos jugadors
		 * •Cada  jugador  col·locarà  en  el  taulell  els  seus  5  vaixells,  vaixells  d’una  sola  posició, vigilant que dos vaixells no es poden tocar.
		 * •Alternativament  cada  jugador  anirà  disparant  i  el  programa  haurà  de  dir  si  es  aigua  o tocat i enfonsat.
		 * Abans de disparar caldrà mostrar en pantalla l’estat del taulell mostrant de  manera  diferent  les  caselles  on  encara  no  s’ha  disparat,  
		 * les  que  s’ha  disparat  i  s’ha fallat i les que s’ha disparat i s’ha enfonsat un vaixell.
		 * •El joc finalitza quan un jugador enfosa tots els vaixells de l’altre jugador.*/

		JocVaixells programa = new JocVaixells();
		programa.iniciar();
	}

	private void iniciar() {
		int[][] taula1 = new int[TAMANY][TAMANY]; //taula1
		int[][] taula2 = new int[TAMANY][TAMANY]; //taula2
		cLector teclat = new cLector();
		System.out.println("Joc Vaixells simple");
		
		JocVaixells.generarcela(taula1);//Omplo la primera taula
		JocVaixells.generarcela(taula2);//Omplo la segona taula
		
		for(int i = 0; i < 5; i++) {//Omplim el taulell del primer jugador
			JocVaixells.omplirvaixell(taula1);
		}
		for(int i = 0; i < 5; i++) {//Omplim el taulell del segon jugador
			JocVaixells.omplirvaixell(taula2);
		}
		
		int fila, columna;
		while(!(JocVaixells.jocacabat(taula1))||(JocVaixells.jocacabat(taula2))) {//Mentre que cap dels taulells tingui tots els vaixel, escontinua jugant
			
			System.out.println("Jugador 1. Quina casella vols disparar? [1-5]");//Demanem al jugador 1 quina casella vol disparar
			System.out.println("Taulell jugador 2");
			JocVaixells.imprimir(taula2);//Imprimeixo la taula del jugador2
			fila = teclat.llegirEnter("Introdueix la fila que vols disparar: ");
			columna = teclat.llegirEnter("Introdueix la columna que vols disparar: ");
			
			while((columna > 5 || columna < 1) || (fila > 5 || fila < 1)) {//Els valors han d'estar dins del rang de [1-5]
				System.out.println("Un dels valors introduits no està dins del rang permés.");
				fila = teclat.llegirEnter("Torna a introduir la fila: ");
				columna = teclat.llegirEnter("Torna a introduir la columna: ");
			}
			JocVaixells.disparar(taula2, fila, columna);//Disparem i seguidament actualitzem la taula
			System.out.println("Taulell jugador 2 despres de disparar");
			JocVaixells.imprimir(taula2);//Imprimeixo la taula del jugador2
			
			System.out.println("Jugador 2. Quina casella vols disparar? [1-5]");//Demanem al jugador 2 quina casella vol disparar
			System.out.println("Taulell jugador 1");
			JocVaixells.imprimir(taula1);//Imprimeixo la taula del jugador1
			fila = teclat.llegirEnter("Introdueix la fila que vols disparar: ");
			columna = teclat.llegirEnter("Introdueix la columna que vols disparar: ");
			
			while((columna > 5 || columna < 1) || (fila > 5 || fila < 1)) {//Els valors han d'estar dins del rang de [1-5]
				System.out.println("Un dels valors introduits no està dins del rang permés.");
				fila = teclat.llegirEnter("Torna a introduir la fila: ");
				columna = teclat.llegirEnter("Torna a introduir la columna: ");
			}
			JocVaixells.disparar(taula1, fila, columna);//Si la posició és correcta, procedim a disparar i seguidament actualitzem la taula
			System.out.println("Taulell jugador 1");
			JocVaixells.imprimir(taula1);//Imprimeixo la taula del jugador1
		}
		
	}
	
	private static void omplirvaixell(int[][] taula) {//Funcio per a omplir 5 vaixells en el taulell
		
	}
	
	private static void disparar(int[][] taula,int fila, int columna) {//Joc pirncipal per enfonsar
		if(taula[fila][columna] == 0 ) taula[fila][columna] = 2; //0 aigua - 2 aigua fallida
		else if(taula[fila][columna] == 1) taula[fila][columna] = 3;//1 vaixell - 3 vaixell tocat i enfonsat
		else System.out.println("Inútil ja havies disparat en aquesta casella.");//Si la casella ja s'havia disparat no farà res
	}
	
	private static void generarcela(int[][] taula) {//Funció per a omplir les caselles amb aigua 
		for(int fila = 0; fila < TAMANY;fila++) {
			for(int columna = 0; columna < TAMANY;columna++) {	
				taula[fila][columna] = 0;	
			}
		}
			
	}
	private static boolean jocacabat(int[][] taula) {//Funcio per a veure si tots els vaixells estàn enfonsats
		boolean acabat = false;
		int vius = 5;//Variable per a veure els vaixells vius
		for(int fila = 1; fila < taula.length-1; fila++) {
			for(int columna = 1; columna < taula[fila].length-1; columna++) {
				if(taula[fila][columna] == 1) vius--;
			}
		}
		if(vius == 0) acabat = true;//Si el taulell no te cap vaixell viu, el joc s'acaba
			
		return acabat;
	}
	private static boolean buscarveins(int[][] taula, int fila, int columna) {//Funció per mirar si el vaixell que 
		//col·loques té un vaixell vei.
			
			boolean vei = false;//Variable per a vere si té algun vei o no
			for(int i = fila-1; i < fila+1 && !vei; i++) {
				for(int j = columna-1; j < columna+1 && !vei; j++) {
					
					if(taula[fila][columna] == 1) vei = true;
		
				}
			}
			return vei;
		}
	
	private static void imprimir(int[][] taula) {//Metode per a imprimir la taula i/o actualitzar-la
		
		for(int i = 1; i <= taula.length-1; i++) {
			if(i == 1) System.out.print("┌");
			else if(i <= taula.length-2) System.out.print("───┬");
			else System.out.println("───┐");
			
		}
		
		for(int fila = 1; fila < taula.length-1; fila++) {
			System.out.print("│");
			
			for(int columna = 1; columna < taula[fila].length-1; columna++) {
				
				if(taula[fila][columna] == 0) {//Aigua
					System.out.print("   │");
				}else if(taula[fila][columna] == 1){//Vaixell viu
					System.out.print(" █ │");
				}else if(taula[fila][columna] == 2) {//Aigua fallo
					System.out.print(" ░ │");
				}else if(taula[fila][columna] == 3) {//Vaixell tocat
					System.out.print(" * │");
				}
			}
			System.out.println();
			if(fila < taula.length-2) {
				for(int i = 1; i<=taula.length-1; i++) {
					if(i == 1) System.out.print("├");
					else if(i <= taula.length-2) System.out.print("───┼");
					
					
					else System.out.println("───┤");
				}
			}
		}
		
		for(int i = 1; i <= taula.length-1; i++) {
			if(i == 1) System.out.print("└");
			else if(i <= taula.length-2) System.out.print("───┴");
			else System.out.println("───┘");
			
		}
		
	}
}
