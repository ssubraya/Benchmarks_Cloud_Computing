

/*-----Server.java -----*/
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;


public class Server extends Thread{
		public static void main(String[] args) throws IOException, InterruptedException {
			int thread_count;

			Scanner sc = new Scanner(System.in);
	    	System.out.println	("\n\n********* Server Executing *********\n\n");
	    	System.out.println("\n Enter no. of threads (1 or 2) : \n");
	    	thread_count=sc.nextInt();
			if(thread_count==2){
				/* -- to run the thread functions */
			new Server().runServer();
			new Server().runServer1();
			}
			else if(thread_count==1){
				new Server().runServer();

			}
	    	}
			
		
	public void runServer() throws IOException {
		final int PORT = 5002;

                ServerSocket serverSocket = new ServerSocket(PORT);
System.out.println("Server is Ready and Running.........!");
		Socket socket = serverSocket.accept();//sockets accepts from the client
		new ServerThread(socket).start(); /* Thread is started  */
		



     }
	
	public void runServer1() throws IOException {
		final int PORT1 = 5010;

        ServerSocket serverSocket1 = new ServerSocket(PORT1);
System.out.println("Server is Ready and Running.........!");
System.out.println("Hi");
		Socket socket2 = serverSocket1.accept();//sockets accepts from the client
		new ServerThread2(socket2).start();/* Thread is started  */

     }
	

public class ServerThread extends Thread{
	Socket socket;
	ServerThread(Socket socket){
	this.socket = socket;
	}	
	public void run() {
	try {
        String message = null;
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));// receives the packets from the client
        while (( message = bufferedReader.readLine()) != null) {
	System.out.println("Incoming Client Message ok : " +message);
//	socket = new Socket ("localhost", 8887);
	PrintWriter printWriter1 = new PrintWriter(socket.getOutputStream(), true);
	printWriter1.println("packet received from t1");
	}

	socket.close();
	} catch (IOException e) {
          e.printStackTrace();
       }
     }
   }

public class ServerThread2 extends Thread{
	Socket socket;
	ServerThread2(Socket socket2){
	this.socket = socket2;
	}	
	public void run() {
	try {
        String message = null;
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));// receives the packets from the client
        while (( message = bufferedReader.readLine()) != null) {
	System.out.println("Incoming Client Message ok : " +message);
	PrintWriter printWriter1 = new PrintWriter(socket.getOutputStream(), true);
	printWriter1.println("packet received from t2");

	}

	socket.close();
	} catch (IOException e) {
          e.printStackTrace();
       }
     }
   }

	
}


