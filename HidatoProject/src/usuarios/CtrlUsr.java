package usuarios;

import hidato.GestorPartides;
import hidato.GestorTaulells;
import score.CtrlRanking;

public class CtrlUsr {
	
	private Usuario current;
	private GestorUsr gu;
	
	/*Constructora*/
	public CtrlUsr() {
		gu = new GestorUsr();
	}
	
	//Afegim un nou Usuari
	public boolean afegirUsuari(String u, String p) {
		boolean afegit = false;
		Usuario aux = new Usuario(u, p);
		afegit=gu.afegirUsuari(aux);
		return afegit;
	}
	
	//Quan passem false comprovem password i nom d'usuari.
	//Quan passem true comprovarem el noms d'usuari.
	public boolean logUsuari(String u, String p){
		boolean loguejat = false;
		Usuario newCurrent = new Usuario(u, p);
		loguejat=gu.comprovarUsr(newCurrent);
		if (loguejat) current = new Usuario(u, p);
		return loguejat;
	}
	
	//Ens modifica el nostre nom d'usuari
	public boolean modUsr(String uact, String unou){
		boolean fet = false;
		if (uact.equals(current.getUsr()) & !gu.comprovarUsrMod(unou)){
			Usuario newCurrent = new Usuario(unou, current.getPass());
			fet = gu.modUsr(uact, unou, newCurrent.getPass());
			GestorTaulells aux1 = new GestorTaulells();
			aux1.modTaulellUsr(uact, unou);
			GestorPartides aux2 = new GestorPartides();
			aux2.modPartidaUsr(uact, unou);
			CtrlRanking aux3 = new CtrlRanking();
			aux3.modifyUsr(unou, uact);
			if (fet) current = newCurrent;
		}
		return fet;
	}
	
	//Modifica la nostra password
	public boolean modPass(String pact, String pnov){
		boolean fet = false;
		if (pact.equals(current.getPass())){
			Usuario newCurrent = new Usuario(current.getUsr(), pnov);
			fet=gu.modPassword(newCurrent.getUsr(), pnov);
			if (fet) current = newCurrent;
		}
		return fet;
	}
	
	public boolean esbUsr(String pass){
		boolean fet = false;
		if (pass.equals(current.getPass())){
			fet=gu.esbUsuari(current.getUsr());
			GestorTaulells aux1 = new GestorTaulells();
			aux1.esbTaulellsUsr(current.getUsr());
			GestorPartides aux2 = new GestorPartides();
			aux2.esbPartidaUsr(current.getUsr());
			CtrlRanking aux3 = new CtrlRanking();
			aux3.deleteUsrRanking(current.getUsr());
		}
		return fet;
	}
}
