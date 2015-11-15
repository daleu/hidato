import java.util.Objects;

public class Pair {
    private int fila;
    private int columna;

    public Pair(int fila, int columna) {
    	super();
    	this.fila = fila;
    	this.columna = columna;
    }

    public int hashCode() {
    	return Objects.hash(fila, columna);
    }

    public boolean equals(Object other) {
    	if(other == this) return true;
    	
    	if (other instanceof Pair) {
    		Pair otherPair = (Pair) other;
    		
    		return (Objects.equals(columna, otherPair.columna) && Objects.equals(fila, otherPair.fila));
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