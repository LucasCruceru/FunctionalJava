package ro.lucas.chapter5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locking {
    private Lock lock = new ReentrantLock();

    protected void setLock(final Lock mock){
        lock = mock;
    }

    private static void runLocked(Lock lock, Runnable block){
     lock.lock();
     try {
         block.run();
     } finally {
       lock.unlock();
     }
    }
    public void doOp(){
        runLocked(lock,() -> {/*...locked code...*/} );
    }

}
