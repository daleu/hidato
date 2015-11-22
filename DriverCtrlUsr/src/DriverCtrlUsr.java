import java.util.Scanner;

public class DriverCtrlUsr {
    
    private static final int OP_ANADU = 1;
    private static final int OP_LOGU = 2;
    private static final int OP_MODU = 3;
    private static final int OP_MODC = 4;
    private static final int OP_EXIT = 5;
    
    private static CtrlUsr cu;
    
    private static void añadUsuario(Scanner input) {
    	System.out.println("Escriu el nom d'usuari");
    	String usr1=input.next();
    	System.out.println("Escriu la contrasenya");
    	String usr2=input.next();
    	cu.afegirUsuari(usr1, usr2);
    }
    
    private static void logUsr(Scanner input) {
    	System.out.println("Escriu el nom d'usuari");
    	String usr1=input.next();
    	System.out.println("Escriu la contrasenya");
    	String usr2=input.next();
    	cu.logUsuari(usr1, usr2);
    }
    
    private static void modificarUsr(Scanner input) {
    	System.out.println("Escriu el nom d'usuari actual");
    	String usr1=input.next();
    	System.out.println("Escriu el nom d'usuari nou");
    	String usr2=input.next();
    	cu.modUsr(usr1,usr2);
    }
    
    private static void modificarPass (Scanner input) {
    	System.out.println("Escriu la contrasenya actual");
    	String pass1=input.next();
    	System.out.println("Escriu la nova contrasenya");
    	String pass2=input.next();
    	cu.modPass(pass1, pass2);
    }
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean b = true;
        int op = 0;
        
        cu = new CtrlUsr();
        
        while(b) {
            System.out.println("\nOpciones:");
            System.out.println(OP_ANADU + ". Añadir usuario");
            System.out.println(OP_LOGU + ". Loguear Usuario");
            System.out.println(OP_MODU+ ". Modificar usuario");
            System.out.println(OP_MODC + ". Modificar contraseña");
            System.out.println(OP_EXIT + ". Salir");
    
            if (!input.hasNextInt()) {
                input.next();
                op = 0;
            }
            else op = input.nextInt();
            
            switch (op) {
            case OP_ANADU:
            	añadUsuario(input);
                break;
            
            case OP_LOGU:
            	logUsr(input);
                break;
            
            case OP_MODU:
                modificarUsr(input);
                break;
                
            case OP_MODC:
                modificarPass(input);
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
    

