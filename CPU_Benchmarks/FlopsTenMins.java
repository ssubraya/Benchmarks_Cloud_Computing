package pa1;

import java.util.Timer;



public class FlopsTenMins extends Thread {

	
	// Display a message, preceded by
	// the name of the current thread
	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.println("Name 4: " + threadName);
		System.out.format("%s: %s%n", threadName, message);
	}

	private static class MessageLoop extends  FlopsTenMins   {
		public void run() {
				

			float sample_float1, sample_float2, sample_float3;
			//sample_float1 = 1.3f;
			//sample_float2 = 5.6f;
			
					for (int k = 0; k < 1000000000; k++)
					{
	
						sample_float3 = 1.3f + 5.6f;
						sample_float1= 5.6f-1.3f;
					}
				
		
	}

	}
		
		
	public static void main(String args[]) throws InterruptedException {

		threadMessage("Starting MessageLoop thread");

	

		System.out
				.println("-------------------- 4 Threads --------------------");

		final long NANOSEC_PER_SEC = 1000l*1000*1000;

		long start = System.nanoTime();
		while ((( System.nanoTime())-start)< 1*60*NANOSEC_PER_SEC){		
		Thread a1 = new Thread(new MessageLoop());
		Thread a2 = new Thread(new MessageLoop());
		Thread a3 = new Thread(new MessageLoop());
		Thread a4 = new Thread(new MessageLoop());
		long startTime2 = System.nanoTime();
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		a1.join();
		a2.join();
		a3.join();
		a4.join();
		long end_time2 = System.nanoTime();
		double total_time2 = ((double) end_time2 - startTime2)/1000000000;
		System.out.println(total_time2);
		System.out.println("Flops for thread 4=" + ((float) 1000000000 * 2*4/ (total_time2))/1000000000);
		}
		threadMessage("Finally!");
	}
}