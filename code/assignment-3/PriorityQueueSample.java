
import java.util.*; 

class PriorityQueueSample{ 
    public static void main(String args[]) 
    { 
        
        Scanner sc= new Scanner(System.in); 
        // System.out.print("Enter first number- ");  
        // int a= sc.nextInt();
        char wantaddmore;  
        int a;
        PriorityQueue<Integer> pQueue = 
            new PriorityQueue<Integer>(Collections.reverseOrder()); 

        // Adding items to the pQueue using add() 
        // pQueue.add(80); 
        // pQueue.add(60); 
        // pQueue.add(40); 
        // pQueue.add(20); 

        do 
        {
            System.out.println( "Please Enter number: ");
            a= sc.nextInt(); 
            pQueue.add(a);  
            // System.out.println( "Please Enter priority: ");
            // int priority= sc.nextInt(); 
            // pQueue.add(80);  
            System.out.println( "Do you want to add more? ");
            wantaddmore = sc.next().charAt(0);
        }
        while(wantaddmore == 'y'|| wantaddmore == 'Y');
        // Printing the most priority element 
        System.out.println("Head value is:" + 
                                            pQueue.peek()); 

        // Printing all elements 
        System.out.println("The queue elements:"); 
        Iterator itr = pQueue.iterator(); 
        while (itr.hasNext()) 
            System.out.println(itr.next()); 

        // Removing the top priority element (or head) and 
        
        pQueue.poll(); 
        System.out.println("After removing an element "
                        + "with poll function:"); 
        Iterator<Integer> itr2 = pQueue.iterator(); 
        while (itr2.hasNext()) 
            System.out.println(itr2.next()); 

        // Removing 60 using remove() 
        pQueue.remove(60); 
        System.out.println("after removing 60 with"
                        + " remove function:"); 
        Iterator<Integer> itr3 = pQueue.iterator(); 
        while (itr3.hasNext()) 
            System.out.println(itr3.next()); 

        
        Object[] arr = pQueue.toArray(); 
        System.out.println("Value in array: "); 
        for (int i = 0; i < arr.length; i++) 
            System.out.println("Value: " + arr[i].toString()); 
    } 
} 
