
public class Casilla {
   
   private pair<int,int> posicion;
   private boolean editable;
   private int valor;

   /* Constructora */
   
   public Casilla() {
      this->posicion = pair<-1, -1>;
      this->editable = true;
      this->valor = 0;
   }
   
   public Casilla(int columna, int fila, boolean editable, int valor) {
      this->posicion = pair<columna, fila>;
      this->editable = editable;
      this->valor = valor;
   }
   
   /* Modificadores */

   void setPosicion(int columna, int fila) {
      this->posicion = pair<columna, fila>;
   }
   
   void setEditable(boolean editable) {
      this->editable = editable;
   }
   
   void setValor(int valor) {
      this->valor = valor;
   }
   
   /* Consultoras */

   pair<int,int> getPosicion() {
      return this->posicion;
   }
   
   boolean getEditable() {
      return this->editable;
   }
   
   int getValor() {
      return this->valor;
   }
} 
