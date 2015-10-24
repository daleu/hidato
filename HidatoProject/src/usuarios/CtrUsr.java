package usuarios;

public class CtrUsr {
	
	private Usuario current;
	private GestorUsr gu;
	
	public CtrUsr() {
		gu = new GestorUsr();
	}
	
	public void addUser(String u, String p) {
		current = new Usuario(u, p);
		gu.addUser(current);
	}
}
