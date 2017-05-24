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
