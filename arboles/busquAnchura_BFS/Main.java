public class Main {
    public static void main(String[] args) {
        arbol a1 = new arbol();
        a1.add(5);
        a1.add(8);
        a1.add(2);
        a1.add(1);
        a1.add(6);
        a1.add(4);
        a1.add(7);
        a1.add(10);

        bfs(a1);

    }

    static void bfs(arbol a1){
        cola c1 = new cola();
        nodoa aux = a1.raiz;
        c1.formar(aux);
        while(c1.size != 0){
            System.out.print(c1.inicio.dato.data+" ");
            if(aux.izquierdo != null) {
                c1.formar(aux.izquierdo);
            }
            if(aux.derecho != null) {
                c1.formar(aux.derecho);
            }
            c1.sacar();
            if(c1.inicio == null){
                break;
            }
            aux = c1.inicio.dato;
        }
        System.out.println();
    }
}

class nodo{
    nodoa dato;
    nodo siguiente;

    nodo(nodoa dato){
        this.dato = dato;
    }
}

class cola{
    nodo inicio;
    nodo ultimo;
    int size = 0;
    
    cola(){
        inicio = null;
        ultimo = null;
    }

    void formar(nodoa i){
        nodo n = new nodo(i);
        if(inicio == null && ultimo == null){
            inicio = n;
            size++;
        }else{
            if(ultimo == null){
                inicio.siguiente = n;
                ultimo = n;
                size++;
            }else{
                ultimo.siguiente = n;
                ultimo = n;
                size++;    
            }
        }
    }

    nodo sacar(){
        nodo out = this.inicio;
        if(inicio != null){
            inicio = inicio.siguiente;
            out.siguiente = null;
            size--;
        }
        return out;
    }

}