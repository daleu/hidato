import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class DriverRanking {
	
	private static final int OP_SCORE = 1;
	private static final int OP_SHOW = 2;
	private static final int OP_CHANGE = 3;
	private static final int OP_DEL = 4;
	private static final int OP_EXIT = 5;
	
	static void menuNewScore(Scanner input) {
		int score = 0;
		String usr;
		PairIntString pis;
		
		while(score <= 0) {
			System.out.println("Introduzca la puntuacion:");
			if(input.hasNextInt()) score = input.nextInt();
			else if(score <= 0) System.out.println("Esa no es una puntuacion valida.");
		}
		
		System.out.println("Introduzca el nombre del usuario que la ha obtenido:");
		usr = input.next();
		
		pis = new PairIntString(score, usr);
	}
	
	static void menuShowRank(Scanner input) {
		
	}
	
	static void menuChangeUsr(Scanner input) {
		
	}
	
	static void menuDeleteUsr(Scanner input) {
		
	}
	
	///////////////////////////-------------MAIN-------------///////////////////////////

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//cpu.setInput(input);
		
		boolean b = true;
		int op = 0;
		
		while(b) {
			System.out.println("\nOpciones:");
			System.out.println(OP_SCORE + ". Introducir nueva puntuacion");
			System.out.println(OP_SHOW + ". Mostrar un ranking");
			System.out.println(OP_CHANGE + ". Cambiar nombre de usuario");
			System.out.println(OP_DEL + ". Eliminar usuario");
			System.out.println(OP_EXIT + ". Salir");
			
			if (!input.hasNextInt()) {
				input.next();
				op = 0;
			}
			else op = input.nextInt();
			
			switch (op) {
			case OP_SCORE:
				menuNewScore(input);
				break;
			
			case OP_SHOW:
				menuShowRank(input);
				break;
			
			case OP_CHANGE:
				menuChangeUsr(input);
				break;
			
			case OP_DEL:
				menuDeleteUsr(input);
			
			case OP_EXIT:
				System.out.println("Cerrando...");
				input.close();
				b = false;
				break;
			
			default:
				System.out.println("Opcion incorrecta");
				break;
			}

		}
	}
}
