package MyNewProject;


import java.util.concurrent.atomic.AtomicInteger;

class Counter extends Thread {
        AtomicInteger count;
        Counter()
        {
            count = new AtomicInteger();
        }
        public void run()
        {
            int max = 10000;
            for (int i = 0; i < max; i++) {
                count.addAndGet(2);
            }
        }
    }
    public class Test12{
        public static void main(String[] args)
                throws InterruptedException
        {
            Counter c = new Counter();
            Thread one = new Thread(c, "one");
            Thread two= new Thread(c, "Two");
           one.start();
            two.start();
            one.join();//it will wat for both the threads to complete execution
            two.join();
            System.out.println("Total number of times increment: " +c.count);//final value
        }
    }
