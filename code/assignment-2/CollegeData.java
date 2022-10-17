import java.util.*; 
public class CollegeData {

	// Driver code
	public static void main(String[] args)
	{
        Scanner sc= new Scanner(System.in); 
        int capacity;
        String name;
		// Create a queue of capacity 4
            System.out.println( "Please Enter Total number of programs: ");
            int totalPrograms,programsInput=0;
            totalPrograms= sc.nextInt(); 
		ProgramQueue programQ = new ProgramQueue(totalPrograms);
        // Queue q = new Queue[40];  


        while(programsInput<totalPrograms) 
        {
            System.out.println( "Please Enter program name: ");
            name= sc.next();
            System.out.println( "Please Enter capacity: ");
            capacity= sc.nextInt(); 
            programQ.queueEnqueue(name,capacity);
            programsInput++;
        }
        int stprogramcount;
        String programName;
        int totalStPrograms = 5;
        
        System.out.println( "Please Enter Total number of Students: ");
        int totalStudents,studentsInput=0;
        totalStudents= sc.nextInt(); 
		StudentQueue studentQ = new StudentQueue(totalStudents);
        while(studentsInput<totalStudents) 
        {
            System.out.println( "Please Enter Student name: ");
            name= sc.next();
            System.out.println( "Please Enter 5 programs: ");
            stprogramcount=0;
            String programarr[] = new String[totalStPrograms];
            while(stprogramcount<totalStPrograms){
                programName= sc.next();
                programarr[stprogramcount] = programName;
                stprogramcount++;
            }
            
            studentQ.queueEnqueue(name,programarr);
            studentsInput++;
        }
        
		// print Queue elements
        System.out.print("\nThe programs Queue Before Assignment is::\n");
		programQ.queueDisplay();

        studentQ.arrangeQueue(programQ);
        System.out.print("\nThe Students Queue is::\n");
		studentQ.queueDisplay();
        System.out.print("\nThe programs Queue is::\n");
		programQ.queueDisplay();
	}
}
class StudentQueue {
	public int front, rear, totalcapacity;
	public StudentObject[] queue;

    int capacity;
    String name;
	StudentQueue(int c)
	{
        name ="";
        capacity=0;
		front = rear = 0;
		totalcapacity = c;
		queue = new StudentObject[c];
	}

	public void queueEnqueue(String name, String[] programArr)
	{
		if (totalcapacity == rear) {
			System.out.printf("\nQueue is full\n");
			return;
		}

		else {
            queue[rear] = new StudentObject(name, programArr);
			rear++;
		}
		return;
	}

	public void queueDequeue()
	{
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
			System.out.printf(" %d <-- %s - %s ", i, queue[i].name,queue[i].program);
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
	public void arrangeQueue(ProgramQueue stQ)
	{
		// traverse front to rear and print elements
		for (int i = front; i < rear; i++) {

            for(int j=0;j<queue[i].programArray.length && queue[i].program=="";j++){
                for(int k=0;k<stQ.queue.length && queue[i].program=="";k++){
                    if((stQ.queue[k].name.equals(queue[i].programArray[j])) && (stQ.queue[k].remainingCapacity>0)){
                        queue[i].program = stQ.queue[k].name;
                        stQ.queue[k].remainingCapacity = stQ.queue[k].remainingCapacity-1;
                    }
                }
            }
        }
		return;
	}

}
class ProgramQueue {
	public int front, rear, totalcapacity;
	public CollegeObject[] queue;

    int capacity;
    String name;
	ProgramQueue(int c)
	{
        name ="";
        capacity=0;
		front = rear = 0;
		totalcapacity = c;
		queue = new CollegeObject[c];
	}

	public void queueEnqueue(String name, int c)
	{
		if (totalcapacity == rear) {
			System.out.printf("\nQueue is full\n");
			return;
		}

		else {
            queue[rear] = new CollegeObject(name, c);
			rear++;
		}
		return;
	}

	public void queueDequeue()
	{
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
			System.out.printf(" %d <-- %s - %d ", i, queue[i].name,queue[i].capacity);
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

class StudentObject{
    String[] programArray;
    String name,program;
    StudentObject(String n, String[] c){
        name=n;
        program="";
        programArray=c;
    }
}

class CollegeObject{
    int capacity,remainingCapacity;
    String name;
    String students;
    CollegeObject(String n, int c){
        name=n;
        capacity=c;
        remainingCapacity=c;
    }
}