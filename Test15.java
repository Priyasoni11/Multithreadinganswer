package MyNewProject;
//15.Use Reentract lock for coordinating 2 threads with signal(), signalAll() and wait().
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test15 {
    private static int count = 0;
    private static final Lock lock = new ReentrantLock();
    private static final Condition cond = lock.newCondition();

    private static void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }
    public void firstThread() throws InterruptedException {
        lock.lock();

        System.out.println("Waiting ....");
        cond.await();

        System.out.println("Woken up!");

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public static void secondThread() throws InterruptedException {

        Thread.sleep(1000);
        lock.lock();

        System.out.println("Press the return key!");
        new Scanner(System.in).nextLine();
        System.out.println("Got return key!");

        cond.signalAll();

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }
    public static void finished() {
        System.out.println("Count is: " + count);
    }
}
