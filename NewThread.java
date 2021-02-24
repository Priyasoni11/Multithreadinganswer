package MyNewProject;
//1.Create and Run a Thread using Runnable Interface and Thread class
public class NewThread {
    public static void main(String[] args) {
        System.out.println("This is my main thread "+Thread.currentThread().getName());
        Thread thread1 = new Thread(new RunnableImple());
        thread1.start();
        Thread thread2 =new Thread(new RunnableImple());
        thread2.start();
        }
        static class RunnableImple implements Runnable{
            @Override
            public void run() {
                for (int i=0;i<5; i++){
                    System.out.println("Hi, i am Priya"+i);
               }
            }
        }
}
