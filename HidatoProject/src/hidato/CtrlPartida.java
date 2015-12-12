package hidato;

import score.CtrlRanking;

public class CtrlPartida {
	private String usr;
	private Partida actual;
	
	//Creadora
	
	//1=Partida Random
	//2=Partida Personalitzada
	//3=Partida del Repositori
	//4=Carregar partida començada
	//Tant en l'opcio 3 i 4, utilitzarem un id per indicara a quin taulell/partida ens referim dins del repositori
	public CtrlPartida(String usuari, int tipus_par, int mida, int forats, int fixos, String id){
		usr = new String(usuari);
		if(tipus_par==1)actual = new Partida();
		else if (tipus_par==2) actual = new Partida(mida, forats, fixos);
		else if (tipus_par==3){
			GestorTaulells tau = new GestorTaulells();
			TaulellHidato aux = tau.getTaulell(id,usr);
			if (aux.getMida()==0) System.out.println("Taulell Invalid");
			else actual = new Partida(aux);
		}
		else{
			GestorPartides par = new GestorPartides();
			Partida aux = par.getPartida(id,usr);
			actual = new Partida(aux);
		}
	}
	
	public boolean guardarPartida(String id){
		GestorPartides aux = new GestorPartides();
		System.out.println(usr);
		return aux.guardarPartida(id,actual,usr);
	}
	
	public void guardarRanking(CtrlRanking r){
		actual.setScore();
		int score = actual.getScore();
		int dificultad = 1;
		r.saveScore(dificultad, score, usr);
	}
	
	//Si el valor == 0, aleshores esborrem una casella
	//Si el retorn es fals, es que la casella no es pot modificar!!!
	//En cas que s'haigui modificat, si el valor de retorn==1, indica que hem rellenat tot el taulell
	public boolean[] modificarCas(int fila, int columna, int valor){//---------------------------------------------------------------
		return actual.modCas(fila, columna, valor);
	}
		
	
	//Consultores
	public int[][] mostrarTaulell(){
		return actual.getTauActual();		
	}
	
	public int getTime(){
		return actual.getTime();
	}
	
	public int getScore(){
		return actual.getScore();
	}
}

