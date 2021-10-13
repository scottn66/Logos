package alpha;

import java.lang.IllegalArgumentException;
//import jblas;



/*
 * Notes for CS
 * 
 * Computer simulation:
 * 
 * REAL SYSTEM --> MAKE A MODEL ---> MODEL SYSTEM--> PERFORM SIMULATIONS -->SIMULATION RESULTS
 * |									\-->CONSTRUCT APPROXIMATE THOERIES
 * |
 * |-->PERFORM EXPERIMENTS --> EXPERIMENTAL RESULTS
 * |
 * \--> RESULTS INFORM COMPARING/IMPROVING MODEL/THEORY
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class LinkedList implements IntegerListInterface{
	
	
	//fields
	private Node head;
	public int size;
	
	
	//constructor
	LinkedList() {
		this.head = null;
		this.size = 0;
	}
	LinkedList(int first, int... rest) {
		this.size = 1;
		this.head.data = first;
		Node current = head;
		for (int i : rest) {
			current.next = new Node(i);
			this.size++;
		}
	}
	
	
	public int size() {
		return size;
	}
	
	

	public int getAt(int index) {
		// returns item @index
		
		if (index >= size || index < 0) {throw new IllegalArgumentException();}
		
		
		Node current = head;
		int i = index;
		while( i!=0 ) {
			current = current.next;
			i++;
		}
		return current.data;
	}


	public void append(int toAdd) {
		// appends new Node with toAdd data
		this.size++;
		
		Node toAppend = new Node(toAdd);
		if ( head == null ) {
			head = toAppend;
			return;
		}
		
		Node current = head;
		while ( current.next != null ) {
			current = current.next;
		}
		
		current.next = toAppend;
	}

	
	public void removeAt(int index) {
		// Removes item @index and aligns reference
		if (index >= size || index < 0) {throw new IllegalArgumentException();}
		
		
		Node current = head;
		int i = index;
		while ( i!= 1 ) {
			current = current.next;
			i--;
		}
		
		Node tbRemoved = current.next;
		current.next = tbRemoved.next;
		size--;
	}

	
	public void insertAt(int toAdd, int index) {
		// method for inserting new item @index
		this.size++;
		Node toAppend = new Node(toAdd);
		
		if (index >= size || index < 0) {throw new IllegalArgumentException();}
		else if ( head == null ) { head = toAppend;}
		
		Node current = head;
		int i = index;
		while(i != 1) {
			current = current.next;
			i--;
		}
		
		Node newReference = current.next;
		current.next = toAppend;
		toAppend.next = newReference;
		
		 
	}

	
	
	
	private class Node {
		int data;
		Node next;
		Node(int d) {
			this.data = d;
			this.next = null;
		}
	}
}
