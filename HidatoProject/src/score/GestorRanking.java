package score;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorRanking {
	
	public GestorRanking() {
		
	}
	
	public void store(Ranking r) {
		try{
			File aux = new File("Ranking");
			if (!aux.exists()) aux.mkdirs();
			File fac = new File("Ranking/", "facil.txt");
			if(!fac.exists())fac.createNewFile();
			File nor = new File("Ranking/", "normal.txt");
			if(!nor.exists())nor.createNewFile();
			File dif = new File("Ranking/", "dificil.txt");
			if(!dif.exists())dif.createNewFile();
			ArrayList<PairIntString> arrayfac = r.getRank(1);
			ArrayList<PairIntString> arraynor = r.getRank(2);
			ArrayList<PairIntString> arraydif = r.getRank(3);
			FileWriter escfac = new FileWriter("/Ranking/facil.txt");
			BufferedWriter bwfac = new BufferedWriter(escfac);
			for (int i=0; i<arrayfac.size(); ++i){
				bwfac.write(arrayfac.get(i).getSecond());
				bwfac.write(arrayfac.get(i).getFirst());
			}
			bwfac.close();
			escfac.close();
			FileWriter escnor = new FileWriter("/Ranking/facil.txt");
			BufferedWriter bwnor = new BufferedWriter(escfac);
			for (int i=0; i<arraynor.size(); ++i){
				bwnor.write(arraynor.get(i).getSecond());
				bwnor.write(arraynor.get(i).getFirst());
			}
			bwnor.close();
			escnor.close();
			FileWriter escdif = new FileWriter("/Ranking/facil.txt");
			BufferedWriter bwdif = new BufferedWriter(escfac);
			for (int i=0; i<arraydif.size(); ++i){
				bwdif.write(arraydif.get(i).getSecond());
				bwdif.write(arraydif.get(i).getFirst());
			}
			bwdif.close();
			escdif.close();
		}catch(IOException ex){
			
		}
	}
	
	public Ranking load() {
		Ranking r = new Ranking();		
		try{
			File fac = new File("/Ranking/facil.txt");
			if (fac.exists()){
				FileReader frfac = new FileReader("/Ranking/facil.txt");
				BufferedReader bffac = new BufferedReader(frfac);
				int puntuacio;
				String nom;
				while ((nom=bffac.readLine())!=null){
					puntuacio = Integer.parseInt(bffac.readLine());
					r.addNewRanking(1, puntuacio, nom);
				}
				bffac.close();
		        frfac.close();
			}
			File nor = new File("/Ranking/normal.txt");
			if (nor.exists()){
				FileReader frnor = new FileReader("/Ranking/normal.txt");
				BufferedReader bfnor = new BufferedReader(frnor);
				int puntuacio;
				String nom;
				while ((nom=bfnor.readLine())!=null){
					puntuacio = Integer.parseInt(bfnor.readLine());
					r.addNewRanking(2, puntuacio, nom);
				}
				bfnor.close();
		        frnor.close();
			}
			File dif = new File("/Ranking/dificil.txt");
			if (dif.exists()){
				FileReader frdif = new FileReader("/Ranking/dificil.txt");
				BufferedReader bfdif = new BufferedReader(frdif);
				int puntuacio;
				String nom;
				while ((nom=bfdif.readLine())!=null){
					puntuacio = Integer.parseInt(bfdif.readLine());
					r.addNewRanking(3, puntuacio, nom);
				}
				bfdif.close();
		        frdif.close();
			}
		}catch(IOException ex){
			
		}
		return r;
	}
}