/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week7;
// Java program to demonstrate 
// methods of Semaphore class
import java.util.concurrent.*;
//import java.util.concurrent.
/**
 *
 * @author ialsmadi
 */
// Driver class
public class SemaphoreDemo 
{
 
    public static void main(String args[]) throws InterruptedException 
    {
        // creating a Semaphore object
        // with number of permits 3 and fairness true
        Semaphore sem = new Semaphore(3, true);
         
        //isFair() method 
        System.out.println("is Fairness enabled : " + sem.isFair());
         
        // Main thread try to acquire 2 permits
        // tryAcquire(int permits) method
        sem.tryAcquire(2);
         
        // availablePermits() method
        System.out.println("Available permits : " + sem.availablePermits());
         
        //drainPermits() method
        System.out.println("number of permits drain by Main thread : "
                                      + sem.drainPermits());
         
        // permit released by Main thread
        sem.release(1);
         
        // creating two threads with name A and B
         for (int i = 0; i <5; i ++) {
		String name=String.valueOf(i);	
        MyThread mt1 = new MyThread(sem, name);
    //    MyThread mt2 = new MyThread(sem, "B");
          
         
        // starting threads A
        mt1.start();
         
        // starting threads B
        //mt2.start();
         
        // toString method
        System.out.println(sem.toString());
         
          
        // waiting for threads A and B 
        mt1.join();
         }
        //mt2.join();
    }
}