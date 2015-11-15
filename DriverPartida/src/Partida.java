class Partida{
	private Integer score;
	private Contador temps;
	private TaulellHidato taulellh;

// Creadores
	public Partida(){
		this.taulellh = new TaulellHidato((int)Math.random()*30);
		this.temps = new Contador();
		score = 0;
	}
	public Partida(TaulellHidato t){
		this.taulellh = t;
		this.temps = new Contador();
		this.score = 0;
	}
	public Partida(TaulellHidato t, Contador c, int s){
		this.taulellh = t;
		this.temps = c;
		this.score = s;
	}
	public Partida(int forats, int mida, int fixos){
		this.taulellh = new TaulellHidato(mida);
		this.taulellh.crearTaulellRandom(forats, fixos);
		this.temps = new Contador();
		score = 0;
	}

// Modificadores

	public void setScore(int score){
		this.score = score;
	}
	
	public void penalitzacio(int pen){
		this.score = score-pen;
	}

// Consultores
	public int getScore(){
		return score;
	}

	public int getTime(){
		return temps.getSegundos();
	}

}