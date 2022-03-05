/*
 * @Authors: George Naous, Mohammad Raisul Hasan Shamim, Azizul Hakim
 * @Date: 11.12.2021
 * Purpose: Main class that contains the test program
 */

package worksheet2;

import java.util.Iterator;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		SortedBinaryTree tree = new SortedBinaryTree();			//creates a new BT object to structure the nodes
		Random random = new Random();
		System.out.println("Employees with randomly generated key values: ");
		for(int i = 1; i <= 100; i++) {
		   int randomAge = random.nextInt(65 - 21 + 1) + 21; //new random number within an age interval for the employees
		   Employee employee = new Employee(randomAge);
//		   employee.id = "E" + String.format("%04d", i);	 //optional, creates an id for each employee object
		   System.out.println(employee);
		   tree.insert(employee);
		}
		System.out.println();
		System.out.println("Iterator inOrder traversal of the random-key tree: ");
		//Print in order the first 20, then each fifth, and the last 20 key numbers
		int i = 1;
		for (Iterator<Node> it = tree.iterator(); it.hasNext(); i++) {
			int iter = it.next().getKey();
		    if (i <= 20) {
				System.out.print(iter + ", ");
		    }
		    if (i == 20) {
				System.out.println();
		    }
		    if (i > 20 && i%5 == 0 && i <= 80) {
				System.out.print(iter + ", ");
		    }
		    if (i == 80) {
				System.out.println();
		    }
		    if (i > 80 && i < 100) {
				System.out.print(iter + ", ");
		    }
		    if (i == 100) {
				System.out.print(iter);
		    }
		}    
		//Create 2 sets of employees (each set has 10 employee objects) and insert each set in a tree
		//Set #1
		Employee e1 = new Employee(25);
		Employee e2 = new Employee(22);
		Employee e3 = new Employee(37);
		Employee e4 = new Employee(52);
		Employee e5 = new Employee(48);
		Employee e6 = new Employee(40);
		Employee e7 = new Employee(29);
		Employee e8 = new Employee(38);
		Employee e9 = new Employee(58);
		Employee e10 = new Employee(44);
		SortedBinaryTree tree1 = new SortedBinaryTree();
		tree1.insert(e1);
		tree1.insert(e2);
		tree1.insert(e3);
		tree1.insert(e4);
		tree1.insert(e5);
		tree1.insert(e6);
		tree1.insert(e7);
		tree1.insert(e8);
		tree1.insert(e9);
		tree1.insert(e10);
		//Set #2
		Employee e11 = new Employee(35);
		Employee e12 = new Employee(28);
		Employee e13 = new Employee(37);
		Employee e14 = new Employee(42);
		Employee e15 = new Employee(60);
		Employee e16 = new Employee(52);
		Employee e17 = new Employee(28);
		Employee e18 = new Employee(48);
		Employee e19 = new Employee(34);
		Employee e20 = new Employee(25);
		SortedBinaryTree tree2 = new SortedBinaryTree();
		tree2.insert(e11);
		tree2.insert(e12);
		tree2.insert(e13);
		tree2.insert(e14);
		tree2.insert(e15);
		tree2.insert(e16);
		tree2.insert(e17);
		tree2.insert(e18);
		tree2.insert(e19);
		tree2.insert(e20);
		//An iterator to insert employees from the tree2 to tree1
		Iterator<Node> it1 = tree2.iterator();
		while (it1.hasNext()) {
			Employee e = new Employee(it1.next().getKey());
			tree1.insert(e);
		}
		//An iterator to print tree1 after adding employees of tree2 to it
		System.out.print("\n\n");
		System.out.println("Merged tree (tree1 after adding tree2 employees) inOrder traversal: ");
		Iterator<Node> it2 = tree1.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
	}
	
}
