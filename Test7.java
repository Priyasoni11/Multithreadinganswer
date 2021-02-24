package MyNewProject;
//7.Submit List of tasks to ExecutorService and wait for the completion of all the tasks.
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
public class Test7 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());
        executorService.submit(runnable);
        List<Callable<Integer>> threads= Arrays.asList(()->2,()->3,()->4,()->5);

        try {
            //executorService.shutdown(); -> both the method can be used.
            List<Future<Integer>> futures =executorService.invokeAll(threads);
            int sum=futures.stream().map(t->{
                try{
                    return t.get();

                }catch (Exception e){
                    throw new IllegalStateException(e);
                }
            }).mapToInt(Integer::intValue).sum();
            System.out.println("sum is: " +sum);
            executorService.shutdownNow();
            //executorService.awaitTermination(10, TimeUnit.SECONDS);
            System.out.println("Reached to the end");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
