import java.util.Scanner;

public class DriverPartida {
    
    private static final int OP_RANDOM = 1;
    private static final int OP_REPO = 2;
    private static final int OP_LOAD = 3;
    private static final int OP_PERS = 4;
    private static final int OP_SETSCORE = 5;
    private static final int OP_GETSCORE = 6;
    private static final int OP_GETTIME = 7;
    private static final int OP_EXIT = 8;
    
    private static final int PEN_POS = 10;
    private static final int PEN_VISUAL = 11;
    private static final int PEN_NOMBRE = 12;
    
    private static Partida p;
    
    static void menuRandom(Scanner input) {
        Partida p = new Partida();
    }
    
    static void menuRepo(Scanner input) {
    	System.out.println("Introduce el id del tablero a cargar");
    	int x = input.nextInt();
    	
    	Partida p = new Partida(t);
    }
    
    static void menuLoad(Scanner input) {
    	System.out.println("Introduce el id del tablero a cargar");
    	p.Partida(input.nextInt());
    }
        
    static void menuPartidaRandomPers(Scanner input) {
    	System.out.println("Introduce el número de agujeros deseados");
    	int agujeros = input.nextInt();
    	System.out.println("Introduce el tamaño deseado");
    	int tam = input.nextInt();
    	System.out.println("Introduce el número de números fijos");
    	int fijos = input.nextInt();
    	p.Partida(agujeros,tam,fijos);
    }
    
    static void menuSetScore(Scanner input){
    	System.out.println("Introduce la nueva puntuaciÃ³n");
    	p.setScore(input.nextInt());
    }
    
    static void menuPenalitzacio(Scanner input){
    	System.out.println("Introduce la pista");
    	int pen = input.nextInt();
    	if(pen == PEN_POS ||
    }
    
    static void menuGetScore(Scanner input){
    	p.getScore();
    }

    static void menuGetTime(Scanner input){
    	p.getTime();
    }
    
    ///////////////////////////-------------MAIN-------------///////////////////////////

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //cpu.setInput(input);
        
        boolean b = true;
        int op = 0;
        
        while(b) {
            System.out.println("\nOpciones:");
            System.out.println(OP_RANDOM + ". Crear partida aleatoria");
            System.out.println(OP_REPO + ". Cargar una partida del repositorio");
            System.out.println(OP_LOAD + ". Cargar partida empezada");
            System.out.println(OP_PERS + ". Crear partida aleatoria con parámetros personalizados");
            System.out.println(OP_SETSCORE + ". Modificar puntuaciÃ³n de la partida");
            System.out.println(OP_GETSCORE + ". Obtener puntuaciÃ³n de la partida");
            System.out.println(OP_GETTIME + ". Obtener tiempo de la partida");
            System.out.println(OP_EXIT + ". Salir");
            
            if (!input.hasNextInt()) {
                input.next();
                op = 0;
            }
            else op = input.nextInt();
            
            switch (op) {
            case OP_RANDOM:
                menuRandom(input);
                break;
            
            case OP_REPO:
                menuRepo(input);
                break;
            
            case OP_LOAD:
                menuLoad(input);
                break;
            
            case OP_PERS:
                menuPartidaRandomPers(input);
                break;
                
            case OP_SETSCORE:
                menuSetScore(input);
                break;
                
            case OP_GETSCORE:
                menuGetScore(input);
                break;

            case OP_GETTIME:
                menuGetTime(input);
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
}