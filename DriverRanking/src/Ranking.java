import java.util.ArrayList;

public class Ranking {
	
	private static final int DIF_EAS = 1;
	private static final int DIF_NOR = 2;
	private static final int DIF_HAR = 3;
	
	private ArrayList<PairIntString> facil;
	private ArrayList<PairIntString> normal;
	private ArrayList<PairIntString> dificil;
	
	/*Contructores*/
	
	public Ranking(){
		
	}
	
	/*Consultores*/
	
	//dificultat=1 -> easy, dificultat=2 -> normal, dificultat=3 -> dificil
	public ArrayList<String> getRank(int dificultat){
		ArrayList<String> rank=new ArrayList<String>();
		ContDom cd = new ContDom();
		rank = getRank(dificultat);
		return rank;
	}
	
	//dificultat=1 -> easy, dificultat=2 -> normal, dificultat=3 -> dificil
	public ArrayList<Integer> getPos(String user, int dificultat){
		return null;
		
	}
	
	//dificultat=1 -> easy, dificultat=2 -> normal, dificultat=3 -> dificil
	public ArrayList<Integer> getScore(String user, int dificultat){
		return null;
	}
	
	/*Modificadores*/
	
	public void addNewRanking(int dificultat, String user, int score){
		
	}
	
	public void deleteUserRanking(String user){
		
	}
	
	public void modifyUsername(String userActual, String userAnterior){
		
	}
}
