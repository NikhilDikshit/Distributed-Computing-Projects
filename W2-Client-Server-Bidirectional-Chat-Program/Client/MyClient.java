package Client;

import java.io.*;
import java.net.*;

public class MyClient{
  public static void main(String[] args) throws Exception {
    	try {
    	int port = 16790;
        String host = "localhost";
    	Socket clientSocket = new Socket(host, port);
    	
    	// reading the user input from keyboard
    	BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    	PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); 
    	BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
        System.out.println("Hello!! \n");
    	
    	String receiveMessage, sendMessage;
    	do
    	{
    		System.out.print("Enter a line or end to quit: ");
    		sendMessage = keyboard.readLine();
    		// message is sent to the server
    		out.println(sendMessage); 
    		//flushing the data go because none of the streams are closed yet
    		out.flush(); 
    		// message is received from the server
    		if((receiveMessage = in.readLine()) != null) 
    		{
    			// printing the message
    			System.out.println(receiveMessage); 
    		}
    	} 
    	while(!(sendMessage.equals("end")));
    	in.close();
        out.close();
        clientSocket.close();
    	} catch (IOException e) {
    	      System.out.println("Error: " + e);
    	      System.exit(0);
    	}
  }
}