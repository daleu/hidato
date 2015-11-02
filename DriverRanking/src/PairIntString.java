

public class PairIntString {
	   private Integer puntuacio;
	   private String usuari;
	
	
	   public PairIntString(Integer puntuacio, String usuari){
	     this.puntuacio = puntuacio;
	     this.usuari = usuari;
	   }
	
	   public void setFirst(Integer puntuacio){
	    this.puntuacio = puntuacio;
	   }
	
	   public void setSecond(String usuari) {
	     this.usuari = usuari;
	   }
	
	   public Integer getFirst() {
	     return this.puntuacio;
	   }
	
	   public String getSecond() {
	     return this.usuari;
	   }
	
	   public boolean equals(Object o) {
	        if (o instanceof PairIntString) {
	                PairIntString originalp = (PairIntString) o;
	                return
	                ((  this.puntuacio == originalp.puntuacio ||
	                        ( this.puntuacio != null && originalp.puntuacio != null &&
	                          this.puntuacio.equals(originalp.puntuacio))) &&
	                 (      this.usuari == originalp.usuari ||
	                        ( this.usuari != null && originalp.usuari != null &&
	                          this.usuari.equals(originalp.usuari))) );
	        }
	
	        return false;
	    }
}