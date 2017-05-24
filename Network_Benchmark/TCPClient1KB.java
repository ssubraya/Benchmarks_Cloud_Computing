

/* ------------TCPClient1KB.java -----------*/
import java.net.Socket;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;





public class TCPClient1KB extends Thread {
	static int thread_count;
	public static final int PORT = 8888;
	static int KB=1024;

	private static class MessageLoop  extends TCPClient1KB  {
		/* ---------------Thread Function for the First thread -------------*/
	 public void run(){
			String name="Client-1";
//			String name = args[0];
			Socket socket;
			try {
				String readerInput;
				FileReader fs=new FileReader("abc4.txt");// reading from the file
				socket = new Socket ("localhost", 8877);// Connects with the corresponding port number in the server
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
				//String readerInput = bufferedReader.readLine();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 		
			
			}
	
	}
	private static class MessLoop  extends TCPClient1KB  {
		/* ---------------Thread Function for the second thread -------------*/
		 public void run(){
				String name="Client-1";
//				String name = args[0];
				Socket socket;
				try {
					String readerInput;
					FileReader fs=new FileReader("1KB.txt");// reading from the file
					socket = new Socket ("localhost", 8890);// Connects with the corresponding port number in the server
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
					//String readerInput = bufferedReader.readLine();
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
	    		double total_time = (end_time - startTime)/1000000000;
	    		System.out.println(total_time);
	    		double RTT= total_time/thread_count;   	//calculates the return time	
	       		System.out.println("Latency = "+RTT*1000+" ms");
	       		System.out.println("Throughput = "+((8*KB/RTT)/(1024))+" Mb/sec");
	       		System.out.println("\n Data received successful!!!!\n\n");	    	}

	    	/*------For a two threads -------*/
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
	    		double total_time1 = (end_time1 - startTime1)/1000000000;
	    		System.out.println(total_time1);
	    		double RTT= total_time1/thread_count;   //calculates the return time		
	       		System.out.println("Latency = "+RTT*1000+" ms");
	       		System.out.println("Throughput = "+((8*KB/RTT)/(1024))+" Mb/sec");
	       		System.out.println("\n Data received successful!!!!\n\n");		
	    	}
			}

	    	
	
}
					
