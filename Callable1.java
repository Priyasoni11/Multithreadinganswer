package MyNewProject;
//6.Return a Future from ExecutorService by using callable and use get(), isDone(), isCancelled() with the Future object to know the status of task submitted.

import java.util.concurrent.Callable;

public class Callable1 implements Callable<Integer> {
private Integer number;
public Callable1(Integer number){
    this.number=number;
}
    @Override
    public Integer call() throws Exception {
    int sum=0;
        for (int i = 1; i <=number; i++) {
            sum=sum+i;

        }
        return sum;
    }
}
