public class Casilla {
   
   private Pair posicion;
   private boolean editable;
   private int valor;

   /* Constructora */
   
   public Casilla() {
	   Pair p = new Pair(-1,-1);
	   this.posicion = p;
	   this.editable = true;
	   this.valor = 0;
   }
   
   public Casilla(int columna, int fila, boolean editable, int valor) {
      this.posicion.setColumna(columna);
	  this.posicion.setFila(fila);
      this.editable = editable;
      this.valor = valor;
   }
   
   /* Modificadores */

   void setPosicion(int columna, int fila) {
      this.posicion.setColumna(columna);
	  this.posicion.setFila(fila);
   }
   
   void setFila(int fila) {
	  this.posicion.setFila(fila);
   }
   
   void setColumna(int columna) {
      this.posicion.setColumna(columna);
   }
   
   void setEditable(boolean editable) {
      this.editable = editable;
   }
   
   void setValor(int valor) {
      this.valor = valor;
   }
   
   /* Consultoras */

   Pair getPosicion() {
      return this.posicion;
   }
   
   int getFila() {
	  return this.posicion.getFila();
   }
   
   int getColumna() {
      return this.posicion.getColumna();
   }
   
   boolean getEditable() {
      return this.editable;
   }
   
   int getValor() {
      return this.valor;
   }
} 
