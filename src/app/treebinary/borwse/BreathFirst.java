package app.treebinary.borwse;

import app.treebinary.Node;
import app.treebinary.Tree;

import java.util.ArrayList;

public class BreathFirst<E> {
	private ArrayList<E> array = new ArrayList();

	public BreathFirst(){
	}

	public ArrayList<E> browse(ArrayList<Node> root){
		ArrayList<Node> list = new ArrayList<Node>();

		for (int i = 0; i < root.size(); i++){
			Node<E> node = root.get(i);
			array.add(node.getElement());

			Node<E> left  = node.getLeft();
			Node<E> right = node.getRight();

			if (left != null)  list.add(left);
			if (right != null) list.add(right);
		}

		if (list.size() > 0)
			browse(list);

		return array;
	}

	public ArrayList<E> toArray(Tree<E> tree){
		ArrayList<Node> list = new ArrayList<Node>();
		list.add(tree.getRoot());
		return browse(list);
	}
}
