package com.yk.threadnasis;

public class Actress implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "是个演员");
        int count = 0;
        boolean keepRunning = true;
        while(keepRunning)
        {
            System.out.println(Thread.currentThread().getName() + (++count));
            if(count == 100)
            {
                keepRunning = false;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
