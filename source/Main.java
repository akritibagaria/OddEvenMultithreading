import java.util.*;

public class Main {
	public static void main(String args[])
	{
		int noOfthreads = 2;
		Thread [] t = new Thread[noOfthreads];
		OddEven oe = new OddEven(2, noOfthreads);
		for(int i = 0; i<noOfthreads ; i++) {
			t[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						oe.printNumbers();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
					
				}
			});
		}
		for(int i = 0; i<noOfthreads ; i++) {
			t[i].setName(String.valueOf(i));
			t[i].start();
			//System.out.println("started thread " + (i));
		}
		
		for(int i=0; i<noOfthreads; i++) {
			try {
				t[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
