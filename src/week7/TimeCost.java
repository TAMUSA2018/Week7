/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week7;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author ialsmadi
 */
public class TimeCost implements Lock {

	 private final Lock lock;
         protected AtomicBoolean m_locked;
	
	 public TimeCost (Lock lock) {
		 this.lock = lock;
	 }
	
	 @Override
	 public void lock () {
		 long start = System.nanoTime ();
		 lock.lock ();
		 long duration = System.nanoTime () - start;
		 System.out.println (lock.toString () + "time cost is" + duration + "ns");
	 }
@Override
          public boolean tryLock() {
        if(m_locked.get()) {
            return false;
        }

        return m_locked.compareAndSet(false, true);
    }
	 @Override
	 public void unlock () {
		 lock.unlock ();
	 }

 }
