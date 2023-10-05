/* Date: 04/10/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Ordena una matriz de enteros con la logica de bubble sort  
*/

import java.util.Scanner;

public class SortMatriz {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n, m;
        System.out.println("Dimenciones:");
        n = entrada.nextInt();
        m = entrada.nextInt();

        int[][] matriz = new int[n][m];
        System.out.println("Dato:");
        for (int l = 0; l < n; l++) {
            for (int i = 0; i < m; i++) {
                matriz[l][i] = entrada.nextInt();
            }
        }
  
        ordenaBubble(matriz);        

        for (int l = 0; l < n; l++) {
            for (int i = 0; i < m; i++) {
                System.out.print(matriz[l][i]+ "  ");
            }
            System.out.println();
        }

        entrada.close();
    }

    public static void ordenaBubble(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        for (int l = 0; l < n; l++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (a[l][i] < a[j][k]) {
                            int aux = a[l][i];
                            a[l][i] = a[j][k]; 
                            a[j][k] = aux;
                        }
                    }
                }
                
            }
        }
    }

    //revisar esta seccion dont works
    public static void ordenaSelection(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        for (int l = 0; l < n; l++) {
            for (int i = 0; i < m; i++) {
                int x = l, y = i;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (a[x][y] < a[j][k]) {
                            x = j;
                            y = k;
                        }
                    }
                }
                int aux = a[x][y];
                a[x][y] = a[l][i]; 
                a[l][i] = aux;
            }
        }
    }
}