import java.util.Scanner;

public class DriverPairIntString {
	
	private static int puntuacio;
	private static String nom;
	private static PairIntString pis;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Tria una de les opcions:");
		System.out.println("1. Pair per defecte");
		System.out.println("2. Pair definit");
		
		int op=0;
		
		if (!input.hasNextInt()) {
            input.next();
            op = 0;
        }
        else op = input.nextInt();
		
		switch (op) {
        case 1:
        	pis = new PairIntString(puntuacio,nom);
            break;
        
        case 2:
        	System.out.println("Introdueixi un puntuacio");
    		puntuacio = input.nextInt();
    		System.out.println("Introdueixi el seu nom d'usuari");
    		nom = input.next();
    		pis = new PairIntString(puntuacio,nom);
            break;
            
        default:
            System.out.println("Opció incorrecta");
            break;
		}
		
		boolean cont = true;
		while(cont){
			
			System.out.println("Tria una de les opcions:");
			System.out.println("1. Veure la puntuacio");
			System.out.println("2. Veure nom");
			System.out.println("3. Modificar Puntuacio");
			System.out.println("4. Modificar Nom");
			System.out.println("5. Comprivar si un altre Pair es igual al que tenim");
			
			if (!input.hasNextInt()) {
	            input.next();
	            op = 0;
	        }
	        else op = input.nextInt();
			
			switch (op) {
				case 1:
		        	System.out.println(pis.getFirst());
		            break;
		        
		        case 2:
		        	System.out.println(pis.getSecond());
		            break;
		            
		        case 3:
		        	System.out.println("Introdueix un nou valor de puntuacio");
		        	pis.setFirst(input.nextInt());
		            break;
		        
		        case 4:
		        	System.out.println("Introdueix un nou valor de nom");
		        	pis.setSecond(input.next());
		            break;
		            
		        case 5:
		        	System.out.println("Introdueixi un puntuacio");
		    		puntuacio = input.nextInt();
		    		System.out.println("Introdueixi el seu nom d'usuari");
		    		nom = input.next();
		    		PairIntString o = new PairIntString(puntuacio,nom);
		    		boolean igual = pis.equals(o);
		    		if (igual) System.out.println("Els Pairs son iguals");
		    		else System.out.println("Els Pairs no son iguals");
		            break;
		            
		        default:
		            System.out.println("Opció incorrecta");
		            break;
				}
			}
		}
	}
