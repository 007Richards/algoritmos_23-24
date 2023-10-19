import java.util.Scanner;

class nodo {
    int dato;
    nodo siguiente;

    nodo(int dato) {
        this.dato = dato;
    }

}

class ListaC {
    nodo inicio;
    nodo ultimo;
    int longitud = 0;

    ListaC() {
        inicio = null;
        ultimo = null;
    }

    void print() {
        nodo temp = inicio;
        for (int i = 0; i < longitud; i++) {
            System.out.println(temp.dato);
            temp = temp.siguiente;
        }
    }

    void agregarNodo(nodo n) {
        if (inicio == null) {
            inicio = n;
            ultimo = inicio;
            inicio.siguiente = ultimo;
            longitud++;
        } else {
            ultimo.siguiente = n;
            n.siguiente = inicio;
            ultimo = n;
            longitud++;
        }
    }

    nodo ruleta(int v) {
        nodo ind = inicio;
        while (longitud != 1) {
            for (int i = 1; i < (v - 1); i++) {
                ind = ind.siguiente;
            }
            nodo next = ind.siguiente.siguiente;
            nodo out = ind.siguiente;
            ind.siguiente = next;
            // System.out.println("\n"+out.dato+"\n");
            out.siguiente = null;
            ind = next;
            longitud--;
        }
        return ind;
    }

}

class Main {
    public static void main(String[] args) {
        ListaC l = new ListaC();
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        int m = entrada.nextInt();
        entrada.close();

        for (int i = 1; i <= n; i++) {
            l.agregarNodo(new nodo(i));
        }
        // System.out.println();
        // l.print();
        // System.out.println();
        nodo ganador = l.ruleta(m);
        System.out.println(ganador.dato);

    }
}
