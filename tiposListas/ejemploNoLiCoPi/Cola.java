public class Cola {
    nodo inicio;

    void formar(nodo n){
        if(inicio != null)
            inicio.addFinal(n);
        else
            inicio = n;        
    }

    nodo sacar(){
        nodo t = inicio;
        if(inicio != null){
            inicio = inicio.sig;
            t.sig = null;
        }
        return t;
    }

    void printRecursivo(){
        if(inicio != null)
            inicio.print();
        System.out.println();
    }

    void print(){
        nodo t = inicio;
        while(t != null){
            System.out.print(t.x+" ");
            t = t.sig;
        }
        System.out.println();
    }

    Cola(nodo n){
        inicio = n;
    }

    public static void main(String[] args){
        Cola C = new Cola(new nodo(1));
        C.formar(new nodo(2));
        C.formar(new nodo(3));
        C.formar(new nodo(4));
        C.formar(new nodo(5));
        C.print();
        C.sacar();
        C.printRecursivo();
        nodo s = C.sacar();
        System.out.println(s);
        C.print();
    }


}
