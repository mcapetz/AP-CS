//MARGARET CAPETZ

//package ch9webcat;

import ch9webcat.Node;

public class LinkedListOfStrings {
	// What is our underlying data structure...not a Node[]!  A linked list!
	// Well, what does a LinkedList need? 
	Node head;
	int nodeCount;
	
	// iteratively traverse the Linked List, printing out the String + " --> "
	// unless it's the last node, in which case print out the String + " --> null"
	public String toString() {
		String listString = "Head: ";
		Node runner = head;
		
		while(runner != null) {
			listString += runner.name + "-->";
			runner = runner.next;
		}
		
		return listString;
	}
	
	// iteratively traverse the Linked List, counting out the number of Nodes
	// whose String contains str
	public int countNodesWithString(String str) {
		int count = 0;
		Node runner = head;
		
		while(runner != null) {
			if(runner.name.contains(str)) count++;
			runner = runner.next;
		}
		
		return count;
	}
	
	// recursively traverse the Linked List, counting out the number of Nodes
	// whose String contains str
	public int recursivelyCountNodesWithString(Node head, String str) {
		if(head == null) return 0;
		
		if(head.name.contains(str)) return 1 + recursivelyCountNodesWithString(head.next, str);
		else return recursivelyCountNodesWithString(head.next, str);
	}
	
	// Prints the nodes in reverse, iteratively
	public void printReversed(Node head) {
		String listString = "";
		Node runner = head;
		
		while(runner != null) {
			listString = runner.name + "  " + listString;
			runner = runner.next;
		}
		
		System.out.println(listString);

	}
	
	// Prints the nodes in reverse, recursively
	public void recursivelyPrintReversed(Node head) {
		if(head == null) System.out.print("");
		
		else {
			recursivelyPrintReversed(head.next);
			System.out.print(head.name + "  ");
		}
	}
	
	
	
	//********* Some of the LinkedList operations specified by Interface List ********
	// (not all of them, that's why we aren't implementing the actual interface)
	
	
	// Appends the specified element to the end of this list.
	// Returns true if this collection changed as a result of the call. 
	// (Returns false if this collection does not permit duplicates and already contains the specified element.) 
	public boolean add(Node n) {
		//System.out.println("add()");
		Node runner = head;
		if(runner == null) {
			//System.out.println("i got here 1");
			head = n;
			nodeCount++;
			//System.out.println("true");
			return true;
		}
		else {
			//System.out.println("i got here 2");
			while(runner.next != null) {
				if(runner.name.equals(n.name)) return false;
				runner = runner.next;
			}
			runner.next = n;
			nodeCount++;
			return true;
		}
	}
	
	// Inserts the specified element at the specified position in this list.
	// Throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
	public void add(int index, Node n) {
		//System.out.println(n.name);
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException("Index out of bounds");
		//System.out.println("addIndex(" + index + ")");
		if(index == size()) {
			//System.out.println("i got here");
			add(n);
		}
		else if(index == 0) {
			nodeCount++;
			Node front = head;
			head = n;
			head.next = front;
		}
		else {
			Node runner = head;
			Node previous = null;
			int i = 0;
			while(runner.next != null && i < index) {
				//System.out.println("Index: " + i + " " + runner.name);
				previous = runner;
				runner = runner.next;
				i++;
			}
			//System.out.println(i + " " + previous.name + " " + runner.name);
			previous.next = n;
			n.next = runner;
			nodeCount++;
			//System.out.println(toString());
		}
	}
	
	// Removes all of the elements from this list.
	public void clear() {
		head = null;
		nodeCount = 0;
	}
	
	// Returns true if this list contains the specified element.
	public boolean contains(Node n) {
		//System.out.println("containsNOde()");
		if(head == null) {
			//System.out.println("false");
			return false;
		}
		else {
			Node runner = head;
			while(runner != null) {
				//System.out.println(runner.name);
				if(runner.name.equals(n.name)) {
					//System.out.println("true");
					return true;
				}
				if(runner.next == null) {
					//System.out.println("false");
					return false;
				}
				runner = runner.next;
			}
		}
		System.out.println("false");
		return false;
	}
	
	// Returns the element at the specified position in this list
	// Throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
	public Node get(int index) {
		if(index < 0 || index > size() - 1) throw new IndexOutOfBoundsException("Index out of bounds");
		Node runner = head;
		//System.out.println("get(" + index + ")");
		if(runner != null) {
			int i = 0;
			while(runner.next != null && i < index) {
				//System.out.println("Index: " + i + " "+ runner.name);
				runner = runner.next;
				i++;
			}
			return runner;
		}
		//System.out.println("Null");
		return null;
	}
	
	// Removes the element at the specified position in this list.
	// Returns the element previously at the specified position
	// Throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
	public Node remove(int index) {
		if(index < 0 || index > size() - 1) {
			//System.out.println("index out of bounds");
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		//System.out.println("remove(" + index + ")");
		if(index == 0) {
			Node removed = head;
			head = head.next;
			nodeCount--;
			return removed;
		}
		Node runner = head;
		if(runner != null) {
			int i = 0;
			Node previous = runner;
			while(runner.next != null && i < index) {
				//System.out.println("i got here");
				//System.out.println("Index: " + i + " "+ runner.name);
				previous = runner;
				runner = runner.next;
				i++;
			}
			//System.out.println("Index: " + i + " "+ runner.name);
			//System.out.println("previous " + previous.name);
			Node removed = runner;
			previous.next = runner.next;
			nodeCount--;
			//System.out.println("removed: " + removed.name);
			//System.out.println(toString());
			return removed;
		}
		//System.out.println("null");
		return null;
	}
	
	
	// Removes the first occurrence of the specified element from this list, if it is present.
	// Returns true if this list contained the specified element (or equivalently, if this list changed as a result of the call).
	public boolean remove(Node n) {
		if(head.name.equals(n.name)) {
			remove(0);
			return true;
		}
		//System.out.println(toString());
		//System.out.println("remove()" + n.name);
		Node runner = head;
		Node previous = runner;
		if(runner != null) {
			while(runner.next != null) {
				//System.out.println("previous: " + previous.name);
				//System.out.println("runner: " + runner.name);
				previous = runner;
				runner = runner.next;
				if(runner.name.equals(n.name)) {
					//System.out.println("i got here");
					break;
				}
			}
			if(!runner.name.equals(n.name)) return false;
			previous.next = runner.next;
			nodeCount--;
			//System.out.println(toString());
			return true;
		}
		return false;
	}
	
	// Replaces the element at the specified position in this list with the specified element.
	// Throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
	public Node set(int index, Node n) {
		//System.out.println("set(" + index + ")");
		if(index < 0 || index > size() - 1) throw new IndexOutOfBoundsException("Index out of bounds");
		Node runner = head;
		if(runner != null) {
			for(int i = 0; i < index; i++) {
				runner = runner.next;
			}
			add(index, n);
			//System.out.println(toString());
			remove(index + 1);
			//System.out.println(runner.name);
			return runner;
		}
		return null;
	}
	
	// Returns the number of elements in this collection.
	public int size() {
		return nodeCount;
	}
	

	
}
