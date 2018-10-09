package project3_test;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Random; 

public class MyClient {
	private static double f() {
		  long toss, number_of_tosses, number_in_circle = 0;
		  double x, y, distance_squared, pi_estimate;
		  Random generator = new Random();
		  number_of_tosses = generator.nextInt(5000) + 5000;
		  for ( toss=0 ; toss< number_of_tosses ; toss++) {
		    x = 2*Math.random() - 1;
		    y =  2*Math.random() - 1;
		    distance_squared = x * x + y * y;
		    if(distance_squared <= 1) number_in_circle++;
		  }
		  pi_estimate = 4 * number_in_circle/((double) number_of_tosses);
		  return pi_estimate;
	}
	
public static void main(String [] args)	{
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        System.out.println("Please enter the value of the constant identifier: ");
        int size = input.nextInt();

        double array[] = new double[size];
        
        try {
		   Socket clientSocket = new Socket("localhost", 4321);
		   DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
		   
		   for(int i = 0; i < array.length; i++) {
			   // storing random values of pi as different elements of the array 
			   array[i] = f();
			   out.writeDouble(array[i]);
			   System.out.println(array[i]);
		   }

		   DataInputStream in = new DataInputStream(clientSocket.getInputStream());
		   System.out.println("\nServer responds Average Value: " +in.readDouble());
		   clientSocket.close();
        	} catch(IOException e) {
		   System.out.println("Error: " + e);
		   System.exit(0);
        }
	} 
}