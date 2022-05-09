
class Element implements Comparable {
    public int valor;
    public int frequencia;

    public Element(int valor, int frequencia) {
        this.valor = valor;
        this.frequencia = frequencia;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
}

class No {
    public Element elemento;
    public No esq, dir;

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     */
    public No(Element elemento) {
        this(elemento, null, null);
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     * @param esq      No da esquerda.
     * @param dir      No da direita.
     */
    public No(Element elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }

    public Element getElemento() {
        return elemento;
    }

    public void setElemento(Element elemento) {
        this.elemento = elemento;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }
}