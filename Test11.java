package MyNewProject;
//11.Use Synchronize block to enable synchronization between multiple threads trying to access method at same time.
class Airport1{
    public void getLine(){         //synchronized Block
        for (int i = 0; i <5 ; i++) {
            synchronized (this){
            System.out.println("Available Gate to land the flight-" +i);
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println();
            }
        }
        }
    }
}
class Flight1 extends Thread{
    Airport1 Gate;
    Flight1(Airport1 Gate){
        this.Gate=Gate;
    }
    @Override
    public void run(){
        Gate.getLine();
    }
}
public class Test11{
    public static void main(String[] args) {
        Airport1 obj1= new Airport1();
        Flight1 flight1=new Flight1(obj1);
        Flight1 flight2= new Flight1(obj1);
        flight1.start();
        flight2.start();
    }

}
