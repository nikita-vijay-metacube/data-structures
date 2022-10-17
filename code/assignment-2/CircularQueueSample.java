// Java program for insertion and
// deletion in Circular Queue
import java.util.ArrayList;

class CircularQueueSample{

// Declaring the class variables.
private int size, front, rear;

// Declaring array list of integer type.
private ArrayList<Integer> queue = new ArrayList<Integer>();

// Constructor
CircularQueueSample(int size)
{
	this.size = size;
	this.front = this.rear = -1;
}

// Method to insert a new element in the queue.
public void enQueue(int data)
{
	
	// Condition if queue is full.
	if((front == 0 && rear == size - 1) ||
	(rear == (front - 1) % (size - 1)))
	{
		System.out.print("Queue is Full");
	}

	// condition for empty queue.
	else if(front == -1)
	{
		front = 0;
		rear = 0;
		queue.add(rear, data);
	}

	else if(rear == size - 1 && front != 0)
	{
		rear = 0;
		queue.set(rear, data);
	}

	else
	{
		rear = (rear + 1);
	
		// Adding a new element if
		if(front <= rear)
		{
			queue.add(rear, data);
		}
	
		// Else updating old value
		else
		{
			queue.set(rear, data);
		}
	}
}

// Function to dequeue an element
// form th queue.
public int deQueue()
{
	int temp;

	// Condition for empty queue.
	if(front == -1)
	{
		System.out.print("Queue is Empty");
		
		// Return -1 in case of empty queue
		return -1;
	}

	temp = queue.get(front);

	// Condition for only one element
	if(front == rear)
	{
		front = -1;
		rear = -1;
	}

	else if(front == size - 1)
	{
		front = 0;
	}
	else
	{
		front = front + 1;
	}
	
	// Returns the dequeued element
	return temp;
}

// Method to display the elements of queue
public void displayQueue()
{
	
	// Condition for empty queue.
	if(front == -1)
	{
		System.out.print("Queue is Empty");
		return;
	}

	// If rear has not crossed the max size
	// or queue rear is still greater then
	// front.
	System.out.print("Elements in the " +
					"circular queue are: ");

	if(rear >= front)
	{
	
		// Loop to print elements from
		// front to rear.
		for(int i = front; i <= rear; i++)
		{
			System.out.print(queue.get(i));
			System.out.print(" ");
		}
		System.out.println();
	}

	// If rear crossed the max index and
	// indexing has started in loop
	else
	{
		
		// Loop for printing elements from
		// front to max size or last index
		for(int i = front; i < size; i++)
		{
			System.out.print(queue.get(i));
			System.out.print(" ");
		}

		// Loop for printing elements from
		// 0th index till rear position
		for(int i = 0; i <= rear; i++)
		{
			System.out.print(queue.get(i));
			System.out.print(" ");
		}
		System.out.println();
	}
}

// Driver code
public static void main(String[] args)
{
	
	// Initialising new object of
	// CircularQueueSample class.
	CircularQueueSample q = new CircularQueueSample(4);
	
	System.out.println("Queue is initialized with Size 4");
	System.out.println("Inserting 20, 30, 40, 50 in Queue");
	q.enQueue(20);
	q.enQueue(30);
	q.enQueue(40);
	q.enQueue(50);
	
	q.displayQueue();
	System.out.printf(
		"\n\ndeleting 2 nodes\n\n");

	int x = q.deQueue();

	// Checking for empty queue.
	if(x != -1)
	{
		System.out.print("Deleted value = ");
		System.out.println(x);
	}

	x = q.deQueue();

	// Checking for empty queue.
	if(x != -1)
	{
		System.out.print("Deleted value = ");
		System.out.println(x);
	}

	q.displayQueue();
	
	System.out.println("\nInserting one more item 60 in Queue");
	q.enQueue(60);
	System.out.println("\nInserting one more item 25 in Queue");
	q.enQueue(25);
	
	q.displayQueue();
	
	System.out.println("\nInserting one more item 20 in Queue");
	q.enQueue(20);
}
}
