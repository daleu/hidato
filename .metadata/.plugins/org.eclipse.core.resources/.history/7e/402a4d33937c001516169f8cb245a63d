package usuarios;

public class CtrUsr {
	
	private Usuario current;
	private GestorUsr gu;
	
	public CtrUsr() {
		gu = new GestorUsr();
	}
	
	public void addUser1(String u, String p) {
		current = new Usuario(u, p);
		gu.addUser2(current);
	}
	
	public boolean isUser1(String u, String p){
		current = new Usuario(u,p);
		boolean exist = gu.isUser2(current);
		return exist;
	}
}
