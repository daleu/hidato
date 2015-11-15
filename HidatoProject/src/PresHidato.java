import java.util.Scanner;

import hidato.CtrlPartida;

public class PresHidato {
	
	private Scanner input;
	private CtrlPartida cp;
	
	//Opcions de Partida Rapida
	public static final int OP_DEFECT = 1;
	public static final int OP_PERSON = 2;
	public static final int OP_MENUANT = 3;
	
	//Opcions de forma de taulell
	public static final int OP_QUAD = 1;
	public static final int OP_RECT = 2;
	public static final int OP_TRI	= 3;
	
	/*Constructor*/
	public PresHidato() {
		
	}
	
	/*Modificadores|voids*/
	public void setInput(Scanner input) {
		this.input = input;
	}
	
	//Editor
	public void editor(){
		
	}
	
	//Repositori
	public void repositorio(){
		
	}
	
	//Partida Rapida
	public void partidaRapida(){
		System.out.println("Partida R�pida: Elige una de las siguientes configuraciones:");
		System.out.println(OP_DEFECT + ". Conficuraci�n por defecto");
		System.out.println(OP_PERSON + ". Conficuraci�n Personalizada");
		System.out.println(OP_MENUANT + ". Salir al menu principal");
		
		int op = input.nextInt();
		
		switch (op){
		case OP_DEFECT:
			System.out.println("Configuraci�n por defecto");
			break;
		
		case OP_PERSON:
			System.out.println("Configuraci�n Personalizada");
			configPers();
			break;
		
		case OP_MENUANT:
			System.out.println("Volviendo al menu de inicio...");
			break;
		
		default:
			System.out.println("Opcion incorrecta");
			break;
		}
	}
	
	//Partida Rapida -> configuracio personalitzada
	private void configPers(){
		
		System.out.println("Ha continuaci�n introduzca los siguientes parametros:");
		System.out.println("Forma del tablero:");
		System.out.println(OP_QUAD + ". Quadrado");
		System.out.println(OP_RECT + ". Rectangulo");
		System.out.println(OP_TRI + ". Triangulo");
		int forma = input.nextInt();
		
		System.out.println("N�mero de casillas");
		int numCas = input.nextInt();
		
		System.out.println("N�mero de numeros colocados");
		int numCol = input.nextInt();
		
		System.out.println("N�mero de agujeros");
		int agujeros = input.nextInt();
		
	}
	
	//Partida Rapida -> configuracio defecte
	private void configDef(){
		
	}

}