package Projectes;

import java.io.IOException;

public class Simon {
	private static final String[] COLORS = {"VERMELL","BLAU","GROC","VERD"};//Magatzem dels colors
	
	public static void main(String[] args) throws IOException{
		/*96. Joc del Sim�n dice.
		 * La din�mica del joc �s la seg�ent:
		 * 1.L�ordinador  es triar�  aleat�riament  un  color  entre  els  4  colors  VERMELL �BLAU �GROC -VERD
		 * 2.Aquest color es posar� a la cua de colors inventats per l�ordinador.
		 * 3.L�ordinador mostrar� en pantalla tota la cua de colors durant INTERVAL segons.
		 * 4.Es neteja la pantalla.
		 * 5.L�usuari ha de dir tots els colors de la cua en el mateix ordre.
		 * 6.En el moment que s�equivoqui amb un color el joc acava mostrant la puntuaci�.
		 * 7.Si els encerta tots s�incrementa un punt a la puntuaci� i es torna al punt 1.
		 * 
		 * Al comen�ar una partida es demanar� en quin nivell es vol jugar.
		 * �Nivell b�sic: INTERVAL a 5 segons
		 * �Nivell intermig: INTERVAL a 3 segons
		 * �Nivell pro: INTERVAL a 1 segon*/
		Simon programa = new Simon();
		programa.iniciar();
	}
	
	private void iniciar(){
		String[] cua = new String[99];//Magatzem del joc inicial
		
	}
	
	private static void generarcela(int[][] taula) {//Funci� per a omplir els colors
		for(int fila = 0; fila < TAMANY;fila++) {
			for(int columna = 0; columna < TAMANY;columna++) {	
				taula[fila][columna] = 0;	
			}
		}
			
	}
}
