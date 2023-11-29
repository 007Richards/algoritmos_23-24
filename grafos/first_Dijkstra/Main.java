import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int nodos = entrada.nextInt();
        int[][] matAdy = llenado(nodos);
        int origen = entrada.nextInt(); int destino = entrada.nextInt();

        dijkstra(origen, destino, matAdy);
    }

    static void dijkstra(int o, int d, int[][] ady){
        int nodos = ady.length;
        ColaP temp = new ColaP();
        boolean[] visitd = new boolean[nodos];
        int[] pfinal = new int[nodos];
        int[] prev = new int[nodos];

        for (int i = 0; i < pfinal.length; i++) {
            pfinal[i] = Integer.MAX_VALUE;
        }

        temp.push(new nodo(o, 0));
        pfinal[o] = 0;

        while (!temp.isempty()) {
            nodo actual = temp.pop();
            if(!visitd[actual.node]){
                visitd[actual.node] = true;
                for (int i = 0; i < ady[actual.node].length; i++) {
                    int adyacente = i + 1;
                    int peso = ady[actual.node][adyacente];
                    if(!visitd[adyacente]){
                        if (pfinal[adyacente] > pfinal[actual.node] + peso) {
                            pfinal[adyacente] = pfinal[actual.node] + peso;
                            prev[adyacente] = actual.node;
                            temp.push(new nodo(adyacente, pfinal[adyacente]));
                        }
                    }
                }
            }
        }
    }

    static int[][] llenado(int nodos){
        int aristas = entrada.nextInt();
        int[][] Ady = new int[nodos + 1][nodos + 1];
        for (int i = 1; i < Ady.length; i++) {
            for (int j = 1; j < Ady.length; j++) {
                Ady[i][j] = Integer.MAX_VALUE;           //todos los valores de la matriz estan en infinito
            }
        }

        for (int i = 0; i < aristas; i++) {           // llenada la matriz con los pesos correspondientes
            int origen = entrada.nextInt();
            int destino = entrada.nextInt();
            int peso = entrada.nextInt();
            Ady[origen][destino] = peso;
        }
        return Ady;
    }

}


class nodo {
    int node;
    int costo;
    nodo siguiente;

    nodo(int dato, int costo) {
        this.node = dato;
        this.costo = costo;
    }

    nodo addOrden(nodo n) {
        if (n.costo <= this.costo) {
            n.siguiente = this;
            return n;
        } else if (this.siguiente != null)
            this.siguiente = this.siguiente.addOrden(n);
        return this;
    }

}

class ColaP {
    nodo inicio;

    ColaP() {
        inicio = null;
    }

    boolean isempty(){
        return inicio != null;
    }

    void push(nodo n) {
        if (inicio != null)
            inicio.addOrden(n);
        else
            inicio = n;
    }

    nodo pop() {
        nodo t = inicio;
        if (inicio != null) {
            inicio = inicio.siguiente;
            t.siguiente = null;
        }
        return t;
    }
}