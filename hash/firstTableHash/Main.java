public class Main {
    static int size = 13;

    static int hash(int i){
        int ind = Math.abs(i) % size;
        return ind;
    }    

    static void insertar(String s, Lista[] list){
        int r = 0;
        for(int i = 0; i < s.length(); i++){
            int t = s.charAt(i);
            r = r + t;
        }
        int ind = hash(r);

        if(list[ind] == null){
            list[ind] = new Lista();
            list[ind].addFinal(s);
        }else
            list[ind].addFinal(s);
    }

    static void imprimir(Lista[] l){
        for (int i = 0; i < l.length; i++) {
            if(l[i] == null){
            }else
                l[i].print();
        }
    }

    public static void main(String[] args){
        Lista[] list = new Lista[size];

        insertar("hola", list);
        insertar("mundo", list);
        insertar("screem", list);
        insertar("laho", list);
        insertar("modun", list);

        imprimir(list);

    }
    

}









class nodo {
    String dato;
    nodo siguiente;

    nodo(String dato) {
        this.dato = dato;
    }

}

class Lista {
    nodo inicio;
    nodo ultimo;
    int longitud = 0;

    Lista() {
        inicio = null;
        ultimo = null;
    }

    void print() {
        nodo temp = inicio;
        for (int i = 0; i < longitud; i++) {
            System.out.print(temp.dato+" ");
            temp = temp.siguiente;
        }
        System.out.println();
    }

    void addFinal(String i) {
        nodo n = new nodo(i);
        if (inicio == null) {
            inicio = n;
            ultimo = inicio;
            longitud++;
        } else {
            ultimo.siguiente = n;
            ultimo = n;
            longitud++;
        }
    }

}