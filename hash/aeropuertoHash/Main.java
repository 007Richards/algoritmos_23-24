/* Date: 07/Nov/2023
   Autor: Ricardo Fabian Zuniga
   Indicacion: Crear una tabla hash para controlar las peticiones de entradas y salidas de un aeropuerto.
*/

import java.util.Scanner;  

class Main{

    static void insertar(Lista[] list, int a){
        int ind = hash(list, a);
        if(list[ind].longitud == 0){
            list[ind].addFinal(a);
        }else{
            int posmin = 0;
            for (int i = 0; i < list.length; i++) {
                if(list[i].longitud < list[posmin].longitud){
                    posmin = i;
                }
            }
            list[posmin].addFinal(a);
        }
    }

    static int hash(Lista[] l, int i){
        int ind = Math.abs(i) % l.length;
        return ind;
    }

    static void sacar(Lista[] list, int p){
        if(list[p-1].inicio == null){
        }else{
            list[p-1].sacar();
        }
    }

    static void imprimir(Lista[] list){
        for (int i = 0; i < list.length; i++) {
            System.out.print((i + 1)+"->");
            list[i].imprimir();
        }
    }

    public static void main (String[]arg){
        Scanner entrada = new Scanner(System.in); 
        int n = entrada.nextInt();//numero de instrucciones
        int m = entrada.nextInt();// numero de pistas
        Lista[] list = new Lista[m];
        for (int i = 0; i < list.length; i++){
            list[i] = new Lista();
        }
        int i = 0;
        do{
            String s = entrada.next();
            int a = entrada.nextInt();
            switch(s){
                case "e":
                    insertar(list, a);
                    break;
                case "s":
                    sacar(list, a);
                    break;
                default:
                    break;
            }
            i++;
        }while(i < n);
        entrada.close();

        imprimir(list);
    }
}

class nodo{
    int dato;
    nodo siguiente;

    nodo(int  dato){
        this.dato = dato;
    }
}

class Lista{
    nodo inicio;
    nodo ultimo;
    int longitud = 0;

    Lista(){
        this.inicio = null;
        this.ultimo = null;
    }

    void imprimir(){
        if(this.inicio == null){
            System.out.println(0);
        }else{
            nodo temp = this.inicio;
            while(temp != null) {
                System.out.print(temp.dato+", ");
                temp = temp.siguiente;
            }
            System.out.println();
        }
    }

    void addFinal(int i){
        nodo n = new nodo(i);
        if(inicio == null){
            inicio = n;
            ultimo = inicio;
            longitud ++;
        }
        else{
            ultimo.siguiente = n;
            ultimo = n;
            longitud ++;
        }
    }
    
    void sacar(){
        if(this.inicio == null){
        }else{
            nodo t = this.inicio;
            inicio = inicio.siguiente;
            t.siguiente = null;
            longitud --;
        }
    }

}