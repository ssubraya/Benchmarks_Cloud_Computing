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

Another experiment is to be performed where GFLOPS and GIOPS for 4 threads are run for 10 minutes and instruction per cycle is measured every second.The data obtained is then plotted. Here two more Java classes are used.  

