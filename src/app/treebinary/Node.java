package app.treebinary;

public class Node<E> {
	// Data
	private E element;

	// Node tra
	private Node<E> parent;

	// Node trái, (node nhỏ hơn)
	private Node<E> left = null;

	// Node phải (node lớn hơn hoặc bằng)
	private Node<E> right = null;

	// Constructor
	public Node(){
	}
	public Node(E element) {
		this.element = element;
	}

	// Get
	public Node<E> getParent() {
		return parent;
	}
	public Node<E> getLeft() {
		return left;
	}
	public Node<E> getRight() {
		return right;
	}

	// Set
	public void setParent(Node<E> parent) {
		this.parent = parent;
	}
	public void setLeft(Node<E> left) {
		if(left != null) left.setParent(this);
		this.left = left;
	}
	public void setRight(Node<E> right) {
		if(right != null) right.setParent(this);
		this.right = right;
	}

	public E getElement() {
		return element;
	}

	public int compareTo(E o) {
		Comparable o1 = (Comparable) this.element;
		Comparable o2 = (Comparable) o;

		if (o1.compareTo(o2) > 0)
			return 1;
		else if (o1.compareTo(o2) < 0)
			return -1;
		else
			return 0;
	}
}
