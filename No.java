
class Element {
    public int valor;
    public int frequencia;
}

class No {
    public Element elemento; 
    public No esq, dir;  

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     */
    public No(Element elemento) {
        this(elemento, null, null);
    }

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     * @param esq No da esquerda.
     * @param dir No da direita.
     */
    public No(Element elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}