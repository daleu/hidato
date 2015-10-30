package usuarios;
//import java.util.Vector;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorPerUsr {
	
	/*Constructora*/
	public GestorPerUsr() {

	}
	
	//Afegir Usuari
	public boolean afegirUsuari(UsuarioDom u){
		boolean afegit=false;
		try{
			File fichero = new File("usuaris/"+u.getUser()+".txt");
			if (!fichero.exists()){
				afegit=true;
				fichero.createNewFile();
				FileWriter esc =new FileWriter("usuaris/"+u.getUser()+".txt",true);
				BufferedWriter bw = new BufferedWriter(esc); 
				bw.write(u.getPassword());
				bw.close();
				esc.close();
			}
			else afegit=false;
		}catch(IOException ex){
			// S'ha de fer encara
		}
		return afegit;
	}
	
	//Comprovar Usuari
	public boolean comprovarUsr(UsuarioDom u){
		boolean trobat=false;
		try{
			File fichero = new File("usuaris/"+u.getUser()+".txt");
			if (fichero.exists()){
				FileReader fr = new FileReader("usuaris/"+u.getUser()+".txt");
				BufferedReader bf = new BufferedReader(fr);
				String cont =bf.readLine();
				bf.close();
		        fr.close();
		        if (cont.equals(u.getPassword())) trobat=true;
			}
			else trobat=false;
		}catch(IOException ex){
			// S'ha de fer encara
		}
		return trobat;
	}
	
	//Modifica el nom d'un Usuari
	public boolean modUsuari(String uact, String unou, String pass){
		boolean trobat=false;
		try{
			File fichero = new File("usuaris/"+uact+".txt");
			if (fichero.exists()){
				trobat=true;
				fichero.delete();
				File fichero2 = new File("usuaris/"+unou+".txt");
				fichero2.createNewFile();
				FileWriter esc =new FileWriter("usuaris/"+unou+".txt",true);
				BufferedWriter bw = new BufferedWriter(esc); 
				bw.write(pass);
				bw.close();
				esc.close();
			}
			else trobat=false;
		}catch(IOException ex){
			// S'ha de fer encara
		}
		return trobat;
	}
	
	//Modificar contrasenya
	public boolean modPassword(String u, String pass){
		boolean trobat=false;
		try{
			File fichero = new File("usuaris/"+u+".txt");
			if (fichero.exists()){
				trobat=true;
				FileWriter esc =new FileWriter("usuaris/"+u+".txt");
				BufferedWriter bw = new BufferedWriter(esc); 
				bw.write(pass);
				bw.close();
				esc.close();
			}
			else trobat=false;
		}catch(IOException ex){
			// S'ha de fer encara
		}
		return trobat;
	}
}
