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
public class TALockDemoNoLock {
    private static TimeCostNoLock timeCost1 = new TimeCostNoLock ();
	
	 // private static TimeCost timeCost = new TimeCost (new TTASLock ());
	
	 public static void method () {
             System.out.println("K value before lock is..."+TimeCostNoLock.k );
		 timeCost1.lock ();
                 try {
                     System.out.println("K value in lock is..."+TimeCostNoLock.k );
                    Random r = new Random();
int Low = 1;
int High = 10000;
int Result = r.nextInt(High-Low) + Low;
           //   try{
               Thread.sleep(Result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
		 // int a = 10;
		 timeCost1.unlock ();
                  System.out.println("K value after unlock is..."+TimeCostNoLock.k );
	 }
	
	 public static void main (String [] args) {
		 for (int i = 0; i <10; i ++) {
                     System.out.println("Thread...."+ i);
			 Thread t = new Thread (new Runnable () {
	         
				 @Override
				 public void run () {
                                      
					 method ();
				 }
				
			 });
			 t.start ();
                       /*  try{
                         t.join();}
                         catch(Exception ex){
                             
                         } */
		 }
	 }
        
}
