import java.util.Scanner;
 
public class DriverSolucio {
 
    public static void main(String[] args) {
    	System.out.println("Introduzca las medidas del tablero (alzada y ancho):");
    	Scanner in = new Scanner(System.in);
    	int alzada = in.nextInt();
    	in.nextLine();
    	System.out.println("Introduzca una matriz con el siguiente formato:");
    	System.out.println("Agujero= -1 ");
    	System.out.println("Numero = numero");
    	System.out.println("Vacio = 0 ");
    	
    	int[][] input = new int[alzada][alzada];
    	
        for (int i=0; i<alzada;++i){
        	for (int j=0; j<alzada; ++j)
        	input[i][j] = in.nextInt();
        }
        
        in.close();
        
        TaulellHidato prova = new TaulellHidato(alzada);
        boolean exists = prova.fesTaulell(input);
        if (exists) printBoard(prova.agafaSolucio());
        else System.out.println("El taulell Proposat no te solucio");
    }
 
    private static void printBoard(int[][] Solucio) {
        for (int[] row : Solucio) {
            for (int c : row) {
                if (c == -1)
                    System.out.print("  . ");
                else
                    System.out.printf(c > 0 ? "%3d " : "___ ", c);
            }
            System.out.println();
        }
    }
}