

/* ---UDPServer.java ---*/ 
import java.io.*;
import java.net.*;



class UDPServer
{
   public static void main(String args[]) throws Exception
      {
	   new UDPServer().runServer();
	   
      
      }
   public void runServer() throws IOException {
	   DatagramSocket serverSocket = new DatagramSocket(9876);//to get packets from the client
	   DatagramSocket serverSocket1 = new DatagramSocket(9877);//to get packets from the client
System.out.println("Server is Ready and Running.........!");
/*--Threads are started--*/
		new ServerThread(serverSocket).start(); ;
		new ServerThread2(serverSocket1).start();

   }
   public class ServerThread extends Thread{
	   DatagramSocket serverSocket;
	   public ServerThread(DatagramSocket serverSocket) {
		// TODO Auto-generated constructor stub
		   this.serverSocket=serverSocket;
	}
/* --Thread function --*/
	public void run(){
		   byte[] rec = new byte[63*1024];
	       byte[] s = new byte[63*1024];
	       while(true)
	          {
	             DatagramPacket recpacket = new DatagramPacket(rec, rec.length);
	             try {
					serverSocket.receive(recpacket); //receives the packet
					
	             String t = new String( recpacket.getData()); //data is then stored in a string
		             System.out.println("Packet RECEIVED from client from thread 1");
					
		             InetAddress IPAddress = recpacket.getAddress(); // address of the client
		             int port = recpacket.getPort(); // port number
		             s = t.getBytes();
		             DatagramPacket sendPacket =
		             new DatagramPacket(s, s.length, IPAddress, port);
		             serverSocket.send(sendPacket); //packet is sent to the client 
					}
				 catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	          }
	   }
   }
   
   public class ServerThread2 extends Thread{
	   DatagramSocket serverSocket;
	   public ServerThread2(DatagramSocket serverSocket1) {
		// TODO Auto-generated constructor stub
		   this.serverSocket=serverSocket1;
	}
/*-- Thread Function for the second port --*/
	public void run(){
		   byte[] rec = new byte[1024];
	       byte[] s = new byte[1024];
	       while(true)
	          {
	             DatagramPacket recpacket = new DatagramPacket(rec, rec.length);
	             try {
	            	 serverSocket.receive(recpacket); //receives the packet

		             String t = new String( recpacket.getData()); //data is then stored in a string
		             System.out.println(" Packet RECEIVED from client from thread 2 " );
					
		             InetAddress IPAddress = recpacket.getAddress(); // address of the client
		             int port = recpacket.getPort(); // port number
		             s = t.getBytes();
		             DatagramPacket sendPacket =
		             new DatagramPacket(s, s.length, IPAddress, port);
		             serverSocket.send(sendPacket); //packet is sent to the client 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	          }
	   }
   }
}
