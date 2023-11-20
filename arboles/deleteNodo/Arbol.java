class nodoA{
    int data;
    nodoA izquierdo;
    nodoA derecho;
    nodoA padre;
    
    nodoA(int dato){
        this.data = dato;
    }

    boolean esHoja(){
        return this.izquierdo == null && this.derecho == null;
    }

    nodoA max(){
        if(derecho != null && !derecho.esHoja()){
            return derecho.max();
        }else
        return this;
    }

}

class Arbol{
    nodoA raiz;
    
    Arbol(){    
        raiz = null;
    }

    boolean esVacio(){
        return raiz == null;
    }

    boolean esHoja(int d){
        return esHojas(this.raiz, d);
    }

    boolean esHojas(nodoA es, int d){
        if(es != null){
            if(es.data == d){
                return es.izquierdo == null && es.derecho == null;
            }
            if(es.data > d && es.izquierdo != null){
                esHojas(es.izquierdo, d);
            }
            if(es.data < d && es.derecho != null){
                esHojas(es.derecho, d);
            }
        }
        return false;
    }

    boolean isHoja(int i){
        nodoA aux = this.raiz;
        if(esVacio()){ return false;}
        while(aux.data != i){
            if(aux.data < i) aux = aux.derecho;
            if(aux == null){ return false;}
            if(aux.data > i) aux = aux.izquierdo;
            if(aux == null){ return false;}
        }
        if(aux.derecho == null && aux.izquierdo == null){
            return true;
        }else 
            return false;
    }
    
    void add(int dato){
        nodoA n = new nodoA(dato);
        if(raiz == null){
            raiz = n;
            n.padre = null;
        }else
            addTree(this.raiz, n);
    }
    
    void addTree(nodoA raizA, nodoA n){
        if(n.data < raizA.data){
            if(raizA.izquierdo == null){
                raizA.izquierdo = n;
                n.padre = raizA;
            }else{
                addTree(raizA.izquierdo, n);
            }
        }else{
            if(raizA.derecho == null){
                raizA.derecho = n;
                n.padre = raizA;
            }else{
                addTree(raizA.derecho, n);
            }
        }
    }
    
    void eliminar(int in){
        if(!esVacio()){
            delete(this.raiz, in);
        }
    }

    void delete (nodoA raizA, int in){
        if(raiz != null){
            if(in == raizA.data){
                deleteIN(raizA);
            }else if(in < raizA.data && raizA.izquierdo != null){
                delete(raizA.izquierdo, in);
            }else if(in > raizA.data && raizA.derecho != null){
                delete(raizA.derecho, in);
            }
        }
    }

    void deleteIN(nodoA n){
        if(n.izquierdo != null && n.derecho != null){ //eliminar con 2 hijos
            nodoA max = n.izquierdo.max();
            n.data = max.data;
            deleteIN(max);
        }else if (n.izquierdo != null || n.derecho != null) { //eliminar con 1 hijo
            nodoA remp = n.izquierdo != null ? n.izquierdo : n.derecho;
            n.data = remp.data;
            n.izquierdo = remp.izquierdo;
            n.derecho = remp.derecho;
            if(remp.izquierdo != null) remp.izquierdo.padre =  n;
            if(remp.derecho != null) remp.derecho.padre =  n;
        }else{ //eliminar con 0 hijos
            if (n.padre != null) {
                if(n == n.padre.izquierdo) n.padre.izquierdo = null;
                if(n == n.padre.derecho) n.padre.derecho = null;
                n.padre = null;
            }
            n = null;
        }

    }

    void showIn(){
        nodoA r = this.raiz;
        mostrarInOrder(r);
        System.out.println();
    }
    
    void showPre(){
        nodoA r = this.raiz;
        mostrarPreOrder(r);
        System.out.println();
    }

    void showPos(){
        nodoA r = this.raiz;
        mostrarPosOrder(r);
        System.out.println();
    }

    void mostrarInOrder(nodoA root){
        if(root == null){
            return;
        }else{
            mostrarInOrder(root.izquierdo);
            System.out.print(root.data+" ");
            mostrarInOrder(root.derecho);
        }
    }

    void mostrarPreOrder(nodoA root){
        if(root == null){
            return;
        }else{  
            System.out.println(root.data+" ");
            mostrarPreOrder(root.izquierdo);
            mostrarPreOrder(root.derecho);
        }
    }

    void mostrarPosOrder(nodoA root){
        if(root == null){
            return;
        }else{
            mostrarPosOrder(root.izquierdo);
            mostrarPosOrder(root.derecho);
            System.out.println(root.data+" ");
        }
    }
    
}