/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week7;

/**
 *
 * @author ialsmadi
 */
public class WaitSignalMonitor {
    


    private int i;

    WaitSignalMonitor() {

        i = 0;
    }

    synchronized int print(String name, boolean isOdd) {
        System.out.println("print..." + i);
        if(!isOdd && i % 2 == 0) {
          try {
            wait();
        } catch(InterruptedException e) {
            System.out.println("wait for thread " + name + "interrupted");
        }
        }

        if(!isOdd && i % 2 == 1) {
           try {
            wait();
        } catch(InterruptedException e) {
            System.out.println("wait for thread " + name + "interrupted");
        }
        }

        System.out.println(name + ": " + i);
        i++;
        notifyAll();
        return i;
    }

    
}
