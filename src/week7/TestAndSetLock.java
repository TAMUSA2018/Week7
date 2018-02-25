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
import java.util.concurrent.atomic.AtomicBoolean;

 //Test - set the spin lock, use AtomicBoolean atomic variables to save the state * Each use getAndSet atomic operation to determine the lock state and try to acquire the lock * The disadvantage is that the bottom getAndSet using CAS to achieve, has been modifying the value of shared variables will trigger Cache Consistency Traffic Storm ** /
 public class TestAndSetLock implements Lock {
	 private AtomicBoolean mutex = new AtomicBoolean (false);
          
    
	
	 @Override
	 public void lock () {
		 // The getAndSet method will set the mutex variable to true and return the value before the mutex // Return if the mutex was previously false, indicating that the lock was acquired // The getAndSet method is atomic and the mutex atomic variables are visible to all threads while ( mutex.getAndSet (true)) {
			
		 }
	 
/**
     * Locks the lock if available. This will not
     * block.
     */
    public boolean tryLock() {
        if(mutex.get()) {
            return false;
        }

        return mutex.compareAndSet(false, true);
    }
	 @Override
	 public void unlock () {
		 mutex.set (false);
	 }

	 public String toString () {
		 return "TASLock";
	 }
 }
