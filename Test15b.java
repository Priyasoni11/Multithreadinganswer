package MyNewProject;
//Use Reentract lock for coordinating 2 threads with signal(), signalAll() and wait().

public class Test15b {
    public static void main(String[] args) throws Exception {
        final Test15 test15 = new Test15();
        Thread t1 = new Thread(() -> {
            try {
                test15.firstThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Test15.secondThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Test15.finished();
    }

}

