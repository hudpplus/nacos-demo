package com.hudp.jvm;


/**
 * 垃圾判断算法 之 引用计数法
 *
 * 无法解决循环引用的问题。
 */
public class ReferenceCountingGC {

    public Object instance;

    public ReferenceCountingGC(String name){

    }

    public static void testGc(){

        ReferenceCountingGC a = new ReferenceCountingGC("a");
        ReferenceCountingGC b = new ReferenceCountingGC("b");
        a.instance = b;
        b.instance = a;
        a=null;
        b=null;

        //这2个对象已经不可能再被访问了，但由于他们相互引用着对方，导致它们的引用计数永远都不会为0，
        //通过引用计数算法，也就永远无法通知GC收集器回收它们。
    }
}
