package org.geekbang;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;

public class Method04 extends Thread {

    private CyclicBarrier cyclicBarrier;
    private int value = 0;

    public Method04(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        super.run();

        try {
            value += 1;
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getValue() throws BrokenBarrierException, InterruptedException {
        cyclicBarrier.await();
        return value;
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        Method04 method = new Method04(cyclicBarrier);
        method.start();
        System.out.println("value: " + method.getValue());
    }
}