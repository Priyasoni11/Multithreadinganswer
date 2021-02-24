package MyNewProject;

class Airport3{
    public synchronized void getLine(){         //synchronized method
        for (int i = 0; i <5 ; i++) {
            System.out.println("Available Gate to land the flight-" +i);
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println();
            }
        }this.notifyAll();
    }
}
class Flight3 extends Thread{
    Airport3 Gate;
    Flight3(Airport3 Gate){
        this.Gate=Gate;
    }
    @Override
    public void run(){
        Gate.getLine();
    }
}
public class Test14{
    public static void main(String[] args) throws InterruptedException {
        Airport3 obj= new Airport3();
        Flight3 flight1=new Flight3(obj);
        Flight3 flight2= new Flight3(obj);
        synchronized (flight1) {
            flight1.start();
            System.out.println("Flight A landing and flight B");
            flight1.wait();
            System.out.println(flight1);
            flight2.start();
            System.out.println("Flight B landing");
            flight2.wait();
        }

    }

}
