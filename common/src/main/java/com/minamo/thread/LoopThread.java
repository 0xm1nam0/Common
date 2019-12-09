package com.minamo.thread;

/**
 * @author Minamo
 * @e-mail kleinminamo@gmail.com
 * @time 2019/8/7
 * @des  循环线程
 */

public abstract class LoopThread extends Thread {

    volatile Thread blinker = this;

    abstract public void setup();

    abstract public void loop();

    abstract public void over();

    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        setup();
        while (blinker == thisThread) {
            loop();
        }
        over();
    }

    public void breakLoop() {
        blinker = null;
    }

    public void shutdown() {
        breakLoop();
        try {
            if (this != Thread.currentThread()) {
                synchronized (this) {
                    this.notifyAll();
                }
                this.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
