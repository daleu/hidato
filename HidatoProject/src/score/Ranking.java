package score;
import java.util.ArrayList;
import java.util.ListIterator;

public class Ranking {
	
	private static final int DIF_EAS = 1;
	private static final int DIF_NOR = 2;
	private static final int DIF_HAR = 3;
	
	protected ArrayList<PairIntString> facil;
	protected ArrayList<PairIntString> normal;
	protected ArrayList<PairIntString> dificil;
	
	/*Contructores*/
	
	public Ranking(){
		this.facil = new ArrayList<PairIntString>();
		this.normal = new ArrayList<PairIntString>();
		this.dificil = new ArrayList<PairIntString>();
	}
	
	/*Consultores*/
	
	//dificultat=1 -> easy, dificultat=2 -> normal, dificultat=3 -> dificil
	public ArrayList<PairIntString> getRank(int dificultat){
		switch (dificultat) {
		case DIF_EAS:
			return facil;
		case DIF_NOR:
			return normal;
		case DIF_HAR:
			return dificil;
		}
		
		return null;
	}
	
	//dificultat=1 -> easy, dificultat=2 -> normal, dificultat=3 -> dificil
	public ArrayList<Integer> getPos(String user, int dificultat) {
		ArrayList<Integer> ap = new ArrayList<Integer>();
		ListIterator<PairIntString> it;
		
		switch (dificultat) {
		case DIF_EAS:
			it = facil.listIterator();
			while (it.hasNext()) {
				if (it.next().getSecond().equals(user)) ap.add(it.previousIndex());
			}
			break;
			
		case DIF_NOR:
			it = normal.listIterator();
			while (it.hasNext()) {
				if (it.next().getSecond().equals(user)) ap.add(it.previousIndex());
			}
			break;
			
		case DIF_HAR:
			it = dificil.listIterator();
			while (it.hasNext()) {
				if (it.next().getSecond().equals(user)) ap.add(it.previousIndex());
			}
			break;
			
		default:
			break;
		}
		return ap;
	}
	
	//dificultat=1 -> easy, dificultat=2 -> normal, dificultat=3 -> dificil
	public ArrayList<Integer> getScore(String user, int dificultat) {
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
			break;
			
		case DIF_NOR:
			it = normal.listIterator();
			while (it.hasNext()) {
				pis = it.next();
				if (pis.getSecond().equals(user)) {
					ap.add(pis.getFirst());
				}
			}
			break;
			
		case DIF_HAR:
			it = dificil.listIterator();
			while (it.hasNext()) {
				pis = it.next();
				if (pis.getSecond().equals(user)) {
					ap.add(pis.getFirst());
				}
			}
			break;
			
		default:
			break;
		}
		return ap;
	}
	
	/*Modificadores*/
	
	public void addNewRanking(int dificultat, int score, String user) {
		ListIterator<PairIntString> it = null;
		PairIntString pis, newPis;
		boolean found = false;
		newPis = new PairIntString(score, user);
		
		switch (dificultat) {
			case DIF_EAS:
				it = facil.listIterator();
				break;
				
			case DIF_NOR:
				it = normal.listIterator();
				break;
				
			case DIF_HAR:
				it = dificil.listIterator();
				break;
				
			default:
				break;
				
		}
		while (it.hasNext() && !found) {
	
			pis = it.next();
			if (pis.getFirst() < score) {
				it.previous();
											// it.add(newPis) anade newPis justo
											// antes de it.next(), que seria despues
											// de pis. Y como lo queremos just antes,
											// llamo a it.previous() para que it.next()
											// sea el que corresponde al actual
											// valor de pis. Despues de esto no hace
											//volver a donde estabamos con it.next()
											// porque ponemos inserted = true
				found = true;
			}
			
		}
		
		it.add(newPis);
	}
	
	public void deleteUsrRanking(String user) {
		ListIterator<PairIntString> it;
		
		it = facil.listIterator();
		while (it.hasNext()) {
			if (it.next().getSecond().equals(user)) it.remove();
		}
	
		it = normal.listIterator();
		while (it.hasNext()) {
			if (it.next().getSecond().equals(user)) it.remove();
		}
		
		it = dificil.listIterator();
		while (it.hasNext()) {
			if (it.next().getSecond().equals(user)) it.remove();
		}
											// it.remove() quita el ultimo elemento
											// llamado con it.next() o it.previous(),
											// es decir, el que llamamos al hacer la
											// comprobacion del if
	}
	
	public void modifyUsr(String userActual, String userAnterior) {
		ListIterator<PairIntString> it;
		PairIntString pis, newPis;
		
		it = facil.listIterator();
		while (it.hasNext()) {
			pis = it.next();
			if (pis.getSecond().equals(userAnterior)) {
				newPis = new PairIntString(pis.getFirst(), userActual);
				it.add(newPis);
			}
		}
	
		it = normal.listIterator();
		while (it.hasNext()) {
			pis = it.next();
			if (pis.getSecond().equals(userAnterior)) {
				newPis = new PairIntString(pis.getFirst(), userActual);
				it.add(newPis);
			}
		}
		
		it = dificil.listIterator();
		while (it.hasNext()) {
			pis = it.next();
			if (pis.getSecond().equals(userAnterior)) {
				newPis = new PairIntString(pis.getFirst(), userActual);
				it.add(newPis);
			}
		}
		
		deleteUsrRanking(userAnterior);
	}
}