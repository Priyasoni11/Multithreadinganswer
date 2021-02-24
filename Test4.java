package MyNewProject;
//4.Try shutdown() and shutdownNow() and observe the difference.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class Test4 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        executorService.submit(runnable);
        Future<String> futureResult=executorService.submit(()->{
        System.out.println("Callable");
        Thread.sleep(1000000);
        return Thread.currentThread().getName();
    });
        try {
            //executorService.shutdown(); -> both the method can be used.
            executorService.shutdownNow();
            System.out.println("Reached to the end");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
