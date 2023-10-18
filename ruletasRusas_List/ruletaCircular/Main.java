import java.util.Scanner;

class nodo{
    int dato;
    nodo siguiente;


    nodo(int dato){
        this.dato = dato;
    }
    
    void print(){
        System.out.println(this);
        if(this.siguiente != null)
            siguiente.print();
    }

    void agregarNodo(nodo n){
        if(this.siguiente == null)
            this.siguiente = n;
            //indicar puntero al inicio de la lista
        else
            this.siguiente.agregarNodo(n);
    }

    void eliminarInd(int i){

    }
}

class ListaC{
    nodo inicio;
    nodo ulitmo;

    ListaC(nodo inicio){
    this.inicio = inicio;
    }

    ListaC(){
    }

    void print(){
        inicio.print();
    }

    void agregarNodo(nodo n){
        if(inicio != null)
            inicio.agregarNodo(n);
        else
            inicio = n;
    }
}

class Main{
    public static void main(String[] args){
        ListaC l = new ListaC();
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        int m = entrada.nextInt();

        for(int i=1; i <= n; i ++){
            l.agregarNodo(new nodo(i));
        }

    }
}
