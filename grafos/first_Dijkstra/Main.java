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
1 7
 */
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int nodos = entrada.nextInt();
        int[][] matAdy = llenado(nodos);
        int origen = entrada.nextInt(); int destino = entrada.nextInt();
        
        dijkstra(origen, destino, matAdy);
    }

    static int[][] llenado(int nodos){
        int aristas = entrada.nextInt();
        int[][] Ady = new int[nodos + 1][nodos + 1];
        for (int i = 0; i < Ady.length; i++) {
            for (int j = 0; j < Ady.length; j++) {
                Ady[i][j] = max;           //todos los valores de la matriz estan en infinito
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

    static void dijkstra(int o, int d, int[][] ady){
        int nodos = ady.length;
        ColaP temp = new ColaP();
        boolean[] visitd = new boolean[nodos];
        int[] pfinal = new int[nodos];
        int[] prev = new int[nodos];

        for (int i = 0; i < pfinal.length; i++) {
           pfinal[i] = max;
        }

        temp.push(new nodo(o, 0));
        pfinal[o] = 0;

        while (temp.isempty()) {
            nodo actual = temp.pop();
            if(!visitd[actual.node]){
                visitd[actual.node] = true;
                for (int i = 1; i < ady[actual.node].length; i++) {
                    int adyacente = i;
                    int peso = ady[actual.node][adyacente];
                    if(!visitd[adyacente]  && ady[actual.node][adyacente] != max){
                        if (pfinal[adyacente] > pfinal[actual.node] + peso) {
                            pfinal[adyacente] = pfinal[actual.node] + peso;
                            prev[adyacente] = actual.node;
                            temp.push(new nodo(adyacente, pfinal[adyacente]));
                        }
                    }
                }
            }
        }
        for (int i = 1; i < pfinal.length; i++) {
            System.out.println("Para el nodo :"+i+" el camino mas corto es: "+pfinal[i]);
        }
        System.out.println("\nEl camino para llegar de: "+o+" hasta: "+d+" es:");
        int aux = d;

        while(aux != o){
            System.out.print(aux+"->");
            aux = prev[aux];
        }
        System.out.println(o+".");
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

}

class ColaP {
    nodo inicio;
    int size = 0;

    ColaP() {
        inicio = null;
    }

    boolean isempty(){
        return inicio != null;
    }

    void push(nodo n) {
        nodo temp = inicio;
        if (inicio == null) {
            inicio = n;
            size++;
        }else if(size == 1){
            if(n.costo <= inicio.costo){
                n.siguiente = inicio;
                inicio = n;
            }else inicio.siguiente = n;
            size++;
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
            size++;
        }
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