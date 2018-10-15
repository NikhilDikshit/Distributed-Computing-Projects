/**
 * @author nikhil
 *
 */
import java.io.*;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
import java.rmi.*;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class ClientCustomer extends UnicastRemoteObject implements AccountInterface {
	private static final long serialVersionUID = 1L;
	
	int customerID;
	String name;
	int accountNo;
	float balance;
	Scanner input = new Scanner(System.in);

	public ClientCustomer(int customerID, String name, int accountNo, int balance) throws RemoteException {
		super();
		this.customerID = customerID;
		this.name = name;
		this.accountNo = accountNo;
		this.balance = balance;
	}

	// display existing user
	public void display(ArrayList<ClientCustomer> accounts) throws RemoteException {
		System.out.println("CustomerID:" + customerID);
		System.out.println("Name:" + name);
		System.out.println("Account Number:" + accountNo);
	}

	// show balance
	public int balance(int balance) throws RemoteException {
		System.out.println("Balance:" + balance);
		return (int) balance;
	}

	// deposit
	public int deposit(int amount) throws RemoteException {

		amount = input.nextInt();
		if (amount >= 500) {
			System.out.println("Invalid");

		} else {
			balance = balance + amount;

		}
		return (int) balance;
	}

	// withdraw
	public int withdraw(int amount) throws RemoteException {

		if (balance < amount) {
			System.out.println(name + " you do not have enough fund to withdraw.");
		} else {
			balance = balance - amount;
			System.out.println(name + " your total balance is:" + balance);
		}
		return (int) balance;
	}

	public int transfer(int balance) throws RemoteException {
		System.out.println(balance + " is successfully tranferred.");
		return (int) balance;
	}

}