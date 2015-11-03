import java.io.IOException;
import java.util.ArrayList;

public class TaulellHidato extends Taulell{
	
	public ArrayList[][] noCandidats;
	public Casilla Matriu_joc [][];
	private int Matriu_solucio [][];
	private ArrayList<Integer> usats;
	private int nombres; 
	private boolean[][] ple;

	public TaulellHidato(int tamany) {
		super(tamany);
		Matriu_joc = new Casilla[tamany][tamany];
		Matriu_solucio = new int[tamany][tamany];
		noCandidats = new ArrayList[tamany][tamany];
		ple = new boolean[tamany][tamany];
		for (int i=0; i<tamany; ++i){
			for (int j=0; j<tamany; ++j){
				Matriu_joc[i][j] = new Casilla();
				noCandidats[i][j] = new ArrayList<Integer>();
				ple[i][j]=false;
			}
		}
		usats = new ArrayList<Integer>();
		nombres=tamany*tamany;
	}
	
	//Si entrada=false, entra pel driver. Si entrada=true, escriu el client
	public void modifica_valor (int new_valor, int fila, int columna, boolean entrada) {
		if (fila >= Matriu_joc.length | columna >= Matriu_joc[0].length | usats.contains(new_valor)){
		/*	IOException error = new IOException();
			throw error;*/
		}
		else {
			if (entrada==true) {										/*FALTA IMPLEMENTAR AQUEST IF!!!!!!!!*/
				if (!Matriu_joc[fila][columna].getEditable()){
		/*			IOException error = new IOException();
					throw error;*/
				}
				else Matriu_joc[fila][columna].setValor(new_valor);	
			}
			else {
				if (Matriu_joc[fila][columna].getEditable()){
					Matriu_joc[fila][columna].setValor(new_valor);
					Matriu_joc[fila][columna].setEditable(false);
					Matriu_solucio[fila][columna]=new_valor;
					usats.add(new_valor);
					ple[fila][columna]=true;
					for (int i=0;i<Matriu_joc.length;++i){
						for (int j=0;j<Matriu_joc[0].length;++j){
							noCandidats[i][j].add(new_valor);
							if (new_valor==1){
																					//PER ACABAR!!!!!
							}
							else if (new_valor==nombres){
								
							}
							else {
								
							}
						}
					}
					
				}
				else {
				/*	IOException error = new IOException();
					throw error;*/
				}
			}
		}
	}
	
	public int getMida(){
		return Matriu_joc.length;
	}
	
	public int getMaxNombres(){
		return nombres;
	}
	
	public void intForat (int fila, int columna) {
		if (fila >= Matriu_joc.length | columna >= Matriu_joc[0].length | !Matriu_joc[fila][columna].getEditable()){
			Matriu_joc[fila][columna].setValor(0);
			Matriu_joc[fila][columna].setEditable(false);
			Matriu_solucio[fila][columna]=0;
			--nombres;
		}
	}
}
