
import java.util.ArrayList;
/*----- Flops.java  ------- */
import java.util.Scanner;


public class Flops extends Thread {

	
static ArrayList<Double> a= new ArrayList<>();
static int count=0;
static float sum = 0;
	private static class MessageLoop extends  Flops   {
		/* --------------------------- Thread  function for floating point addition  ----------------*/
		public void run() {
			float sample_float1, sample_float2, sample_float3;
			//sample_float1 = 1.3f;
			//sample_float2 = 5.6f;
			
			//double startTime = System.currentTimeMillis();//start time

					for (long k = 0; k <= 1000000000; k++)
					{
	
						sample_float3 = 1.3f + 5.6f;
//+1.5f+2.4f3.5f+3.5f+5.4f+5.2f1.3f + 5.6f1.5f+2.4f3.5f+3.5f5.4f+5.2f+7.4f+2.4f+1.3f + 5.6f+1.5f+2.4f+3.5f+3.5f+5.4f+5.2f+7.4f+2.4f;

	}

					//double end_time = System.currentTimeMillis(); //end time
					//double total_time =  (end_time - startTime)/1000;
					//System.out.println(total_time);
					//double f=(double) (((1000000000 / (total_time))*6)/1000000000);
					//count++;
					//a.add(f);
					//System.out.println("Flops for thread 1 =" + f);
					}

	}
	public static void main(String args[]) throws InterruptedException {

Scanner sc=new Scanner(System.in);
System.out.println("Enter the number of threads\n");
System.out.println("1 ---------------  1 Thread");
System.out.println("2 ---------------  2 Threads");
System.out.println("3 ---------------  4 Threads");
int m=sc.nextInt();
if(m==1){
	/*------------ For a single Thread-----------*/

		System.out
				.println("-------------------- 1 Thread --------------------");
		
		/* Thread initialisation  and starting the thread */
		Thread t = new Thread(new MessageLoop());
double startTime = System.currentTimeMillis();//start time		
t.start();
		/*To terminate the thread  */
		t.join();
 double end_time = System.currentTimeMillis(); //end time
                                          double total_time =  (end_time - startTime)/1000;
                                          System.out.println(total_time);
                                          double f=(double) (((1000000000 / (total_time))*6)/1000000000);
System.out.println("GFlops for thread 1 =" + f);

//		for(double e:a){
    //                                      sum+=e;
  //               System.out.println(count);
      //            System.out.println(sum);
        //          System.out.println(" Avg Flops for thread =" + sum/count);
          //         }

}
else if (m==2) {
	/*----------- For a two threads Thread-------------*/

		System.out
				.println("-------------------- 2 Threads --------------------");
		
		/* Thread initialisation  and starting the thread */
		Thread t1 = new Thread(new MessageLoop());
		Thread t2 = new Thread(new MessageLoop());
double startTime = System.currentTimeMillis();//start time
		t1.start();		
		t2.start();
		/*To terminate the thread  */
		t1.join();
		t2.join();
 double end_time = System.currentTimeMillis(); //end time
                                          double total_time =  (end_time - startTime)/1000;
                                          System.out.println(total_time);
                                          double f=(double) (((1000000000 / (total_time))*6*2)/1000000000);
System.out.println("GFlops for thread 1 =" + f);
//for(double e:a){
  //                                        sum+=e;
    //                                      System.out.println(count);
      //                                    System.out.println(sum);
        //                                  System.out.println(" Avg Flops for thread =" + sum/count);
          //                                }


	}
else if (m==3) {
	
	/*----------- For a four threads Thread-------------*/
		System.out
				.println("-------------------- 4 Threads --------------------");

		/* Thread initialisation  and starting the thread */
		Thread a1 = new Thread(new MessageLoop());
		Thread a2 = new Thread(new MessageLoop());
		Thread a3 = new Thread(new MessageLoop());
		Thread a4 = new Thread(new MessageLoop());
double startTime = System.currentTimeMillis();//start time
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		/*To terminate the thread  */
		a1.join();
		a2.join();
		a3.join();
		a4.join();
 double end_time = System.currentTimeMillis(); //end time
                                          double total_time =  (end_time - startTime)/1000;
                                          System.out.println(total_time);
                                          double f=(double) (((1000000000 / (total_time))*6*4)/1000000000);
System.out.println("GFlops for thread 1 =" + f);
//for(double e:a){
  //                                        sum+=e;
    //                                      System.out.println(count);
      //                                    System.out.println(sum);
        //                                 System.out.println(" Avg Flops for thread =" + sum/count);
          //                                }

}
else{
 System.out.println("Enter proper input");
}
	}
}
