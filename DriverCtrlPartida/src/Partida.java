import java.util.Random;

class Partida{
	private Integer score;
	private Contador temps;
	private TaulellHidato taulellh;
	private int penal;

// Creadores
	
	//Aleatoria
	public Partida(){
		Random aux = new Random();
		int x = aux.nextInt(12)+4;
		this.taulellh = new TaulellHidato(x);
		taulellh.crearTaulellRandom((x*x)/5, (x*x)/3);
		this.temps = new Contador();
		temps.iniciar();
		score = 0;
		penal=0;
	}
	
	//Repositori
	public Partida(TaulellHidato t){
		this.taulellh = t;
		this.temps = new Contador();
		temps.iniciar();
		this.score = 0;
		penal=0;
	}
	
	//Carregar Partida
	public Partida(Partida aux){
		taulellh = aux.getTaulell();
		temps = new Contador(aux.getTime(),false);
		temps.iniciar();
		score = aux.getScore();
		penal = aux.getPenalitzacio();
	}
	
	//Personalitzada
	public Partida(int forats, int mida, int fixos){
		this.taulellh = new TaulellHidato(mida);
		this.taulellh.crearTaulellRandom(forats, fixos);
		this.temps = new Contador();
		temps.iniciar();
		score = 0;
		penal=0;
	}

// Modificadores
	//Nomes s'executara en el cas que finalitzem la partida.
	public void setScore(){
		temps.detener();
		int cas =taulellh.getNoFixes();
		int tempsPerf=cas*15;
		tempsPerf=2*tempsPerf;
		score=tempsPerf-temps.getSegundos()-penal;
	}
	
	public boolean[] modCas(int fila, int columna, int valor){
		return taulellh.modValor(fila, columna, valor);
	}
	
	public void setTime(int te){
		temps = new Contador(te,false);
	}
	
	public void setPenalitzacio(int pen){
		penal = pen;
	}
	
	public void setTaulell(TaulellHidato aux){
		taulellh = aux;
	}
	

// Consultores
	public int getScore(){
		return score;
	}

	public int getTime(){
		return temps.getSegundos();
	}
	
	public TaulellHidato getTaulell(){
		return taulellh;
	}
	
	public int[][] getTauActual(){
		return taulellh.agafaTaulell();
	}
	
	public int getPenalitzacio(){
		return penal;
	}

}