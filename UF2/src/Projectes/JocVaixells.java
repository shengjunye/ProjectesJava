package Projectes;

import javax.xml.ws.handler.MessageContext.Scope;

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
		System.out.println("Joc Vaixells simple");
		
		JocVaixells.generarcela(taula1);//Omplo la primera taula
		JocVaixells.generarcela(taula2);//Omplo la segona taula
		
		
		
		System.out.println("Taulell jugador 1:");
		JocVaixells.imprimir(taula1);//Imprimeixo les taules
		System.out.println("Taulell jugador 2:");
		JocVaixells.imprimir(taula2);//Imprimeixo les taules
		
		
	}
	
	private static void omplirvaixell(int[][] taula) {//Funcio per a omplir 5 vaixells en el taulell
		
	}
	
	private static void generarcela(int[][] taula) {//Funció per a omplir les caselles amb aigua 
		for(int fila = 0; fila < TAMANY;fila++) {
			for(int columna = 0; columna < TAMANY;columna++) {	
				taula[fila][columna] = 0;	
			}
		}
			
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
				}else if(taula[fila][columna] == 1){//Vaixell
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
