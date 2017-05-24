# Benchmarks_Cloud_Computing


CPU BENCHMARK
•	PURPOSE: 
This benchmark measures the speed of the processor in terms of GFLOPS and GIOPS running multiple instructions concurrently. Multi-Threading environment is exploited by running the instructions in 2,4 threads also.

•	CODE FLOW:
Here the file Flops.java is used to measure the CPU benchmark in terms of FLOPS.The code here performs addition operations between two Floating point objects.
The addition operation is performed inside the run function once the thread or threads are started.
The main fuction asks the user whether FLOPS are to be done to 1 or 2 or 4 threads.
Threads are created by performing the following:
Thread t= new Thread();
A thread.join condition is performed to before the end time is calculated to make sure that all threads running have been successfully terminated before endtime is calculated  

Another file IOPS.java is used to measure the CPU benchmark speed in terms of GIOPS. Here increment operation for an interger is performed.The main function and thread function activities for this class are similar to as of FLOPS 

A System.nanoTime() function is used to determine the time taken to perform the addition as well as the increment operations. 

1,2,4 threads are separately called and their total time is measured 

Another experiment is to be performed where GFLOPS and GIOPS for 4 threads are run for 10 minutes and instruction per cycle is measured every second. The data obtained is then plotted. Here two more Java classes are used.


Disk Benchmark:
This benchmark measures the speed of the disk for the read and write operations. Both sequential and random seeks are implemented for varying concurrency levels[1 thread & 2 thread] and varying block sizes[ 1byte, 1 kilobyte and 1megabite]

Code:
The benchmark has 3 individual file in it. 
•	disk.java: Here the file uses the function run to copy a byte of data into the disk using single thread or 2 threads.
•	diskKB,java: Here the file uses the function run to copy a 1 kilobyte of data into the disk using single thread or 2 threads.
•	disk_megabyte.cpp: Here the file uses the function run to copy a i megabyte of data into the disk using single thread or 2 threads.

Here file handling functions are being performed
•	FileWriter fw=new FileWriter("abc1.txt");
        fw.write("s");  
A simple text file  is created with this function and content 's' is written in it(for 1KB and 1MB we iterate so that the file can have 1KB and 1MB size respectively) .

•	fr.read();
This reads a byte of data from the text file into the buffer.

For the random access a string is 'Hello' is used. The characters from this String are randomly taken and randomly positioned in the file by using.
 Random r=new Random();
 RandomAccessFile file = new RandomAccessFile("abc4.txt", "rw");
 file.seek(v);

File is randomly read using 
 Random r=new Random();
 RandomAccessFile file1 = new RandomAccessFile("abc4.txt", "r");
 file1.seek(v);
 file1.read();


System.nanoTime() function is used to determine the time taken for the transfers, Difference of end time and start time allocated in tot_time_write variable and latency and write speed is calculated in MB/sec accordingly.

The main() function provides the choice to the user for selecting the concurrency. 


NETWORK BENCHMARK

PURPOSE: 
This benchmark exploits the client-server architecture to measure the Throughput and Latency of the underlying network.

CODE FLOW: 
This benchmark contains the following files. 
TCP
•	Server.java
•	Client.java
•	TCPClient1KB.java
•	TCPClient64KB.java
UDP
•	UDPServer.java
•	UDPClient.java
•	UDPClient1KB.java
•	UDPClient64KB.java


On the TCP server side two separate threads having two different port number are created.
Each of these threads performs the same operation of the recieving the all packets from the client.The ouput recieved is "Incoming Client Message ok : " along with packet data. The data are recieved from the client with the use of socket 
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); recieves the input from the client socket having the same port number.

The UDP Server is almost similar to TCPServer with the difference being that the UDPServer uses DatagramSocket in place of ServerSocket.DatagramPacket is initialized in order to recieve data from the client side.The recieved data is stored in a string and is displayed. The address and portnumber of the sender is obtained and a confirmation message is sent


The TCP Client side has two separate threads with two different port numbers.The port numbers along with the address are used to connect to the server. A file of 1byte size is taken and its data is sent tot the server side.The main method here asks the user as to how many threads he is using
The TCPClient1KB and TCPClient 4KB are similar to the above withe difference being the file size.

The UDPClient acts similar to the TCPserver except DatagramPacket and Datagramsockets are used here.This sends the data to server side using datagramsocket,datagramPacket,address and port number.The server then responds to the client which is displayed.
The UDPClient1KB and UDPClient4KB are similar to the above withe difference being the file size.

NOTE:1) Place the given text files 1B.txt, 1KB.txt, 64kb.txt in the same location as that java file
2) In order the run the change the address and port number of the instance, go to the corresponding client code and change the address and port number.

Executiom 

•	javac Server.java
	java Server
•	javac Client.java
	java Client
•	javac TCPClient1KB.java
	java TCPClient1KB
•	javac TCPClient64KB.java
	java TCPClient64KB
UDP
•	javac UDPServer.java
	java UDPServer
•	javac UDPClient.java
	java UDPClient
•	javac UDPClient1KB.java
	java UDPClient1KB
•	javac UDPClient64KB.java
	java UDPClient64KB
