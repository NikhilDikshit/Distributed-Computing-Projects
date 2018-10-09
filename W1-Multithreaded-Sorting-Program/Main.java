import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args){
    Random r = new Random(System.currentTimeMillis());
    int n = r.nextInt(101) + 50; // creating a random number between 0 and 101
    int[] a = new int[n];
    for(int i = 0; i < n; i++)
      a[i] = r.nextInt(100);
    
    n = r.nextInt(101) + 50;
    int[] b = new int[n];
    for(int i = 0; i < n; i++)
      b[i] = r.nextInt(100);
    
    SortThread t1 = new SortThread(a);
    t1.start();
    SortThread t2 = new SortThread(b);
    t2.start();
    try{
        t1.join();
        t2.join();
      }
    catch(Exception e){
  	System.out.println("Error: " + e);
  	System.exit(0);
      }
    
    MergeThread m = new MergeThread(t1.get(), t2.get());
    m.start();
    try{
    	m.join();
      }catch(Exception e){
  	System.out.println("Error: " + e);
  	System.exit(0);
      }
    
    System.out.println(Arrays.toString(m.get()));
  }
}
