
public class BDLLIST<T> implements Cloneable {
	private static final int BSIZE = 4;
	private class Node<T> {
		Block<T> bloco;
		Node<T> next;
		Node<T> previous;
		private Node(Node<T> next, Node<T> previous) {
			bloco = new Block<T>(BSIZE + 1);
			this.next = next;
			this.previous = previous;
		}
	}
	private int size;
	public BDLLIST () {
		
	}
	
	
}
