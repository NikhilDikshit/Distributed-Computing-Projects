package project3_test;

import java.io.*;
import java.net.*;

public class MyServer {
@SuppressWarnings("resource")
public static void main(String[] args)throws IOException {
	ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(4321);
    } catch (IOException e) {
      System.out.println("Error: " + e);
      System.exit(0);
    }
    while(true){
      MyThread a = new MyThread(serverSocket.accept());
      Thread t = new Thread(a);
      t.start();
    }
  }
}