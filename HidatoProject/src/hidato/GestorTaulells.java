package hidato;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorTaulells {
	
	public GestorTaulells(){
			
	}
	
	public int[][] getTaulell(String id, String nom_usr){ //load
		TaulellHidato aux = new TaulellHidato(0);
		int[][] input = null;
		try{
			File ids =  new File("Taulells/" + nom_usr + "/" + id);
			if (ids.exists()){ 
				File mid = new File("Taulells/" + nom_usr + "/" + id, id + "_mida.txt");
				Scanner scan = new Scanner(mid);
				int mida = scan.nextInt();
				scan.close();
				aux = new TaulellHidato(mida);
				
				File t = new File("Taulells/" + nom_usr + "/" + id, id + "_taulell.txt");
				Scanner scansol = new Scanner(t);
				
				input = new int[mida][mida];
				
				for (int i=0; i<mida;++i){
		        	for (int j=0; j<mida; ++j){
			        	input[i][j] = scansol.nextInt();  		
		        	}
		        }
				scansol.close();
			}
		} catch(IOException ex){
			
		}
		return input;
	}		
		
    public boolean storeTaulell(TaulellHidato aux, String id, String nom_usr){
    	boolean guardat = false;
		try {
			  File ids =  new File("Taulells/" + nom_usr + "/" + id);
			  if(!ids.exists()) ids.mkdirs(); //si la carpeta id no existeix la creem
			  File txt = new File("Taulells/" + nom_usr + "/" + id + "/" + id +"_taulell.txt");
			  if(!txt.exists()) txt.createNewFile(); // si l'arxiu del taulell no hi es el creem
			  File taule = new File("Taulells/" + nom_usr + "/" + id + "/" + id + "_mida.txt");
			  if(!taule.exists()) taule.createNewFile(); //si l'arxiu del taulell sol no hi es el creem
			  FileWriter esctau = new FileWriter("Taulells/" + nom_usr + "/" + id + "/" + id + "_taulell.txt");
			  FileWriter escsol = new FileWriter("Taulells/" + nom_usr + "/" + id + "/" + id + "_mida.txt");
			  
	
			  BufferedWriter bwsol = new BufferedWriter(escsol);
			  int mida = aux.getMida();
			  bwsol.write(String.valueOf(mida));
			  bwsol.close();
			  escsol.close();
			  
			  BufferedWriter bwtau = new BufferedWriter(esctau);
			  int[][] sol1 = aux.getSolucio();
			  String f = null;
			  for (int i = 0; i<mida; ++i){
				  for (int j=0; j<mida; ++j){
					  if(j==0) f = sol1[i+1][j+1] + " ";
					  else f += sol1[i+1][j+1] + " ";
				  }
				  bwtau.write(f);
				  bwtau.newLine();
				  f = null;
			  }

			  bwtau.close();
			  esctau.close();	
			  guardat = true;
    	  }
          catch(IOException ex){	
        	  guardat = false;
    	  }
		  return guardat;
      }
    
    //Esborrar Usuari
    public boolean esbTaulellsUsr(String nom_usr){
    	boolean fet = false;
    	File ids =  new File("Taulells/" + nom_usr);
    	if(ids.exists()) deleteFolder(ids);
    	fet = true;
    	return fet;
    }
    
    //Esborrar un taulell
    public boolean esbTaulells(String nom_usr, String id){
    	boolean fet = false;
    	File ids =  new File("Taulells/" + nom_usr + "/" + id);
    	if(ids.exists()) deleteFolder(ids);
    	fet = true;
    	return fet;
    }
    
    private static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if(files!=null) { 
            for(File f: files) {
                if(f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
    
    public boolean modTaulellUsr(String act, String nou){
    	boolean fet = false;
    	File ids =  new File("Taulells/" + act);
    	if(ids.exists()){
    		File ids2 =  new File("Taulells/" + nou);
    		ids.renameTo(ids2);
    	}
    	fet = true;
    	return fet;
    }
   }