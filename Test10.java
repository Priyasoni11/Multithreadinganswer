package MyNewProject;
//10.Use Synchronize mthod to enable synchronization between multiple threads trying to access method at same time.
class Airport{
    public synchronized void getLine(){         //synchronized method
        for (int i = 0; i <5 ; i++) {
            System.out.println("Available Gate to land the flight-" +i);
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println();
            }
        }
    }
}
class Flight extends Thread{
    Airport Gate;
    Flight(Airport Gate){
        this.Gate=Gate;
    }
    @Override
    public void run(){
        Gate.getLine();
    }
}
public class Test10 {
    public static void main(String[] args) {
        Airport obj= new Airport();
        Flight flight1=new Flight(obj);
        Flight flight2= new Flight(obj);
        flight1.start();
        flight2.start();
    }

}
