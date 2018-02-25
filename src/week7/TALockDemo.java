/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week7;
import java.util.concurrent.*;
/**
 *
 * @author ialsmadi
 */
public class TALockDemo {
    private static TimeCost timeCost = new TimeCost (new TestAndSetLock ());
	
	 // private static TimeCost timeCost = new TimeCost (new TTASLock ());
	
	 public static void method () {
		 timeCost.lock ();
                 try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
		 // int a = 10;
		 timeCost.unlock ();
	 }
	
	 public static void main (String [] args) {
		 for (int i = 0; i <10; i ++) {
			 Thread t = new Thread (new Runnable () {
	
				 @Override
				 public void run () {
					 method ();
				 }
				
			 });
			 t.start ();
                         try{
                         t.join();}
                         catch(Exception ex){
                             
                         }
		 }
	 }
        
}
