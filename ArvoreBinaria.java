/**
 * Arvore binaria de pesquisa
 * 
 */
public class ArvoreBinaria {
   private No raiz;

   public ArvoreBinaria() {
      raiz = null;
   }

   public boolean pesquisar(int x) {
      return pesquisar(x, raiz);
   }

   private boolean pesquisar(int x, No i) {
      boolean resp;
      if (i == null) {
         resp = false;

      } else if (x == i.elemento.valor) {
         resp = true;

      } else if (x < i.elemento.valor) {
         resp = pesquisar(x, i.esq);

      } else {
         resp = pesquisar(x, i.dir);
      }
      return resp;
   }

   public void caminharCentral() {
      System.out.print("[ ");
      caminharCentral(raiz);
      System.out.println("]");
   }

   private void caminharCentral(No i) {
      if (i != null) {
         caminharCentral(i.esq); // Elementos da esquerda.
         System.out.print(i.elemento.valor + "-" + i.elemento.frequencia + " "); // Conteudo do no.
         caminharCentral(i.dir); // Elementos da direita.
      }
   }

   public void caminharPre() {
      System.out.print("[ ");
      caminharPre(raiz);
      System.out.println("]");
   }

   private void caminharPre(No i) {
      if (i != null) {
         System.out.print(i.elemento.valor + "-" + i.elemento.frequencia + " "); // Conteudo do no.
         caminharPre(i.esq); // Elementos da esquerda.
         caminharPre(i.dir); // Elementos da direita.
      }
   }

   public void caminharPos() {
      System.out.print("[ ");
      caminharPos(raiz);
      System.out.println("]");
   }

   private void caminharPos(No i) {
      if (i != null) {
         caminharPos(i.esq); // Elementos da esquerda.
         caminharPos(i.dir); // Elementos da direita.
         System.out.print(i.elemento.valor + "-" + i.elemento.frequencia + " "); // Conteudo do no.
      }
   }

   public void inserir(Element x) throws Exception {
      raiz = inserir(x, raiz);
   }

   private No inserir(Element x, No i) throws Exception {
      if (i == null) {
         i = new No(x);
         // Inserir pela frequencia
      } else if (i.elemento.compareTo(x) == 1) {
         i.esq = inserir(x, i.esq);

      } else if (i.elemento.compareTo(x) == -1) {
         i.dir = inserir(x, i.dir);

      } else {
         throw new Exception("Erro ao inserir!");
      }

      return i;
   }

   public void remover(int x) throws Exception {
      raiz = remover(x, raiz);
   }

   private No remover(int x, No i) throws Exception {

      if (i == null) {
         throw new Exception("Erro ao remover!");

      } else if (x < i.elemento.frequencia) {
         i.esq = remover(x, i.esq);

      } else if (x > i.elemento.frequencia) {
         i.dir = remover(x, i.dir);

         // Sem no a direita.
      } else if (i.dir == null) {
         i = i.esq;

         // Sem no a esquerda.
      } else if (i.esq == null) {
         i = i.dir;

         // No a esquerda e no a direita.
      } else {
         i.esq = maiorEsq(i, i.esq);
      }

      return i;
   }

   private No maiorEsq(No i, No j) {

      // Encontrou o maximo da subarvore esquerda.
      if (j.dir == null) {
         i.elemento = j.elemento; // Substitui i por j.
         j = j.esq; // Substitui j por j.ESQ.

         // Existe no a direita.
      } else {
         // Caminha para direita.
         j.dir = maiorEsq(i, j.dir);
      }
      return j;
   }

   public int getMaior() {
      int resp = -1;

      if (raiz != null) {
         No i;
         for (i = raiz; i.dir != null; i = i.dir)
            ;
         resp = i.elemento.valor;
      }

      return resp;
   }

   public int getMenor() {
      int resp = -1;

      if (raiz != null) {
         No i;
         for (i = raiz; i.esq != null; i = i.esq)
            ;
         resp = i.elemento.valor;
      }

      return resp;
   }

   public int getAltura() {
      return getAltura(raiz, 0);
   }

   public int getAltura(No i, int altura) {
      if (i == null) {
         altura--;
      } else {
         int alturaEsq = getAltura(i.esq, altura + 1);
         int alturaDir = getAltura(i.dir, altura + 1);
         altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
      }
      return altura;
   }

   public int getRaiz() throws Exception {
      return raiz.elemento.valor;
   }
}
