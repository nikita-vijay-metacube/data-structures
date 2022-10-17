// Java program to implement a queue using an array
class Queue implements QueueSampleInterface {
	static private int front, rear, capacity;
	static private int queue[];

	Queue(int c)
	{
		front = rear = 0;
		capacity = c;
		queue = new int[capacity];
	}

	public void queueEnqueue(int data)
	{
		if (capacity == rear) {
			System.out.printf("\nQueue is full\n");
			return;
		}

		else {
			queue[rear] = data;
			rear++;
		}
		return;
	}

	public void queueDequeue()
	{
		// if queue is empty
		if (front == rear) {
			System.out.printf("\nQueue is empty\n");
			return;
		}

		else {
            if (front >= rear) {
                front = -1;
                rear = -1;
            } /* Q has only one element, so we reset the queue after deleting it. */
            else {
                front++;
            }

		}
		return;
	}

	// print queue elements
	public void queueDisplay()
	{
		int i;
		if (front == rear) {
			System.out.printf("\nQueue is Empty\n");
			return;
		}

		// traverse front to rear and print elements
		for (i = front; i < rear; i++) {
			System.out.printf(" %d <-- ", queue[i]);
		}
		return;
	}

	// print front of queue
	public void queueFront()
	{
		if (front == rear) {
			System.out.printf("\nQueue is Empty\n");
			return;
		}
		System.out.printf("\nFront Element is: %d",
						queue[front]);
		return;
	}
}

public class QueueSample {

	// Driver code
	public static void main(String[] args)
	{
		Queue q = new Queue(4);

		System.out.println("Queue is initialized with Size 4");
		q.queueDisplay();
		// inserting elements in the queue
		System.out.println("Inserting 20, 30, 40, 50 in Queue");
		q.queueEnqueue(20);
		q.queueEnqueue(30);
		q.queueEnqueue(40);
		q.queueEnqueue(50);

		// print Queue elements
		q.queueDisplay();

		System.out.println("\nInserting one more item 60 in Queue");
		// insert element in the queue
		q.queueEnqueue(60);

		// print Queue elements
		q.queueDisplay();

		q.queueDequeue();
		q.queueDequeue();
		System.out.printf(
			"\n\nafter two node deletion\n\n");

		// print Queue elements
		q.queueDisplay();

		// print front of the queue
		System.out.println("\nNow, the front element of queue after deleting 2 nodes is-");
		q.queueFront();
		System.out.println("\nInserting item 60 agin in Queue(As we have deleted 2 nodes, we have only 2 nodes remaining in the queue");
		q.queueEnqueue(60);
		q.queueDisplay();
		System.out.println("\nStill we can't add more items as queue maintains unused space. So here we will be using circular queue to recover this issue");
	}
}
