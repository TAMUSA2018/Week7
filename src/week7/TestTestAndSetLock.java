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


public class TestTestAndSetLock implements Lock {

    /**
     * Whether or not the lock is locked.
     */
    protected AtomicBoolean m_locked;

    /**
     * Constructs a new TTAS lock.
     */
    public TestTestAndSetLock() {
        m_locked = new AtomicBoolean(false);
    }

    /**
     * Locks the lock.
     */
    public void lock() {
        boolean acquired = false;
        while(!acquired) {
            /* First test the lock without invalidating
               any cache lines. */
            if(!m_locked.get()) {
                /* Attempt to lock the lock with an atomic CAS. */
                acquired = m_locked.compareAndSet(false, true);
            }
        }
    }

    /**
     * Locks the lock if available. This will not
     * block.
     */
    public boolean tryLock() {
        if(m_locked.get()) {
            return false;
        }

        return m_locked.compareAndSet(false, true);
    }

    /**
     * Unlocks the lock. This will not block.
     */
    public void unlock() {
        m_locked.set(false);
    }

}
