package com.yk.threadnasis;

public class Actor extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + "现在开始运行");

        int count = 0;
        boolean keepRunning = true;

        while(keepRunning)
        {
            System.out.println(getName() + (++count));
            if(count == 100)
            {
                keepRunning = false;
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("结束");
    }


}
