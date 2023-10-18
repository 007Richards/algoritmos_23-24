public class Pila {
    nodo inicio;

    Pila(nodo n){
        inicio = n;
    }
    void push(nodo n){
        n.sig = inicio;
        inicio = n;
    }

    nodo pop(){
        nodo n = inicio;
        if(inicio != null)
        inicio = inicio.sig;
        n.sig = null;
    return n;
    }

    void print(){
        if(inicio != null)
            inicio.print();
        System.out.println();
    }

    public static void main(String[] args){
        Pila P = new Pila(new nodo(1));
        P.push(new nodo(2));
        P.push(new nodo(3));
        P.push(new nodo(4));
        P.push(new nodo(5));

        P.print();
        P.pop();
        P.print();
        nodo m = P.pop();
        System.out.println(m+"\n");
        P.print();
    }
    
}
