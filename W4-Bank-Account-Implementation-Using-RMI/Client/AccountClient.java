/**
 * @author nikhil
 *
 */
import java.io.*;
import java.rmi.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountClient {
	@SuppressWarnings("unused")
	public static void main(String args[]) throws RemoteException {
		try {
			int port = 16790;
			String host = "localhost";
			String registryURL = "rmi://" + host + ":" + port + "/hello";
			AccountInterface h = (AccountInterface) Naming.lookup(registryURL);
			System.out.println("Lookup completed ");
		} catch (Exception e) {
			e.printStackTrace();
		}

		ArrayList<ClientCustomer> accounts = new ArrayList<ClientCustomer>();
		
		// manually creating 3 customers as of now
		ClientCustomer customer1 = new ClientCustomer(1, "John Doe", 12001, 9500);
		ClientCustomer customer2 = new ClientCustomer(2, "Mehdi Bahdii", 12002, 7000);
		ClientCustomer customer3 = new ClientCustomer(3, "Nikhil Dikshit", 12003, 5500);

		accounts.add(customer1);
		accounts.add(customer2);
		accounts.add(customer3);

		int ch, ch1, temp = 0;
		int customerID = 0;
		String name = null;
		int accountNo = 0;
		int balance = 0;
		boolean flag = true;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		ClientCustomer operation = new ClientCustomer(customerID, name, accountNo, balance);

		try {
			String bankserverURL = "rmi://" + args[0] + "/BankServer";
			AccountInterface accountIntf = (AccountInterface) Naming.lookup(bankserverURL);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (flag) {
				System.out.println("Select a choice:");
				System.out.println("1. Existing customer");
				System.out.println("2. New customer");
				System.out.println("3. Quit");
				String input = in.next();

				if (input.equals("1")) {
					System.out.println("Enter CustomerID: ");
					customerID = in.nextInt();
					System.out.println("\nEnter the name of the person:");
					name = in.nextLine();
					System.out.println("\nEnter the account number:");
					accountNo = in.nextInt();

					System.out.println(
							"\nEnter 1 to create, 2 to get the balance, 3 to withdraw, 4 to deposit, 5 to transfer, 6 to terminate");
					System.out.println("\nEnter your choice:");
					ch = Integer.parseInt(br.readLine());
					switch (ch) {
					// existing user
					case 1:
						System.out.println(name + "your account number is: " + accountNo);
						break;

					case 2:
						operation.balance(balance);
						break;

					case 3:
						System.out.println("\nEnter amount to withdraw:");
						int wd = Integer.parseInt(br.readLine());
						System.out.println("\nEnter your account number:");
						int acWCheck = Integer.parseInt(br.readLine());
						if (acWCheck == accountNo) {
							System.out.println("Account Number:" + acWCheck);
							operation.withdraw(wd);
						} else {
							System.out.println("Wrong Account Number");
						}
						break;

					case 4:
						System.out.println("\nEnter amount of deposit:");
						int dp = Integer.parseInt(br.readLine());
						System.out.println("\nEnter your account number:");
						int acDCheck = Integer.parseInt(br.readLine());
						if (acDCheck == accountNo) {
							System.out.println("Account Number:" + acDCheck);
							operation.deposit(dp);
						} else {
							System.out.println("Wrong Account Number");
						}
						break;

					case 5:
						System.out.println("Enter the amount to tranfer: ");
						int tm = Integer.parseInt(br.readLine());
						System.out.println("\nEnter your account number:");
						int acTCheck = Integer.parseInt(br.readLine());
						if (acTCheck == balance) {
							System.out.println("Account Number:" + acTCheck);
							System.out.println("Enter the customer ID to tranfer: ");
							ch1 = Integer.parseInt(br.readLine());
							switch (ch1) {

							case 2:
								temp = (int) customer1.balance;
								customer1.balance -= balance;
								customer2.balance += temp;
								operation.deposit(tm);

							case 3:
								temp = (int) customer1.balance;
								customer1.balance -= balance;
								customer3.balance += temp;
								operation.deposit(tm);
							}
						} else {
							System.out.println("Wrong Account Number");
						}
					
					case 6:
						flag = false;
					}
				}

				// new user
				else if (input.equals("2")) {
					// add new user to arraylist
					int newID = customerID + 1;
					System.out.println("Enter initial balance: ");
					balance = in.nextInt();
					System.out.println("Your customer ID will be: " + newID);
					accounts.add(new ClientCustomer(newID, name, accountNo, balance));
				}

				// termination
				else if (input.equals("3")) {
					System.out.println("Terminated");
					flag = false;
				}else{
					System.out.println("Invalid");
				}
			}
		} catch (Exception e1) {
			System.out.println("Exception :" + e1);
		}
	}
}
