package com.hudp.designModel.singleton;

/**
 * 单例模式 --- 懒汉
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton(){}

    public static synchronized Singleton getInstance(){
        if(singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }
}

/**
 * 单例模式 --- 饿汉
 *
 */
class Singleton2{

    private static final Singleton2 singleton2 = new Singleton2();

    private Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        return singleton2;
    }


}