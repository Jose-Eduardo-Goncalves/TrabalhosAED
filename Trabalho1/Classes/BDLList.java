/**
 * Esta classe implementa uma lista de blocos duplamente ligada
 * @author Jose Goncalves (Numero 49457) Sergio Batalha (Numero 49473)
 * @param <E> Tipo de elementos nesta lista
 */
public class BDLList<E> implements Cloneable, Iterable<E> {
	private static final int BSIZE = 8;
	/**
	 * Cria um no contendo um bloco e duas referencias,
	 * uma para o noh anterior e outra para o proximo
	 * @param <E> Tipo de elementos nesta lista
	 */
	private class Node<E> {
		Block<E> bloco;
		Node<E> next;
		Node<E> previous;
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
	 * @param e 
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
	 * 
	 * @param index
	 * @return
	 * @requires 0 <= index < size()
	 */
	public E get (int index) {
		
	}
	
	
	
	
	
}
