package score;
import java.util.ArrayList;
import java.util.ListIterator;

public class CtrlRanking {
	
	Ranking r;

	public CtrlRanking() {
		GestorRanking gr = new GestorRanking();
		r = gr.load();
	}
	
	public void saveScore(int dif, int score, String usr) {
		r.addNewRanking(dif, score, usr);
		
		GestorRanking gr = new GestorRanking();
		gr.store(r);
	}
	
	public String getRank(int dif) {
		ArrayList<PairIntString> rank = r.getRank(dif);
		ListIterator<PairIntString> it = rank.listIterator();
		String s = "";
		PairIntString aux = null;
			
		while(it.hasNext()) {
			aux = it.next();
			s += (it.previousIndex() + 1) + ": " + aux.getFirst() + " - " + aux.getSecond() + "\n"; // "pos,score,usuario<salto-de-linea>"
			
		}
		
		s += ".";		//indica final de string
		
		return s;
	}
	
	public ArrayList<Integer> getPos(String usr, int dif) {
		return r.getPos(usr, dif);
	}
	
	public ArrayList<Integer> getScore(String usr, int dif) {
		return r.getScore(usr, dif);
	}
	
	public String getUsrScore(String usr, int dif) {
		ArrayList<Integer> pos = r.getPos(usr, dif);
		ArrayList<Integer> score = r.getScore(usr, dif);
		String s = usr + ":\n";
		ListIterator<Integer> itPos = pos.listIterator();
		ListIterator<Integer> itScore = score.listIterator();
		int aux;
		
		while(itPos.hasNext() && itScore.hasNext()) {
			aux = itPos.next();
			s += (aux + 1) + ": "; // "pos,"
			aux = itScore.next();
			s += aux + "\n"; //"pos,score<salto-de-linea>"
		}
		s += ".";	//indica final de string
		
		return s;
	}
	
	public void deleteUsrRanking(String usr) {
		r.deleteUsrRanking(usr);
		
		GestorRanking gr = new GestorRanking();
		gr.store(r);
	}
	
	public void modifyUsr(String newName, String oldName) {
		r.modifyUsr(newName, oldName);
		
		GestorRanking gr = new GestorRanking();
		gr.store(r);
	}
        
        public String[] getFacil() {
		ArrayList<PairIntString> facaux = r.getRank(1);
		String fac[] = new String [facaux.size()]; 
		int i = 0;
		PairIntString aux = null;
		ListIterator<PairIntString> it = facaux.listIterator();
		while(i < facaux.size()) {
			aux = it.next();
			fac[i] = (i+1) + " " + Integer.toString(aux.getFirst()) + " " + aux.getSecond() ;
			++i;
		}
		return fac;
	}
	public String[] getNormal() {
		ArrayList<PairIntString> noraux = r.getRank(2);
		String nor[] = new String [noraux.size()]; 
		int i = 0;
		PairIntString aux = null;
		ListIterator<PairIntString> it = noraux.listIterator();
		while(i < noraux.size()) {
			aux = it.next();
			nor[i] = (i+1) + " " + Integer.toString(aux.getFirst()) + " " + aux.getSecond() ;
			++i;
		}
		return nor;
	}
	public String[] getDificil() {
		ArrayList<PairIntString> difaux = r.getRank(3);
		String dif[] = new String [difaux.size()]; 
		int i = 0;
		PairIntString aux = null;
		ListIterator<PairIntString> it = difaux.listIterator();
		while(i < difaux.size()) {
			aux = it.next();
			dif[i] = (i+1) + " " + Integer.toString(aux.getFirst()) + " " + aux.getSecond() ;
			++i;
		}
		return dif;
	}
        
        public String[] getFacilUsr(String usr) {
		ArrayList<PairIntString> facaux = r.getRank(1);
		String fac[] = new String [facaux.size()]; 
		int i = 0;
		PairIntString aux = null;
		ListIterator<PairIntString> it = facaux.listIterator();
		while(i < facaux.size()) {
			aux = it.next();
			if ((aux.getSecond().equals(usr))) fac[i] = (i+1) + " " + Integer.toString(aux.getFirst()) + " " + aux.getSecond() ;
			++i;
		}
		return fac;
	}
	public String[] getNormalUsr(String usr) {
		ArrayList<PairIntString> noraux = r.getRank(2);
		String nor[] = new String [noraux.size()]; 
		int i = 0;
		PairIntString aux = null;
		ListIterator<PairIntString> it = noraux.listIterator();
		while(i < noraux.size()) {
			aux = it.next();
			if ((aux.getSecond().equals(usr))) nor[i] = (i+1) + " " + Integer.toString(aux.getFirst()) + " " + aux.getSecond() ;
			++i;
		}
		return nor;
	}
	public String[] getDificilUsr(String usr) {
		ArrayList<PairIntString> difaux = r.getRank(3);
		String dif[] = new String [difaux.size()]; 
		int i = 0;
		PairIntString aux = null;
		ListIterator<PairIntString> it = difaux.listIterator();
		while(i < difaux.size()) {
			aux = it.next();
			if ((aux.getSecond().equals(usr))) dif[i] = (i+1) + " " + Integer.toString(aux.getFirst()) + " " + aux.getSecond() ;
			++i;
		}
		return dif;
	}
}