package com.hudp.juc;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(50);
        LatchDemo latchDemo = new LatchDemo(countDownLatch);
        int i=0;
        long start = System.currentTimeMillis();
        while (i<50){
            new Thread(latchDemo).start();i++;
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end=System.currentTimeMillis();
        System.out.println("耗费时间为："+(end-start));
    }
}

class LatchDemo implements Runnable{

    private CountDownLatch latch;

    private static int i=1;

    public LatchDemo(CountDownLatch latch){
        this.latch=latch;
    }
    @Override
    public void run() {
        try{
            //for(int i=0;i++){
                //if(i%2==0){
                    System.out.println(i++);
                //}
          //  }
        }finally{
            latch.countDown();//latch的值减一
        }
    }
}
