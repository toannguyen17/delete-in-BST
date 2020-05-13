package app.treebinary.borwse;

import app.treebinary.Node;
import app.treebinary.Tree;

import java.util.ArrayList;

public class Inorder<E> {
	private ArrayList<E> array = new ArrayList();

	public Inorder(){
	}

	public ArrayList<E> browse(Node<E> root){
		Node<E> left = root.getLeft();
		if (left != null){
			browse(left);
		}

		array.add(root.getElement());

		Node<E> right = root.getRight();
		if (right != null){
			browse(right);
		}
		return array;
	}

	public ArrayList<E> toArray(Tree<E> tree){
		return browse(tree.getRoot());
	}
}
