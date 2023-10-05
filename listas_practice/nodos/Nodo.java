public class Nodo{
    Object valor;
    Nodo siguiente;

    public Nodo(Object valor){
        this.valor = valor;
        this.siguiente = null;
    }

    public Object obtenerValor(){
        return this.valor;
    }

    public void enlazarSiguinete(Nodo n){
        siguiente = n;
    }

    public Nodo obtenerSiguiente(){
        return siguiente;
    }
}   