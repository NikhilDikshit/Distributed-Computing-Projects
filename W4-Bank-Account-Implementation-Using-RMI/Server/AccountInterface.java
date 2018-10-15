
/**
 * @author nikhil
 *
 */
import java.rmi.*;
import java.util.ArrayList;

public interface AccountInterface extends Remote {
	void display(ArrayList<ClientCustomer> accounts) throws RemoteException;

	int balance(int balance) throws RemoteException;

	int withdraw(int balance) throws RemoteException;

	int deposit(int balance) throws RemoteException;

	int transfer(int balance) throws RemoteException;
}