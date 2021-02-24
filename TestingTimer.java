package MyNewProject;
//8.Schedule task using schedule(), scheduleAtFixedRate() and scheduleAtFixedDelay()
import java.util.concurrent.*;
public class TestingTimer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Callable<Integer> callabletask=()->3; (Comment out in case of Schedule and ScheduleAtFixedDelay) //
        Runnable task1=()->System.out.println("Testing..");
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        //ScheduledFuture<Integer> result=executorService.schedule(callabletask,3,TimeUnit.SECONDS);-->for Schedule()
        //ScheduledFuture result= executorService.scheduleAtFixedRate(task1, 3, 5,TimeUnit.SECONDS);-->for ScheduleAtFixedRate
        ScheduledFuture result= executorService.scheduleWithFixedDelay(task1, 3, 5,TimeUnit.SECONDS); //For ScheduleAtFixedDelay
      //executorService.shutdown();

        System.out.println("Scheduling thread" +result.get());

    }
}