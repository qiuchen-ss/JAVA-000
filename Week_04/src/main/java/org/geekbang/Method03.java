package org.geekbang;

import java.util.concurrent.*;

public class Method03 extends Thread {

    private int value = 0;
    private CountDownLatch mlatch;

    public Method03(CountDownLatch latch) {
        this.mlatch = latch;
    }

    @Override
    public void run() {
        value += 1;
        this.mlatch.countDown();
    }

    public int getValue() throws InterruptedException {
        this.mlatch.await();
        return value;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Method03 method = new Method03(latch);
        method.start();
        System.out.println("value: " + method.getValue());
    }
}