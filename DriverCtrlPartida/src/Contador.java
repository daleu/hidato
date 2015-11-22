
import java.util.Timer;
import java.util.TimerTask;

public class Contador {
	private int segundos;
	private Timer cronometro;
	private boolean countdown;
	
	private class Segundera extends TimerTask {
		
		public void run() {
			if(!countdown) segundos++;
			else segundos--;
			
			if(segundos==0) detener();
		}
	}
	
	public Contador() {
		segundos = 0;
		cronometro = new Timer();
		countdown = false;
	}
	
	public Contador(int s, boolean b) {
		segundos = s;
		cronometro = new Timer();
		countdown = b;
	}
	
	public Contador(int m, int s, boolean b) {
		this(m*60 + s, b);
	}
	
	public Contador(int h, int m, int s, boolean b) {
		this(h*3600 + m*60 + s, b);
	}
	
	public void iniciar() {
		cronometro.schedule(new Segundera(), segundos, 1000);
	}
	
	public void detener() {
		cronometro.cancel();
	}
	
	public int getSegundos() {
		return segundos;
	}
}
