

/* ------------- UDPClient.java ------------*/
import java.io.*;
import java.net.*;
import java.util.Scanner;



class UDPClient
{
	static int thread_count;
	static int BYTE=1; //for BYTE values
	private static class MessageLoop  extends Client  {
		 public void run() {
  Socket socket = null;
  FileReader fs;
try {
	fs = new FileReader("1B.txt");// reading from the file
	BufferedReader bufferedReader = new java.io.BufferedReader(fs);;
	 DatagramSocket clientSocket = new DatagramSocket(); //Socket to connect with the server
	 InetAddress IPAddress = InetAddress.getByName("localhost"); //host address
	 byte[] buffer = new byte[1024];
	 String sentence = bufferedReader.readLine();
	 buffer = sentence.getBytes();
	 DatagramPacket sPacket = new DatagramPacket(buffer, buffer.length, IPAddress, 9876); //packet along with data, address and port number
	 byte[] recpac = new byte[1024];
	 
	 clientSocket.send(sPacket);//Packet is sent
	 DatagramPacket recpacket = new DatagramPacket(recpac, recpac.length);
	 clientSocket.receive(recpacket); //Packet is received from the server
	 String mas = new String(recpacket.getData());
	 System.out.println(" packet from SERVER Thread 1:" );
//	 while((mas =bufferedReader.readLine()) != null){
//	 System.out.println("FROM SERVER:" );
//	 }
	 clientSocket.close();
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
	}
	}
		 private static class MessLoop  extends Client  {
			 public void run() {
	  Socket socket = null;
	  FileReader fs;
	try {
		fs = new FileReader("1B.txt");// reading from the file
		BufferedReader bufferedReader = new java.io.BufferedReader(fs);;
		 DatagramSocket clientSocket = new DatagramSocket(); //Socket to connect with the server
		 InetAddress IPAddress = InetAddress.getByName("localhost"); //host address
		 byte[] buffer = new byte[1024];
		 String sentence = bufferedReader.readLine();
		 buffer = sentence.getBytes();
		 DatagramPacket sPacket = new DatagramPacket(buffer, buffer.length, IPAddress, 9877); //packet along with data, address and port number
		 byte[] recpac = new byte[1024];
		 
		 clientSocket.send(sPacket);//Packet is sent
		 DatagramPacket recpacket = new DatagramPacket(recpac, recpac.length);
		 clientSocket.receive(recpacket); //Packet is received from the server
		 String mas = new String(recpacket.getData());
		 System.out.println("packet from SERVER Thread 2:" );
		 while((mas =bufferedReader.readLine()) != null){
		 System.out.println("FROM SERVER:" );
		 }
		 clientSocket.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
		}
		 }
   public static void main(String args[]) throws InterruptedException 
   {
	   Scanner sc = new Scanner(System.in);
   	System.out.println	("\n\n********* Client Executing *********\n\n");
   	System.out.println("\n Enter no. of threads (1 or 2) : \n");
   	thread_count=sc.nextInt();
   	/*------For a Single threads -------*/
   	if(thread_count == 1)
   	{
   		/* Thread initialisation  and starting the thread */
   		Thread t = new Thread(new MessageLoop());
   		long startTime = System.nanoTime();
   		t.start();
   		/*To terminate the thread  */
   		t.join();
   		long end_time = System.nanoTime();
   		double total_time =  (end_time - startTime)/1000000000;
   		System.out.println(total_time);
   		double RTT= total_time/thread_count;
   		System.out.println("Latency = "+RTT*1000+"ms");//calculates the return time
   		System.out.println("Throughput = "+((8*BYTE/RTT)/(1024*1024))+" Mb/sec");
   		System.out.println("\n Data received successful!!!!\n\n");
   	}
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
   		double total_time1 = (end_time1 - startTime1)/1000000000;
   		System.out.println(total_time1);
   		double RTT= total_time1/thread_count;
   		System.out.println("Latency = "+RTT*1000+" ms");//calculates the return time
   		System.out.println("Throughput = "+((8*BYTE/RTT)/(1024*1024))+" Mb/sec");
   		System.out.println("\n Data received successful!!!!\n\n");
	
   	}
		}

   	


   		
   }
		
