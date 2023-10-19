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

    void print(){
        if(inicio.siguiente == null)
            System.out.println(inicio.dato);
        else{
            nodo tem = inicio;
            for(int i = 0; i < longitud; i++){
                System.out.println(tem.dato);
                tem = tem.siguiente;
            }
        }
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

    nodo ruleta(int v, int[] direccion) {
        nodo ind = inicio;
        int j = 0;
        while (longitud != 1) {
            if(direccion[j] == 0){
                for (int i = 1; i < (v - 1); i++) {
                    ind = ind.siguiente;
                }
                nodo next = ind.siguiente.siguiente;
                nodo out = ind.siguiente;
                ind.siguiente = next;
                next.anterior = ind;
                //System.out.println("\n"+out.dato+"\n");
                out.siguiente = null;
                out.anterior = null;
                ind = next;
                longitud--;
                j++;
            }else{
                for (int i = 1; i < (v - 1); i++) {
                    ind = ind.anterior;
                }
                nodo next = ind.anterior.anterior;
                nodo out = ind.anterior;
                ind.anterior = next;
                next.siguiente = ind;
                //System.out.println("\n"+out.dato+"\n");
                out.anterior = null;
                out.siguiente = null;
                ind = next;
                longitud--;
                j++;
            }
        }
        return ind;
    }



}


class Main {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        int m = entrada.nextInt();
        int[] direccion = new int[n-1];
        for(int i = 0; i < direccion.length; i++){
            direccion[i] = entrada.nextInt();
        }
        entrada.close();
        
        ListaDC l = new ListaDC();
        for(int i = 1; i <= n; i++){
            l.agregarfinal(new nodo(i));
        }

        //System.out.println();
        //l.print();
        //System.out.println();

        nodo ganador = l.ruleta(m, direccion);
        System.out.println(ganador.dato);

    }
}