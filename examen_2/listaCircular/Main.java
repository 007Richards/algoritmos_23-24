import java.util.Scanner;

class nodo{
    int dato;
    nodo siguiente;
    nodo anterior;
    int length = 0;
    
    nodo(int dato){
        this.dato = dato;
    }

}

class ListaDC{
    nodo inicio;
    nodo ultimo;
    int longitud = 0;

    ListaDC(){
        inicio = null;
        ultimo = null;
    }

    void agregarfinal(nodo n){        
        if(inicio == null){
            inicio = n;
            inicio.siguiente = null;
            inicio.anterior = null;
            longitud++;
        }else{
            if(inicio.siguiente == null){
                inicio.siguiente = n;
                inicio.anterior = n;
                n.siguiente = inicio;
                n.anterior = inicio;
                ultimo = n;
                longitud++;
            }else{
                n.siguiente = inicio;
                n.anterior = ultimo; 
                ultimo.siguiente = n;
                inicio.anterior = n;
                ultimo = n;
                longitud++;
            }
        }
    }

    void ruleta(int[] direccion, int[] brincos) {
        nodo ind = inicio;
        int j = 0;
        while (j < direccion.length) {
            if(direccion[j] == 0){
                for (int i = 1; i < (brincos[j]); i++) {
                    ind = ind.siguiente;
                }
                nodo cambio = ind.siguiente;
                int q = ind.dato;
                int w = cambio.dato;
                ind.dato = w;
                cambio.dato = q;
                j++;
            }else{
                for (int i = 1; i < (brincos[j]); i++) {
                    ind = ind.anterior;
                }
                nodo cambio = ind.anterior;
                int q = ind.dato;
                int w = cambio.dato;
                ind.dato = w;
                cambio.dato = q;
                j++;
            }
        }

        for(int i = 0; i < longitud; i++){
            System.out.print(ind.dato+", ");
            ind = ind.siguiente;
        }
        System.out.println();
    }



}


class Main {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();// numero de nodos
        int m = entrada.nextInt();// numero de instrucciones
        int[] direccion = new int[m];
        int[] brincos = new int[m];
        
        int l = 0;
        while(l < m){
            direccion[l] = entrada.nextInt();
            brincos[l] = entrada.nextInt();
            l++;
        }
        entrada.close();
        
        ListaDC list = new ListaDC();
        for(int i = 1; i <= n; i++){
            list.agregarfinal(new nodo(i));
        }

        list.ruleta(direccion, brincos);

    }
}