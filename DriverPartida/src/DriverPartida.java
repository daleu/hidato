import java.util.Scanner;

public class DriverPartida {
    
    private static final int OP_RANDOM = 1;
    private static final int OP_REPO = 3;
    private static final int OP_LOAD = 4;
    private static final int OP_PERS = 2;
    
    private static final int OP_GETTAULELL = 1;
    private static final int OP_MODVAL = 3;
    private static final int OP_GETTIME = 2;
    
    private static Partida p;
    
    static void menuRandom(Scanner input, int op) {
        p = new Partida();
    }
    
    static void menuRepo(Scanner input, int op) {
    	Partida aux = new Partida();
    	TaulellHidato au = aux.getTaulell();
    	p = new Partida(au);
    }
    
    static void menuLoad(Scanner input, int op) {
    	Partida aux = new Partida();
    	p = new Partida(aux);
    }
        
    static void menuPartidaRandomPers(Scanner input, int op) {
    	System.out.println("Introduce el n�mero de agujeros deseados");
    	int agujeros = input.nextInt();
    	System.out.println("Introduce el tama�o deseado");
    	int tam = input.nextInt();
    	System.out.println("Introduce el n�mero de n�meros fijos");
    	int fijos = input.nextInt();
    	p = new Partida(agujeros,tam,fijos);
    }
    
    private static void printBoard(int[][] matriu) {
        for (int[] row : matriu) {
            for (int c : row) {
                if (c == -1)
                    System.out.print("  . ");
                else
                    System.out.printf(c > 0 ? "%3d " : "___ ", c);
            }
            System.out.println();
        }
    }
    
    static boolean modVal(Scanner input){
    	System.out.println("Introdueixi la fila:");
    	int fila = input.nextInt();
    	System.out.println("Introdueixi la columna:");
    	int columna = input.nextInt();
    	System.out.println("Introdueixi el valor (si vols esborrar el valor de la posicio introdueixi un 0:");
    	int valor = input.nextInt();	
    	boolean[] aux=p.modCas(fila, columna, valor);
    	if (aux[0] = true){
    		System.out.println("El valor s'ha modificat correctament");
    		if (aux[1]==true){
    			System.out.println("Partida finalitzada");
    			System.out.println("Guardant ranking...");
    			p.setScore();
    			return false;
    		}
    		else return true;
    	}
    	else{
			System.out.println("La posicio que ha intentat modificar, no es pot modificar");
			return modVal(input);
    	}
    }
    
    ///////////////////////////-------------MAIN-------------///////////////////////////
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int op = 0;
   
        System.out.println("\nOpciones:");
        System.out.println(OP_RANDOM + ". Crear partida aleatoria");
        System.out.println(OP_PERS + ". Crear partida aleatoria con par�metros personalizados");
        System.out.println(OP_REPO + ". Cargar una partida del repositorio");
        System.out.println(OP_LOAD + ". Cargar partida empezada");
        
            
        if (!input.hasNextInt()) {
            input.next();
            op = 0;
        }
        else op = input.nextInt();
        
        switch (op) {
        case OP_RANDOM:
            menuRandom(input, op);
            break;
        
        case OP_REPO:
            menuRepo(input, op);
            break;
        
        case OP_LOAD:
            menuLoad(input, op);
            break;
        
        case OP_PERS:
            menuPartidaRandomPers(input, op);
            break;
            
        default:
            System.out.println("Opcion incorrecta");
            break;
             
        }
        boolean b = true;
        while(b){
        	System.out.println("\nOpciones:");
            System.out.println(OP_GETTAULELL + ". Mostrar el Taulell");
            System.out.println(OP_GETTIME + ". Mostar Temps");
            System.out.println(OP_MODVAL + ". Modificar Valor");
            
            if (!input.hasNextInt()) {
                input.next();
                op = 0;
            }
            else op = input.nextInt();
            
            switch (op) {
            case OP_GETTAULELL:
                int[][] aux = p.getTauActual();
                printBoard(aux);
                break;
            
            case OP_GETTIME:
                int au = p.getTime();
                System.out.println("El nostre temps es: " + au + " s");
                break;
            
            case OP_MODVAL:
                b=modVal(input);
                break;
                
            default:
                System.out.println("Opcion incorrecta");
                break;
            }
        }
        System.out.println("Hem fet " + p.getScore() + " punts");
    }
}