import java.util.ArrayList;
import java.util.ListIterator;

public class Ranking {
	
	private static final int DIF_EAS = 1;
	private static final int DIF_NOR = 2;
	private static final int DIF_HAR = 3;
	
	private ArrayList<PairIntString> facil;
	private ArrayList<PairIntString> normal;
	private ArrayList<PairIntString> dificil;
	//private ControladorDomini cd = new ControladorDomini();
	
	/*Contructores*/
	
	public Ranking(){
		this.facil = new ArrayList<PairIntString>();
		this.normal = new ArrayList<PairIntString>();
		this.dificil = new ArrayList<PairIntString>();
		
		//this.cd = new ControladorDomini();
	}
	
	/*Consultores*/
	
	//dificultat=1 -> easy, dificultat=2 -> normal, dificultat=3 -> dificil
	public ArrayList<PairIntString> getRank(int dificultat){
		
		switch (dificultat) {
		case DIF_EAS:
			return (ArrayList<PairIntString>) facil.clone();
		case DIF_NOR:
			return (ArrayList<PairIntString>) normal.clone();
		case DIF_HAR:
			return (ArrayList<PairIntString>) dificil.clone();
		}
		return null;
	}
	
	//dificultat=1 -> easy, dificultat=2 -> normal, dificultat=3 -> dificil
	public ArrayList<Integer> getPos(String user, int dificultat) {
		ArrayList<Integer> ap = new ArrayList<Integer>();
		ListIterator<PairIntString> it;
		PairIntString pis;
		
		switch (dificultat) {
		case DIF_EAS:
			it = facil.listIterator();
			while (it.hasNext()) {
				pis = it.next();
				if (pis.getSecond().equals(user)) {
					ap.add(pis.getFirst());
				}
			}
		case DIF_NOR:
			return (ArrayList<PairIntString>) normal.clone();
		case DIF_HAR:
			return (ArrayList<PairIntString>) dificil.clone();
		}
		return null;
	}
	
	//dificultat=1 -> easy, dificultat=2 -> normal, dificultat=3 -> dificil
	public ArrayList<Integer> getScore(String user, int dificultat) {
		return null;
	}
	
	/*Modificadores*/
	
	public void addNewRanking(int dificultat, String user, int score) {
		
	}
	
	public void deleteUserRanking(String user) {
		
	}
	
	public void modifyUsername(String userActual, String userAnterior) {
		
	}
}
