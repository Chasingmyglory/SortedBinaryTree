/*
 * @Authors: George Naous, Mohammad Raisul Hasan Shamim, Azizul Hakim
 * @Date: 11.12.2021
 * Purpose: Employee class that extends the superclass Node, instances are created to be sorted in a BT
 */

package worksheet2;

public class Employee extends Node{
	//instance variable for the Node class
	String id;
	int key;
	
	public Employee(int key) {			//constructor for the Employee class
		super(key);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
