import java.util.*;
// Java program for Quick Sort on Singly Linked List

/*Sort a linked list using quick sort*/
class Employee {
  private String name;

  private int salary;

  private int age;
  
  Employee(String name, int salary, int age) {
    name = name;
    salary = salary;
    age = age;
  }

  public String toString() {
    return name + " " + age + " " + salary;
  }
}

public class InsertionSortLinkedList {
	static class Node {

		String name;
		int age;
		int salary;
		Node next;
		Node(String name, int salary, int age)
		{
			this.name = name;
			this.salary = salary;
			this.age = age;
			this.next = null;
		}
	}

	Node head;
    Node sorted;

	void addNode(String name, int salary, int age)
	{
		if (head == null) {
			head = new Node(name,salary,age);
			return;
		}

		Node curr = head;
		while (curr.next != null)
			curr = curr.next;

		Node newNode = new Node(name,salary,age);
		curr.next = newNode;
	}

	void printList(Node n)
	{
		while (n != null) {
			System.out.print(n.name+"("+n.age+")=>");
			System.out.print(n.salary);
			System.out.print(" ");
			n = n.next;
		}
	}

	// Takes first and last node,
	// but do not break any links in
	// the whole linked list
	void sortedInsert(Node newnode)
	{
		
        /* Special case for the head end */
        if (sorted == null || sorted.salary <= newnode.salary) 
        {
            newnode.next = sorted;
            sorted = newnode;
        }
        else 
        {
            Node current = sorted;
            /* Locate the Node before the point of insertion */
            while (current.next != null && current.next.salary > newnode.salary) 
            {
				if(current.next.salary == newnode.salary){
					if(current.next.age > newnode.age){
						current = current.next;
					}
				}else{
                	current = current.next;
				}
            }
            newnode.next = current.next;
            current.next = newnode;
        }
	}

	void sort(Node headref)
	{

        Node prevNode = new Node("", 0, 0);
        
        // Initialize sorted linked list
        sorted = null;
        Node current = headref;
        // Traverse the given linked list and insert every
        // Node to sorted
        while (current != null) 
        {
            // Store next for next iteration
            Node next = current.next;
            // insert current in sorted linked list
            sortedInsert(current);
            // Update current
            current = next;
        }
        // Update head_ref to point to sorted linked list
        head = sorted;
		
	}

	// Driver's Code
	public static void main(String[] args)
	{
		InsertionSortLinkedList list
			= new InsertionSortLinkedList();
		list.addNode("Alice",23300,23);
		list.addNode("Austin",40000,32);
		list.addNode("Thomas",30000,31);
		list.addNode("Peter",30000,30);
		list.addNode("Andrew",20000,27);
		list.addNode("Olivia",50000,26);

		Node n = list.head;
		while (n.next != null)
			n = n.next;

		System.out.println("Linked List before sorting");
		list.printList(list.head);

		// Function call
		// list.sort(list.head, n, "age");
		list.sort(list.head);
        

		System.out.println("\nLinked List after sorting");
		list.printList(list.head);
	}
}

// This code is contributed by trinadumca
