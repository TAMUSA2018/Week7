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
public class WaitSignalMonitorThread implements Runnable {
    


    Thread t;
    WaitSignalMonitor pN;
    String name;
    boolean isOdd;

    WaitSignalMonitorThread(WaitSignalMonitor pN, boolean isOdd, String name) {

        this.name = name;
        this.pN = pN;
        this.isOdd = isOdd;
        t = new Thread(this, name);
        t.start();
    }

    public void run() {

        System.out.println("running");
        
        while(true) {
            int i = pN.print(name, isOdd);
            System.out.println(i);
            if(i >= 100) {
                break;
            }
        }
    }
}
