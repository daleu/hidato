import java.util.Scanner;
import hidato.PartidaDom;

public class CtrPresHidato {
	
	private Scanner input;
	private PartidaDom partida;
	
	public static final int OP_DEFECT = 1;
	public static final int OP_PERSON = 2;
	public static final int OP_MENUANT = 3;
	
	public static final int OP_QUAD = 1;
	public static final int OP_RECT = 2;
	public static final int OP_TRI	= 3;
	
	public CtrPresHidato() {
		
	}
	
	public void setInput(Scanner input) {
		this.input = input;
	}

	public void editor(){
		
	}
	
	public void repositorio(){
		
	}
	
	public void partidaRapida(){
		System.out.println("Partida Rápida: Elige una de las siguientes configuraciones:");
		System.out.println(OP_DEFECT + ". Conficuración por defecto");
		System.out.println(OP_PERSON + ". Conficuración Personalizada");
		System.out.println(OP_MENUANT + ". Salir al menu principal");
		
		int op = input.nextInt();
		
		switch (op){
		case OP_DEFECT:
			System.out.println("Configuración por defecto");
			break;
		
		case OP_PERSON:
			System.out.println("Configuración Personalizada");
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
	
	private void configPers(){
		PartidaDom partida = new PartidaDom();
		
		System.out.println("Ha continuación introduzca los siguientes parametros:");
		System.out.println("Forma del tablero:");
		System.out.println(OP_QUAD + ". Quadrado");
		System.out.println(OP_RECT + ". Rectangulo");
		System.out.println(OP_TRI + ". Triangulo");
		int forma = input.nextInt();
		
		System.out.println("Número de casillas");
		int numCas = input.nextInt();
		
		System.out.println("Número de numeros colocados");
		int numCol = input.nextInt();
		
		System.out.println("Número de agujeros");
		int agujeros = input.nextInt();
		
		partida.crearPartPers(forma, numCas, numCol, agujeros);
	}

}
