

/* ------------Client.java -----------*/
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;





public class Client extends Thread {
	static int thread_count;	
	static int BYTE=1;
	private static class MessageLoop  extends Client  {
		/* ---------------Thread Function for the First thread -------------*/
		public void run(){
			String name="Client-1";
//			String name = args[0];
			Socket socket;
			try {
				String readerInput;
				FileReader fs=new FileReader("1B.txt");// reading from the file
				socket = new Socket ("localhost", 5002);// Connects with the corresponding port number in the server
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader bufferedReader = new java.io.BufferedReader(fs);
				readerInput = bufferedReader.readLine();// reads line from the file
				do{
					printWriter.println(name +": "+readerInput);
				}
				while((readerInput =bufferedReader.readLine()) != null);
				//String readerInput = bufferedReader.readLine();
				BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String mess=bufferedReader1.readLine();
				System.out.println(mess);
				
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 		
			
			}
	
	}
	private static class MessLoop  extends Client  {
		/* ---------------Thread Function for the second thread -------------*/
		 public void run(){
				String name="Client-1";
//				String name = args[0];
				Socket socket;
				try {
					String readerInput;
					FileReader fs=new FileReader("1B.txt");// reading from the file
					socket = new Socket ("localhost", 5010); // Connects with the corresponding port number in the server 
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
					BufferedReader bufferedReader = new java.io.BufferedReader(fs);
					readerInput = bufferedReader.readLine();// reads line from the file

					do{
						printWriter.println(name +": "+readerInput);
					}
					while((readerInput =bufferedReader.readLine()) != null);
					BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String mess=bufferedReader1.readLine();
					System.out.println(mess);
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 		
				
				}
		
		}
		public static void main (String[] args) throws UnknownHostException, IOException, InterruptedException {
			
			
			Scanner sc = new Scanner(System.in);
	    	System.out.println	("\n\n********* Client Executing *********\n\n");
	    	System.out.println("\n Enter no. of threads (1 or 2) : \n");
	    	thread_count=sc.nextInt();
	    	/*------For a Single threads -------*/
	    	if(thread_count == 1)
	    	{
	    		/* Thread initialisation  and starting the thread */
	    		Thread t = new Thread(new MessageLoop());
	    		double startTime = System.nanoTime();
	    		t.start();
	    		/*To terminate the thread  */
	    		t.join();
	    		double end_time = System.nanoTime();
	    		double total_time = (double) end_time - startTime;
	    		System.out.println(total_time);
	    		double RTT= total_time/thread_count;//calculates the return time
	       		System.out.println("Latency = "+RTT*1000+" ms");
	       		System.out.println("Throughput = "+((8*BYTE/RTT)/(1024*1024))+" Mb/sec");
	       		System.out.println("\n Data received successful!!!!\n\n");	    	}
	    	/*------For a Two threads -------*/
	    	else if(thread_count == 2)
	    	{
	    		/* Thread initialisation  and starting the thread */
	    		Thread t1 = new Thread(new MessageLoop());
	    		Thread t2 = new Thread(new MessLoop());
	    		double startTime1 = System.nanoTime();
	    		t1.start();		
	    		t2.start();
	    		/*To terminate the thread  */
	    		t1.join();
	    		t2.join();
	    		double end_time1 = System.nanoTime();
	    		double total_time1 = (double) end_time1 - startTime1;
	    		System.out.println(total_time1);
	    		double RTT= total_time1/thread_count;//calculates the return time
	       		System.out.println("Latency = "+RTT*1000+" ms");
	       		System.out.println("Throughput = "+((8*BYTE/RTT)/(1024*1024))+" Mb/sec");
	       		System.out.println("\n Data received successful!!!!\n\n");		
	    	}
			}

	    	
	
}
					
