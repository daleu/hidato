

public class Pair<int,int> {
    private int fila;
    private int columna;

    public Pair(int fila, int columna) {
    	super();
    	this.fila = fila;
    	this.columna = columna;
    }

    public int hashCode() {
    	int hashfila = fila != null ? fila.hashCode() : 0;
    	int hashcolumna = columna != null ? columna.hashCode() : 0;

    	return (hashfila + hashcolumna) * hashcolumna + hashfila;
    }

    public boolean equals(Object other) {
    	if (other instanceof Pair) {
    		Pair otherPair = (Pair) other;
    		return 
    		((  this.fila == otherPair.fila ||
    			( this.fila != null && otherPair.fila != null &&
    			  this.fila.equals(otherPair.fila))) &&
    		 (	this.columna == otherPair.columna ||
    			( this.columna != null && otherPair.columna != null &&
    			  this.columna.equals(otherPair.columna))) );
    	}

    	return false;
    }

    public String toString()
    { 
           return "(" + fila + ", " + columna + ")"; 
    }

    public int getFila() {
    	return fila;
    }

    public void setFila(int fila) {
    	this.fila = fila;
    }

    public int getColumna() {
    	return columna;
    }

    public void setColumna(int columna) {
    	this.columna = columna;
    }
}