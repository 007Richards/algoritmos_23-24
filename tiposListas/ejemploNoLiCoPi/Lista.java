public class Lista {
    nodo inicio;

    void addOrden(nodo n){
        if(inicio != null)
            inicio = inicio.addOrden(n);
        else
            inicio = n;
    }
    Lista(nodo n){
        inicio = n;
    }

    void print(){
        inicio.print();
    }

    public static void main(String[] args){
        Lista L = new Lista(new nodo(4));
        L.addOrden(new nodo(3));
        L.addOrden(new nodo(1));
        L.addOrden(new nodo(2));
        L.print();
    }
}
