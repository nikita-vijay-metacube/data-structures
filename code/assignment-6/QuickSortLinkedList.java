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

public class QuickSortLinkedList {
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
	Node paritionLast(Node start, Node end, String type)
	{
		if (start == end || start == null || end == null)
			return start;

		Node pivot_prev = start;
		Node curr = start;
        

		// iterate till one before the end,
		// no need to iterate till the end
		// because end is pivot


        // if(type == "salary"){
            Node pivot = new Node("", 0, 0);
			pivot.salary=end.salary;
			pivot.age=end.age;
			pivot.name=end.name;
            while (start != end) {
                if ((type == "salary" && start.salary > pivot.salary) || (type == "age" && start.age < pivot.age)) {

                    // keep tracks of last modified item
                      pivot_prev = curr;

					  Node temp = new Node("", 0, 0);
					  temp.salary = curr.salary;
					  temp.name = curr.name;
					  temp.age = curr.age;

					  curr.salary = start.salary;
					  curr.name = start.name;
					  curr.age = start.age;

					  start.salary = temp.salary;
					  start.age = temp.age;
					  start.name = temp.name;
					curr = curr.next;
                }
                start = start.next;
            }

            // Swap the position of curr i.e.
            // next suitable index and pivot
					  Node temp = new Node("", 0, 0);
			temp.salary = curr.salary;
			temp.name = curr.name;
			temp.age = curr.age;
			// int temp = curr.salary;
			
			curr.age = pivot.age;
			curr.salary = pivot.salary;
			curr.name = pivot.name;
			// curr.salary = pivot;
			
			end.age = temp.age;
			end.salary = temp.salary;
			end.name = temp.name;
			// end.salary = temp;
	
        
		// Return one previous to current
		// because current is now pointing to pivot
		return pivot_prev;
	}

	void sort(Node start, Node end, String type)
	{
		if (start == null || start == end
			|| start == end.next)
			return;

		// Split list and partition recurse
		Node pivot_prev = paritionLast(start, end, type);
		sort(start, pivot_prev, type);

		// If pivot is picked and moved to the start,
		// that means start and pivot is same
		// so pick from next of pivot
		if (pivot_prev != null && pivot_prev == start)
			sort(pivot_prev.next, end, type);

		// If pivot is in between of the list,
		// start from next of pivot,
		// since we have pivot_prev, so we move two nodes
		else if (pivot_prev != null
				&& pivot_prev.next != null)
			sort(pivot_prev.next.next, end, type);

	}

	// Driver's Code
	public static void main(String[] args)
	{
		QuickSortLinkedList list
			= new QuickSortLinkedList();
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
		list.sort(list.head, n, "age");
		list.sort(list.head, n, "salary");
        

		System.out.println("\nLinked List after sorting");
		list.printList(list.head);
		System.out.println();
	}
}

// This code is contributed by trinadumca
