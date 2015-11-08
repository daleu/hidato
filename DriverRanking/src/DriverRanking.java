import java.util.Scanner;

public class DriverRanking {
    
    private static final int OP_SCORE = 1;
    private static final int OP_SHOW = 2;
    private static final int OP_CHANGE = 3;
    private static final int OP_DEL = 4;
    private static final int OP_POS = 5;
    private static final int OP_GETSCORE = 6;
    private static final int OP_EXIT = 7;
    
    private static Ranking r;
    
    static void menuNewScore(Scanner input) {
        int score = 0;
        int dif = 0;
        String usr;
        
        while(score <= 0) {
            System.out.println("1 - Introduzca la puntuacion:");
            if(input.hasNextInt()) score = input.nextInt();
            if(score < 0) System.out.println("1 - Esa no es una puntuacion valida.");
        }
        
        System.out.println("1 - Introduzca el nombre del usuario que la ha obtenido:");
        usr = input.next();
        while(dif < 1 || dif > 3) {
            System.out.println("1 - Introduzca la dificultad:");
            if(input.hasNextInt()) dif = input.nextInt();
            if(dif < 1 || dif > 3) System.out.println("1 - Esa no es una dificultad valida.");
        }
        
        r.addNewRanking(dif, score, usr);
    }
    
    static void menuShowRank(Scanner input) {
        System.out.println("2 - Que ranking quieres ver?");
        System.out.println("1. Facil");
        System.out.println("2. Normal");
        System.out.println("3. Dificil");
        int rankget = input.nextInt();
        if (rankget < 1 || rankget > 3){
         System.out.println("2 - Introduce una cifra valida");
         menuShowRank(input);
        }
        else r.getRank(rankget);
    }
    
    static void menuChangeUsr(Scanner input) {
         System.out.println("3 - Introduce su nombre de usuario:");
         String usr1=input.next();
         
         System.out.println("3 - Introduce su nuevo nombre de usuario: ");
         String usr2=input.next();
         
         r.modifyUsername(usr1, usr2);
    }
        
    static void menuDeleteUsr(Scanner input) {
        System.out.println("4 - Introduce su nombre de usuario:");
        String usr=input.next();
        r.deleteUserRanking(usr);
    }
    
    static void menuPos(Scanner input){
        System.out.println("5 - Selecciona la dificultad");
        System.out.println("1. Facil");
        System.out.println("2. Normal");
        System.out.println("3. Dificil");
        int posdif = input.nextInt();
        if (posdif < 1 || posdif > 3){
         System.out.println("Introduce una cifra valida");
         menuPos(input);
        }
        System.out.println("5 - Introduce un usuario");
        String usr = input.next();
        r.getPos(usr,posdif);
    }
    
    static void menuGetScore(Scanner input){
        System.out.println("6 - Selecciona la dificultad");
        System.out.println("1. Facil");
        System.out.println("2. Normal");
        System.out.println("3. Dificil");
        int scoredif = input.nextInt();
        if (scoredif < 1 || scoredif > 3){
         System.out.println("6 - Introduce una cifra valida");
         menuGetScore(input);
        }
        System.out.println("6 - Introduce un usuario");
        String usr = input.next();
        r.getScore(usr,scoredif);
    }
    
    ///////////////////////////-------------MAIN-------------///////////////////////////

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        r = new Ranking();
        
        //cpu.setInput(input);
        
        boolean b = true;
        int op = 0;
        
        while(b) {
            System.out.println("\nOpciones:");
            System.out.println(OP_SCORE + ". Introducir nueva puntuacion");
            System.out.println(OP_SHOW + ". Mostrar un ranking");
            System.out.println(OP_CHANGE + ". Cambiar nombre de usuario");
            System.out.println(OP_DEL + ". Eliminar usuario");
            System.out.println(OP_POS + ". Mostrar las posiciones de un usuario");
            System.out.println(OP_GETSCORE + ". Mostrar las puntuaciones de un usuario");
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
                break;
                
            case OP_POS:
                menuPos(input);
                break;
                
            case OP_GETSCORE:
                menuGetScore(input);
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