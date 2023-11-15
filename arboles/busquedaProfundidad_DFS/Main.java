public class Main {
    public static void main(String[] args){
        arbol a1 = new arbol();
        a1.add(5);
        a1.add(8);
        a1.add(2);
        a1.add(1);
        a1.add(6);
        a1.add(4);
        a1.add(7);
        a1.add(10);

        dfs(a1);

    }

    static void dfs(arbol a1){
        pila p1 = new pila();
        nodoa aux = a1.raiz;
        p1.push(aux);
        while(p1.size != 0){
            System.out.print(p1.primero.dato.data+" ");
            if(aux.izquierdo != null) {
                p1.push(aux.izquierdo);
            }
            if(aux.derecho != null) {
                p1.push(aux.derecho);
            }
            p1.pop();
            if(p1.primero == null){
                break;
            }
            aux = p1.primero.dato;
        }
        System.out.println();
    }
    
}

class nodo{
    nodoa dato;
    nodo siguiente;

    nodo(nodoa dato){
        this.dato = dato;
    }

}

class pila{
    nodo primero;
    int size = 0;

    pila(){
        primero = null;
    }

    void push(nodoa i){
        nodo n = new nodo(i);
        if(primero == null){
            primero = n;
        }else{
            n.siguiente = primero;
            primero = n;
        }
        size++;
    }

    nodo pop(){
        nodo out = primero;
        if(primero == null){
        }else{
            primero = out.siguiente;
            out.siguiente = null;
        }
        size--;
        return out;
    }

}