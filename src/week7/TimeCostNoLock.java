/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week7;

//import java.util.concurrent.atomic.AtomicBoolean;

import java.util.Random;


/**
 *
 * @author ialsmadi
 */
public class TimeCostNoLock {

//	 private final Lock lock;
         static int k=6;
  //       protected AtomicBoolean m_locked;
	
	 public TimeCostNoLock () {
//		 this.lock = lock;
	 }
	
	// @Override
	 public void lock () {
		 long start = System.nanoTime ();
//		 lock.lock ();
                 k=k+5;
                  
		 long duration = System.nanoTime () - start;
		 System.out.println ( "time cost is" + duration + "ns");
                 // System.out.println ( "time cost is" + duration + "ns");
	 }
//@Override
 /*         public boolean tryLock() {
        if(m_locked.get()) {
            return false;
        }

        return m_locked.compareAndSet(false, true);
    } 
//	 @Override
	 public void unlock () {
		 lock.unlock ();
	 }
*/
         public void unlock () {
          //     k=k-5;
		 
	 }
 }
