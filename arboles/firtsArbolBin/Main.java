class nodo{
    int dato;
    nodo izquierdo;
    nodo derecho;
    
    nodo(int dato){
        this.dato = dato;
    }
}

class arbol{
    nodo raiz;
    int niveles = 0;
    
    arbol(){
        raiz = null;
    }
    
    void add(int dato){
        nodo n = new nodo(dato);
        if(raiz == null){
            raiz = n;
            niveles++;
        }else
            addTree(this.raiz, n);
            niveles++;
    }
    
    void addTree(nodo raiz, nodo n){
        if(n.dato < raiz.dato){
            if(raiz.izquierdo == null){
                raiz.izquierdo = n;
            }else{
                addTree(raiz.izquierdo, n);
            }
        }else{
            if(raiz.derecho == null){
                raiz.derecho = n;
            }else{
                addTree(raiz.derecho, n);
            }
        }
    }
    
    void show(){
        nodo r = this.raiz;
        mostrarInOrder(r);
    }
    
    void mostrarInOrder(nodo root){
        if(root == null){
            return;
        }else{
            mostrarInOrder(root.izquierdo);
            System.out.println(root.dato);
            mostrarInOrder(root.derecho);
        }
    }

    void mostrarPreOrder(nodo root){
        if(root == null){
            return;
        }else{
            System.out.println(root.dato);
            mostrarPreOrder(root.izquierdo);
            mostrarPreOrder(root.derecho);
        }
    }

    void mostrarPosOrder(nodo root){
        if(root == null){
            return;
        }else{
            mostrarPosOrder(root.izquierdo);
            mostrarPosOrder(root.derecho);
            System.out.println(root.dato);
        }
    }
    
    int altura(){
        nodo i = this.raiz;
        nodo j = this.raiz;
        int izq = 0;
        int der = 0;
        if(raiz == null){
            return 0;
        }
        while(i != null){
            i = i.izquierdo;
            izq++;
        }
        while(j != null){
            j = j.derecho;
            der++;
        }
        if(izq < der){
            return der;
        }else{
            return izq;
        }
    }
    
}


class Main{
    public static void main(String[] args){
        arbol a = new arbol();
        a.add(5);
        a.add(8);
        a.add(2);
        a.add(1);
        a.add(6);
        a.add(4);
        a.add(7);
        
        a.show();
        
        System.out.println();
        int s = a.altura();
        System.out.println(s);
    }
}
