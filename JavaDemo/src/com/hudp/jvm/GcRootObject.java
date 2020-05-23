package com.hudp.jvm;

/**
 * Java内存区域中可以作为GC ROOT的对象：
 */
public class GcRootObject {

    public GcRootObject(String name){}

    /**
     * 1. 虚拟机栈中引用的对象
     */
    public static void testGc(){
        GcRootObject g = new GcRootObject("localParameter");
        g = null;

        //此时的g，即为GC Root，当s置空时，localParameter对象也断掉了与GC Root的引用链，将被回收。
    }


    public static GcRootObject m;
    /**
     * 2. 方法区中类静态属性引用的对象
     */
    public static void testGc2(){
        GcRootObject s = new GcRootObject("properties");
        s.m = new GcRootObject("parameter");
        s = null;
        /*此时的s，即为GC Root，s置为null，经过GC后，s所指向的properties对象由于无法与GC Root建立关系被回收。
        而m作为类的静态属性，也属于GC Root，parameter 对象依然与GC root建立着连接，所以此时parameter对象并不会被回收。*/
    }


    /**
     * 3. 方法区中常量引用的对象
     */
    public static final GcRootObject m2 = new GcRootObject("");
    public static void testGc3(){

        GcRootObject s = new GcRootObject("");
        s = null;
        //m2即为方法区中的常量引用，也为GC Root，s置为null后，final对象也不会因没有与GC Root建立联系而被回收。
    }


    /**
     * 4. 本地方法栈中引用的对象
     * @param args
     */

   // =======================================================================================================
    /*public static void main(String[] args)  {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
    }*/

    public static void main(String[] args)  {
        String a = "hello2";
        final String b = getHello();
        String c = b + 2;
        System.out.println((a == c));

    }

    public static String getHello() {
        return "hello";
    }
}
