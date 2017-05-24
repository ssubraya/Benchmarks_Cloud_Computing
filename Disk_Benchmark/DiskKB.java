
/*----- DiskKB.java  ------- */


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class DiskKB extends Thread{
	static double total_write_time;
	 static double total_read_time;
	 static double total_write_time1;
	 static double total_read_time1;

	final static int KB=1024; //Kilobyte initialisation
	public static void main(String args[]) throws IOException, InterruptedException{  
		 
		class MessageLoop implements Runnable{

			/* --------------------------- Thread  function for Disk with KB data  ----------------*/
			public void run(){
	
		double startTime  = System.nanoTime();
		 /*-- Sequential Write --*/
		  try{ 
			  FileWriter fw=new FileWriter("abc45.txt");// To create a file
		for(int i=0;i<KB;i++){
		  
			
		   fw.write("s");  // to enter a character into the file
		   
		}
		fw.close();
		  }
		  catch(Exception e){System.out.println(e);}  
		   
		  double end_time=System.nanoTime();
		  System.out.println(end_time);
		   total_write_time=(end_time-startTime)/1000000000;
		
		   /*-- Sequential Read --*/
		double startTime1 = System.nanoTime();
		try {
			FileReader fr=new FileReader("abc45.txt");
		for(int i=0;i<KB;i++){
			
	  int m;  
	  fr.read();// To read a character
		//while((m=fr.read())!=-1)  
		 // System.out.println((char)m); 
		 
	}
		fr.close();
		}catch (IOException e) {
		// TODO Auto-generated catch block
			System.out.println(e);
	}  
	  
	 
	
		double end_time1=System.nanoTime();
		 total_read_time=(end_time1-startTime1)/1000000000;
		 
		 /*-- Random Write --*/
		 double startTime2 = System.nanoTime();
		 try {
			 Random r=new Random();
		 RandomAccessFile file = new RandomAccessFile("abc25.txt", "rw");
		 String al ="Hello";
		 int n= al.length();
		 for(int i=0;i<KB;i++){
			 int x=r.nextInt(n);
			 int v=r.nextInt(KB);//Randomly selects a number
			 file.seek(v);//Points to v position in the file
				 file.writeByte(al.charAt(x));
				 
				 } file.close();}catch (FileNotFoundException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
				 } catch (IOException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
				 }
		 
		 double end_time2=System.nanoTime();
		  total_write_time1=(end_time2-startTime2)/1000000000;
		 
		  /*-- Random Read -- */
		 double startTime4 = System.nanoTime();				 
		 try {
			 Random r=new Random();
			RandomAccessFile file1 = new RandomAccessFile("abc25.txt", "r");
		 for(int i=0;i<KB;i++){
			 int v=r.nextInt(KB);
					file1.seek(v);//Points to v position in the file
					file1.read();//Reads the file
				//System.out.println((char)file1.read());
					
				}file1.close();} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				 
		 
		 double end_time4=System.nanoTime();
		  total_read_time1=(end_time4-startTime4)/1000000000;
			}
		}
	
		while(true)
		{
		System.out.println("\n\n ***** MENU *****\n\n 1-->Byte Transfer of Single thread \n 2-->Byte Transfer of Two threads   \n\n");
	 
		Scanner sc=new Scanner(System.in);
		System.out.println("\nSelect your choice from above menu : ");
		
		int choice=sc.nextInt();
			
		switch(choice)
		{
		/*------Byte Transfer Using a Single threads -------*/
			case 1 : System.out.println("\n*** Byte Transfer(Single thread) ***");
			/* Thread initialisation  and starting the thread */
			MessageLoop m=new MessageLoop();
			Thread t = new Thread(m);
			t.start();
			/*To terminate the thread  */
			t.join();
			
			System.out.println("----------Sequential Access ----------------");
			System.out.println(total_write_time);
			System.out.println(total_read_time);
			System.out.println("\nLatency(time for kilobyte write operation) is   : "+(double)(total_write_time/KB)*1000+" msec");
			System.out.println("\n Throughput(KiloByte write speed) = "+(double)(KB/(1024*total_write_time))+" MB/s");
			System.out.println("\nLatency(time for kilobyte read operation) is   : "+(double)(total_read_time/KB)*1000+" msec");
			System.out.println("\nThroughput(KiloByte kiloread speed) = "+(double)(KB/(1024*total_read_time))+" MB/s");
			System.out.println("\n* * * * * Random Access * * * * *");
			System.out.println("\nLatency(time for kilobyte write operation) is   :  "+(double)(total_write_time1/KB)*1000+"msec");
			System.out.println("\nThroughput(KiloByte write speed) = "+ (double)(KB/(1024*total_write_time1))+"MB/s");
			System.out.println("\nLatency(time for kilobyte read operation) is  :  "+(double)(total_read_time1/KB)*1000+"msec");
			System.out.println("\nThroughput(KiloByte read speed) = "+(double)(KB/(1024*total_read_time1))+"MB/s");
			 	 break; 
			 	 
			 	/*------Byte Transfer Using Two threads -------*/
			case 2 : System.out.println("\n*** Byte Transfer(Two threads) ***");
			/* Thread initialisation  and starting the thread */
			MessageLoop m1= new MessageLoop();
			Thread t1 = new Thread(m1);
			Thread t2 = new Thread(m1);
			t1.start();
			t2.start();
			/*To terminate the thread  */
			t1.join();
			t2.join();
			System.out.println("----------Sequential Access ----------------");
			System.out.println(total_write_time);
			System.out.println(total_read_time);
			System.out.println("\nLatency(time for kilobyte write operation) is   : "+(total_write_time/KB)*1000+" msec");
			System.out.println("\nThroughput(KiloByte write speed) = "+(double)(KB/(1024*total_write_time))+" MB/s");
			System.out.println("\nLatency(time for kilobyte read operation) is   : "+(total_read_time/KB)*1000+" msec");
			System.out.println("\nThroughput(KiloByte read speed) = "+(double)(KB/(1024*total_read_time))+" MB/s");
			System.out.println("\n* * * * * Random Access * * * * *");
			System.out.println("\nLatency(time for kilobyte write operation) is   :  "+(total_write_time1/KB)*1000+"msec");
			System.out.println("\nThroughput(KiloByte write speed) = "+ (double)(KB/(1024*total_write_time1))+"MB/s");
			System.out.println("\nLatency(time for kilobyte read operation) is  :  "+(total_read_time1/KB)*1000+"msec");
			System.out.println("\nThroughput(KiloByte read speed) = "+(double)(KB/(1024*total_read_time1))+"MB/s");
			 	 break;

					
		
			default : System.out.println("\nPLEASE ENTER A VALID INPUT!!");
				 break;
		}
Scanner sc1= new Scanner(System.in);
		System.out.println("\n\nDo you wish to continue...??? ");
		System.out.println("1 --> YES");
		System.out.println("2 --> NO");
		int choice1=sc1.nextInt();

		if(choice1==1)
			continue;

		else
			System.exit(0);
		}
	}
}
