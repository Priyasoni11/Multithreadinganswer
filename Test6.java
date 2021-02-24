package MyNewProject;
//6.Return a Future from ExecutorService by using callable and use get(), isDone(), isCancelled() with the Future object to know the status of task submitted.
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test6{

    public static void main(String[] args) {

        Callable<String> task1 = () -> "My task is done";
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(task1);

        if(!future.isDone() || !future.isCancelled()){
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
       Callable1 task2 = new Callable1(2);
        Future<Integer> future2 = executorService.submit(task2);

        try {
            System.out.println(future2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}