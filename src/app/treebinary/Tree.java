package app.treebinary;

public class Tree<E> {
	private Node<E> root;

	// Constructor
	public Tree() {
	}

	public Tree(E data) {
		this.root = new Node<E>(data);
	}

	public Node<E> getRoot() {
		return root;
	}

	public void add(E data){
		Node<E> node = new Node<E>(data);

		if(root == null){
			root = node;
		}else{
			Node<E> current = root;
			while (true) {
				Node<E> line;

				if (current.compareTo(data) > 0) {
					line = current.getLeft();
					if (line == null){
						current.setLeft(node);
						break;
					}
				} else {
					line = current.getRight();
					if (line == null){
						current.setRight(node);
						break;
					}
				}
				current = line;
			}
		}
	}

	public boolean search(E element) {
		Node<E> current = root;
		while (current != null) {
			if (current.compareTo(element) > 0) {
				current = current.getLeft();
			} else if (current.compareTo(element) < 0) {
				current = current.getRight();
			} else {
				return true;
			}
		}
		return false;
	}

	public void moveNode(Node<E> parent, Node<E> child) {
		if (child != null){
			Node<E> current = parent;
			while (true) {
				if (current.compareTo(child.getElement()) > 0) {
					if(current.getLeft() == null){
						current.setLeft(child);
						break;
					}
					current = current.getLeft();
				} else {
					if(current.getRight() == null){
						current.setRight(child);
						break;
					}
					current = current.getRight();
				}
			}
		}
	}

	public boolean delete(E element) {
		boolean isDelete = false;
		Node<E> current = root;
		while (current != null) {
			if (current.compareTo(element) > 0) {
				current = current.getLeft();
			} else if (current.compareTo(element) < 0) {
				current = current.getRight();
			} else {
				isDelete = true;
				// current
				Node<E> leftCurrent  = current.getLeft();
				Node<E> rightCurrent = current.getRight();
				//
				if (current.getParent() == null){
					root = null;
					if (leftCurrent != null){
						root = leftCurrent;
						moveNode(root, rightCurrent);
					}else if (rightCurrent != null){
						root = rightCurrent;
					}
				}else{
					current.setLeft(null);
					current.setRight(null);

					if (current.getParent().compareTo(current.getElement()) > 0) {
						current.getParent().setLeft(null);
					} else {
						current.getParent().setRight(null);
					}

					moveNode(current.getParent(), leftCurrent);
					moveNode(current.getParent(), rightCurrent);
				}
				break;
			}
		}
		return isDelete;
	}
}
