class nodo {
    int dato;
    nodo siguiente;

    nodo(int dato) {
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

    void addFin(nodo n) {
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

    void addInicio(nodo n) {
        if (inicio == null) {
            inicio = n;
            ultimo = inicio;
            longitud++;
        } else {
            n.siguiente = inicio;
            inicio = n;
            longitud++;
        }
    }
}


class main{
    public static void main (String[] args){
    Lista l = new Lista();
    for(int i = 10; i > 0; i--){
        l.addFin(new nodo(i));
    }
    //l.print();
    
    //mergeSort(l);
    //l.print();

    Lista l1 = new Lista();
    Lista l2 = new Lista();
    Lista l3 = new Lista();

    for(int i = 10; i >= 6; i--){
        l2.addFin(new nodo(i));
    }
    for(int i = 5; i >= 1; i--){
        l3.addFin(new nodo(i));
    }

    merge(l1, l2, l3);
    l1.print();
    }

    public static void mergeSort(Lista l1){
        if(l1.longitud < 2){
            return;
        }
        
        Lista l2 = new Lista();
        Lista l3 = new Lista();

        dividir(l1, l2, l3);
        l2.print();

        l3.print();

        mergeSort(l2);
        mergeSort(l3);

        merge(l1, l2, l3);
        
    }

    public static void dividir(Lista l1, Lista l2, Lista l3){
        int full = l1.longitud;
        int mid = l1.longitud/2;
        nodo temp = l1.inicio;
        
        for(int i = 0; i < mid; i++){
            l2.addFin(temp);
            temp = temp.siguiente;    
        }
        for(int i = mid; i < full; i++){
            l3.addFin(temp);
            temp = temp.siguiente;
        }
    }
    
    public static void merge(Lista l1, Lista l2, Lista l3){
        nodo temp1 = l2.inicio;
        nodo temp2 = l3.inicio;
        
        while(temp1 != null && temp2 != null){
            if(temp1.dato <= temp2.dato || temp2 == null){
                l1.addFin(temp1);
                temp1 = temp1.siguiente;
            }else if(temp2.dato <= temp1.dato || temp1 == null){
                l1.addFin(temp2);
                temp2 = temp2.siguiente;
            }
        }
        while(temp1 != null){
            l1.addFin(temp1);
            temp1 = temp1.siguiente;
        }
        while(temp2 != null){
            l1.addFin(temp2);
            temp2 = temp2.siguiente;
        }
    }

    
}