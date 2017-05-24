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
