import java.util.ArrayList;

public class SolHidato {
	
	private ArrayList[][] disponibles;		//ArrayList amb els nombres que es poden colocar en aquella casella
	private ArrayList nombresLliures;		//Vector amb els nombres que encara no estan colocats
	private int[][] solucio;				//Matriu amb el resultat final
	private int forats;						//Numero de forats
	private int nombrescolocats;			//Numero de nombres colocats
	private boolean[][] editable;
	
	
	public void SolHidato(int mida, int fora, int nombrecol){
		forats=fora;
		nombrescolocats=nombrecol;
		solucio=new int[mida][mida];
		disponibles=new ArrayList[mida][mida];
		editable = new boolean[mida][mida];
		int aux = mida*mida;
		for(int i=1;i<=aux-forats;++i){
			nombresLliures.add(i);
		}
		for(int j=0;j<mida;++j){
			for(int k=0;k<mida;++k){
				for(int l=1;l<=aux-forats;++l){
					disponibles[j][k].add(l);
				}
				editable[j][k]=true;
			}
		}
	}

	public void introduirForat(int x, int y){
		solucio[x][y]=0;
		editable[x][y]=false;
	}
	
	public void introduirNombres(int x, int y, int valor){
		solucio[x][y]=valor;
		editable[x][y]=false;
		for(int j=0;j<solucio[j].length;++j){
			for(int k=0;k<solucio[j].length;++k){
				if(disponibles[j][k].contains(valor)) disponibles[j][k].remove(valor);
			}
		}
		nombresLliures.remove(valor);
	}
	
	public void solucionarHidato(){

	}
}
