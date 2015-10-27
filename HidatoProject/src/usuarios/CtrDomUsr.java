package usuarios;

public class CtrDomUsr {
	
	private UsuarioDom current;
	private GestorPerUsr gu;
	
	public CtrDomUsr() {
		gu = new GestorPerUsr();
	}
	
	public void addUser1(String u, String p) {
		current = new UsuarioDom(u, p);
		gu.addUser2(current);
	}
	
	public boolean isUser1(String u, String p){
		current = new UsuarioDom(u,p);
		boolean exist = gu.isUser2(current);
		return exist;
	}
}
