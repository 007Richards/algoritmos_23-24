class nodo {
    int x;
    nodo sig;

    nodo(int x){
        this.x = x;
    }

    nodo(int x, nodo sig){
        this.x = x;
        this.sig = sig;
    }

    void print(){
        System.out.println(this);
        if(sig != null)
            sig.print();
    }
    
    public String toString(){
        return "x: "+this.x;
    }

    void addFinal(nodo n){
        if(this.sig == null)
            this.sig = n;
        else
        this.sig.addFinal(n);
    }

    nodo addOrden(nodo n){
        if(n.x <= this.x){
            n.sig = this;
            return n;
        }
        else
            if(this.sig != null)
                this.sig = this.sig.addOrden(n);
        return this;
    }

}
