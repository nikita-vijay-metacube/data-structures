
import java.util.*; 

class MinimumScores{ 

    public static void main(String args[]) 
    { 
        
        Scanner sc= new Scanner(System.in);
        int a,n,currentBowler;
        String str;
        System.out.println("Please Enter number of bowlers: ");

        n=sc.nextInt();  
        Bowler[] bowlers = new Bowler[n];  
        int i=0;
        do 
        {
            System.out.println("Please Enter quota of bowler " + (i+1) +" \n- number of left balls: ");
            a= sc.nextInt();
            System.out.println("- Name: ");
            str= sc.next();
            bowlers[i] = new Bowler(str, a);
            i++;
        }
        while(i<n);

        System.out.println("\nPlease Enter total number of balls: ");
        int totalBalls = sc.nextInt();
        int ballsRemaining=totalBalls;
        System.out.print("\nThe Bowlers You Entered Are(in Pattern of Bowler's Name => Number of Balls Left):: \n");
        Bowler.printList(bowlers,n );
        System.out.println("Sequence of bowlers should be:: \n");
        while(ballsRemaining > 0){
            currentBowler = Bowler.findGreatest(bowlers,n);
            ballsRemaining = ballsRemaining-bowlers[currentBowler].ballsLeft;
            bowlers[currentBowler].chosen = 1;
            System.out.println("Bowler Name:: " +bowlers[currentBowler].name+", balls:: "+(ballsRemaining>0 ? bowlers[currentBowler].ballsLeft : (ballsRemaining+bowlers[currentBowler].ballsLeft))+" \n");
        }
    } 
} 
class Bowler{
    String name;
    int ballsLeft;
    int chosen;
    Bowler(String n, int balls){
        name=n;
        ballsLeft=balls;
        chosen=0;
    }
	public static void printList(Bowler[] bowlers, int n)
	{
        
        for (int j=0; j<n; j++)   
        {  
			System.out.print(bowlers[j].name+"=>");
			System.out.print(bowlers[j].ballsLeft);
			System.out.print(" ");
        }
	}
	public static int findGreatest(Bowler[] bowlers, int n)
	{
        int greatest = 0;
        for (int j=1; j<n; j++)   
        {  
            if(bowlers[j].ballsLeft>bowlers[greatest].ballsLeft && bowlers[j].chosen == 0){
                greatest = j;
            }
        }
        return greatest;
	}
}
