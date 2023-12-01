/*
ejempo de entrada:
7 11
1 2 3
1 3 4
2 5 8
2 4 9
3 4 8
3 6 7
4 5 3
4 7 5
4 6 3
5 7 2
6 7 6
 */
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int nodos = entrada.nextInt();
        Lista[] list = new Lista[(nodos/2)+2];
        ColaP cola = new ColaP();
        for (int i = 0; i <list.length; i++) {
            list[i] = new Lista();
        }
        int aris = entrada.nextInt();
        for (int i = 0; i < aris ; i++) {
            int origen = entrada.nextInt();
            int destino = entrada.nextInt();
            int peso = entrada.nextInt();
            cola.push(new nodo(origen, destino, peso));
        }
        kruskal(cola, list, nodos);

    }   
    
    static void kruskal(ColaP cola, Lista[] list, int nodos){
        int pesot = 0;
        int aristas = 1;
        
        while(aristas < nodos){
            nodo temp = cola.pop();
            int indA = find(list, temp.nodoA);
            int indB = find(list, temp.nodoB);

            if(indA == 0 && indB == 0){
                int m = findVacio(list);
                list[m].addFinal(temp.nodoA);
                list[m].addFinal(temp.nodoB);
                aristas ++;
                pesot += temp.costo;
                System.out.println("("+temp.nodoA+" , "+temp.nodoB+"): costo: "+temp.costo);
            }else if(indA == 0 || indB == 0){
                if(indA != 0) list[indA].addFinal(temp.nodoB);
                if(indB != 0) list[indB].addFinal(temp.nodoA);
                aristas ++;
                pesot += temp.costo;
                System.out.println("("+temp.nodoA+" , "+temp.nodoB+"): costo: "+temp.costo);
            }else if(indA != 0 && indB != 0 && indA != indB){
                list[indA].addLista(list[indB]);
                list[indB].vaciar();
                aristas ++;
                pesot += temp.costo;
                System.out.println("("+temp.nodoA+" , "+temp.nodoB+"): costo: "+temp.costo);
            }else if( indA == indB){
                //bucle
            }
        }
        System.out.println("Peso total: "+pesot);
        int x = findFull(list);
        list[x].print();

    }

    static int findFull(Lista[] l){
        for (int i = 1; i < l.length; i++) {
            if(!l[i].isempty()) return i;
        }
        return -1;
    }

    static int findVacio(Lista[] l){
        for (int i = 1; i < l.length; i++) {
            if(l[i].isempty()) return i;
        }
        return -1;
    }

    static int find(Lista[] l, int i){
        for (int j = 1; j < l.length; j++) {
            if (!l[j].isempty()) {
                if(l[j].find(i)) return j;
            }
        }
        return 0;
    }

}




class nodo {
    int nodoA;
    int nodoB;
    int costo;
    nodo siguiente;

    nodo(int nodoA, int nodoB, int costo) {
        this.nodoA = nodoA;
        this.nodoB = nodoB;
        this.costo = costo;
    }

}

class ColaP {
    nodo inicio;
    int size = 0;

    ColaP() {
        inicio = null;
    }

    boolean isempty(){
        return inicio == null;
    }

    void push(nodo n) {
        nodo temp = inicio;
        if (inicio == null) {
            inicio = n;
        }else if(size == 1){
            if(n.costo <= inicio.costo){
                n.siguiente = inicio;
                inicio = n;
            }else inicio.siguiente = n;
        }else {
            while (temp != null) {
                if (temp.siguiente == null) {
                    temp.siguiente = n;
                    break;
                }else if (n.costo <= inicio.costo) {
                    n.siguiente = inicio;
                    inicio = n;
                    break;
                } else if(n.costo <= temp.siguiente.costo){
                    n.siguiente = temp.siguiente;
                    temp.siguiente = n;
                    break;
                }
                temp = temp.siguiente;
            }
        }
        size++;
    }

    nodo pop() {
        nodo t = inicio;
        if (inicio != null) {
            inicio = inicio.siguiente;
            t.siguiente = null;
        }
        size--;
        return t;
    }
}


class nodoL {
    int dato;
    nodoL siguiente;

    nodoL(int dato) {
        this.dato = dato;
    }

}

class Lista {
    nodoL inicio;
    nodoL ultimo;
    int longitud = 0;

    Lista() {
        inicio = null;
        ultimo = null;
    }

    boolean isempty(){
        return inicio == null;
    }

    boolean find(int i){
        nodoL temp = inicio;

        for (int j = 0; j < longitud; j++) {
            if(temp != null){
                if (temp.dato == i) {
                    return true;                
                }
            }
            temp = temp.siguiente;
        }
        return false;
    }

    void print() {
        nodoL temp = this.inicio;
        for (int i = 0; i < longitud; i++) {
            System.out.print(temp.dato+" ");
            temp = temp.siguiente;
        }
        System.out.println();
    }

    void addFinal(int i) {
        nodoL n = new nodoL(i);
        if (inicio == null) {
            inicio = n;
            ultimo = inicio;
            inicio.siguiente = ultimo;
            longitud++;
        } else {
            ultimo.siguiente = n;
            ultimo = n;
            longitud++;
        }
    }
    void addLista(Lista l){
        if(longitud != 0){
            nodoL aux = l.inicio;
            for (int i = 0; i < l.longitud; i++) {
                this.addFinal(aux.dato);
                aux =aux.siguiente;
            }
        }
    }

    void vaciar(){
        if(inicio != null){
            inicio.siguiente = null;
            ultimo = null;
            inicio = null; 
        }
        longitud = 0;
    }

    nodoL sacar() {
        nodoL t = inicio;
        if (inicio != null) {
            inicio = inicio.siguiente;
            t.siguiente = null;
        }
        longitud--;
        return t;
    }

}