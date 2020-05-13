package app;

import app.treebinary.borwse.BreathFirst;
import app.treebinary.borwse.Postorder;
import app.treebinary.Tree;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>(60);

		// Add element
		tree.add(55);
		tree.add(100);
		tree.add(45);
		tree.add(57);
		tree.add(67);
		tree.add(107);
		tree.add(59);
		tree.add(101);

		// Postorder
		Postorder postorder = new Postorder<Integer>();

		ArrayList<Integer> array = postorder.toArray(tree);
		//Before deleting
		System.out.println("Before deleting: \n" + array);

		tree.delete(45);

		Postorder postorder2 = new Postorder<Integer>();
		array = postorder2.toArray(tree);
		//Before deleting
		System.out.println("After deleting number 45: \n" + array);
	}
}
