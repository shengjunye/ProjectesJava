package Projectes;

public class Jocdelavida {

	private static final int  TAMANY = 10; //TAMANY DE TAULA
	private static boolean[][] taula = new boolean[TAMANY][TAMANY];//CREACIÓ DE LA TAULA
	
    public static void main(String[] args) {
		
    	Jocdelavida programa = new Jocdelavida();
    	programa.iniciar();
  
	}
	
    private void iniciar()  {
    	System.out.println("EL JOC DE LA VIDA");
    	//joc.omplirtaula();//Omplo la taula amb tots els valors a false
    	Jocdelavida.generarcela();//Genero celes vivas aleatoriament
    	
    	for(int i = 1; i <= 50; i++) {
    		try {
				Thread.sleep(825);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.out.println("Generació: " + i);
    		Jocdelavida.imprimir();//Imprimeixo la taula
    		Jocdelavida.novaGen();//Actualitzo la taula per a veure la següent gen
    	}
    	
    	
    }
	
	private static void generarcela() {//Funció per a generar celules aleatoriament
		int sino = 0;
		for(int fila = 0; fila < taula.length;fila++) {
			for(int columna = 0; columna < taula[fila].length;columna++) {
				sino = (int) Math.floor(Math.random() * 2);
					if (sino == 0) {
						taula[fila][columna] = false;
					}
					if(sino == 1) {
						taula[fila][columna] = true;
					}
			}
		}
			
	}
	
	private static void novaGen() {//Funció per a crear la nova generació
		boolean[][] taulagen = new boolean[TAMANY][TAMANY];//taule per a guaurdar la taula anterior
		int veines;
		//Recorro totes les caselles per a veure quantes veines en tenen
		for(int fila = 0; fila < Jocdelavida.TAMANY; fila++) {
			for(int columna = 0; columna < Jocdelavida.TAMANY; columna++) {
				
				veines = Jocdelavida.quantsveins(fila, columna);//Miro quantes veines vives te AQUESTA casella
				
				if(taula[fila][columna]) {//Si la celula esta viva, mirem tots els casos (de la taula anterior)
					if(veines == 2 || veines == 3) {
						taulagen[fila][columna] = true;
					}
					else
						taulagen[fila][columna] = false;
				}
				else if(veines == 3){//Tota cel·la morta amb exactament tres veïns vius torna a la vida.
					 taulagen[fila][columna] = true;
				}
				else taulagen[fila][columna] = false;
	
			}
		}
		taula = taulagen;//Un cop acabem actualitzem la nova generació
		
	}
	private static int quantsveins(int fila, int columna) {//Funció per a veure quants veins vius en tinc cridant a altres funcions
		int count;
		if(!Jocdelavida.escentre(fila, columna)) {//Mirem si és una casella del "mig"
			count = esquines(fila,columna);//Si la casella és una esquina
			count = Jocdelavida.bordes(fila, columna);//Si la casella és un borde
		}	
		else {
			count = Jocdelavida.mig(fila, columna);//Si no és ni esquina ni borde
		}
		
		return count;
	}
	
	private static int esquines(int fila, int columna) {//Funció per a tractar les esquines
		int count = 0;
		
		if(fila == 0 && columna == 0) {//Esquina superior esquerra
            if(taula[fila][columna+1]) count++;

            if(taula[fila+1][columna]) count++;

            if(taula[fila+1][columna+1]) count++;
		}
		else if((fila == 0) && (columna == TAMANY-1)) {//Esquina superior dret
            if(taula[fila][columna-1]) count++;

            if(taula[fila+1][columna]) count++;

            if(taula[fila+1][columna-1]) count++;
		}
		else if((fila == TAMANY-1) && (columna == 0)) {//Esquina inferior esquerra
            if(taula[fila-1][columna]) count++;

            if(taula[fila][columna+1]) count++;

            if(taula[fila-1][columna+1]) count++;
		}
		else if((fila == TAMANY-1) && (columna == TAMANY-1)) {//Esquina inferior dret
            if(taula[fila][columna-1]) count++;

            if(taula[fila-1][columna]) count++;

            if(taula[fila-1][columna-1]) count++;
		}
		return count;
	}
	
	private static int bordes(int fila, int columna) {//Funció per a tractar els bordes
		int count = 0;
		if(fila == 0 && !(columna == TAMANY-1 || columna == 0)) {//Primera fila
			if(taula[fila][columna-1]) count++;
			
            if(taula[fila][columna+1]) count++;

            if(taula[fila+1][columna-1]) count++;
            
            if(taula[fila+1][columna]) count++;

            if(taula[fila+1][columna+1]) count++;
			
		}
		else if(columna == 0 && !(fila == TAMANY-1 || fila == 0)) {//Primera columna
			if(taula[fila-1][columna]) count++;
			
            if(taula[fila-1][columna+1]) count++;

            if(taula[fila][columna+1]) count++;
            
            if(taula[fila+1][columna]) count++;

            if(taula[fila+1][columna+1]) count++;
		}
		else if(fila == TAMANY-1 && !(columna == TAMANY-1 || columna == 0)) {//Ultima fila
			if(taula[fila][columna-1]) count++;
			
            if(taula[fila][columna+1]) count++;

            if(taula[fila-1][columna-1]) count++;
            
            if(taula[fila-1][columna]) count++;

            if(taula[fila-1][columna+1]) count++;
		}
		else if(columna == TAMANY-1 && !(fila == TAMANY-1 || fila == 0)) {//Ultima columna
			if(taula[fila-1][columna]) count++;
			
            if(taula[fila-1][columna-1]) count++;

            if(taula[fila][columna-1]) count++;
            
            if(taula[fila+1][columna]) count++;

            if(taula[fila+1][columna-1]) count++;
		}
		return count;
	}
	
	private static int mig(int fila, int columna) {//Funció per a comptar les veines del "mig"
		int count = 0;
		
		if(taula[fila-1][columna]) count++;
		
        if(taula[fila-1][columna-1]) count++;

        if(taula[fila][columna-1]) count++;
        
        if(taula[fila+1][columna]) count++;

        if(taula[fila+1][columna-1]) count++;
        
		if(taula[fila-1][columna+1]) count++;
		
        if(taula[fila][columna+1]) count++;

        if(taula[fila+1][columna+1]) count++;
		
		return count;
	}
	private static boolean escentre(int fila, int columna) {//Funció per a veure si és una casella del "mig"
		boolean centre = false;
		if((fila > 0 && fila < TAMANY-1) && (columna > 0 && columna < TAMANY-1)) {
			centre = true;
		}
		return centre;
	}
	/*https://foro.elhacker.net/programacion_cc/tableros-t409842.0.html*/
	//┌   ─   ┬   ┐  │  ├   ┼   ┤   └   ┴ 
	private static void imprimir() {//Metode per a imprimir la taula i/o actualitzar-la
		
		for(int i = 0; i <= taula.length; i++) {
			if(i == 0) System.out.print("┌");
			else if(i <= taula.length-1) System.out.print("───┬");
			else System.out.println("───┐");
			
		}
		
		for(int fila = 0; fila < taula.length; fila++) {
			System.out.print("│");
			
			for(int columna = 0; columna < taula[fila].length; columna++) {
				
				if(taula[fila][columna] == true) {
					System.out.print(" █ │");
				}else {
					System.out.print("   │");
				}
			}
			System.out.println();
			if(fila < taula.length-1) {
				for(int i = 0; i<=taula.length; i++) {
					if(i == 0) System.out.print("├");
					else if(i <= taula.length-1) System.out.print("───┼");
					
					
					else System.out.println("───┤");
				}
			}
		}
		
		for(int i = 0; i <= taula.length; i++) {
			if(i == 0) System.out.print("└");
			else if(i <= taula.length-1) System.out.print("───┴");
			else System.out.println("───┘");
			
		}
		
	}
}
