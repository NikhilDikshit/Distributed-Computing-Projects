/**
 * @author nikhil
 *
 */
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;

@SuppressWarnings("unused")
public class AccountServer {
	public static void main(String args[]) {
		try {
			ClientCustomer impl = new ClientCustomer(0, null, 0, 0);
			int port = 16790; 
		      String host = "localhost";
		      AccountClient exportedObj = new AccountClient();
		      LocateRegistry.createRegistry(port);
		      String registryURL = "rmi://" + host + ":" + port + "/hello";
		      Naming.rebind(registryURL, (Remote) exportedObj);
		      System.out.println("Hello Server ready.");
		} catch (Exception e) {
			System.out.println("Exception :" + e);
		}
	}
}