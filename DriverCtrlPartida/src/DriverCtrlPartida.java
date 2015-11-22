import java.util.Scanner;

public class DriverCtrlPartida {
    
    private static final int OP_RANDOM = 1;
    private static final int OP_REPO = 3;
    private static final int OP_LOAD = 4;
    private static final int OP_PERS = 2;
    
    private static final int OP_GETTAULELL = 1;
    private static final int OP_MODVAL = 3;
    private static final int OP_GETTIME = 2;
    private static final int OP_PISTA = 4;
    private static final int OP_GUARDPAR = 5;
    
    
    private static final int PEN_POS = 1;
    private static final int PEN_VISUAL = 2;
    private static final int PEN_NOMBRE = 3;
    
    private static CtrlPartida p;
    private static String usr;
    
    static void menuRandom(Scanner input, int op) {
        p = new CtrlPartida(usr, op, 0, 0, 0, null);
    }
    
    static void menuRepo(Scanner input, int op) {
    	System.out.println("Introduce el id del tablero a cargar");
    	String id = input.next();
    	
    	p = new CtrlPartida(usr, op, 0, 0, 0, id);
    }
    
    static void menuLoad(Scanner input, int op) {
    	System.out.println("Introduce el id del tablero a cargar");
    	String id = input.next();
    	p = new CtrlPartida(usr, op, 0, 0, 0, id);
    }
        
    static void menuPartidaRandomPers(Scanner input, int op) {
    	System.out.println("Introduce el número de agujeros deseados");
    	int agujeros = input.nextInt();
    	System.out.println("Introduce el tamaño deseado");
    	int tam = input.nextInt();
    	System.out.println("Introduce el número de números fijos");
    	int fijos = input.nextInt();
    	p = new CtrlPartida(usr,op,agujeros,tam,fijos,null);
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
    
    static void guardar(Scanner input){
    	System.out.println("Introdueixi el nom en que vols que es guardi la partida:");
    	String id = input.next();
        boolean a = p.guardarPartida(id);
        if (!a){
        	System.out.println("Aquest nom ja existeix");
        	guardar(input);
        }
        else System.out.println("La partida s'ha guardat correctament");
    }
    
    static boolean modVal(Scanner input){
    	System.out.println("Introdueixi la fila:");
    	int fila = input.nextInt();
    	System.out.println("Introdueixi la columna:");
    	int columna = input.nextInt();
    	System.out.println("Introdueixi el valor (si vols esborrar el valor de la posicio introdueixi un 0:");
    	int valor = input.nextInt();	
    	boolean[] aux=p.modificarCas(fila, columna, valor);
    	if (aux[0] = true){
    		System.out.println("El valor s'ha modificat correctament");
    		System.out.println("El valor es " + valor);
    		if (aux[1]==true){
    			System.out.println("Partida finalitzada");
    			System.out.println("Guardant ranking...");
    			CtrlRanking au = new CtrlRanking();
    			p.guardarRanking(au);
    			return false;
    		}
    		else return true;
    	}
    	else{
			System.out.println("La posicio que ha intentat modificar, no es pot modificar");
			return modVal(input);
    	}
    }
    
    static void pista(Scanner input){
    	System.out.println("\nOpciones:");
    	System.out.println(PEN_POS + ". Comprova si les caselles proposades estan en una posicio correcta");
        System.out.println(PEN_VISUAL + ". Visualitzar nombre nou");
        System.out.println(PEN_NOMBRE + ". Visualitzar un nombre concret dels que l'usuari ha demanat");
        
        int op=0;
        
        if (!input.hasNextInt()) {
            input.next();
            op = 0;
        }
        else op = input.nextInt();
        
        switch (op) {
        case PEN_POS:
            System.out.println("La solucio que estem proposant va per bon cami");
            break;
        
        case PEN_VISUAL:
            menuRepo(input, op);
            break;
        
        case PEN_NOMBRE:
            menuLoad(input, op);
            break;
            
        default:
            System.out.println("Opcion incorrecta");
            break;
        }
    }
    
    ///////////////////////////-------------MAIN-------------///////////////////////////
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Introdueix el nom d'usuari:");
        usr = input.next();
        int op = 0;
   
        System.out.println("\nOpciones:");
        System.out.println(OP_RANDOM + ". Crear partida aleatoria");
        System.out.println(OP_PERS + ". Crear partida aleatoria con parámetros personalizados");
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
            System.out.println(OP_PISTA + ". Demanar Pista");
            System.out.println(OP_GUARDPAR + ". Guardar Partida");
            
            if (!input.hasNextInt()) {
                input.next();
                op = 0;
            }
            else op = input.nextInt();
            
            switch (op) {
            case OP_GETTAULELL:
                int[][] aux = p.mostrarTaulell();
                printBoard(aux);
                break;
            
            case OP_GETTIME:
                int au = p.getTime();
                System.out.println("El nostre temps es: " + au + " s");
                break;
            
            case OP_MODVAL:
                b=modVal(input);
                break;
                
            case OP_PISTA:
            	pista(input);
            	break;
            
            case OP_GUARDPAR:
            	guardar(input);
            	b=false;
                break;
                
            default:
                System.out.println("Opcion incorrecta");
                break;
            }
        }
    }
}