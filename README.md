# Distributed-Computing-Projects
Source codes of the projects completed as part of the Distributed Computing coursework (CS 610) taught by Prof. Mehdi Badii at Pace University, New York

## Week 1 (09/23)
There are two arrays: 'a' and 'b' of type integer. Make two threads to sort: a and b. Make a third thread to merge these two arrays into array: c. The method: main should display array c. Note that the two sort threads should work concurrently. Once the array a and b are sorted the merge thread merges them.

## Week 2 (09/30)
Write two programs to chat. Each program is playing the role of a client and a server. Name one of them MyServer.java and the other MyClient.java. This is how these programs should work:
* **Run MyServer:** The program is waiting for the client. After the client is connected the server program send: *Hello !!*
* **Run MyClient:** This program receives The word: *Hello !!*  

**The following steps are repeated until the client enters: *bye***
```
$ Enter a message on the client’s console (Like: How are you server?) 
This message should appear on the server’s console (like: How are you server?)

$ Enter a message on the server’s console (like: I am good. Do you have any question client?) 
This message should appear on the client’s console (like: I am good. Do you have any question client?)
```
It is acceptable if both sides alternate on sending messages. However, it would be good if you make your project like the real online chat (e.g. yahoo messenger, skype messenger).

## Week 3 (10/07)
Write client-server classes to calculate *π*. We have a number of clients. The server creates a thread for each client. Each client calculates the estimated value of π and sends to the server. The server takes an average of these values and displays a more precise value of *π*. Note that the server should work for any number of clients by just changing the value of the constant identifier: *size*.
