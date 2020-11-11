package org.geekbang;

public class Method01 extends Thread {

    private int value = 0;

    @Override
    public void run() {
        value += 1;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) throws InterruptedException {
        Method01 method = new Method01();
        method.start();
        method.join();
        System.out.println("value: " + method.getValue());
    }
}
