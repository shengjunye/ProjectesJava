package Metodes;

import java.util.Scanner;

public class cLector {

		public int llegirEnter(){
			
			Scanner lector = new Scanner(System.in);
			int correcte = 0;
			
			while (!lector.hasNextInt()){
					lector.next();
					System.out.print("No es un enter. Introdueix un altre numero: ");
			}
			correcte=lector.nextInt();
			lector.nextLine();
			return correcte;
		}
		
		public int llegirEnter (String missatge){
			System.out.print(missatge);
			return llegirEnter();
		}
		
		public String llegirString (){
			String frase = "";
			Scanner lector = new Scanner(System.in);
			
			frase=lector.nextLine();
			return frase;
		}		

		public String llegirString (String missatge){
			System.out.print(missatge);
			return llegirString();
		}
		
}
