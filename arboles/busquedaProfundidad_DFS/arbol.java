class nodoa{
    int data;
    nodoa izquierdo;
    nodoa derecho;
    
    nodoa(int dato){
        this.data = dato;
    }
}

class arbol{
    nodoa raiz;
    int niveles = 0;
    
    arbol(){
        raiz = null;
    }
    
    void add(int dato){
        nodoa n = new nodoa(dato);
        if(raiz == null){
            raiz = n;
            niveles++;
        }else
            addTree(this.raiz, n);
            niveles++;
    }
    
    void addTree(nodoa raiz, nodoa n){
        if(n.data < raiz.data){
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
    
    void showIn(){
        nodoa r = this.raiz;
        mostrarInOrder(r);
    }
    
    void showPre(){
        nodoa r = this.raiz;
        mostrarPreOrder(r);
    }

    void showPos(){
        nodoa r = this.raiz;
        mostrarPosOrder(r);
    }

    void mostrarInOrder(nodoa root){
        if(root == null){
            return;
        }else{
            mostrarInOrder(root.izquierdo);
            System.out.println(root.data);
            mostrarInOrder(root.derecho);
        }
    }

    void mostrarPreOrder(nodoa root){
        if(root == null){
            return;
        }else{
            System.out.println(root.data);
            mostrarPreOrder(root.izquierdo);
            mostrarPreOrder(root.derecho);
        }
    }

    void mostrarPosOrder(nodoa root){
        if(root == null){
            return;
        }else{
            mostrarPosOrder(root.izquierdo);
            mostrarPosOrder(root.derecho);
            System.out.println(root.data);
        }
    }
    
    int altura(){
        nodoa i = this.raiz;
        nodoa j = this.raiz;
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