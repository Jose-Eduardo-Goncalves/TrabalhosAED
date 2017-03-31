/**
 * Esta classe implementa uma lista de blocos duplamente ligada
 * @author Jose Goncalves (Numero 49457) Sergio Batalha (Numero 49473)
 * @param <E> Tipo de elementos nesta lista
 */
public class BDLList<E> implements Cloneable {
    private static final int BSIZE = 1;
    /**
     * Cria um noh contendo um bloco e duas referencias,
     * uma para o noh anterior e outra para o proximo
     * @param <E> Tipo de elementos nesta lista
     */
    private static class Node<E> {
        private Block<E> bloco;
        private Node<E> next;
        private Node<E> previous;
        /**
         * Constroi um novo noh
         * @param next Referencia para o proximo noh
         * @param previous Referencia para o noh anterior
         */
        private Node(Node<E> next, Node<E> previous) {
            bloco = new Block<E>(BSIZE + 1);
            this.next = next;
            this.previous = previous;
        }
    }
    private int size;
    private Node<E> first;
    private Node<E> last;
    /**
     * Constroi uma lista vazia duplamente ligada com blocos 
     */
    public BDLList () {
        first = new Node<E>(null,null);
        last = first;
    }
    /**
     * Verifica se uma dada lista 
     * esta vazia
     * @return True se estiver vazia, 
     * false caso contrario.
     */
    public boolean isEmpty () {
        return size == 0;
    }
    /**
     * Adiciona um elemento ao final da lista
     * @param e Elemento a adicionar ao fim 
     * da lista
     * @requires e != null
     */
    public void add (E e) {
        if (isEmpty()) {
            first.bloco.addFirst(e);
            size++;
        } else if (!last.bloco.isFull()) {
            last.bloco.addLast(e);
            size++;
        } else {
            last.next = new Node<E> (last, null);
            last = last.next;
            last.bloco.addFirst(e);
            size++;
        }
    }
    /**
     * Retorna quantos elementos estao nesta
     * lista
     * @return Numero de elementos na lista
     */
    public int size () {
        return size;
    }
    /**
     * Devolve o elemento que esta na posicao
     * index da lista
     * @param index Posicao do elemento a 
     * retornar
     * @return O elemento na posicao index
     * @requires 0 <= index < size()
     */
    public E get (int index) {
        if (index < BSIZE + 1) {
            return first.bloco.get(index);
         } else {
            int indiceBloco = index % (BSIZE + 1);
            return noh(index).bloco.get(indiceBloco);
         }
    }
    /**
     * Coloca um dado elemento numa 
     * dada posicao da lista
     * @param index A posicao da lista
     * @param e O elemento a colocar
     * @requires index >= 0 && e != null &&
     *          0 <= index < size ()
     */
    public void set (int index, E e) {
        int indiceBloco = index % (BSIZE + 1);
        if (index < BSIZE + 1) {
            first.bloco.set(index, e);
        } else {
            noh(index).bloco.set(indiceBloco, e);
        }
    }
    /**
     * Calcula qual o noh a que pertence
     * o indice da posicao do elemento
     * requesitado no metodo get (index)
     * @param index O indice de posicao
     * @return O noh onde esta o elemento
     * @requires index >= 0
     */
    private Node<E> noh (int index) {
        //Numero de nos ate a posicao requesitada
        int nosAPercorrer = numeroNos (index);
        Node<E> referencia = first.next;
        //Comeca em i = 2 porque a variavel 
        //referencia ja contem o enderenco
        //do segundo noh
        for (int i = 2; i < nosAPercorrer; i++) {
            referencia = referencia.next;
        }
        return referencia;
    }
    /**
     * Calcula quantos nos tem que percorrer
     * para chegar aquele que contem o indice
     * requesitado
     * @param index O index a ser procurado
     * @return O numero de nos ate ao noh
     * que contem o indice index
     * @requires index >= 0
     */
    private static int numeroNos (int index) {
        if (index % BSIZE == 0) {
            return index / BSIZE;
        } else {
            return index / BSIZE + 1;
        }
    }
}
