package com.hudp.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {

    public static void main(String[] args) {
        ThreadDemo2 t = new ThreadDemo2();
        FutureTask<Integer> result = new FutureTask<>(t);
        new Thread(result).start();

        //2.接收线程运算后的结果
        try {
            Integer sum = result.get();//FutureTask 可用于 闭锁  当子线程执行完毕，才会执行此后语句
            System.out.println(sum);
            System.out.println("----------------------");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class ThreadDemo2 implements Callable {

    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=0;i<=10;i++){
            sum+=i;
        }
        return sum;
    }

}
