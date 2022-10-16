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

		q.queueDisplay();

		// inserting elements in the queue
		q.queueEnqueue(20);
		q.queueEnqueue(30);
		q.queueEnqueue(40);
		q.queueEnqueue(50);

		// print Queue elements
		q.queueDisplay();

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
		q.queueFront();
		q.queueEnqueue(60);
		q.queueDisplay();
	}
}
