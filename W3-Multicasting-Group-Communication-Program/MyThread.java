package project3_test;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyThread implements Runnable {
	Socket clientSocket;
	
	public MyThread(Socket clientSocket){
		this.clientSocket = clientSocket;
		}
	
	public void run() {
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of the constant identifier again:  ");
        int size = input.nextInt();
        double array[] = new double[size];
        
		while(true) {
			try {
				DataInputStream in = new DataInputStream(clientSocket.getInputStream());
				Double sum = 0.0;
				for(int i = 0; i < array.length; i++) {
					array[i] = in.readDouble();
					sum = sum + array[i];
				}
				
				DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
				out.writeDouble(sum/size);
				
				clientSocket.close();
				} catch(IOException e) {
					e.printStackTrace();
					break;
			}
		}
	}
}