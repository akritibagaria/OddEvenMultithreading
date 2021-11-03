import java.util.*;
public class OddEven {
int max ; 
volatile int count;
volatile Integer threadId;
int noOfThreads ;


public OddEven(int max, int noOfThreads) {
	super();
	this.max = max;
	this.noOfThreads = noOfThreads;
	count = 1 ;
	threadId =0;
}

//TODO: Try to pass threadId as a parameeter here
public synchronized void printNumbers() throws InterruptedException
{

	   while(count <= max)
	   {
		   while(!(Thread.currentThread().getName().equals(threadId.toString()))) 
		   {
			   System.out.println("Thead " + Thread.currentThread().getName() + " addeed to wait queue");
			   wait();
		   }
		   System.out.println("thread " + Thread.currentThread().getName() + "printed " + count +  "!!!!!!!!!!!!!!!!!!!!!!!!!!!!") ;
		   count++;
		   threadId = (threadId + 1)%noOfThreads;
		   notifyAll();
	   }
}

}
