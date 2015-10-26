import java.util.Scanner;

public class Main {
	
	public static final int OP_LOGIN = 1;			//Opcions primer menu
	public static final int OP_REGISTER = 2;
	public static final int OP_EXIT = 3;
	
	public static final int OP_EDITOR = 1;			//Opcions segon menu
	public static final int OP_REP = 2;
	public static final int OP_PARRAP = 3;
	public static final int OP_RANK = 4;
	public static final int OP_GESTUS = 5;
	public static final int OP_EXT = 6;
	
	
	private static CtrPresUser cpu		= new CtrPresUser();
	private static CtrPresHidato cph	= new CtrPresHidato();
	private static CtrPresRanquing cpr	= new CtrPresRanquing();
	
	public static void main(String[] args) {
		Scanner input 	= new Scanner(System.in);
		cpu.setInput(input);
		boolean b = true;
		int op = 0;
		
		while(b) {
			System.out.println("\nOpciones:");
			System.out.println(OP_LOGIN + ". Entrar");
			System.out.println(OP_REGISTER + ". Registrarse");
			System.out.println(OP_EXIT + ". Salir");
			
			if (!input.hasNextInt()) {
				input.next();
				op = 0;
			}
			else op = input.nextInt();
			
			switch (op) {
			case OP_LOGIN:
				System.out.println("Hola de nuevo");
				cpu.login();
				segonMenu(input);
				
				break;
			
			case OP_REGISTER:
				System.out.println("Bienvenido");
				cpu.register();
				break;
			
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
	
	public static void segonMenu(Scanner input){
		System.out.println("\nOpciones:");
		System.out.println(OP_EDITOR + ". Editor");
		System.out.println(OP_REP + ". Repositorio");
		System.out.println(OP_PARRAP + ". Partida Rápida");
		System.out.println(OP_RANK + ". Ranking");
		System.out.println(OP_GESTUS + ". Gestionar cuenta");
		System.out.println(OP_EXT + ". Salir");
		
		
	}

}
