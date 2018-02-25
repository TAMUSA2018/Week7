/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week7;
import java.util.Random;
import java.util.concurrent.*;
/**
 *
 * @author ialsmadi
 */
public class TALockDemo implements Runnable{
    private static TimeCost timeCost = new TimeCost (new TestAndSetLock ());
	 private static volatile int myParam;
	 // private static TimeCost timeCost = new TimeCost (new TTASLock ());
	public TALockDemo(int k1) {
           // this.myParam=k1;
           k1=myParam;
       // store parameter for later user
   }

   public void run() {
         System.out.println("Thread NO...."+ myParam);
       method ();
   }
	 public static void method () {
             System.out.println("K value before lock is..."+TimeCost.k );
		 timeCost.lock ();
                 
                 try {
                     System.out.println("K value in thread..."+ "....timeCost"+".."+TimeCost.k );
                    Random r = new Random();
int Low = 1;
int High = 10000;
int Result = r.nextInt(High-Low) + Low;
            
               Thread.sleep(Result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
		 // int a = 10;
		 timeCost.unlock ();
                  System.out.println("K value after unlock is..."+TimeCost.k );
	 }
	
	 public static void main (String [] args) {
		 for (int i = 0; i <10; i ++) {
                     System.out.println("Thread...."+ i);
                     myParam=i;
			Thread t = new Thread(new TALockDemo(i));
	         
				t.start();
                      /*   try{
                         t.join();}
                         catch(Exception ex){
                             
                         } */
		 }
	 }
        
}
