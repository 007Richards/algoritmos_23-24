import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Solucion por matriz de adyacencia
 *
 * @author GUERRERO
 *
 */
public class prueba {

    private static int matrix[][];
    private static int maxvertices;
    private static int maxaristas;
    private static int aristas;

    /**
     * Cramos en grafo
     *
     * @param nVertices
     * @param nAristas
     */
    public static void crearGrafo(int nVertices, int nAristas) {
        maxvertices = nVertices;
        maxaristas = nAristas;
        aristas = 0;
        matrix = new int[maxvertices][maxvertices];
    }

    /**
     * Insertar arista
     *
     * @param v1
     *             vertice 1
     * @param v2
     *             vertice 2
     * @param dist
     *             distancia entre cada vertice
     */
    public static void insertaArista(int v1, int v2, int dist) {
        if (v1 >= maxvertices || v2 >= maxvertices) {
            throw new ArrayIndexOutOfBoundsException(
                    "Vertices inválidos, fuera de rango" + "nRango de vertices: 0 - " + (maxvertices - 1));
        } else if (aristas == maxaristas) {
            throw new UnsupportedOperationException("No se puede añadir más aristas");
        } else {
            matrix[v1][v2] = dist;
            matrix[v2][v1] = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp[] = br.readLine().split(" ");
        int vertices = Integer.parseInt(temp[0]);
        int aristas = Integer.parseInt(temp[1]);
        // crea el grafo y lo llena
        crearGrafo(vertices, aristas);
        for (int i = 0; i < vertices; i++) {
            String temp2[] = br.readLine().split(" ");
            insertaArista(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]));
        }

        // en este caso calcula la distancia minima entre el nodo 0 y el 2
        System.out.println(dijkistra(0)[2]);
    }

    /**
     * Calcula la distancia mas corta.
     * 
     * @param inicio nodo desde donde se va a iniciar.
     * @return
     */
    public static int[] dijkistra(int inicio) {
        int[] distancia = new int[maxvertices];
        int[] padre = new int[maxvertices];
        boolean[] visto = new boolean[maxvertices];
        for (int i = 0; i < maxvertices; i++) {
            distancia[i] = 1200000000;
            padre[i] = -1;
            visto[i] = false;
        }
        distancia[inicio] = 0;
        PriorityQueue<Integer> pila = new PriorityQueue<>();
        pila.add(distancia[inicio]);
        while (!pila.isEmpty()) {
            int u = pila.poll();
            visto[u] = true;
            for (int i = 0; i < maxvertices; i++) {
                if (matrix[u][i] != 0) {
                    // aqui es donde se debe tratar de editar para que nos incluya el parametro gas
                    // que es un arreglo de strings
                    if (distancia[i] > distancia[u] + matrix[u][i]) {
                        distancia[i] = distancia[u] + matrix[u][i];
                        padre[i] = u;
                        pila.add(i);
                    }
                }
            }
        }
        return distancia;
    }

}