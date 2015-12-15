package hidato;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaulellHidato extends Taulell {

	private int[] given;
	private int[] start;
	private int tamany;
	
	private int perposar;
	private int posats;
	
	public TaulellHidato(int tam) {
		super(tam);
		tamany = tam;
		Matriu_joc = new Casilla[tam][tam];
		for (int i=0; i<tam;++i){
			for (int j=0; j<tam; ++j){
				Matriu_joc[i][j] = new Casilla();
				Matriu_joc[i][j].setValor(0);
				Matriu_joc[i][j].setEditable(true);
				Matriu_joc[i][j].setColumna(j);
				Matriu_joc[i][j].setFila(i);
			}
		}
	}
	
	public TaulellHidato(Casilla[][] mat1, int[][] mat2, int[] give, int[] star, int perpos, int posat){
		super(mat1.length);
		Matriu_joc=mat1;
		Matriu_solucio=mat2;
		given=give;
		start=star;
		tamany=mat1.length;
		perposar=perpos;
		posats=posat;
	}
	
	//GETS PER GESTIO TAULELLS
	
	public int[][] getSolucio(){
		return Matriu_solucio.clone();
	}
	
	public Casilla[][] getTaulell(){
		return Matriu_joc.clone();
	}
	
	public int[] getPosIni(){
		return start.clone();
	}
	
	public int[] getDonats(){
		return given.clone();
	}
	
	public int getPosats(){
		return posats;
	}
	
	public int getPerPosar(){
		return perposar;
	}
	
	public int getMida(){
		return tamany;
	}
	
	///////////////////////////////// SET
	
	public void setSolucio(int[][] sol){
		Matriu_solucio = sol;
	}
	
	public void setTaulell(Casilla[][] joc){
		Matriu_joc = joc;
	}
	
	public void setPosIni(int[] sta){
		start = sta;
	}
	
	public void setDonats(int[] giv){
		given = giv;
	}
	
	public void setPosats(int pos){
		posats = pos;
	}
	
	public void setPerPosar(int perpos){
		perposar = perpos;
	}
	
	
	/////////////////////////////////
	
	public int[][] agafaTaulell(){
		int[][] aux = new int[tamany+2][tamany+2];
		
		for (int x=0; x<tamany+2;  ++x){
        	aux[0][x] = -1;
        	aux[x][0] = -1;
        	aux[tamany+1][x] = -1;
        	aux[x][tamany+1] = -1;
        }
		
		for(int i = 0; i < aux.length - 2; ++i) {
			for(int j = 0; j < aux[0].length - 2; ++j) {
				aux[i+1][j+1] = Matriu_joc[i][j].getValor();
			}
		}
		
		return aux;
	}
	
	public boolean[] modValor(int fila, int columna, int valor){
		boolean[] aux = new boolean[2];
		if (Matriu_joc[fila][columna].getEditable()){
			aux[0]=true;
			if(valor==0 && Matriu_joc[fila][columna].getValor()!=valor)--posats;
			else if (valor!=0 && Matriu_joc[fila][columna].getValor()==0) ++posats;
			if (posats==perposar)aux[1]=true;
			else aux[1]=false;
			Matriu_joc[fila][columna].setValor(valor);
			System.out.println(posats + " de " + perposar);
			return aux;
		}
		else {
			aux[0]=false;
			aux[1]=false;
			return aux;
		}
	}
	
	public int getNoFixes(){
		return perposar;
	}
	
	public int getTiempoBronce(){
		return 500;
	}
	
	public int getTiempoPlata(){
		return 500;
	}
	
	public int getTiempoOro(){
		return 500;
	}
}