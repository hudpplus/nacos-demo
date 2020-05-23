package com.hudp.juc;

public class TestVolatile {

    public static void main(String[] args) {

        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();
        while(true){
            if(threadDemo.flag){
                System.out.println("主线程读取到的flag = " + threadDemo.flag);
                break;
            }
            System.out.println(Thread.currentThread()+" 循环...");
        }
    }
}

class ThreadDemo implements Runnable{

    public boolean flag = false;
    @Override
    public void run() {
        try {
            Thread.sleep(200);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println(Thread.currentThread()+ " 修改 flag 为 true");
    }
}
