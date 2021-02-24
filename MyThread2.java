package MyNewProject;
//2.Use sleep and join methods with thread.
public class MyThread2 extends Thread {

        public void run() {
            for (int i = 0; i <= 5; i++) {
                try {
                    Thread.sleep(800);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(i);
            }
        }
        public static void main(String [] args) {
            MyThread2 t1 = new MyThread2();
            MyThread2 t2 = new MyThread2();
            t1.start();
            try {
                t1.join(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            t2.start();
            System.out.println("Using join thread here");

        }
    }


