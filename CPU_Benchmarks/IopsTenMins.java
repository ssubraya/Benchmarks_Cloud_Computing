package pa1;
/*FlopsTenMins.java */
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;





public class IopsTenMins extends Thread {

static ArrayList<Double> al= new ArrayList<>();	

	private static class MessLoop extends  IopsTenMins   {
	private final ScheduledExecutorService scheduler =
		       Executors.newScheduledThreadPool(1);
	/* --------------------------- Thread  function getting GIOPS every second  ----------------*/
		    public void run() {
		        final Runnable gflops = new Runnable() {
		                public void run() { 
		                	if(al.listIterator().hasNext()==true)
		                	{//System.out.println(al);
		                		System.out.println(al.listIterator().next());
		                	al.remove(0);
		                	}
		                	//System.out.println(al.listIterator().next()); 
		                	}
		                
		                };
		        final ScheduledFuture<?> gflopshan =
		            scheduler.scheduleAtFixedRate(gflops, 1, 1, TimeUnit.SECONDS);
		        scheduler.schedule(new Runnable() {
		                public void run() { gflopshan.cancel(true); }
		            }, 600, TimeUnit.SECONDS);
		    }
	}
	private static class MessageLoop extends  IopsTenMins   {
		/* --------------------------- Thread  function for floating point addition  ----------------*/
		public void run() {
				

			long sample_int=50;;

			// Floating point  addition for 10^9 iterations
					for (long k = 0; k <= 1000000000; k++)
					{
	
						sample_int = sample_int+k;					}
				
		
	}

	}
		
		
	public static void main(String args[]) throws InterruptedException {


	

		System.out
				.println("-------------------- 4 Threads --------------------");

		final long NANOSEC_PER_SEC = 1000l*1000*1000;

		long start = System.nanoTime();
		while ((( System.nanoTime())-start)< 10*62*NANOSEC_PER_SEC){    // 10 Minute Run
		
			/* Thread initialisation  and starting the thread */
			Thread a1 = new Thread(new MessageLoop());
			Thread a2 = new Thread(new MessageLoop());
			Thread a3 = new Thread(new MessageLoop());
			Thread a4 = new Thread(new MessageLoop());
			double startTime2 = System.nanoTime();
			a1.start();
			a2.start();
			a3.start();
			a4.start();
			/*To terminate the thread  */
			a1.join();
			a2.join();
			a3.join();
			a4.join();

		double end_time2 = System.nanoTime();
		double total_time2 = ( end_time2 - startTime2)/1000000000;
		System.out.println(total_time2);
		double f=(( 1000000001 / (total_time2))*6*4)/1000000000;
		System.out.println("GIOPS for 4 threads =" + f);
		//}
		al.add(f);// to store the GFLOPS
		}
		//To run the thread every second
		Thread b1= new Thread(new MessLoop());
		b1.start();
		b1.join();
	}
}