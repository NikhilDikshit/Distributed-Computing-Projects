package Server;

import java.io.*;
import java.net.*;

public class MyServer{
public static void main(String[] args) throws Exception
  {
	try {
    ServerSocket serverSocket = new ServerSocket(16790);
    System.out.println();
    Socket clientSocket = serverSocket.accept( );                          
    
    // reading the user input from keyboard
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    // stream for sending the message to client
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    // stream for receiving the message from server
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
    
    String receiveMessage, sendMessage;
    do
    {
    	if((receiveMessage = in.readLine()) != null)  
    	{
    	    	System.out.println(receiveMessage);
    	}  
		System.out.print("Enter a line for the server: ");
    	sendMessage = keyboard.readLine(); 
    	out.println(sendMessage);             
    	out.flush();
    }
   	while(!(sendMessage.equals("end")));
    in.close();
    out.close();
    clientSocket.close();
    serverSocket.close();
  } catch (IOException e) {
      System.out.println("Error: " + e);
      System.exit(0);
  }
  }
}                    