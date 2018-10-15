# Distributed-Computing-Projects
Source codes of the projects completed as part of the Distributed Computing coursework (CS 610) taught by Prof. Mehdi Badii at Pace University, New York.

## Week 1 (09/23)
There are two arrays: 'a' and 'b' of type integer. Make two threads to sort: a and b. Make a third thread to merge these two arrays into array: c. The method: main should display array c. Note that the two sort threads should work concurrently. Once the array a and b are sorted the merge thread merges them.

## Week 2 (09/30)
Write two programs to chat. Each program is playing the role of a client and a server. Name one of them MyServer.java and the other MyClient.java. This is how these programs should work:
* **Run MyServer:** The program is waiting for the client. After the client is connected the server program sends *Hello !!*
* **Run MyClient:** This program receives the word: *Hello !!*  

**The following steps are repeated until the client enters: *Bye***
```
$ Enter a message on the client’s console (Like: How are you server?) 
This message should appear on the server’s console (like: How are you server?)

$ Enter a message on the server’s console (like: I am good. Do you have any question client?) 
This message should appear on the client’s console (like: I am good. Do you have any question client?)
```
It is acceptable if both sides alternate on sending messages. However, it would be good if you make your project like the real online chat (e.g. yahoo messenger, skype messenger).

## Week 3 (10/07)
Write client-server classes to calculate π. We have a number of clients. The server creates a thread for each client. Each client calculates the estimated value of π and sends to the server. The server takes an average of these values and displays a more precise value of π. Note that the server should work for any number of clients by just changing the value of the constant identifier: *size*.

## Week 4 (10/14)
Write a client-server program using RMI for a bank account. Note that my bank is just a Java vector. Each customer is an object of the following class:
```
//Needs on the server side.
class Account
{
  public String name;
  public int accountNo;
  public float balance;
	
  public Account(String name, int accountNo, float balance)
  {
    this.name = name; this.accountNo = accountNo; this.balance = balance;
  }
}
```
Use the following interface to completer the program. Note: The vector is of the type of this class:
```
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountInterface extends Remote {
//In creating an account, it is the bank that selects an account number. In
//our project the first new account is 100, the next is 101, next is 102,...
//Anyone can open a new account. It does not matter if the person has already accounts	  
public String createAccount(String name, float balance) throws RemoteException;
  
//If the name with accountNo is in the bank return the person balance as a string.
//otherwise either name has no account or his account no is wrong.  
public String getBalance(String name, int accountNo) throws RemoteException;
  
// The account number with the name must be in the bank.
// There is not enough fund return to the user a message.
// There is enough funds. Withdraw and return the new balance.  
public String withdraw(String name, float amt,  int accountNo)throws RemoteException;
  
// The account number with the name must be in the bank.
// If account number with the name is in the bank, deposit and return the new balance.
public String deposit(String name, float amt, int accountNo) throws RemoteException;
  
// Both account numbers with the same name must be in the bank.
// There is not enough fund in the account that is goind to transfer return to the user a message.
// There is enough funds. Withdraw and return the new balance.
public String transfer(String name, int fromAccount,  int toAccount, float amt) throws RemoteException;
}
```
