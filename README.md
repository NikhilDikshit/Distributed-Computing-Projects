# Parallel-and-Distributed-Computing-Projects
Source codes of the projects completed as part of the Parallel and Distributed Computing coursework (CS 610) taught by Professor Mehdi Badii at Pace University, New York.

## Week 1 (09/23)
There are two arrays: 'a' and 'b' of type integer. Make two threads to sort: a and b. Make a third thread to merge these two arrays into array: c. The method: main should display array c. Note that the two sort threads should work concurrently. Once the array a and b are sorted the merge thread merges them.

## Week 2 (09/30)
Write two programs to chat. Each program is both the client and the server. 

## Week 3 (10/07)
Write client-server classes to calculate π. We have a number of clients. The server creates a thread for each client. Each client calculates the estimated value of π and sends to the server. The server takes an average of these values and displays a more precise value of π. Note that the server should work for any number of clients by just changing the value of the constant identifier: *size*.

## Week 4 (10/14)
Write a client-server program using RMI for a bank account. 

## Week 5 (12/02)
Write a Pthreads program that uses a Monte Carlo method to estimate π. The main thread should read in the total number of tosses and print the estimate. You may want to use long long int s for the number of hits in the circle and the number of tosses, since both may have to be very large to get a reasonable estimate of π.
