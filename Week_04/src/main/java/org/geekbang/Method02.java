package org.geekbang;

import java.util.concurrent.*;

public class Method02 implements Callable<Integer> {

    private int value = 0;

    @Override
    public Integer call() throws Exception {
        return value += 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(new Method02());
        System.out.println("value: " + future.get());
        executor.shutdown();
    }
}
