import java.util.Scanner;

public class DriverUsr {
    
    private static final int OP_MODU = 1;
    private static final int OP_MODP = 3;
    private static final int OP_CONSULTARU = 4;
    private static final int OP_CONSULTARP = 5;
    private static final int OP_EXIT = 6;
    
   private static String uu = "username";
   private static String p = "pass";
   private static Usuario u = new Usuario(uu,p);
    
    
    private static void menuModUsuari(Scanner input) {
    	System.out.println("Escriu el nom d'usuari");
    	String usr1=input.next();
    	u.setUsr(usr1);
    }
    
    private static void menuModPass(Scanner input) {
    	System.out.println("Escriu la contrasenya");
    	String usr2=input.next();
        u.setUsr(usr2);
    }
    
    private static void menuConsultarUsr(Scanner input) {
    	String usrn2 = u.getUsr();
    	System.out.println("L'usuari es: " + usrn2 );
    }
    
    private static void menuConsultarPass (Scanner input) {
    	String usrn3 = u.getPass();
    	System.out.println("La contrasenya es: " + usrn3 );
    	
    }
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean b = true;
        int op = 0;
        
        while(b) {
            System.out.println("\nOpciones:");
            System.out.println(OP_MODU + ". Modificar usuario");
            System.out.println(OP_MODP + ". Modificar contraseña");
            System.out.println(OP_CONSULTARU + ". Consultar nombre de usuario");
            System.out.println(OP_CONSULTARP + ". Consultar contraseña usuario");
            System.out.println(OP_EXIT + ". Salir");
    
            if (!input.hasNextInt()) {
                input.next();
                op = 0;
            }
            else op = input.nextInt();
            
            switch (op) {
            case OP_MODU:
                menuModUsuari(input);
                break;
            
            case OP_MODP:
            	menuModPass(input);
                break;
            
            case OP_CONSULTARU:
                menuConsultarUsr(input);
                break;
                
            case OP_CONSULTARP:
                menuConsultarPass(input);
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  