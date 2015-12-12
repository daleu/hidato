
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
			FileWriter escfac = new FileWriter("Ranking/facil.txt");
			BufferedWriter bwfac = new BufferedWriter(escfac);
			String f = null;
			for (int i=0; i<arrayfac.size(); ++i){
				f = arrayfac.get(i).getSecond() + " " + arrayfac.get(i).getFirst() + " ";
				bwfac.write(f);
			}
			bwfac.close();
			escfac.close();
			FileWriter escnor = new FileWriter("Ranking/normal.txt");
			BufferedWriter bwnor = new BufferedWriter(escnor);
			for (int i=0; i<arraynor.size(); ++i){
				f = arraynor.get(i).getSecond() + " " + arraynor.get(i).getFirst() + " ";
				bwnor.write(f);
			}
			bwnor.close();
			escnor.close();
			FileWriter escdif = new FileWriter("Ranking/dificil.txt");
			BufferedWriter bwdif = new BufferedWriter(escdif);
			for (int i=0; i<arraydif.size(); ++i){
				f = arraydif.get(i).getSecond() + " " + arraydif.get(i).getFirst() + " ";
				bwdif.write(f);
			}
			bwdif.close();
			escdif.close();
		}catch(IOException ex){
			
		}
	}
	
	public Ranking load() {
		Ranking r = new Ranking();
		try{
			File fac = new File("Ranking/", "facil.txt");
			if (fac.exists()){
				Scanner fc = new Scanner(fac);
				int puntuacio;
				String nom;
				while (fc.hasNext()){
					nom = fc.next();
					puntuacio = fc.nextInt();
					r.addNewRanking(1, puntuacio, nom);
				}
				fc.close();
			}
			File nor = new File("Ranking/", "normal.txt");
			if (nor.exists()){
				Scanner nc = new Scanner(nor);
				int puntuacio;
				String nom;
				while (nc.hasNext()){
					nom = nc.next();
					puntuacio = nc.nextInt();
					r.addNewRanking(2, puntuacio, nom);
				}
				nc.close();
			}
			File dif = new File("Ranking/", "dificil.txt");
			if (dif.exists()){
				Scanner dc = new Scanner(dif);
				int puntuacio;
				String nom;
				while (dc.hasNext()){
					nom = dc.next();
					puntuacio = dc.nextInt();
					r.addNewRanking(3, puntuacio, nom);
				}
				dc.close();
			}
		}catch(IOException ex){
			
		}
		return r;
	}
}