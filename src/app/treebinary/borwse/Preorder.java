package app.treebinary.borwse;

import app.treebinary.Node;
import app.treebinary.Tree;

import java.util.ArrayList;

public class Preorder<E> {
	private ArrayList<E> array = new ArrayList();

	public Preorder(){
	}

	public ArrayList<E> browse(Node<E> root){

		array.add(root.getElement());

		Node<E> left = root.getLeft();
		if (left != null){
			browse(left);
		}

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
