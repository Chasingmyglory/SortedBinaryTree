/*
 * @Authors: George Naous, Mohammad Raisul Hasan Shamim, Azizul Hakim
 * @Date: 11.12.2021
 * Purpose: Node class, has attributes that help connect instances to be sorted in a BT
 */

package worksheet2;

public class Node {
	//instance variable for the Node class
	private Node parent;
	private Node left;
	private Node right;
	private int key;
	
	public Node(int key){		//constructor for the Node class
		this.parent = null;
		this.left = null;
		this.right = null;
		this.key = key;
	}
	
	public String toString(){			//overrides the toString() method  
		  return /*"Employee ID: " + id + */"Employee's age: " + key;
		  }
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
}
