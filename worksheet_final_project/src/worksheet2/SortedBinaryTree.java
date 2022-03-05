/*
 * @Authors: George Naous, Mohammad Raisul Hasan Shamim, Azizul Hakim
 * @Date: 11.12.2021
 * Purpose: SortedBinaryTree class, to create a BT structure to sort node objects
 * implements an iterator for inOrder traversal
 */

package worksheet2;

import java.util.Iterator;

public class SortedBinaryTree implements Iterable<Node> {
	private Node root;
	
	public SortedBinaryTree() {			//constructor for the SBT, to create a new tree and initialize the root to null
		root = null;
	}

	public Node getRoot() {
		return root;
	}
	
	public void insert(Node k) {			//inserts nodes using the recursive method insertNode
        root = insertNode(root, k, null);
    }
	
	private Node insertNode(Node root, Node k, Node pre) {			//service method for inserting nodes
		if(root == null) {		//base case, root is null
			root = k;
			k.setLeft(null);
			k.setRight(null);
			k.setParent(pre);
		} else if (k.getKey() <= root.getKey()) {	//if current root value is greater than the given node value process the left subtree
				root.setLeft(insertNode(root.getLeft(), k, root));
			} else {								//if current root value is greater than the given node value process the right subtree
				root.setRight(insertNode(root.getRight(), k, root));
			}
		return root;		//return root node after insertion
	}
	
	protected void delete(Node k, Node pre) { 
        root = deleteNode(root, k, pre); 
    } 
   
    private Node deleteNode(Node root, Node k, Node pre) { 

    	if (root == null)  return root; 
   
        if (k.getKey() < root.getKey())
            root.setLeft(deleteNode(root.getLeft(), k, root)); 
        else if (k.getKey() > root.getKey())
            root.setRight(deleteNode(root.getRight(), k, root)); 
        else  { 
            if (root.getLeft() == null) 
                return root.getRight(); 
            else if (root.getRight() == null) 
                return root.getLeft(); 
        } 
        return root; 
    }
	
	public Node find(int key) {			//finds a node that has a certain key
		Node k = root;
		while(k.getKey() != key) {
			if(key < k.getKey()) {
				k = k.getLeft();
			} else {
				k = k.getRight();
			}
			if(k == null) return null;
		}
		return k;
	}
	
	public Node succ(Node k) {			//returns the successor of a certain node
		if (k.getRight() != null) {
			return min(k.getRight());
		}
		Node pre = k.getParent();
		while(pre != null && k == pre.getRight()) {
			k = pre;
			pre = pre.getParent();
		}
		return pre;
	}
	
	public Node min(Node k) {			//returns the node with the minimum key value of a tree/subtree
		while(k.getLeft() != null) {
			k = k.getLeft();
		}
		return k;
	}

	@Override
	public Iterator<Node> iterator() {        //tree iterator, overrides original iterator methods
		return new Iterator<Node>() {
			private Node iterNext = min(root);

			@Override
			public boolean hasNext() {
				return iterNext != null;
			}

			@Override
			public Node next() {
				Node current = iterNext;
				iterNext = succ(current);
				return current;
			}
		};
	}
	
}
